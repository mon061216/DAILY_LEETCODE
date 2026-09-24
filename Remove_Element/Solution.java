package Remove_Element;
public class Solution {
    public static  int removeElement(int[] nums, int val) {
        // int length = nums.length;
        // if(length == 0) return 0;
        // int count = 0;
        // for(int i = 0; i < (length/2); i ++){
        //     if(nums[i] != val){
        //         nums[count++] = nums[i];
        //     }
        //     if(nums[length-1-i] != val){
        //         nums[count++] = nums[length-i-1];
        //     }
        // }
        // return count;
        int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[count++] = nums[i];
        }
    }
    return count;
    }
    public static void main(String[] args) {
        // int[] nums = {3,2,2,3};
        // int k = removeElement(nums, 3);
        // System.out.println("Main array:" + nums.length);
        // System.out.println("Length:" + k);
        // for(int i = 0; i < k; i++){
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();
        // System.out.println("===============");
        int[] nums1 = {0,1,2,2,3,0,4,2};
        System.out.println("Main array:" + nums1.length);
        int k1 = removeElement(nums1, 2);
        System.out.println("Length:" + k1);
        for(int i = 0; i < k1; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}
