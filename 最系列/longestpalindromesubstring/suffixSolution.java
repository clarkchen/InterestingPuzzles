package longestpalindromesubstring;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author chenxi
 * 时间复杂度 O(n^2), 活用最长重复子串，最复杂的操作在于后缀树的建立，和公共串的计算
 */
public class suffixSolution {

	int commonLength(String s1, String s2,String S)
	{
		int i=0;
		for(;i<s1.length();i++)
		{
			if(s1.charAt(i)!=s2.charAt(i)) break;
		}
		if(i>0)
		{
			int i1 = s1.contains("#")?S.length()-s1.indexOf("#"):s1.length()-i;
			int i2 = s2.contains("#")?S.length()-s2.indexOf("#"):s2.length()-i;
			if(i1!=i2) i = 0;
		}
		return i;
	}
	 
	public void getLPS(String S)
	{
		//init
		String s1 = S +"#";
		char temp[] = new char[S.length()];
		int i=S.length()-1,j;
		for(;i>=0;i--)
		{
			s1+= S.charAt(i);
		}
	 	
		System.out.println(s1);
		int len = S.length()*2+1;
		//get suffix;
		ArrayList<String> suffix = new ArrayList<String>();
		for(i=0;i<len;i++)
		{
			suffix.add(s1.substring(i));
		}
		
		Collections.sort(suffix);
		int max =0;
		int maxI =0;
		for(i=0;i<len-1;i++)
		{
			int l =  commonLength(suffix.get(i),suffix.get(i+1),S);
			
			if(l>max)  {
				max = l;
				maxI = i;
			}
		}
		//System.out.println(max+" "+maxI);
		System.out.println(suffix.get(maxI).substring(0,max));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		suffixSolution  ss = new suffixSolution();
		String a= "abaab";
		a= "abdcabacdef";
		a= "caba";
//		a="abacdfgdcaba";
//		a="abcefgcba";
		ss.getLPS(a);
		
	}

}
