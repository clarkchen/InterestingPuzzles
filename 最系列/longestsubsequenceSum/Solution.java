package longestsubsequenceSum;

/**
 * @author chenxi
 * 最大子数组和（连续子数组最大和）
 */
public class Solution {
	
	public void getMaxSum(int []a)
	{
		int sum []= new int[a.length];
		
		sum[0] = a[0];
		
		int max = a[0];
		for(int i=1;i<a.length;i++)
		{
			sum[i] = (sum[i-1]+a[i]) >a[i]?(sum[i-1]+a[i]):a[i];
			if(max<sum[i]) max = sum[i];
		}
		
		System.out.println(max);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =  new Solution();
		int []a = new int[]{-1,3,-5,20,-5,-5,-4,-5,30};
		s.getMaxSum(a);
	}

}
