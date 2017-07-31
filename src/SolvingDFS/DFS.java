package SolvingDFS;

import java.util.Stack;

import DriverPackage.Driver;

public class DFS {

	private int[] positon;

	public int[] getPositon() {
		return positon;
	}

	public void setPositon(int[] positon) {
		this.positon = positon;
	}

	private boolean[][] solutionState;

	public DFS(int[] positon) {
		this.positon = positon;
		this.solutionState = dfs();

	}

	boolean[] check;

	public boolean[][] dfs() {

		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];

		NodeDFS root = new NodeDFS(positon);

		// if (root.isSolved()) {
		// return root.getState();
		// }

		Stack<NodeDFS> stack = new Stack<NodeDFS>();
		stack.push(root);
		check[indexing(root.getPositon())] = true;
		NodeDFS curentState = null;

		while (stack.isEmpty() == false) {

			curentState = stack.pop();

			// System.out.println(check[indexing(curentState.getPositon())]
			// +"->"+indexing(curentState.getPositon()) );
			if (curentState.isSolved()) {
				this.positon = curentState.getPositon();
				break;
			}

			positon = curentState.getPositon();

			for (int i = 0; i < Driver.QUEEN_SIZE; i++) {
				NodeDFS node;
				int[] childPositon = positon.clone();
				if (childPositon[i] == 0) {

					childPositon[i] = childPositon[i] + 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeDFS(childPositon);
						if (node.isSolved()) {
							positon = node.getPositon();
							return node.getState();
						}
						stack.push(node);
						check[indexing(childPositon)] = true;
					}

				} else if (childPositon[i] == (Driver.QUEEN_SIZE - 1)) {

					childPositon[i] = childPositon[i] - 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeDFS(childPositon);
						if (node.isSolved()) {
							positon = node.getPositon();
							return node.getState();
						}
						stack.push(node);
						check[indexing(childPositon)] = true;
					}
				} else {
					childPositon[i] = childPositon[i] - 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeDFS(childPositon);
						if (node.isSolved()) {
							positon = node.getPositon();
							return node.getState();
						}
						stack.push(node);
						check[indexing(childPositon)] = true;

					}
					childPositon = positon.clone();
					childPositon[i] = childPositon[i] + 1;
					if (!check[indexing(childPositon)]) {

						node = new NodeDFS(childPositon);
						if (node.isSolved()) {
							positon = node.getPositon();
							return node.getState();
						}
						stack.push(node);
						check[indexing(childPositon)] = true;

					}
				}
				childPositon = positon.clone();

			}
		}

		return curentState.getState();
	}

	private int indexing(int[] positon) {

		int tens = 1, sum = 0;
		for (int i = positon.length - 1; i >= 0; i--) {
			sum += positon[i] * tens;
			tens *= 10;
		}
		return toDecimal(sum);

	}

	private int toDecimal(int number) {
		int sum = 0, i = 0;

		while (number != 0) {
			sum = sum + (number % 10) * (int) Math.pow(Driver.QUEEN_SIZE, i);
			i++;
			number = number / 10;
		}

		return sum;
	}

}
