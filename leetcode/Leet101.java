package leetcode;

public class Leet101 {
	
	    public boolean isSymmetric(TreeNode root) {
	        return checkSymmetrie(root.left, root.right);
	    }
	    public static boolean checkSymmetrie(TreeNode leftNode, TreeNode rightNode){
	        if (leftNode == null && rightNode == null) return true;
	        else if (leftNode == null || rightNode == null) return false;
	        
	        if (leftNode.val == rightNode.val)  return checkSymmetrie(leftNode.right, rightNode.left) && checkSymmetrie(leftNode.left, rightNode.right);
	        else return false;
	    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

