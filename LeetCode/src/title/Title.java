package title;

import bean.ListNode;
import bean.TreeNode;

import java.util.*;

public class Title {

    /**
     * 将有序数组转换为二叉搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue queue = new LinkedList();

        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = (TreeNode) queue.poll();
                list1.add(treeNode.val);
                if (treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
            }
            list.add(list1);
        }

        return list;
    }

    /**
     * 对称二叉树：空树也是对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }else{
            return isSymmetric(root.left,root.right);
        }

    }
    private boolean isSymmetric(TreeNode left,TreeNode right){
        if ( left == null && right == null ){
            return true;
        }else if ( left == null || right == null){
            return false;
        }
        return left.val==right.val
                && isSymmetric(left.left,right.right)
                && isSymmetric(left.right,right.left);
    }

    /**
     * 验证二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        List<Integer> list = new ArrayList<>();

        inOrder(root,list);

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1)){
                return false;
            }
        }

        return true;
    }

    //树的中序遍历
    private void inOrder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }

        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);

    }

    /**
     * 二叉树的最大深度
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }

    }

    /**
     * 环形链表:两个指针不断移动，如果循环，必定会相遇
     */
    public boolean hasCycle(ListNode head){

        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }

        return false;
    }

    /**
     * 回文链表
     */
    public boolean isPalindrome(ListNode head){

        //如果为空，直接返回true
        if (head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        //若为奇数个，跳过中间的数
        if (fast != null){
            slow = slow.next;
        }

        while (slow != null){
            if (stack.pop() != slow.val){
                return  false;
            }
            slow = slow.next;
        }
        return true;
    }

}
