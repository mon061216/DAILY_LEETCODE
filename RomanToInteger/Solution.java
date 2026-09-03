package RomanToInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int romanToInt_first(String s) {
        int result = 0;
        Map<String, Integer> list = new HashMap<String,Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
            }
        };
        // String[] splitString = s.split("");
        // int length = splitString.length;
        // if(length <= 0) return result;
        // int i = 0;
        // while (i < length - 1){
        //     if(list.get(splitString[i]) < list.get(splitString[i+1])){
        //         result += (list.get(splitString[i+1]) - list.get(splitString[i]));
        //         i += 2;
        //         length = length - 1;
        //     }else{
        //         result += list.get(splitString[i]);
        //         i += 1;
        //     }
        // }
        /*
        Tràn mảng (IndexOutOfBounds): Khi vòng lặp chạy đến ký tự cuối cùng (i = length - 1), dòng kiểm tra splitString[i+1] sẽ cố truy cập phần tử ngoài mảng.Gán cứng số trừ (- 1): Dòng result += (list.get(splitString[i+1]) - 1); chỉ đúng với IV hoặc IX. Với các trường hợp như XC (90) hay CD (400), code sẽ tính thành $100 - 1 = 99$ hoặc $500 - 1 = 499$.Thay đổi biến chặn vòng lặp: Việc vừa tăng i += 2 vừa giảm length = length - 1 sẽ làm cắt ngắn chuỗi sớm hơn thực tế, khiến các ký tự phía sau bị bỏ qua.Tối ưu hiệu năng: Hàm s.split("") và HashMap tạo thêm nhiều bộ nhớ tạm không cần thiết. Dùng charAt() và câu lệnh switch sẽ chạy nhanh hơn đáng kể.
         */
        return result;
    }
    //CÁCH 1: LÀ CỘNG TỪ TRÁI QUA PHẢI
    public int getValue(char x){
        switch (x) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:  return 0;
        }
    }
    public int romanToInt_CACH1(String s){
        int result = 0;
        
        for(int i = 0; i < s.length(); i ++){
            if(i + 1 < s.length() && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))){
                result -= getValue(s.charAt(i));
            }else result += getValue(s.charAt(i));
        }
        return result;
    }
    //CÁCH 2: CỘNG TỪ PHẢI QUA TRÁI
    public int romanToInt(String s){
        int cur = 0;
        int prev = 0;
        int result = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            cur = switch(s.charAt(i)){
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if(cur < prev) result -= cur;
            else {
                result += cur;
                prev = cur;
            }
        }
        return result;
    }
     public static void main(String[] args) {
        Solution check = new Solution();
        System.out.println(check.romanToInt("III"));
        System.out.println(check.romanToInt("LVIII"));
        System.out.println(check.romanToInt("MCMXCIV"));

     }
}
