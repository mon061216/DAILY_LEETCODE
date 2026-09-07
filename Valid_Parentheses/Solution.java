package Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    //Cách này là tự nghĩ và có tham khảo của AI tầm 10%
    public char check_Open_brackets_matching(char dau_ngoac){
        switch (dau_ngoac) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default:
                return '\0';
        }
    }
    public boolean isValid_first(String s) {
        Stack list = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(list.isEmpty() || temp == '(' || temp == '['|| temp == '{') list.push(temp);
            else {
                char check = (char)list.peek();
                if(check_Open_brackets_matching(check) == temp) list.pop();
                else return false;
            }
        }
        return list.isEmpty();
    }
    //Cách này là học từ AI và tự code lại
    /*Ý tưởng thuật toán (Mẹo đẩy ngoặc đóng)
    Duyệt từng ký tự trong chuỗi:
        Nếu gặp (, đẩy ngay ) vào stack.
        Nếu gặp [, đẩy ngay ] vào stack.
        Nếu gặp {, đẩy ngay } vào stack.
        Nếu gặp ngoặc đóng:Kiểm tra xem stack có rỗng không (stack.isEmpty()) hoặc phần tử vừa lấy ra (stack.pop()) có khớp với ký tự hiện tại không.
        Nếu stack rỗng hoặc không khớp --> trả về false.
    Sau khi duyệt hết chuỗi:Nếu stack rỗng (stack.isEmpty()) --> trả về true (tất cả ngoặc mở đều đã được đóng hợp lệ).
    Nếu còn phần tử --> trả về false (thừa ngoặc mở). */
    //Có 2 cách: 1 là dùng Stack (ArrayDequeue) hoặc tự tạo ra stack
    public boolean isValid(String s){
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> list = new ArrayDeque<>();
        for(char var : s.toCharArray()){
            switch (var) {
                case '(': list.push(')');
                    break;
                case '{': list.push('}');
                    break;
                case '[': list.push(']');
                    break;
                default:
                    if(list.isEmpty() || var != list.pop()) return false;
                    break;
            }
        }
        return list.isEmpty();
    }
    //Dưới đây là của AI
    
    public boolean isValid_AI(String s) {
        // Độ dài lẻ không bao giờ hợp lệ
        if (s.length() % 2 != 0) {
            return false;
        }

        // Mảng tĩnh tối đa bằng độ dài chuỗi, không sinh thêm đối tượng Wrapper
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(': 
                    stack[++top] = ')'; 
                    break;
                case '{': 
                    stack[++top] = '}'; 
                    break;
                case '[': 
                    stack[++top] = ']'; 
                    break;
                default:
                    // top == -1 tức stack rỗng, hoặc đỉnh không khớp với ngoặc đóng hiện tại
                    if (top == -1 || stack[top--] != c) {
                        return false;
                    }
                    break;
            }
        }

        return top == -1;
    }
}
