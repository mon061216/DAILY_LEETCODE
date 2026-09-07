package Merge_Two_Sorted_Lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode check = null;
        while (list1.next != null || list2.next != null) {
            if(list1.val <= list2.val){
                if(check == null) check = new ListNode(list1.val,null);
                else{
                    check.next = new ListNode(list1.val);
                    check = check.next;
                }
                list1 = list1.next;                    
            }else{
                if(check == null) check = new ListNode(list2.val,null);
                else{
                    check.next = new ListNode(list2.val);
                    check = check.next;
                }
                list2 = list2.next;
            }
        }
        return check;
    }
}
