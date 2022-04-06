/*
SUMMARY
make a second stack that holds the minimum so far, and pop/push together


MAIN IDEA
you can use the Stack class and use pop() peek() push() isEmpty()
the main task for this problem is to implement the getMin method

Because we need to getMin with constant time, we can't iterate.
Instead, we will have a second stack that holds the min values so far,
The reason why we need to track in a second stack not a single variable,
is because it will change as we  pop elements off

 */
package MinStack;

import java.util.Stack;

public class MinStack {
  
  private Stack<Integer> stack;
  private Stack<Integer> minStack;
  
  public MinStack() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }
  
  public void push(int val) {
     stack.push(val);
     if (minStack.isEmpty()){
       minStack.push(val);
     } else if (val < minStack.peek()){
       minStack.push(val);
     } else {
       minStack.push(minStack.peek());
     }
  }
  
  public void pop() {
    stack.pop();
    minStack.pop();
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return minStack.peek();
  }
  
  public static void main(String[] args){
  
    MinStack minStack = new MinStack();
    
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top());    // return 0
    System.out.println(minStack.getMin()); // return -2
  
  }
}
