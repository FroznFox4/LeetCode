package breadthFirstSearchOrDepthFirstSearch.populatingNextRightPointersInEachNode116;

public class Main {
    public static void main(String[] args) {
        Node root = new Node();
        Node mew = Solution.getInstance().connect(root);
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

    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}

// Definition for a Node.
class Node {
//    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
}

