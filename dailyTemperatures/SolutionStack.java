package dailyTemperatures;

import java.util.Stack;
// TC O(N) SC O(1)
public class SolutionStack {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int LENGTH = temperatures.length;
        int[] result = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pastDay = stack.pop();
                result[pastDay] = i - pastDay;
            }
            stack.push(i);
        }
        return result;
    }
}
