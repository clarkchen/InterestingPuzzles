package D_D;
import java.util.*;
public class King extends Pieces {
	int max = 0;
	public King(String s) {
		super(s);
	}
	 
	@Override
	public int countKill(boolean[][] chessBoard) {
		// TODO Auto-generated method stub
		//move to eight directons 
		int x[] ={1,0,-1,-1,-1,0,1,1};
		int y[]= {-1,-1,-1,0,1,1,1,0};
		
		for(int k = 0;k<x.length;k++)
		{
			int x1 = i+x[k];
			int y1 = j+y[k];
			if(x1>=0 && y1>=0 && x1<chessBoard.length && y1<chessBoard.length ){
				if(chessBoard[x1][y1]) max++;
			}
			
		}
			
		
		return max;
	}

}
