package lecture.lab3;
import java.util.*;

public class InfiniteBlockWorld extends BlockWorld1 {

	Map<Integer, Map<Integer, String>> grid= new HashMap<Integer, Map<Integer, String>>();
	private int n;
	
	
	//constructors
	public InfiniteBlockWorld() {
		n = 10;
		for(int i = 0; i<n; i++) {
			grid.put(i, new HashMap<Integer, String>());
			grid.get(i).put(i, "X");
		}
	}
		
	public InfiniteBlockWorld(int n) {
		this.n = n;
			for(int i=0; i<n; i++) {
			grid.put(i, new HashMap<Integer, String>());
				for(int j = 0; j<n; j++) {
					grid.get(i).put(j, "X");
				}
			}	
	}
	
	
	
	//setCellColor method
	public void setCellColor(int x, int y, boolean setWhite) {			
		if(setWhite) {
			
			if(grid.containsKey(x)) {
				
				if(grid.get(x).containsKey(y)) {
					grid.get(x).put(y, " ");
				}
				else {
					for(int i : grid.keySet()) {
						grid.get(i).put(y, "X");
					}
					grid.get(x).put(y, " ");	
				}	
			}
			else {
				grid.put(x, new HashMap<Integer, String>());
				for(int i : grid.get(0).keySet()) {
					grid.get(x).put(i, "X");
				}
				if(grid.get(x).containsKey(y)) {
				grid.get(x).put(y, " ");
				}
				else {
					for(int i : grid.keySet()) {
						grid.get(i).put(y, "X");
					}
					grid.get(x).put(y, " ");
				}
			}	
		}
	}
	
	//toString method
	public String toString() {					//go through each x and print out every y
		for(int i : grid.keySet()) {
			System.out.println(grid.get(i).values());
		}
		 return null;
	}
	
	//getBounds method
	public int [] getBounds() {
		int xLow = 0;
		int xHigh = 0;
		int yLow = 0;
		int yHigh = 0;
		int max = 0;
		for(int i : grid.keySet()) {
			for(String b : grid.get(i).values()) {
				if(b.equals(" ")) {
					xLow = i;
				}
			}
			for(int w : grid.get(i).keySet()) {
				for(String g : grid.get(w).values()) {
					if(g.equals(" ")) {
						yHigh = w;
						}
					}
				}
		}
		for(int h : grid.keySet()) {
			for(String z : grid.get(h).values()) {
				if(z.equals(" ")) {
					if(h > max) {
						xHigh = max;
					}
				}
			}
			for(int r : grid.get(h).keySet()) {
				for(String p : grid.get(r).values()) {
					if(p.equals(" ")) {
						if(r < yHigh) {
							yLow = r;
						}
					}
				}
			}
		}
		
		int [] bounds = {xLow, xHigh, yLow, yHigh};
		return bounds;
	}
	
	
	//Main method
	public static void main(String [] args) {
		InfiniteBlockWorld n = new InfiniteBlockWorld(3);
		n.setCellColor(-1, -1, true);
		n.setCellColor(2, 1, true);
		n.toString();
	}
}
