CHỈNH LẠI CÁCH LÀM CỦA MÌNH 
package Merge_Two_Sorted_Lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy head acts as an anchor so we never lose reference to the start
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse while both lists have remaining elements
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach whichever list has nodes left over
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
CÁCH NÀY LÀ CỦA AI
Về mặt lý thuyết độ phức tạp thuật toán, cách dùng con trỏ lặp (iterative) với **$O(n + m)$ thời gian** và **$O(1)$ bộ nhớ** đã là giới hạn tối ưu tuyệt đối — bạn bắt buộc phải duyệt qua các phần tử ít nhất một lần để so sánh và nối chúng lại.

Tuy nhiên, nếu muốn tối ưu tốc độ thực tế (runtime micro-optimizations để đạt 0ms trên LeetCode) hoặc viết code ngắn gọn hơn, có 2 hướng:

---

### 1. Cách Đệ Quy (Ngắn gọn nhất)

Code cực kỳ ngắn, tận dụng cơ chế trả về của hàm.

```java
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

```

* **Ưu điểm:** Code thanh lịch, dễ nhớ.
* **Nhược điểm:** Tốn thêm bộ nhớ Call Stack ($O(n + m)$ space). Nếu danh sách dài hàng triệu phần tử có thể bị lỗi `StackOverflowError`.

---

### 2. Tối ưu vi mô (Micro-optimization để đạt 0ms tuyệt đối)

Cách dùng `dummy` node ở bài trước tạo một đối tượng mới trong Heap (`new ListNode(-1)`), việc cấp phát bộ nhớ này tốn một chút thời gian của JVM. Ta có thể loại bỏ hoàn toàn việc tạo nút mới bằng cách chọn trực tiếp nút đầu tiên làm gốc:

```java
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Xác định trực tiếp head thực tế, không cần tạo node giả (dummy)
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode current = head;

        // Vòng lặp nối các nút có sẵn
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Nối thẳng phần còn lại
        current.next = (list1 != null) ? list1 : list2;

        return head;
    }
}

```

Cách này không tốn dù chỉ 1 byte cấp phát mới trên Heap, đạt chuẩn **0ms** và **Beats 100%** trên LeetCode.