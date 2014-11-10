package D_B;
import java.util.*;

public class Solution {
	int n;
	int start[],end[];
	int p;
	int queries[];
	public Solution()
	{
		answerStr="";
		n = s.nextInt();
		start =  new int[n];
		end = new int[n];
		
		for(int i=0;i<n;i++)
		{
			start[i] = s.nextInt();
			end [i] = s.nextInt();
		}
		
		p = s.nextInt();
		queries = new int[p];
		for(int i=0;i<p;i++)
		{
			queries[i] = s.nextInt();
		}
	}
	String answerStr;
	public void answer()
	{
		for(int i=0;i<p;i++)
		{
			int count = 0;
			for(int j=0;j<n;j++)
			{
				if(start[j]<=queries[i] && end[j]>=queries[i]) count++;
			}
			answerStr += " "+count;
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
			//Case #2: 6 4
			res +="Case #"+(i+1)+":"+sl.answerStr+"\n" ;
			
		}
		System.out.println(res);
		s.close();
	}

}
