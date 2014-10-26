package longestCommonSequence;

/**
 * @author chenxi
 * 一个字符串S，去掉零个或者多个元素所剩下的子串称为S的子序列
 * 最长公共子序列就是寻找两个给定序列的子序列，该子序列在两个序列中以相同的顺序出现，但是不必要是连续的。
 * 这类问题主要是找到并且要求输出最长公共子序列
 */
public class Solution {
	
	int length[][];
	String s1,s2;
	 
	public int answer(String s1, String s2)
	{
		if(s1==null || s2==null) return 0;
		if(s1.length()==0 || s2.length()==0) return 0;
		
		length = new int[s1.length()][s2.length()];
		 
		int i=0,j=0;
		//init 0
		length[0][0] =  s1.charAt(0) == s2.charAt(0)?1:0;
		for(i=1;i<s1.length();i++)
			length[i][0] = s1.charAt(i) == s2.charAt(0)?1:length[i-1][0];
		
		for(i=1;i<s2.length();i++)
			length[0][i] = s1.charAt(0) == s2.charAt(i)?1:length[0][i-1];
		
		
		
		
		for(i=1;i<s1.length();i++)
		{
			for(  j=1;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					length[i][j] = length[i-1][j-1]+1;
				}
				else
				{
					length[i][j] = length[i-1][j]>length[i][j-1]?length[i-1][j]:length[i][j-1];
				}
			}
		}
		
		//输出最长公共子串
		int max=  length[i-1][j-1];
		int len1 = s1.length()-1;
		String res="";
		for(i=s2.length()-1;i>=0&&max>0;i--)
		{
			if((i==0)||(length[len1][i] == max &&  length[len1][i-1] == max-1))
			{
				res = s2.charAt(i) + res;
				max--;
			}
		}
		System.out.println(res);
	
		
		return length[s1.length()-1][s2.length()-1];
		
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "1567889";
		String s2 = "78339";
		Solution s = new Solution();
		s.answer(s1, s2);
	}
 
}
