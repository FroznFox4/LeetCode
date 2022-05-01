package twoPointers.RemoveNthNodeFromEndOfList19;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] str = { 1 };
        int nth = 1;
        ArrayList<ListNode> listNode = new ArrayList<>(List.of(new ListNode(str[str.length - 1])));
        for (int i = str.length - 1 - 1; i > -1; i--) {
            listNode.add(new ListNode(str[i], listNode.get(str.length - i - 2)));
        }
        ListNode lastEl = listNode.get(listNode.size() - 1);
        Solution.getInstance().removeNthFromEnd(lastEl, nth);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

//    Runtime: 1 ms, faster than 56.97%; Memory Usage: 41.7 MB, less than 68.75%
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int itr = 0; itr <= n; itr++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

//    Runtime: 1 ms, faster than 56.97%; Memory Usage: 42.5 MB, less than 29.64%
    public ListNode removeNthFromEndMy(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode currHead = head;
        while (currHead.next != null) {
            listNodes.add(currHead);
            currHead = currHead.next;
        }
        listNodes.add(currHead);
        if (listNodes.size() == 1 && n > 0)
            return new ListNode().next;
        else if (n == 1)
            listNodes.get(listNodes.size() - 2).next = null;
        else if (n == listNodes.size())
            head = listNodes.get(1);
        else
            listNodes.get(listNodes.size() - n - 1).next = listNodes.get(listNodes.size() - n + 1);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}