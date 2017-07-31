package SolvingBFS;

import DriverPackage.*;

public class NodeBFS {

	// هاي بكون فيها الحالة بعد تغير موقع واحد
	private boolean[][] state = new boolean[Driver.QUEEN_SIZE][Driver.QUEEN_SIZE];
	private int[] positon;

	public NodeBFS(int[] positon) {
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
		// for (int i = 0; i < positon.length; i++) {
		// for (int j = 0; j < positon.length; j++) {
		// System.out.print(state[i][j]);
		// }
		// System.out.println();
		// }

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

			// N
//			for (int j = i - 1; j >= 0; j--) {
//				if (state[j][truePosition] == true) {
//					// System.out.println("n");
//					return false;
//				}
//			}

			// sw
			int posOfI = i + 1;
			for (int j = truePosition + 1; j < state.length && posOfI < state.length; j++) {
				if (state[posOfI][j] == true) {
					// System.out.println("Sw");
					return false;
				}
				posOfI++;

			}

			// NE
//			posOfI = 0;
//			posOfI = i - 1;
//			for (int j = truePosition - 1; j >= 0 && posOfI >= 0; j--) {
//				if (state[posOfI][j] == true) {
//					// System.out.println("ne");
//					return false;
//				}
//				posOfI--;
//
//			}

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

			// NW
//			posOfI = 0;
//			posOfI = i - 1;
//			for (int j = truePosition + 1; j < state.length && posOfI >= 0; j++) {
//				if (state[posOfI][j] == true) {
//					System.out.println("Nw");
//					return false;
//				}
//				posOfI--;
//
//			}

		}

		return true;
	}

//	 public static void main(String[] args) {
//	 int[] nn = {3,3,3,3 };
//	
//	 NodeBFS n = new NodeBFS(nn);
//	 System.out.println(n.isSolved());
//	 }

}
