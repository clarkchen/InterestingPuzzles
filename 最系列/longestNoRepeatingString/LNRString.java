package longestNoRepeatingString;

public class LNRString {
	void output(String s)
	{
		if(s==null) {output("Empty Null");return;}
		System.out.println(s);
	}
	public void getLNRString(String s)
	{
		if(s==null || s.length()<2) output(s);;
		int len[] = new int[s.length()];
		
		len[0] = 1;
		String s1,s2;
		int j;
		int max = 1,maxI =0;
		for(int i=1;i<s.length();i++)
		{
			s1 = s.substring(i-len[i-1],i);
			j = s1.lastIndexOf(s.charAt(i));
			if(j<0)
			{
				len[i] = len[i-1]+1;
			}
			else
			{
				len[i] = len[i-1] - j;
			}			
			if(len[i]>max) 
			{
				max = len[i];
				maxI = i;
			}
		}
		
		//find Max
		output(s.substring(maxI+1-max,maxI+1));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  a ="abcadbdddefjhigk";
		a ="aaaaaa";
//		System.out.println(a.substring(3).length());
//		System.out.println(a.substring(1,3));
//		System.out.println(a.lastIndexOf('d'));
//		
		LNRString s = new LNRString();
		s.getLNRString(a);
	}

}
