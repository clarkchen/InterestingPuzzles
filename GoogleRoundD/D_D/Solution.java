package D_D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
	String answerStr;
	int n;
	boolean [][] chessBoard;
	ArrayList<Pieces> pces;
	public Solution()
	{
		answerStr="";
		n = s.nextInt();
		int chessWidth = 8;
		chessBoard = new boolean[chessWidth][chessWidth];
		for(int i=0;i<chessWidth;i++)
			for(int j=0;j<chessWidth;j++)
				chessBoard[i][j] =false;
		
		pces =  new ArrayList<Pieces>();
		for(int i=0;i<n;i++)
		{
			String str = s.next();
			String value = str.substring(0, 2);
			char type = str.charAt(str.length()-1);
			Pieces temp = PieceFactory.getObject(type, value);
			pces.add(temp);
			chessBoard[temp.i][temp.j]=true;
		}
		
		
	}
	public void answer() {
		Integer max = 0;
		for(Pieces p: pces)
		{
			max += p.countKill(chessBoard);
		}
		answerStr = max.toString();
	}
	static void output(String content,String Path)
	{
		
	 	try {
			 OutputStreamWriter osw;
			osw = new OutputStreamWriter(new FileOutputStream(Path));
			 osw.write(content,0,content.length());    
		    osw.flush(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = "";
		int t = s.nextInt();
		for(int i=0;i<t;i++)
		{
			Solution sl = new Solution();
			sl.answer();
			res +="Case #"+(i+1)+": "+sl.answerStr+"\n" ;
			
			
		}
		System.out.println(res);
		output(res,"/Users/chenxi/Desktop/d.txt");
		s.close();
	}

}
