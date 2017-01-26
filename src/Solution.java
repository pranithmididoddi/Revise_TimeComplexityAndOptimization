import java.util.*;

/**
 * Created by Pranith on 1/19/17.
 */
public class Solution {

    public static void main(String[] args) {
        Stack<Integer> result = new Stack<>();
        result.push(3);
        result.push(9);
        result.push(2);
        result.push(1);
        result.push(7);
        result.push(8);

        System.out.println(sortStack(result));

    }

    public static Stack<Integer> sortStack(Stack<Integer> nStack) {

        Stack<Integer> rStack=new Stack<>();
        int temp=0;

        rStack.push(nStack.pop());

        while(!nStack.empty()){
            temp=nStack.pop();

            while(!rStack.empty() && temp >rStack.peek()){
                nStack.push(rStack.pop());
            }
            rStack.push(temp);
        }
        return rStack;
    }

    /**Symmetry Check*/
    public boolean isSymmetric(TreeNode root) {

        if(root==null) return true;

        if(symetryCheck(root.left,root.right)) return true;

        return false;

    }

    public boolean symetryCheck(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        if(p.val==q.val){
            return symetryCheck(p.left,q.right)&&symetryCheck(p.right,q.left);
        }

        return false;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        TreeNode p=root;

        while(!stack.empty() || p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else{
                TreeNode temp=stack.pop();
                list.add(temp.val);
                p=temp.right;
            }
        }
        return list;
    }

    public ListNode partition(ListNode head, int x) {

        if(head==null) return null;

        ListNode leftDummy=new ListNode(0);
        ListNode rightDummy=new ListNode(0);

        ListNode left=leftDummy;
        ListNode right=rightDummy;

        while(head!=null){
            if(head.val<x){
                left.next=head;
                left=head;
            }
            else{
                right.next=head;
                right=head;
            }

            head=head.next;
        }

        right.next=null;
        left.next=rightDummy.next;

        return leftDummy.next;

    }


}
