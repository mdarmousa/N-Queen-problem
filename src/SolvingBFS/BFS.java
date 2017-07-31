package SolvingBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import DriverPackage.*;

public class BFS {

	private int[] positon;

	

	private boolean[][] solutionState;

	public BFS(int[] positon) {
		this.positon = positon;
		this.solutionState = bfs();

	}
	
	public int[] getPositon() {
		return positon;
	}

	public void setPositon(int[] positon) {
		this.positon = positon;
	}
	
	
	
	

	boolean[] check;

	public boolean[][] bfs() {

		check = new boolean[(int) Math.pow(Driver.QUEEN_SIZE, Driver.QUEEN_SIZE)];

		NodeBFS root = new NodeBFS(positon);

		if (root.isSolved()) {
			return root.getState();
		}
		Queue<NodeBFS> queue = new LinkedList<NodeBFS>();
		queue.add(root);
		check[indexing(root.getPositon())] = true;
		NodeBFS curentState = null;
		while (queue.isEmpty() == false) {

			for (int i = 0; i < Driver.QUEEN_SIZE; i++) {
				NodeBFS node;
				int[] childPositon = positon.clone();
				if (childPositon[i] == 0) {

					childPositon[i] = childPositon[i] + 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeBFS(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;
					}
				} else if (childPositon[i] == (Driver.QUEEN_SIZE - 1)) {

					childPositon[i] = childPositon[i] - 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeBFS(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;
					}
				} else {
					childPositon[i] = childPositon[i] - 1;
					if (!check[indexing(childPositon)]) {
						node = new NodeBFS(childPositon);
						queue.add(node);
						check[indexing(childPositon)] = true;

					}
					childPositon = positon.clone();
					childPositon[i] = childPositon[i] + 1;
					if (!check[indexing(childPositon)]) {

						node = new NodeBFS(childPositon);
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

	public void tooString() {
		System.out.println("BFS [positon=" + Arrays.toString(positon));

		for (int i = 0; i < positon.length; i++) {
			for (int j = 0; j < positon.length; j++) {
				System.out.print(solutionState[i][j]);
			}
			System.out.println();
		}

	}

}
