package at.fhooe.mc.luis.hainberger;

public class Stack {
	int[] stack;
	int top, size;
	int counter;
	/** Initializes the stack instance */
	// public void initStack(int size) {
	// stack = new int[size];
	// this.size = size;
	// top = 0;
	// counter = 0;
	// }
	/** Clears all elements from the stack */
	public void clear() {
		stack = new int[size];
		top = 0;
		counter = 0;
	}

	/** Pushes an element onto the stack */
	public void push(int val) {

		if (top == size) {
			System.out.println("Stack overflow !!!");

		} else {
			counter += 1;
			stack[top] = val;
			top = top + 1;
		}
	}

	/** Returns the top element of the stack and removes */
	public int pop() {
		int val = 0;
		if (top == 0) {
			return Integer.MIN_VALUE;
		} else {
			counter -= 1;
			val = stack[top - 1];
			stack[top - 1] = 0;
			top = top - 1;
		}
		return val;
	}

	/** Returns the top element of the stack without removing it */
	public int peek() {
		if (top == 0) {
			return Integer.MIN_VALUE;
		} else {
			int val = stack[top - 1];
			return val;
		}
	}

	/** Returns the number of elements in the stack */
	public int elements() {
		return counter;

	}

	/** Returns the maximum size of the stack */
	public int size() {
		return size;
	}

	/** Prints all elements in the stack */
//	 public void print() {
//	 System.out.print("Stack " + size + ": [");
//	 for (int i = 0; i < counter; i++) {
//		if (i == counter - 1){
//			System.out.print(stack[i] + "].");
//			break;
//		}
//	 System.out.print(stack[i] + ", ");
//	 }
//	
//	 }
	/** Constructor initializes stack with a standard size. */
	public Stack() {
		size = 10;
		stack = new int[size];
		top = 0;
		counter = 0;
	}

	/** Constructor initializes stack with the given size. */
	public Stack(int size) {
		stack = new int[size];
		this.size = size;
		top = 0;
		counter = 0;
	}

	/**
	 * * Copy constructor initializes stack with another stack. * This
	 * constructor must COPY all elements of the other stack. * The elements of
	 * the other stack must NOT be changed!
	 */
	public Stack(Stack other) {
		this.size = other.size;
		stack = new int[size];
		for (int i = 0; i < size; i++) {
			stack[i] = other.stack[i];
		}
	}

	/**
	 * the method deinitializes the object the method sets all variables zero,
	 * the array to null and the garbage collector does the rest.
	 */
	protected void finalize() {
		this.stack = null;
		top = 0;
		counter = 0;
		size = 0;

	}

	/**
	 * Pushes all elements from another stack onto this one. If another stack
	 * [4,5] is pushed onto this stack [1,2,3], the result is [1,2,3,4,5] and
	 * not [1,2,3,5,4]. The elements of the other stack must NOT be changed!
	 */
	public void push(Stack other) {
		int k = 0;
		int top1 = top;
		int[] a = new int[other.top + this.top];

		for (int i = 0; i < this.top; i++) {
			a[i] = stack[i];
		}
		for (int i = this.top; i < this.top + other.top; i++) {
			a[i] = other.stack[k];
			k++;
			top1++;
			counter++;
		}
		top = top1;
		stack = a;
		a = null;

	}

	/** Clones this Stack instance and returns an exact COPY. */
	public Stack clone() {
		int[] a = new int[size];
		Stack clone = new Stack();
		clone.top = this.top;
		clone.counter = this.counter;
		for (int i = 0; i < size; i++) {
			a[i] = this.stack[i];
		}
		clone.stack = a;
		a = null;
		return clone;
	}

	/**
	 * Returns true if the other stack is equal to this one, false otherwise.
	 * The contents of the two stacks must not be changed!
	 */
	public boolean equals(Stack other) {
		if (this.size == other.size) {
			for (int i = 0; i < size; i++) {
				if (stack[i] == other.stack[i]) {
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 *  Returns a string representation of the stack. See the exercise *
	 * specification below for the exact string format!
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("Stack " + size + ": [");
		for (int i = 0; i < top; i++) {
			if (i + 1 == top) {
				string.append(stack[i] + "].");
				return string.toString();

			} else {
				string.append(stack[i] + ", ");
			}
		}
		return string.toString();

	}
	/**  Returns true if the element val exists in the stack, false otherwise. */
	public boolean search(int val) {
		for (int i = 0; i < top; i++) {
			if (val == stack[i]) {
				return true;
			}
		}
		return false;
	}

}
