14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.

Có hai cách tiếp cận đạt tốc độ tối đa **0 ms (Beats 100%)** trên LeetCode, vừa sạch code vừa không tốn chi phí cấp phát bộ nhớ từ `substring`:

---

### Cách 1: Thu hẹp tiền tố bằng `indexOf` (Horizontal Scanning - Ngắn gọn nhất)

Lấy luôn chuỗi đầu tiên làm `prefix`. Với mỗi từ tiếp theo, dùng `indexOf` để kiểm tra. Nếu từ đó chưa bắt đầu bằng `prefix`, ta gọt bớt 1 ký tự ở đuôi `prefix` cho tới khi khớp.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Khi strs[i] chưa bắt đầu bằng prefix (tức indexOf != 0)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}

```

* **Ưu điểm:** `indexOf` được tối ưu hóa ở tầng C++ / JVM nên chạy cực nhanh. Nếu gặp 2 từ không chung chữ nào (như `"flower"` và `"dog"`), chuỗi co về `""` rất sớm và dừng thuật toán ngay.

---

### Cách 2: So sánh từ đầu và từ cuối sau khi sắp xếp (Sorting Trick)

Sau khi sắp xếp mảng theo thứ tự từ điển, hai chuỗi khác biệt nhau nhiều nhất chắc chắn nằm ở **vị trí đầu tiên** (`strs[0]`) và **vị trí cuối cùng** (`strs[strs.length - 1]`). Tiền tố chung của cả mảng chính là tiền tố chung của hai chuỗi này.

```java
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        int idx = 0;

        // Chỉ cần so sánh đúng 2 chuỗi: đầu mảng và cuối mảng
        while (idx < first.length() && idx < last.length()) {
            if (first.charAt(idx) == last.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        return first.substring(0, idx);
    }
}

```

* **Ưu điểm:** Viết rất ngắn, không cần lồng 2 vòng lặp để duyệt qua toàn bộ các phần tử ở giữa.