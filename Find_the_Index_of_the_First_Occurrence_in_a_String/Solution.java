package Find_the_Index_of_the_First_Occurrence_in_a_String;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int strStr(String haystack, String needle) {
        // Map temp = new HashMap<>();
        int count = 0;
        int result = -1;
        boolean check = false;
        // for (char var : haystack.toCharArray()) {
        //     if(var == needle.charAt(count)){
        //         if(temp.get(count) == null) temp.put(count, var);
        //         count++;
        //     }else count = 0;
        // }



        /*  CÁCH LÀM DƯỚI MÌNH SAI RẤT NHIỀU:
        Đoạn code trên đang gặp **4 lỗi logic quan trọng**:
    1. Điều kiện vòng lặp trong bị sai mốc so sánh (`j < needle.length()`)
        for(int j = i+1; j < needle.length(); j++)

* Biến `j` duyệt trên chuỗi `haystack` (bắt đầu từ `i + 1`), nhưng điều kiện dừng lại so với độ dài của `needle` (`needle.length()`).
* Khi `i` trôi về phía sau của `haystack` (ví dụ `i = 5` mà `needle.length() = 3`), điều kiện `j < needle.length()` sẽ lập tức sai ngay từ đầu, khiến vòng lặp `j` không chạy.
* Ngược lại, nếu `needle.length()` lớn hơn `haystack.length()`, `haystack.charAt(j)` sẽ bị ném ngoại lệ `StringIndexOutOfBoundsException`.

    2. Trường hợp `needle` chỉ có 1 ký tự (`needle.length() == 1`)
Nếu `needle` có độ dài bằng 1:

* Ký tự đầu tiên khớp tại `if (haystack.charAt(i) == needle.charAt(count))`.
* Vòng lặp `j` có điều kiện `j < 1`, nếu `i = 0` thì `j = 1 < 1` là sai ngay, vòng lặp `j` không chạy lần nào.
* Biến `check` vẫn mang giá trị ban đầu là `false`, hàm bỏ qua và trả về `-1` dù ký tự đó có tồn tại.

    3. Không reset `count` khi ký tự đầu tiên không khớp
`count` được khai báo ngoài vòng lặp `for (int i = 0...)`. Khi gặp một vị trí khớp nhưng chuỗi con phía sau bị lệch,
nếu bạn reset `count = 0` trong `break`, nhưng ở các vị trí khác không kiểm soát chặt, `needle.charAt(count)` có thể trỏ ngoài giới hạn hoặc lệch vị trí index `0`. 
Thực tế, để kiểm tra ký tự đầu của `needle`, bạn chỉ cần kiểm tra cố định tại `needle.charAt(0)`.

    4. Vòng lặp ngoài duyệt thừa (`i < haystack.length()`)
Nếu vị trí bắt đầu `i` cộng với độ dài của `needle` vượt quá độ dài `haystack` (`i + needle.length() > haystack.length()`), đoạn còn lại của `haystack` không đủ ký tự để chứa `needle`, 
việc tiếp tục duyệt sẽ gây lỗi vượt chỉ mục nếu kiểm tra sâu hơn.
         */
        if(haystack.length() < needle.length()) return  result;
        for(int i = 0; i < haystack.length(); i ++){
            if(haystack.charAt(i) == needle.charAt(count)){
                for(int j = i+1; j < needle.length() + i; j++){
                    count++;
                    if(haystack.charAt(j) != needle.charAt(count)){
                        count = 0;
                        check = false;
                        break;
                    }else {
                        check = true;
                    }
                }
                if(check) return i;
            }
        }
        return result;
    }
}
