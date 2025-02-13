import java.util.*;

class Main{

	static class Pair{

		int xSlope;
		int ySlope;

		Pair(int xSlope,int ySlope){

			this.ySlope = ySlope;
			this.xSlope = xSlope;
		}

		public int hashCode() {
			final int prime = 30;
			int result = 1;
			result = prime * result + ySlope;
			result = prime * result + xSlope;
			return result;
		}
		
		// @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (ySlope != other.ySlope)
				return false;
			if (xSlope != other.xSlope)
				return false;
			return true;
		}
	}

	static int findGCD(int x,int y){

		if(y==0) return x;
		else
			return findGCD(y,x%y);
	}

	static Pair getReduced(int dy,int dx){

		int gcd = findGCD(Math.abs(dy),Math.abs(dx));

		boolean isNegOrPos = (dy<0) ^ (dx<0);

		if(isNegOrPos){

			return new Pair(-Math.abs(dy)/gcd,Math.abs(dx)/gcd);

		}else{

			return new Pair(Math.abs(dy)/gcd,Math.abs(dx)/gcd);
		}
	}
	static void find(int mat[][],int x0,int y0,int n){

		HashSet<Pair> hs = new HashSet<Pair>();

		Pair p;
		int minLines = 0;

		for(int i=0;i<n;i++){

			int curX = mat[i][0];
			int curY = mat[i][1];

			//to get the slpoe x2-x1 / y2 -y2 
			// if there slope is same i.e already in set so there is only one path betn these two station
			p = getReduced(curY-y0,curX-x0);


			if(!hs.contains(p)){
				hs.add(p);
				minLines++;
			}
		}

		System.out.println(minLines);
	}
	public static void main(String[] args) {
		
		// from base ;

		int x0 = 1,y0=0;

		int mat[][] = {
        	// {1,1},{-1,1},{2,3}
        	{-1, 3},
        {4, 3},
        {2, 1},
        {-1, -2},
        {3, -3}
        };
        
		int n= mat.length;

		// System.out.println(n);

		find(mat,x0,y0,n);

	}
}