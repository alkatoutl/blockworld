package lecture.lab3;

public class BlockWorld {

	// the dimensions of the world
		private int n;
		// stores the n x n world
		private boolean[][] world;
		
		/**
		 * Create a BlockWorld which is a n x n grid. Initially all cells are black (false).
		 * 
		 * @param n the size of the quadratic grid 
		 */
		public BlockWorld(int n) {
			this.n = n;
			this.world = new boolean[n][n];
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					world[x][y] = false;
				}
			}
		}
		
		

		/**
		 * Creates a 1 x 1 world. Initially all cells are black (false).
		 */
		protected BlockWorld() {
			this(10);
		}
		
		/**
		 * Set the color of the cell at position (x,y). If the point (x,y) is 
		 * outside of the n x n grid, then the method returns without changing any 
		 * cell.
		 * 
		 * @param x the x-coordinate of the cell
		 * @param y the y-coordinate of the cell
		 * @param isWhite true if the cell should be colored white and false if black
		 */
		public void setCellColor(int x, int y, boolean isWhite) {
			if (x > getN() || x < 0 || y > getN() || y < 0)
				return;
			world[x][y] = isWhite;
		}
		
		/**
		 * Get the current color of the cell at (x,y). If (x,y) is outside of the n x n grid, then return black (false).
		 * 
		 * @param x the x-coordinate of the cell
		 * @param y the y-coordinate of the cell
		 * @return the color of the cell at (x,y)
		 */
		public boolean getCellColor(int x, int y) {
			if (x > getN() || x < 0 || y > getN() || y < 0)
				return false;
			return world[x][y];
		}
		
		/**
		 * Encodes the world as a String where black cells are represented as 'X' 
		 * and white cells as ' '.
		 */
		public String toString() {
			StringBuilder b = new StringBuilder();
			
			for(int y = 0; y < getN(); y++) {
				for(int x = 0; x < getN(); x++) {
					b.append(world[x][y] ? " " : "X");
				}
				b.append("\n");
			}
			
			return b.toString();
		}
		
		/**
		 * Creates a 3 x 3 block world, sets the top-left and bottom-right cell to 
		 * white, and prints the world to stdout.
		 * 
		 * @param args ignored
		 */
		public static void main(String[] args) {
			BlockWorld n = new BlockWorld(3);
			n.setCellColor(1,0,true); // set top-left cell
			n.setCellColor(2,2,true); // set bottom-right cell
			System.out.println(n.toString());
		}

		/**
		 * Returns the width/height of the quadratic grid.
		 * 
		 * @return the size n
		 */
		public int getN() {
			return n;
		}
	}
