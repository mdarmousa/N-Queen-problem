package SolvingIDAStar;

import DriverPackage.Driver;


public class NodeIDAStar implements Comparable {

	private boolean[][] state = new boolean[Driver.QUEEN_SIZE][Driver.QUEEN_SIZE];
	private int[] positon;
	private int level;
	private int countOfconfilct;

	public NodeIDAStar(int[] positon,int level) {
		genarateState(positon);	
		this.positon = positon;
		countOfconfilct=countConflict();	
		this.level=level;	
	}
	
	
	public int getCountOfconfilct() {
		return countOfconfilct;
	}

	public void setCountOfconfilct(int countOfconfilct) {
		this.countOfconfilct = countOfconfilct;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

			// Ø¨Ù†Ø²ÙŠØ¯ ÙˆØ§Ø­Ø¯ Ø¹Ø´Ø§Ù† Ù…Ø§ Ù†Ù�Ø­Øµ Ù†Ù�Ø³ Ø§Ù„Ù…Ø­Ù„ Ø§Ù„ÙŠ Ù�ÙŠÙ‡ true
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
	public int countConflict(){
		int count=0;
		for (int i = 0; i < state.length; i++) {
			
			int truePosition = positon[i];

			// Ø¨Ù†Ø²ÙŠØ¯ ÙˆØ§Ø­Ø¯ Ø¹Ø´Ø§Ù† Ù…Ø§ Ù†Ù�Ø­Øµ Ù†Ù�Ø³ Ø§Ù„Ù…Ø­Ù„ Ø§Ù„ÙŠ Ù�ÙŠÙ‡ true
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
	
	@Override
	public int compareTo(Object node) {
			if(this.countConflict()>((NodeIDAStar)node).countOfconfilct)
				return 1;
			else if(this.countConflict()<((NodeIDAStar)node).countOfconfilct)
				return -1;
			else
				return 0;
		
	
	}
	

	// public static void main(String[] args) {
	// int[] nn = { 3, 3, 3, 3 };
	//
	// NodeDFS n = new NodeDFS(nn);
	// System.out.println(n.isSolved());
	// }
}
