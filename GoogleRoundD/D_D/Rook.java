package D_D;
import java.util.*;
public class Rook extends Pieces {

	int max = 0;
	public Rook(String s) {
		super(s);
	}
	 
 
	@Override
	public int countKill(boolean[][] chessBoard) {
		int x[] ={0,-1,0,1};
		int y[]= {-1,0,1,0};
		
		for(int k = 0;k<x.length;k++)
		{
			int x1 = i+x[k];
			int y1 = j+y[k];
			while(x1>=0 && y1>=0 && x1<chessBoard.length && y1<chessBoard.length )
			{
				if(chessBoard[x1][y1])
				{
					max++; break;
				}
				x1 += x[k];
				y1 += y[k];
				
			}
		}
		
		return max;
	}

}
