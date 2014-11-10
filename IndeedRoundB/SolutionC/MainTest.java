package SolutionC;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
public class MainTest {
	Main m= new Main();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(m.answer("AABCCD", "ABEDDA", "EDDAAA")=="YES");
				
		assertTrue(m.answer("AAAAAB", "BCCCCB", "AAABCB")=="YES");
		
		assertTrue(m.answer("AAFFFB", "BACCCC", "AAABCB")=="YES");
		assertTrue(m.answer("VVVVVV", "BAABCA", "AAABCB")=="NO");
		assertTrue(m.answer("AAAAAB", "BCCCCC", "AAABCB")=="NO");
		assertTrue(m.answer("DDBCAB", "DDDAEF", "DDDEAA")=="YES");
		assertTrue(m.answer("BCCCCB", "AAAAAB", "AAABCB")=="YES");
		assertTrue(m.answer("AAABBB", "AAACCC", "AAADDD")=="NO");

				
				
	}

}










