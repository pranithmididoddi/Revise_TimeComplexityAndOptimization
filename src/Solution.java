import java.util.Stack;

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
}
