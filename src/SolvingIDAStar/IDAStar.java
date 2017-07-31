package SolvingIDAStar;

import java.util.PriorityQueue;

import DriverPackage.Driver;

public class IDAStar {

	private int[] positon;

	private boolean[][] solutionState;

	public IDAStar(int[] positoin) {
		this.positon = positoin;
		this.solutionState = idaStar(0);
	}

	public int[] getPositon() {
		return positon;
	}

	public void setPositon(int[] positon) {
		this.positon = positon;
	}

	//boolean[] check2 = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];;
	boolean[] check;

	public boolean[][] idaStar(int limit) {

		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];

		NodeIDAStar root = new NodeIDAStar(positon, 0);

		// if (root.isSolved()) {
		// return root.getState();
		// }

		PriorityQueue<NodeIDAStar> queue = new PriorityQueue<NodeIDAStar>();
		queue.add(root);
		check[indexing(root.getPositon())] = true;
		//check2[indexing(root.getPositon())] = true;
		NodeIDAStar curentState = null;

		while (queue.isEmpty() == false) {

			curentState = queue.poll();

			// System.out.println(check[indexing(curentState.getPositon())]
			// +"->"+indexing(curentState.getPositon()) );
			
			//if (!check2[indexing(curentState.getPositon())])
				if (curentState.isSolved()) {
					this.positon = curentState.getPositon();
					break;
				}

			int debth = curentState.getLevel();

			positon = curentState.getPositon();

			if (debth < limit) {

				for (int i = 0; i < Driver.QUEEN_SIZE; i++) {
					NodeIDAStar node;
					int[] childPositon = positon.clone();
					if (childPositon[i] == 0) {

						childPositon[i] = childPositon[i] + 1;
						if (!check[indexing(childPositon)]) {
							node = new NodeIDAStar(childPositon, debth + 1);
							//if (!check2[indexing(childPositon)])
								if (node.isSolved()) {
									positon = node.getPositon();
									return node.getState();
								}
							queue.add(node);
							check[indexing(childPositon)] = true;
							//check2[indexing(childPositon)] = true;
						}

					} else if (childPositon[i] == (Driver.QUEEN_SIZE - 1)) {

						childPositon[i] = childPositon[i] - 1;
						if (!check[indexing(childPositon)]) {
							node = new NodeIDAStar(childPositon, debth + 1);
							//if (!check2[indexing(childPositon)])
								if (node.isSolved()) {
									positon = node.getPositon();
									return node.getState();
								}
							queue.add(node);
							check[indexing(childPositon)] = true;
							//check2[indexing(childPositon)] = true;
						}
					} else {
						childPositon[i] = childPositon[i] - 1;
						if (!check[indexing(childPositon)]) {
							node = new NodeIDAStar(childPositon, debth + 1);
							//if (!check2[indexing(childPositon)])
								if (node.isSolved()) {
									positon = node.getPositon();
									return node.getState();
								}
							queue.add(node);
							check[indexing(childPositon)] = true;
							//check2[indexing(childPositon)] = true;

						}
						childPositon = positon.clone();
						childPositon[i] = childPositon[i] + 1;
						if (!check[indexing(childPositon)]) {

							node = new NodeIDAStar(childPositon, debth + 1);
							//if (!check2[indexing(childPositon)])
								if (node.isSolved()) {
									positon = node.getPositon();
									return node.getState();
								}
							queue.add(node);
							check[indexing(childPositon)] = true;
							//check2[indexing(childPositon)] = true;

						}
					}
					childPositon = positon.clone();

				}
			}
		}
		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];
		return idaStar(limit + 1);
	}

	// public boolean[][] idaStar() {
	// int depth=0,limit=1;
	// check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE,
	// Driver.QUEEN_SIZE)];
	//
	// NodeIDAStar root = new NodeIDAStar(positon,0);
	//
	// // if (root.isSolved()) {
	// // return root.getState();
	// // }
	//
	// queue<NodeIDAStar> queue = new queue<NodeIDAStar>();
	// queue.add(root);
	// //check[indexing(root.getPositon())] = true;
	// NodeIDAStar curentState = null;
	//
	// while (queue.isEmpty() == false) {
	//
	//
	//
	// curentState = queue.pop();
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
	// NodeIDAStar node;
	// int[] childPositon = positon.clone();
	// if (childPositon[i] == 0) {
	//
	// childPositon[i] = childPositon[i] + 1;
	// //if (!check[indexing(childPositon)]) {
	// node = new NodeIDAStar(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// queue.add(node);
	// check[indexing(childPositon)] = true;
	// //}
	//
	// } else if (childPositon[i] == (Driver.QUEEN_SIZE - 1)) {
	//
	// childPositon[i] = childPositon[i] - 1;
	// //if (!check[indexing(childPositon)]) {
	// node = new NodeIDAStar(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// queue.add(node);
	// check[indexing(childPositon)] = true;
	// //}
	// } else {
	// childPositon[i] = childPositon[i] - 1;
	// // if (!check[indexing(childPositon)]) {
	// node = new NodeIDAStar(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// queue.add(node);
	// check[indexing(childPositon)] = true;
	//
	// //}
	// childPositon = positon.clone();
	// childPositon[i] = childPositon[i] + 1;
	// // if (!check[indexing(childPositon)]) {
	//
	// node = new NodeIDAStar(childPositon,d);
	// if (node.isSolved()) {
	// positon = node.getPositon();
	// return node.getState();
	// }
	// queue.add(node);
	// check[indexing(childPositon)] = true;
	//
	// //}
	// }
	// childPositon = positon.clone();
	//
	// }
	//
	// limit++;
	// queue.add(root);
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
