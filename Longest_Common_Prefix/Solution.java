package Longest_Common_Prefix;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    //Cách tự nghĩ && suy nghĩ sau đó nhờ AI fix lỗi nưax
    public String longestCommonPrefix_first(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int count = 0;
        StringBuilder chuoi = new StringBuilder();

        while(count < strs[0].length()){
            char check = strs[0].charAt(count);
            for(int i = 0; i < strs.length; i++){
                if(count >= strs[i].length() || strs[i].charAt(count) != check) return chuoi.toString();
            }
            chuoi.append(check);
            count++;
        }
        return chuoi.toString();
    }
    //Cách 2: 
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] test = {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix_first(test));
    }
}
