/**
 * 
 */
package D_A;
import java.util.*;
/**
 * @author chenxi
 *
 */
public class Solution {
	int S;
	int minI = Integer.MAX_VALUE;
	int maxV = Integer.MIN_VALUE;
	int count[][];
	int value[][];
	public Solution() {
		// TODO Auto-generated constructor stub
	 	S =  s.nextInt();
		count = new int[S][S];
		value = new int[S][S];
		for(int i=0;i<S;i++)
			for(int j=0;j<S;j++)
			{
				count[i][j] = Integer.MIN_VALUE;
				value[i][j] = s.nextInt();
			}
		 
	}
	void moveMax(int i, int j)
	{
		int max = 1;
		if(count[i][j]==Integer.MIN_VALUE) count[i][j] = max;
		Queue<Integer> q = new LinkedList<Integer>();
		int v = i*S + j;
		q.offer(v);
		while(!q.isEmpty())
		{
			v = q.poll();
			int x = v/S;
			int y = v%S;
			//up  x-1,y
			if(x>0 && value[x-1][y]==value[x][y] +1 )
			{
				
		 		if(count[x-1][y]!=Integer.MIN_VALUE ) {
					count[i][j] = count[x-1][y]+count[i][j];return;
				}
				else 
				{
					count[i][j]++;
				}
				q.offer((x-1)*S+y);
				 
			}
			else if(x<S-1 && value[x+1][y]==value[x][y]+1)//down
			{
				if(count[x+1][y]!=Integer.MIN_VALUE)  {
					count[i][j] = count[x+1][y]+count[i][j];return;
				}
				else 
				{
					count[i][j]++;
				}
				q.offer((x+1)*S+y);
			}
			else if(y>0 && value[x][y-1]==value[x][y]+1)
			{
				if(count[x][y-1]!=Integer.MIN_VALUE )  {
					count[i][j] = count[x][y-1]+count[i][j];return;
				}
				else 
				{
					count[i][j]++;
				}
				q.offer(x*S+y-1);
			}
			else if(y<S-1 && value[x][y+1]==value[x][y]+1)
			{
				if(count[x][y+1]!=Integer.MIN_VALUE )  {
					count[i][j] = count[x][y+1]+count[i][j];return;
				}
				else 
				{
					count[i][j]++;
				}
				q.offer(x*S+y+1);
			}
			
		}
		
	}
	public void answer()
	{
		for(int i=0;i<S;i++)
			for(int j=0;j<S;j++)
			{
				moveMax(i, j);
				if(count[i][j]>maxV )
				{
					maxV = count[i][j];
					minI = value[i][j];
				}
				else if(count[i][j]==maxV && value[i][j]<minI)
				{
					maxV = count[i][j];
					minI = value[i][j];
				}
			}
		
	}
	
	/**
	 * @param args
	 */
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String res = "";
		int t = s.nextInt();
		for(int i=0;i<t;i++)
		{
			Solution sl = new Solution();
			sl.answer();
			//Case #2: 6 4
			res +="Case #"+(i+1)+": "+sl.minI+" "+sl.maxV+"\n" ;
			
		}
		System.out.println(res);
		s.close();
	}

}
