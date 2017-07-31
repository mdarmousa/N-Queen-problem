package SolvingAStar;
import java.util.LinkedList;
import java.util.PriorityQueue;

import DriverPackage.Driver;



public class AStar {
	
	
private int[] positon;

	

	private boolean[][] solutionState;

	public AStar(int[] positon) {
		this.positon = positon;
		this.solutionState = aStar();

	}
	
	public int[] getPositon() {
		return positon;
	}

	public void setPositon(int[] positon) {
		this.positon = positon;
	}
	
	
	
	

	boolean[] check;

	public boolean[][] aStar() {

		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];

		NodeAStar root = new NodeAStar(positon);

		if (root.isSolved()) {
			return root.getState();
		}
		PriorityQueue <NodeAStar> queue = new PriorityQueue<NodeAStar>();
		queue.add(root);
		check[indexing(root.getPositon())] = true;
		NodeAStar curentState = null;
		while (queue.isEmpty() == false) {

			for (int i = 0; i < Driver.QUEEN_SIZE; i++) {
				NodeAStar node;
				int[] childPositon = positon.clone();
				if (childPositon[i] == 0) {

					childPositon[i] = childPositon[i] + 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeAStar(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;
					}
				} else if (childPositon[i] == (Driver.QUEEN_SIZE - 1)) {

					childPositon[i] = childPositon[i] - 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeAStar(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;
					}
				} else {
					childPositon[i] = childPositon[i] - 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeAStar(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;

					}
					childPositon = positon.clone();
					childPositon[i] = childPositon[i] + 1;
					if (!check[indexing(childPositon)]) {

						node = new NodeAStar(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;

					}
				}
				childPositon = positon.clone();

			}
			curentState = queue.poll();

			// System.out.println(check[indexing(curentState.getPositon())]
			// +"->"+indexing(curentState.getPositon()) );
			if (curentState.isSolved()) {
				this.positon = curentState.getPositon();
				break;
			}

			positon = curentState.getPositon();

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
