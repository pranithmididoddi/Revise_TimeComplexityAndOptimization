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

        Stack<Integer> fstack=new Stack<>();
        int temp=0;

        fstack.push(nStack.pop());

        while(!nStack.empty()){
            temp=nStack.pop();

            while(!fstack.empty() && temp<fstack.peek()){
                nStack.push(fstack.pop());
            }
            fstack.push(temp);

        }
        return fstack;
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

    public boolean hasCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) return true;
        }
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            inverted(root);
        }

        return root;


    }

    public void inverted(TreeNode root){
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null){
            inverted(root.left);
        }
        if(root.right!=null){
            inverted(root.right);
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy=new ListNode(0);
        ListNode head=dummy;

        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    head.next=l1;
                    l1=l1.next;
                }else{
                    head.next=l2;
                    l2=l2.next;
                }
                head=head.next;
            }
            else if(l1==null){
                head.next=l2;
                break;
            }
            else if(l2==null){
                head.next=l1;
                break;
            }
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {

        if(head==null) return null;
        if(head.next==null)return head;

        ListNode current=head;
        ListNode next=null;
        ListNode previous=null;

        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        return previous;

    }
}
