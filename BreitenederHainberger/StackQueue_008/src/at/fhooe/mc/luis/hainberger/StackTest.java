package at.fhooe.mc.luis.hainberger;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import at.fhooe.mc.luis.hainberger.Stack;

public class StackTest {
	private Stack s;
	private Stack s1;
	private Stack s2;
	private Stack s3;
	private Stack s4;
	private Stack s5;
	private Stack s6;
	private Stack s7;
	private Stack s8;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		
		s4 = new Stack(10);
		s4.push(5);
		s4.push(10);
		s4.push(2);
		s4.push(11);
		s4.push(4);
		s4.push(3);
		
		s5 = new Stack(10);
		s5.push(5);
		s5.push(10);
		s5.push(2);
		s5.push(11);
		s5.push(4);
		s5.push(3);
		
		s6 = new Stack(10);
		s6.push(5);
		s6.push(10);
		s6.push(2);
		s6.push(11);
		s6.push(4);
		s6.push(3);
		
		s7 = new Stack(5);
		
		s8 = new Stack(15);
		s8.push(5);
		s8.push(10);
		s8.push(2);
		s8.push(11);
		s8.push(1);
		s8.push(3);
		
		
	}
	
	@Test
	public void testStack() {
		s = new Stack(15);
		assertEquals(15, s.stack.length);
		s1 = new Stack(10);
		assertEquals(10, s1.stack.length);
		s2 = new Stack(5);
		assertEquals(5, s2.stack.length);
		s3 = new Stack(15);
		assertEquals(15, s3.stack.length);
	}


	@Test
	public void testStackPushOther() {
		s = new Stack(s7);
		assertEquals(5, s.stack.length);
		s1 = new Stack(s8);
		assertEquals(15, s1.stack.length);
		s2 = new Stack(s6);
		assertEquals(10, s2.stack.length);
	}

	@Test
	public void testFinalize() {
		s6.finalize();
		assertEquals(0, s6.top);
		assertEquals(0, s6.elements());
	}

	@Test
	public void testClear() {
		s7.clear();
		for (int i = 0; i < s7.stack.length; i++) {
			assertEquals(0, s7.stack[i]);
		}
	}

	@Test
	public void testPushVal() {
		s7.push(3);
		assertEquals(3, s7.stack[0]);
		s7.push(4);
		assertEquals(4, s7.stack[1]);
		s7.push(9);
		assertEquals(9, s7.stack[2]);
		s7.push(10);
		assertEquals(10, s7.stack[3]);
		s7.push(1);
		assertEquals(1, s7.stack[4]);
		
	}

	@Test
	public void testPop() {
		assertEquals(3, s8.pop());
		assertEquals(1, s8.pop());
		assertEquals(11, s8.pop());
		assertEquals(2, s8.pop());
		assertEquals(10, s8.pop());
		assertEquals(5, s8.pop());
	}

	@Test
	public void testPeek() {
		assertEquals(3, s6.peek());
		assertEquals(3, s6.peek());
		s6.pop();
		assertEquals(4, s6.peek());
		assertEquals(4, s6.peek());
		s6.pop();
		assertEquals(11, s6.peek());
		assertEquals(11, s6.peek());
		s6.pop();
		assertEquals(2, s6.peek());
		assertEquals(2, s6.peek());
		s6.push(10);
		assertEquals(10, s6.peek());
		assertEquals(10, s6.peek());
	}

	@Test
	public void testElements() {
		s4.push(10);
		assertEquals(7, s4.elements());
		s4.push(2);
		assertEquals(8, s4.elements());
		s4.push(-1);
		assertEquals(9, s4.elements());
		s4.pop();
		assertEquals(8, s4.elements());
		s4.pop();
		assertEquals(7, s4.elements());
	}

	@Test
	public void testSize() {
		assertEquals(5, s7.size());
		assertEquals(15, s8.size());
		assertEquals(10, s4.size());
	}


	@Test
	public void testPush() {
		s = new Stack(15);
		s.push(20);
		s.push(s8);
		assertEquals("Stack 15: [20, 5, 10, 2, 11, 1, 3].", s.toString());
		assertEquals(7, s.elements());
		
		s1 = new Stack(15);
		s1.push(-10);
		s1.push(s6);
		assertEquals("Stack 15: [-10, 5, 10, 2, 11, 4, 3].", s1.toString());
		assertEquals(7, s1.elements());
	}

	@Test
	public void testClone(){
		s = s8.clone();
		assertTrue(s.equals(s8.clone()));
		s1 = s6.clone();
		assertTrue(s1.equals(s6.clone()));
		
	}

	@Test
	public void testEqual() {
		assertEquals(true, s6.equals(s4));
		assertEquals(false, s6.equals(s8));
		assertEquals(false, s4.equals(s8));
	}

	@Test
	public void testToString() {
			assertEquals("Stack 15: [5, 10, 2, 11, 1, 3].", s8.toString());
			assertEquals("Stack 10: [5, 10, 2, 11, 4, 3].", s6.toString());
			s8.pop();
			s6.push(9);
			assertEquals("Stack 15: [5, 10, 2, 11, 1].", s8.toString());
			assertEquals("Stack 10: [5, 10, 2, 11, 4, 3, 9].", s6.toString());
		}

	@Test
	public void testSearch() {
		assertEquals(true, s8.search(10));
		assertEquals(true, s8.search(3));
		assertEquals(false, s8.search(6));
		assertEquals(false, s8.search(7));
		assertEquals(true, s6.search(10));
		assertEquals(true, s6.search(3));
		assertEquals(false, s6.search(6));
		assertEquals(false, s6.search(7));
	}

}




