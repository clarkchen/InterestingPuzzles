package D_C;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

 
public class Solution {
	String answerStr;
	Hashtable< String, Ticket> ht ;
	 int n;
	public void merge(Ticket t)
	{
		
		Ticket cur =  ht.get(t.end);
		while(cur!=null){
	 
			t.addTicket(cur);
			ht.remove(cur.start);
			cur = ht.get(t.Tail.end);
		}
		ht.put(t.start, t);
		
	}
	public Solution(){
		answerStr="";
		ht=  new Hashtable< String, Ticket>();
		n = s.nextInt();
		String start,end;
		for(int i=0;i<n;i++)
		{
			start = s.next();
			end = s.next();
			Ticket t = new Ticket(start, end);
			merge(t);
		}
		
	}
	int i=0;
	public void answer()
	{
		Ticket t=null,cur,maxT=null;
		int max=0;
		Set<String> st = ht.keySet();
		List<String> l = new ArrayList<String>();
		for(String s1:st) l.add(s1);
		i=0;
		while(l.size()>1)
		{
			String start = l.get(i);
			t = ht.get(start);
			String end = t.Tail.end;
			cur = ht.get(end);
			if(cur!=null)
			{
				t.addTicket(cur);
				l.remove(end);
				if(l.size()==1) break;
				i = (i+1)%l.size();
			}
			else 
			{
				i = (i+1)%l.size();
			}
		}
		cur = ht.get(l.get(0));
		while(cur!=null)
		{
			i++;
			answerStr+= " "+cur.start+"-"+cur.end;
			cur = cur.next;
		}
		
		ht.clear();
		
	}
	static void output(String content,String Path)
	{
		
	 	try {
			 OutputStreamWriter osw;
			osw = new OutputStreamWriter(new FileOutputStream(Path));
			 osw.write(content,0,content.length());    
		    osw.flush(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = "";
		int t = s.nextInt();
		for(int i=0;i<t;i++)
		{
			Solution sl = new Solution();
			sl.answer();
			res +="Case #"+(i+1)+":"+sl.answerStr+"\n" ;
			 
			
		}
		output(res,"/Users/chenxi/Desktop/cl.txt");
		s.close();
	}
}
