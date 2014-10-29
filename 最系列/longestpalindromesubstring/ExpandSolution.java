package longestpalindromesubstring;

/**
 * @author chenxi
 * 这其实是最最简单的方法，但是竟然当时没想到这么用
 * 遍历字符串的每一个元素，以其为中心向外扩张求解最大回文长度
 * 
 * 时间复杂度是 O(n^2), 我觉的这真的是最棒的一个方法，简单直观
 * 空间复杂度是 O(1), 只需要记录最长的半径和中心即可，当然分为奇数和偶数的区分
 */
public class ExpandSolution {

	public void getLPS(String S)
	{
		
		 
		int max=0, maxLen=Integer.MIN_VALUE;
		 
		int f,b,l;
		for(int i=0;i<S.length();i++)
		{
			//odd
			b = i-1;f = i+1;
			while (b>=0 && f<S.length() && S.charAt(b) == S.charAt(f)){b--;f++;};
			l = f-b-1;
			if(maxLen < l){maxLen = l;max = b+1;}
			
			//even
			b = i;f = i+1;
			while (b>=0 && f<S.length() && S.charAt(b) == S.charAt(f)){b--;f++;};
			l = f-b-1;
			if(maxLen < l){maxLen = l;max = b+1;}

 		}
		System.out.println(S.substring(max,max+maxLen));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ExpandSolution  ss = new ExpandSolution();
				String a= "abaab";
				a= "abdcabacdef";
//				a= "caba";
//				a="abacdfgdcaba";
//				a="abcefgcba";
//				a="abceababfgcba";
				a="abba";
				ss.getLPS(a);
	}

}
