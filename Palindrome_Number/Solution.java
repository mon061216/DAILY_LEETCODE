public class Solution {
    public boolean isPalindrome(int x){
        int a = 0;
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;    
       
        // while(temp != 0){
        //     a *= 10;
        //     a += temp%10;
        //     temp /= 10;
        // }
        //Chỗ này chỉ chạy tới một nửa số thôi
        while (x < a){
            a = a*10 + (x%10);
            x /= 10;
        }
        // Chẵn chữ số: x == reversedHalf (vd: 1221 -> x = 12, reversed = 12)
        // Lẻ chữ số: x == reversedHalf / 10 (vd: 12321 -> x = 12, reversed = 123)
        return a == x || a == x /10;
    }
    public static void main(String[] args) {
        Solution check = new Solution();
        System.out.println(check.isPalindrome(121));
    }
}
