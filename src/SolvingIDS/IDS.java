package SolvingIDS;

import java.util.Stack;

import DriverPackage.Driver;

public class IDS {

	private int[] positon;

	private boolean[][] solutionState;

	public IDS(int[] positon) {
		this.positon = positon;
		this.solutionState = ids(0);

	}

	public int[] getPositon() {
		return positon;
	}

	public void setPositon(int[] positon) {
		this.positon = positon;
	}

	boolean[] check;

	public boolean[][] ids(int limit) {

		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];

		NodeIDS root = new NodeIDS(positon, 0);

		// if (root.isSolved()) {
		// return root.getState();
		// }

		Stack<NodeIDS> stack = new Stack<NodeIDS>();
		stack.push(root);
		check[indexing(root.getPositon())] = true;
		NodeIDS curentState = null;

		while (stack.isEmpty() == false) {

			curentState = stack.pop();

			// System.out.println(check[indexing(curentState.getPositon())]
			// +"->"+indexing(curentState.getPositon()) );
			if (curentState.isSolved()) {
				this.positon = curentState.getPositon();
				break;
			}

			int debth = curentState.getLevel();

			positon = curentState.getPositon();

			if (debth < limit) {

				for (int i = 0; i < Driver.QUEEN_SIZE; i++) {
					NodeIDS node;
					int[] childPositon = positon.clone();
					if (childPositon[i] == 0) {

						childPositon[i] = childPositon[i] + 1;
						if (!check[indexing(childPositon)]) {
							node = new NodeIDS(childPositon, debth + 1);
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
							node = new NodeIDS(childPositon, debth + 1);
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
							node = new NodeIDS(childPositon, debth + 1);
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

							node = new NodeIDS(childPositon, debth + 1);
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
		}
		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];
		return ids(limit+1);
	}

	// public boolean[][] ids() {
	// int depth=0,limit=1;
	// check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE,
	// Driver.QUEEN_SIZE)];
	//
	// NodeIDS root = new NodeIDS(positon,0);
	//
	// // if (root.isSolved()) {
	// // return root.getState();
	// // }
	//
	// Stack<NodeIDS> stack = new Stack<NodeIDS>();
	// stack.push(root);
	// //check[indexing(root.getPositon())] = true;
	// NodeIDS curentState = null;
	//
	// while (stack.isEmpty() == false) {
	//
	//
	//
	// curentState = stack.pop();
	//
	// // System.out.println(check[indexing(curentState.getPositon())]
	// // +"->"+indexing(curentState.getPositon()) );
	// if (curentState.isSolved()) {
	// this.positon = curentState.getPositon();
	// break;
	// }
	//
	// positon = curentState.getPositon();
	// if(depth<limit )
	// for (int i = 0; i < Driver.QUEEN_SIZE; i++) {
	// int d=depth+1;
	// NodeIDS node;
	// int[] childPositon = positon.clone();
	// if (childPositon[i] == 0) {
	//
	// childPositon[i] = childPositon[i] + 1;
	// //if (!check[indexing(childPositon)]) {
	// node = new NodeIDS(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// stack.push(node);
	// check[indexing(childPositon)] = true;
	// //}
	//
	// } else if (childPositon[i] == (Driver.QUEEN_SIZE - 1)) {
	//
	// childPositon[i] = childPositon[i] - 1;
	// //if (!check[indexing(childPositon)]) {
	// node = new NodeIDS(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// stack.push(node);
	// check[indexing(childPositon)] = true;
	// //}
	// } else {
	// childPositon[i] = childPositon[i] - 1;
	// // if (!check[indexing(childPositon)]) {
	// node = new NodeIDS(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// stack.push(node);
	// check[indexing(childPositon)] = true;
	//
	// //}
	// childPositon = positon.clone();
	// childPositon[i] = childPositon[i] + 1;
	// // if (!check[indexing(childPositon)]) {
	//
	// node = new NodeIDS(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// stack.push(node);
	// check[indexing(childPositon)] = true;
	//
	// //}
	// }
	// childPositon = positon.clone();
	//
	// }
	//
	// limit++;
	// stack.push(root);
	//
	// }
	//
	//
	//
	//
	// return solutionState;
	//
	//
	// }

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
