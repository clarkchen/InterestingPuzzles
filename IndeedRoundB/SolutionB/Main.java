package SolutionB;

import java.util.*;
public class Main{
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n,k;
    	n = sc.nextInt();
    	k = sc.nextInt();
    	
    	int m=-1;
    	int sum=0;
    	for(int i=0;i<n;i++)
    	{
    		sum+=sc.nextInt();
    		if(m<0&&sum>=k) m=i+1;
    	}
    	System.out.println(m);
    }
}

