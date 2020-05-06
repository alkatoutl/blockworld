package lecture.lab3;

public class BlockWorld1 {

	private int n;
	private String [][] cellCoord;
	
	public BlockWorld1(){
		n = 10;
		cellCoord = new String [n][n];
		for(int i = 0; i<cellCoord.length; i++) {
			for(int j = 0; j<cellCoord[i].length; j++) {
				cellCoord[i][j] = "X";
			}
		}
	}
	
	public BlockWorld1(int n) {
		this.n = n;
		cellCoord = new String [n][n];
		for(int i = 0; i<cellCoord.length; i++) {
			for(int j = 0; j<cellCoord[i].length; j++) {
				cellCoord[i][j] = "X";
			}
		}
	}
	
	public void setCellColor(int x, int y, boolean setWhite) {			// x = column,  y = row
		if(setWhite) 
			cellCoord[y][x] = " ";
	}
	
	public boolean getCellColor(int x, int y) {
		if(cellCoord[y][x].equals(" "))
			return true;
		else
			return false;
	}
	
	public String toString() {
		 for(int i = 0; i<cellCoord.length; i++) {
			if(i != 0)
				System.out.println();
				for(int j = 0; j<cellCoord[i].length; j++) {
					System.out.print(" " + cellCoord[i][j]);
				}
		 }
		 return null;
	}
	
	public static void main(String [] args) {
		BlockWorld1 n = new BlockWorld1(3);
		n.setCellColor(0, 0, true);
		n.setCellColor(2, 2, true);
		n.toString();
	}
}
