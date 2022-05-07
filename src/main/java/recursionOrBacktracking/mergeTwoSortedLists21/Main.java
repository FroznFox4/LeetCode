package recursionOrBacktracking.mergeTwoSortedLists21;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] str = { 1, 2, 3, 4, 5 };
        ArrayList<ListNode> listNode = new ArrayList<>(List.of(new ListNode(str[str.length - 1])));
        for (int i = str.length - 1 - 1; i > -1; i--) {
            listNode.add(new ListNode(str[i], listNode.get(str.length - i - 2)));
        }
        ListNode lastEl = listNode.get(listNode.size() - 1);
        ListNode mew = Solution.getInstance().mergeTwoLists(lastEl, lastEl);
        System.out.println(mew);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2:l1;
        return dummy.next;
    }

    public ListNode mergeTwoListsMy(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode head = (list1.val > list2.val) ? list2 : list1;
        ListNode cur1 = head;
        ListNode cur2 = (list1.val > list2.val) ? list1 : list2;
        while (cur1.next != null && cur2.next != null) {
            if (cur1.val <= cur2.val && cur1.next.val >= cur2.val) {
                insertNode(cur1, cur2);
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else {
                cur1 = cur1.next;
            }
        }
        if (cur1.next == null && cur2.next != null) {
            cur1.next = cur2;
        } else if (cur1.next != null) {
            while (cur1.next != null)
                if (cur1.val <= cur2.val && cur1.next.val >= cur2.val) {
                break;
                } else
                    cur1 = cur1.next;
            insertNode(cur1, cur2);
        } else {
            cur1.next = cur2;
        }
        return head;
    }
    private void insertNode(ListNode main, ListNode node) {
        ListNode next = main.next;
        main.next = new ListNode(node.val);
        main.next.next = next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
