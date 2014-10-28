package longestpalindromesubstring;

/**
 * @author chenxi
 * 接下来是一种非常有趣的思想，我们用 P[i,j] boolean 数组来表示 S[i:j] 是否是回文串
 * 
 * 动态规划的思想，是一个二维数组的填充问题，但是这个填充的方法非常神奇
 * 我们只需要关注这个矩阵的上半部分即可，因为 i<=j 
 * 首先填充对角线上的数据 P[i][i]，全部设置为True
 * 然后填充对角线右边的数据 P[i][i+1],如果 s[i]==s[i+1] 设置为True 否则设置为 False
 * 之后看是沿对角线方向来遍历上半边数组，P[i][j] = True only if P[i+1][j-1]==True && S[i]==S[j](来自于对角线上的更新)
 * 这个更新方式绝对是全新的，非常帅气的一种更新方方式，当然整个算法的时间复杂度依然是 O(n^2) 
 * 
 * 
 */
public class MatrixDBSolution {

	public void getLPS(String s1)
	{
		if(s1==null ||s1.length()==0) return;
		int len = s1.length();
		boolean [][]P =  new boolean[len][len];
		int i,j,k;
		for(i=0;i<len;i++) P[i][i] = true;
		int max = 1;
		int maxI = 0;
		
		for(i=0;i<len-1;i++) 
		{
			if(s1.charAt(i) == s1.charAt(i+1))
			{
				P[i][i+1] = true;
				if(2>max) {
					max = 2;
					maxI = i;
				}
			}
			else 	P[i][i+1] = false;
		}
		
		
		for(k = 2;k<len;k++)
		{
			for(i =0;i< len-k;i++)
			{
				j = i + k;
				if(P[i+1][j-1]==true && s1.charAt(i)==s1.charAt(j)){
					P[i][j] = true;
					if(j-i+1>max)
					{
						max = j-i+1;
						maxI = i;
					}
				}
				else P[i][j] = false;
				
			}
		}
		
		System.out.println(s1.substring(maxI,maxI+max));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixDBSolution  ss = new MatrixDBSolution();
		String a= "abaab";
		a= "abdcabacdef";
//		a="aac";
//		a="a";
//		a= "caba";
		a="abacdfgdcaba";
		a="abcefgcba";
		a="abceababfgcba";
		ss.getLPS(a);
		
	}

}
