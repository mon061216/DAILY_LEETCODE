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
    public String longestCommonPrefix_second(String[] strs){
        for(int i = 1; i <= strs[0].length(); i++){
            String check = strs[0].substring(0,i);
            for(int j = 1; j < strs.length; j ++){
                if(strs[j].length() < i || !strs[j].substring(0, i).equals(check)) return strs[0].substring(0,i - 1);
            }
        }
        return strs[0];
    }
    //Cách 3: học thuộc chat và tự code lại
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] test = {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix_first(test));
    }
}
