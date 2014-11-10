package D_D;
import java.util.*;
public abstract class Pieces {
	int i,j;
	public Pieces(String s)
	{
		i=s.charAt(0)-'A';
		j=s.charAt(1)-'1';
		
	}
	abstract int countKill(boolean[][] chessBoard);
}
