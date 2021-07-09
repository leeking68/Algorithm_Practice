package leetcode;

public class leet700 {
	
	public static void main(String[] args) {
		
	}
	
    public static TreeNode searchBST(TreeNode root, int val) {
         
    	if(root == null) return root;
    	if(root.val > val) return searchBST(root.left, val);
    	if(root.val < val) return searchBST(root.right, val);
        
        return root;
        
    }
    
    public class TreeNode {
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
}


