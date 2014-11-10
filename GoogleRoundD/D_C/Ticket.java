package D_C;
import java.util.*;
public class Ticket {
	String start,end;
	Ticket next;
	Ticket Tail ;
	int size ;
	public Ticket(String s, String e)
	{
		start =s;end= e;
		Tail = this;
		next =null;
		size = 1;
	}
	public void addTicket(Ticket t)
	{
		Tail.next = t;
		Tail = t.Tail;
		size += t.size;
	}
	 
}
