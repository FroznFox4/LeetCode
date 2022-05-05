package breadthFirstSearchOrDepthFirstSearch.mergeTwoBinaryTrees617;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode();
        TreeNode mew = Solution.getInstance().mergeTrees(root1, root2);
        System.out.println(mew.toString());
    }
}
class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        else if (root2 == null)
            return root1;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if (node1 == null || node2 == null)
                continue;

            node1.val += node2.val;

            if (node1.left == null)
                node1.left = node2.left;
            else {
                q1.add(node1.left);
                q2.add(node2.left);
            }

            if (node1.right == null)
                node1.right = node2.right;
            else {
                q1.add(node1.right);
                q2.add(node2.right);
            }
        }
        return root1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
}