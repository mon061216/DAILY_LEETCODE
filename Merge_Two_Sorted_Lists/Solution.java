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
        ListNode result = new ListNode(-1); //khỏi tạo có node là -1, để khỏi phải check điều kiện empty
        ListNode check = result; //con trỏ để chạy

        //Tại sao lại dùng && ở đây ???
        while (list1 != null  && list2 != null) {
            if(list1.val <= list2.val){
                check.next = list1;
                list1 = list1.next;                    
            }else{
                check.next = list2;
                list2 = list2.next;
            }
            check = check.next;
        }
        //Chỗ này kiểm tra xem còn list nào còn dư phần tử thì ghép vào
        check.next = list1 != null ? list1 : list2;
        return result.next;
    }
}
