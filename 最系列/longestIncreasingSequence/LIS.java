package longestIncreasingSequence;

import java.util.ArrayList;
import java.util.List;

public class LIS {
	
	//dp[i] = MAX{1+count[j]} where a[j]<a[i] and j<i
	public void getLIS(int []a){
		if(a ==null) return ;
		if(a.length==0) System.out.print(a);
		int []count = new int[a.length];
		count[0] = 1;
		for(int i=1;i<a.length;i++)
		{
			
			int max = 0;
			for(int j=i-1;j>=0;j--)
			{
				if(a[j]<a[i] && count[j]>max)
				{
					max = count[j];
				}
			}
			count[i] = max+1;
		}
		int max=0;
		for(int i=0;i<count.length;i++)
		{
			if(count[i]>max) max =count[i];
		}
		System.out.println("count 数组");
		for(int c:count)
			System.out.print(c+" ");
		System.out.println();
		this.output(count, a,max);
		
	}
	
	List<List<Integer>> getAllSequences(int i,int end, int[]count, int []v)
	{
		List<List<Integer>> rtSet =  new ArrayList<List<Integer>>();
		if(count[i]==1 )
		{
			if( v[i]<v[end]||i==end) {
				List<Integer> rt = new ArrayList<Integer>();
				rt.add(v[i]);
				rtSet.add(rt);
				return rtSet;
			}
			return null;
		}
	
		for(int j=i-1;j>=0 ;j--)
		{
			if(count[j]==count[i]-1)
			{
				List<List<Integer>>  temp = getAllSequences(j, end, count, v);
				if(temp!=null)
				{
					for(List<Integer> t:temp)
					{
						t.add(v[i]);
						rtSet.add(t);
					}
				}
			}
		}
		
		return rtSet;
	}
	public void output(int[]count, int []v,int max)
	{
		List<List<Integer>> rtSet;
		for(int i= count.length-1;i>=0;i--)
		{
			if(count[i]==max)
			{
				rtSet = getAllSequences(i, i, count, v);
				for(List<Integer> t:rtSet)
				{
					System.out.println(t);
				}
				
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= new int []{1,3,9,8};
//		a = new int[]{3,1,9,7};
//		a = new int[]{1,2,1,1};
//		a = new int[]{3,2,1,3};
		//a = new int[]{1,2,3,4,5};
//		a = new int[]{1,1,1};
//		a = new int[]{1,1,1};
		a =  new int[]{3,2,5,1,7,6,4,8};
		a=new int[]{3,1};
		LIS L =new LIS();
		L.getLIS(a);		
	}

}
