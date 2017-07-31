package SolvingDFS;

import DriverPackage.Driver;

public class NodeDFS {

	private boolean[][] state = new boolean[Driver.QUEEN_SIZE][Driver.QUEEN_SIZE];
	private int[] positon;

	public NodeDFS(int[] positon) {
		super();
		genarateState(positon);
		this.positon = positon;
	}

	public boolean[][] getState() {
		return state;
	}

	public void setState(boolean[][] state) {
		this.state = state;
	}

	public int[] getPositon() {
		return positon;
	}

	public void setPositon(int[] positon) {
		this.positon = positon;
	}

	private void genarateState(int[] positon) {

		for (int i = 0; i < state.length; i++) {
			state[i][positon[i]] = true;
		}

	}

	public boolean isSolved() {

		for (int i = 0; i < state.length; i++) {
			int truePosition = positon[i];

			// بنزيد واحد عشان ما نفحص نفس المحل الي فيه true
			// s
			for (int j = i + 1; j < state.length; j++) {
				if (state[j][truePosition] == true) {
					// System.out.println("S");
					return false;
				}
			}

			// sw
			int posOfI = i + 1;
			for (int j = truePosition + 1; j < state.length && posOfI < state.length; j++) {
				if (state[posOfI][j] == true) {
					// System.out.println("Sw");
					return false;
				}
				posOfI++;

			}

			// SE
			posOfI = 0;
			posOfI = i + 1;
			for (int j = truePosition - 1; j >= 0 && posOfI < state.length; j--) {
				if (state[posOfI][j] == true) {
					// System.out.println("Se");
					return false;
				}
				posOfI++;

			}

		}

		return true;
	}

//	public static void main(String[] args) {
//		int[] nn = { 3, 3, 3, 3 };
//
//		NodeDFS n = new NodeDFS(nn);
//		System.out.println(n.isSolved());
//	}

}
