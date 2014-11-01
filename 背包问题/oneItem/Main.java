/**
 * 
 */
package oneItem;
import java.util.*;
/**
 * @author chenxi
 * 0,1 背包问题，并且列出所有物品
 */
public class Main {
	static int smallest(List<Integer> l)
	{
		int min = Integer.MAX_VALUE;
		
		for(int i:l){
			if(i<min)min=i;
		}return min;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		
		int n,b;
		n = s.nextInt();
		b = s.nextInt();
		int i,j;
		int h[] = new int[n];
	 
		for(i=0;i<n;i++)
		{
			h[i] =  s.nextInt();
			 
		}
		 
		int dp[][] = new int[n][b+1];
		dp[0][0] =0;
		 
		for( i=0;i<n;i++){
			 
			for(j =h[i];j<=b;j++)
			{
				if(i==0){ dp[i][j] = h[i]; }
				if(i>0){
					if(dp[i][j]<dp[i-1][j-h[i]]+h[i])
					{
						dp[i][j] = dp[i-1][j-h[i]]+h[i];
					}
				}
			}
		}
 		int max= dp[n-1][b]; 
		for( i=n-1;i>0;i--){
			if(dp[i][b]!=dp[i-1][b])
			{
				System.out.println("放入第" +(i+1));
			}
			 
		}
		if(dp[i][b]!=0){ System.out.println("放入第" +(i+1));}
		System.out.println(max);
	}

}
/*
测试数据：
5 16
3
1
3
5
6

5 16
1
1
3
5
6
*/