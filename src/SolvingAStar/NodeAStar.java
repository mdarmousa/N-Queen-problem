package SolvingAStar;

import DriverPackage.Driver;

public class NodeAStar implements Comparable{

	private boolean[][] state = new boolean[Driver.QUEEN_SIZE][Driver.QUEEN_SIZE];
	private int[] positon;
	private int countOfconfilct;

	

	public NodeAStar(int[] positon) {
		super();
		genarateState(positon);
		this.positon = positon;
		countOfconfilct=countConflict();
		
	}
	
	
	public int getCountOfconfilct() {
		return countOfconfilct;
	}

	public void setCountOfconfilct(int countOfconfilct) {
		this.countOfconfilct = countOfconfilct;
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
	
	public int countConflict(){
		int count=0;
		for (int i = 0; i < state.length; i++) {
			
			int truePosition = positon[i];

			// بنزيد واحد عشان ما نفحص نفس المحل الي فيه true
			// s
			for (int j = i + 1; j < state.length; j++) {
				if (state[j][truePosition] == true) {
					// System.out.println("S");
					count++;
				}
			}

			// sw
			int posOfI = i + 1;
			for (int j = truePosition + 1; j < state.length && posOfI < state.length; j++) {
				if (state[posOfI][j] == true) {
					// System.out.println("Sw");
					count++;
				}
				posOfI++;

			}

			// SE
			posOfI = 0;
			posOfI = i + 1;
			for (int j = truePosition - 1; j >= 0 && posOfI < state.length; j--) {
				if (state[posOfI][j] == true) {
					// System.out.println("Se");
					count++;
				}
				posOfI++;

			}

		}

		return count;
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


	@Override
	public int compareTo(Object node) {
			if(this.countConflict()>((NodeAStar)node).countOfconfilct)
				return 1;
			else if(this.countConflict()<((NodeAStar)node).countOfconfilct)
				return -1;
			else
				return 0;
		
	
	}
	
//	public static void main(String[] args) {
//		int[] aa= {0,0,0,0};
//		NodeAStar a =new NodeAStar(aa);
//		int[] bb= {1,1,1,1};
//		NodeAStar b =new NodeAStar(bb);
//		
//		System.out.println(b.compareTo(a));
//	}
}
