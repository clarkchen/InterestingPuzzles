package longestpalindromesubstring;

/**
 * @author chenxi
 * 神奇动态规划，利用回文串本身的性质
 * 首先需要做一下预处理，预防边界，（最左最右的时候直接进行判断即可）
 * 我们从第一个开始遍历，利用中心点和半径原理，C 和 R 来表示回文最右边界
 * 我们能保证的是C之前的点的回文串都已经做过记录了
 * 左边回文中，如果出现在半径范围内的自回文串的话，其右边肯定也会出现对应的回文串
 * 如果左边的回文中，半径超出R-C的话，我们首先设置一个较小的段，然后再进行扩充，如果扩充的部分超过了R
 * 那就将C 移动 到 i来，也能保证新的 中心 左边的所有位置的回文都被计算过了
 * 
 * 最后的输出转化需要，自己总结一下规律，就出来了
 */
public class PalindromeSolution {
	
	String preProcess(String s)
	{
		String rt = "^";
		for(int i=0;i<s.length();i++)
			rt += "#"+s.charAt(i);
		rt+="#!";
		return rt;
	}
	
	public void getLPS(String s)
	{
		if(s==null || s.length()==0) return;
		String t = preProcess(s);
		
		int count[] = new int [t.length()];
		count[0] = 0;
		int maxC=0,maxLen=0,C,R;
		C=0;R=0;
		for(int i =2;i<t.length()-1;i++)
		{
			if(R>i)
			{
				int j = 2*C - i;
				count[i] = count[j]>R-i?R-i:count[j];
			}
			else count[i] = 0;
			//继续扩充不被回文保证的字段
			while( t.charAt(i-count[i]-1)==t.charAt(i+count[i]+1)) 
				count[i]++;
			
			//保证C不会出现重复跳回的问题
			if(i+count[i]>R)
			{
				C = i;
				R = i+count[i];
			}
			if(count[i]>maxLen)
			{
				maxLen = count[i];
				maxC = i;
			}
		}
		//这个转化逆天了
		int start = (maxC - maxLen -1)/2;
		System.out.println(s.substring(start,start+maxLen));
	}
	
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeSolution ps = new PalindromeSolution();
		String a="abceababfgcba";
		a="abacdfgdcaba";
		a= "abdcabacdef";
		ps.getLPS(a);
	}

}
