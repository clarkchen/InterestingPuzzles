package longestRepeatString;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author chenxi
 * 子串就是属于 String s 的一个 subString
 * 在i 位置上的 subString 如果出现了在了 非i 位置上，则说明其重复，找出这样的最长的子串
 * 处理字符串的子串问题，
 */
public class LRString {
	int commonLength(String s1, String s2)
	{
		int i=0;
		for(;i<s1.length();i++)
		{
			if(s1.charAt(i)!=s2.charAt(i)) return i;
		}
		return i;
	}
	public void getLRString(String s)
	{
		ArrayList<String> suffix = new ArrayList<String>();
		for(int i=0;i<s.length()-2;i++)
		{
			suffix.add(s.substring(i));
		}
		
		Collections.sort(suffix);
		int max=  Integer.MIN_VALUE;
		int maxI=0;
		for(int i=0;i<suffix.size()-1;i++)
		{
			//only compare the most common length between i and i+1
			int cl = commonLength(suffix.get(i), suffix.get(i+1));
			if(cl>max)
			{
				max = cl;
				maxI = i;
			}
		}
		//output
		System.out.println(suffix.get(maxI).substring(0,max));
		System.out.println(max+" "+maxI);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRString lrs = new LRString();
		String res = "abcabcdddabcd";
		lrs.getLRString( res);
	}

}
