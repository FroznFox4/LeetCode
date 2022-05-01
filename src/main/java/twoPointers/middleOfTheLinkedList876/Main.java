package twoPointers.middleOfTheLinkedList876;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] str = { 1, 2, 3, 4, 5 };
        ArrayList<ListNode> listNode = new ArrayList<>(List.of(new ListNode(str[str.length - 1])));
        for (int i = str.length - 1 - 1; i > -1; i--) {
            listNode.add(new ListNode(str[i], listNode.get(str.length - i - 2)));
        }
        ListNode lastEl = listNode.get(listNode.size() - 1);
        Solution.getInstance().middleNode(lastEl);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

//    Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.
//    Space Complexity: O(1)O(1), the space used by slow and fast.

//    Runtime: 0 ms, faster than 100.00%; Memory Usage: 42 MB, less than 20.24%
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

//Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.
//Space Complexity: O(N)O(N), the space used by A.

//    Runtime: 0 ms, faster than 100.00%; Memory Usage: 42.2 MB, less than 15.34%
    public ListNode middleNodeMy(ListNode head) {
        int countNodes = 1;
        ListNode headCurr = head;
        while (headCurr.next != null) {
            headCurr = headCurr.next;
            countNodes += 1;
        }
        headCurr = head;
        for (int i = 0; i < countNodes / 2; i++) {
            headCurr = headCurr.next;
        }
        return headCurr;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
