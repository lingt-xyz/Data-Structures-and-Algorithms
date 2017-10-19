/**
 * Created by Ling Tan on 2017-02-08.
 *
 *         Use a stack and a queue to generate the power of a set T.
 *         (non-recursive)
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class Q2 {
  public static Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
	public static Queue<ArrayList<Integer>> queue = new ArrayDeque<ArrayList<Integer>>();

	public static void PowerOfSet(Integer[] values) {
		stack.add(new ArrayList<Integer>());
		for (Integer value : values) {
			while (!stack.isEmpty()) {
				ArrayList<Integer> previousValues = stack.pop();
				queue.offer(previousValues);
				ArrayList<Integer> newValues = new ArrayList<Integer>(previousValues);
				newValues.add(value);
				queue.offer(newValues);
			}
			while (!queue.isEmpty()) {
				stack.add(queue.poll());
			}
		}
	}

	public static void main(String[] args) {
		Integer[] values = { 1, 2, 3, 4 };
		PowerOfSet(values);
		Iterator<ArrayList<Integer>> it = stack.iterator();
		while (it.hasNext()) {
			ArrayList<Integer> sets = it.next();
			System.out.print("{");
			for (Integer value : sets) {
				System.out.print(value + " ");
			}
			System.out.println("}");
		}
	}
}
