package SolutionC;
import java.util.*;

public class Main{
	String answer(String s1,String s2, String s3)
	{
		 int N = s3.length()/2;
    	 int a[] = new int[26];
	   	 int b[] = new int[26];
	   	 int c[] = new int[26];
 	   	 int t[] = new int[26];
	   	for(int i=0;i<s1.length();i++){
	   		a[s1.charAt(i)-'A']++; 
	   		t[s1.charAt(i)-'A']++; 
 	   	}
	   	
	   	for(int i=0;i<s2.length();i++){
	   		b[s2.charAt(i)-'A']++ ;
	   		t[s2.charAt(i)-'A']++ ;
 	   	}
	   	 
	   	
	   	for(int i=0;i<s3.length();i++){
	   		c[s3.charAt(i)-'A'] ++ ;
	   	}
	   	 
		boolean can =true;
		for(int i=0;i<26;i++)
	   	{
	   		if(t[i]<c[i]) 
	   		{
	   			can= false;break;
	   		}
	   		 
	   	}
	   	int common = 0;
	   	if(can){
	   		for(int i=0;i<26;i++)
		   	{
		   		common +=  c[i]<a[i]?c[i]:a[i];
		   		if(common>=N) break;
		   	}
		   	if(common<N)can = false;
	   	}
	   	common = 0;
	   	if(can){
	   		for(int i=0;i<26;i++)
	    	{
	    		 
	    		common +=  c[i]<b[i]?c[i]:b[i];
	    		if(common>=N) break;
	    	}
	    	if(common<N)can = false;
	   	}
		
		
	   	if(can) 
	   		return "YES";
	   	else return "NO";
	}
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String s1 = sc.next();
    	String s2 = sc.next();
    	String s3= sc.next();
    	Main m = new Main();
    	System.out.println(m.answer(s1, s2, s3));
    }
    
}

