package at.fhooe.mc.luis.hainberger;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Queue q;
	private Queue q1;
	private Queue q2;
	private Queue q3;
	private Queue q4;
	private Queue q5;
	private Queue q6;
	private Queue q7;

	@Before
	public void setUp() throws Exception {
		q4 = new Queue();
		q4.enqueue(1);
		q4.enqueue(2);
		q4.enqueue(7);
		q4.enqueue(6);
		q4.enqueue(10);
		q4.enqueue(9);
		q4.enqueue(4);

		q5 = new Queue();
		q5.enqueue(1);
		q5.enqueue(2);
		q5.enqueue(7);
		q5.enqueue(6);
		q5.enqueue(10);
		q5.enqueue(9);
		q5.enqueue(4);

		q6 = new Queue(10);
		q6.enqueue(10);
		q6.enqueue(2);
		q6.enqueue(3);
		q6.enqueue(6);
		q6.enqueue(8);
		q6.enqueue(9);
		q6.enqueue(4);

		q7 = new Queue();

	}

	@Test
	public void testQueue() {
		q1 = new Queue();
		assertEquals(10, q1.queue.length);
		q2 = new Queue();
		assertEquals(10, q2.queue.length);
	}

	@Test
	public void testQueueSetSize() {
		q = new Queue(10);
		assertEquals(10, q.queue.length);
		q1 = new Queue();
		assertEquals(10, q1.queue.length);
		q2 = new Queue(5);
		assertEquals(5, q2.queue.length);
		q3 = new Queue(20);
		assertEquals(20, q3.queue.length);
	}

	@Test
	public void testQueuePushOther() {
		q = new Queue(q6);
		assertEquals(10, q.queue.length);
		q1 = new Queue(q5);
		assertEquals(10, q1.queue.length);
	}

	@Test
	public void testFinalize() {
		q5.finalize();
		assertEquals(0, q5.top);
		assertEquals(0, q5.head);
		assertEquals(0, q5.counter);
	}

	@Test
	public void testClear() {
		q7.clear();
		for (int i = 0; i < q7.queue.length; i++) {
			assertEquals(0, q7.queue[i]);
		}
	}

	@Test
	public void testEnqueue() {
		q7.clear();
		q7.enqueue(10);
		assertEquals(1, q7.elements());
		assertEquals(10, q7.queue[0]);
		q7.enqueue(1);
		assertEquals(2, q7.elements());
		assertEquals(1, q7.queue[1]);
		q7.enqueue(3);
		assertEquals(3, q7.elements());
		assertEquals(3, q7.queue[2]);
		q7.enqueue(5);
		assertEquals(4, q7.elements());
		assertEquals(5, q7.queue[3]);
		q7.enqueue(7);
		assertEquals(5, q7.elements());
		assertEquals(7, q7.queue[4]);
		
	}

	@Test
	public void testDequeue() {
		assertEquals(10, q6.dequeue());
		assertEquals(2, q6.dequeue());
		assertEquals(3, q6.dequeue());
		assertEquals(6, q6.dequeue());
		assertEquals(8, q6.dequeue());
		assertEquals(9, q6.dequeue());
		assertEquals(4, q6.dequeue());
	}

	@Test
	public void testPeek() {
		assertEquals(1, q5.peek());
		assertEquals(1, q5.peek());
		q5.dequeue();
		assertEquals(2, q5.peek());
		assertEquals(2, q5.peek());
		q5.dequeue();
		assertEquals(7, q5.peek());
		assertEquals(7, q5.peek());
		q5.dequeue();
		assertEquals(6, q5.peek());
		assertEquals(6, q5.peek());
		q5.enqueue(10);
		assertEquals(6, q5.peek());
		assertEquals(6, q5.peek());
	}

	@Test
	public void testElements() {
		assertEquals(7, q5.elements());
		q5.dequeue();
		assertEquals(6, q5.elements());
		q5.dequeue();
		assertEquals(5, q5.elements());
		q5.dequeue();
		assertEquals(4, q5.elements());
		q5.dequeue();
		assertEquals(3, q5.elements());
		q5.dequeue();
		assertEquals(2, q5.elements());
		q5.dequeue();
		assertEquals(1, q5.elements());
		q5.dequeue();
		assertEquals(0, q5.elements());
		
	}

	@Test
	public void testSize() {
		assertEquals(10, q5.size());
		assertEquals(10, q6.size());
		assertEquals(10, q7.size());
	}

	@Test
	public void testEnqueueQueue() {
		q = new Queue(20);
		q.enqueue(1);
		q.enqueue(q5);
		assertEquals(8, q.elements());
		q.enqueue(q6);
		assertEquals(15, q.elements());

	}

	@Test
	public void testClone() {
		q = q6.clone();
		assertEquals(true, q.equals(q6));
		assertEquals(7, q.elements());
		assertEquals(q6.toString(), q.toString());

		q1 = q5.clone();
		assertEquals(true, q1.equals(q5));
		assertEquals(7, q1.elements());
		assertEquals(q5.toString(), q1.toString());
	}

	@Test
	public void testEquals() {
		assertEquals(false, q6.equals(q5));
		assertEquals(true, q6.equals(q6));
		assertEquals(false, q5.equals(q6));
		assertEquals(true, q5.equals(q5));
	}

	@Test
	public void testToString() {
		assertEquals("Queue 10: [10, 2, 3, 6, 8, 9, 4].", q6.toString());
		assertEquals("Queue 10: [1, 2, 7, 6, 10, 9, 4].", q5.toString());

		q6.dequeue();
		q5.enqueue(5);
		assertEquals("Queue 10: [2, 3, 6, 8, 9, 4].", q6.toString());
		assertEquals("Queue 10: [1, 2, 7, 6, 10, 9, 4, 5].", q5.toString());
	}

	@Test
	public void testSearch() {
		assertEquals(true, q5.search(2));
		assertEquals(true, q5.search(10));
		assertEquals(true, q5.search(4));
		assertEquals(false, q5.search(3));
		assertEquals(false, q5.search(-1));
		assertEquals(false, q5.search(11));

		assertEquals(true, q6.search(2));
		assertEquals(true, q6.search(10));
		assertEquals(true, q6.search(4));
		assertEquals(false, q6.search(5));
		assertEquals(false, q6.search(-1));
		assertEquals(false, q6.search(11));
	}

}
