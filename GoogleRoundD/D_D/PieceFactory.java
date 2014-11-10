package D_D;
import java.util.*;
public class PieceFactory {
	static Pieces getObject(char p,String value)
	{
		Pieces rt =null;
		switch (p) {
		case 'K':
			rt = new King(value);
			break;
		case 'Q':
			rt = new Queen(value);
			break;
		case 'R':
			rt =  new Rook(value);break;
		case 'B':
			rt = new Bishop(value);break;
		case 'N':
			rt = new Knights(value);break;
		case 'P':
			rt =new Pawn(value);break;
		default:
			break;
		}
		return rt;
	}
}
