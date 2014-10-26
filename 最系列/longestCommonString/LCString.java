package longestCommonString;

import java.util.ArrayList;

import longestCommonSequence.Solution;

/**
 * @author chenxi
 * 这个LCS跟前面说的最长公共子序列的LCS不一样，不过也算是LCS的一个变体，
 * 在LCS中，子序列是不必要求连续的，而子串则是“连续”的。即：题：给定两个字符串X，Y，求二者最长的公共子串，
 * 例如X=[aaaba]，Y=[abaa]。
 * 二者的最长公共子串为[aba]，长度为3。
 * 这份代码中使用的方法是动态规划
 */
public class LCString {
	
	void output(String s)
	{
		System.out.println(s);
	}
	
	public void getLCString(String s1, String s2)
	{
		if(s1==null ||s2==null) return;
		if(s1.length()==0) { output(s1); return;}
		if(s2.length()==0) { output(s2); return;}
		int count[][] = new int[s1.length()][s2.length()];
		int i,j;
		
		count[0][0] = s1.charAt(0)==s2.charAt(0)?1:0;
		for(i=1;i<s2.length();i++)
			count[0][i] = s1.charAt(0) == s2.charAt(i)?1:0;
		for(i=1;i<s1.length();i++)
			count[i][0] = s1.charAt(i) == s2.charAt(0)?1:0;
		
		int max = 0;
		for(i=1;i<s1.length();i++ )
		{
			for(j=1;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					count[i][j] = count[i-1][j-1]+1;
				}
				else count[i][j] = 0;
				
				if(count[i][j]>max) max = count[i][j];
			}
		}
		ArrayList<Integer> rt =  new ArrayList<Integer>();
		for(i=1;i<s1.length();i++ )
		{
			for(j=1;j<s2.length();j++)
			{
				if(count[i][j] == max)
				{
					//record the position in s1
					rt.add(i);
				}
			}
		}
		
		for(int r:rt)
		{
			output(s1.substring(r-max+1, r+1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 ="156789";
		String s2 = "1568789";
		s1 ="abc";
		s2 = "abcd";
		LCString lcs = new LCString();
		lcs.getLCString(s1, s2);
	}

}
