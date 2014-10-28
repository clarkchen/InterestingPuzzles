package longestpalindromesubstring;

import java.util.ArrayList;

public class dpReverseSolution {
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
		int maxi=0,maxj;
		for(i=1;i<s1.length();i++ )
		{
			for(j=1;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					count[i][j] = count[i-1][j-1]+1;
				}
				else count[i][j] = 0;
				
				if(count[i][j]>max)
				{
					if(i==s2.length()-j-1)
					{
						max = count[i][j];
						maxi = i;
						maxj =j ;
					}
				}
			}
		}
		 
		System.out.println(s1.substring(maxi,maxi+max));
	}
	public void getLPS(String s1)
	{
		String s2="";
		int i=s1.length()-1;
		for(;i>=0;i--)
		{
			s2+= s1.charAt(i);
		}
		
		getLCString(s1, s2);
	 	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		suffixSolution  ss = new suffixSolution();
		String a= "abaab";
		a= "abdcabacdef";
//		a= "caba";
//		a="abacdfgdcaba";
//		a="abcefgcba";
		ss.getLPS(a);
		
	}
}
