// Arrays, linked lists, trees, etc. are best for
// data that represents real objects.

// Stacks & Queues are instead used to complete a 
// task and are soon after discarded.

// Stacks & Queues
// 1. Allow only a single item to be added or removed at a time
// 2. Stacks allow access to the last item inserted (LIFO)
// 3. Queues allow access to the first item inserted (FIFO)

import java.util.Arrays;

public class TheStack {
	
	private String[] stackArray;
	private int stackSize;
	
	// Sets stack as empty
//	rear/back of the array
	private int topOfStack = -1;
	
//	constructor
	TheStack(int size){
		
		stackSize = size;
		
		stackArray = new String[size];
		
		// Assigns the value of -1 to every value in the array
		// so I control what gets printed to screen.
//		topOfStack'in de -1 olmasý ile bir ilintisi yok
		Arrays.fill(stackArray, "-1");
		
	}

// if we wanna put an item onto the stack
//	we are gonna have to push it on
	public void push(String input){
		
//		before putting an item we are making sure 
// 	we have enough room inside of our array
		if(topOfStack+1 < stackSize){
			
			topOfStack++;
			
//			we add whatever item is passed over
//			into our array where our stack is
			stackArray[topOfStack] = input;
			
		} else System.out.println("Sorry But the Stack is Full");
		
		displayTheStack();
		
		System.out.println("PUSH " + input + " Was Added to the Stack\n");
		
	}
	
//	***pop metodunun alternatif çözümü derek banas'da mevcut***
//	we want to get info off of a stack and remove it
	public String pop(){
		String old;
//		an array starts at 0 index
		if(topOfStack >= 0){
			
			old = stackArray[topOfStack];
//			stores the removed value in memory
			
			// Just like in memory an item isn't deleted, but instead is just not available
			stackArray[topOfStack] = "-1"; 
			// Assigns -1 so the value won't appear next time it is displayed

//			topOfStack 1 azalýr 
//			ve bu topOfStack >= 0 þartýný saðlamak bakýmýndan önemlidir
			topOfStack--;
	
		} else {
			
			displayTheStack();
			
			System.out.println("Sorry But the Stack is Empty");
			
			return "-1";
			
		}
		
		displayTheStack();
		
		System.out.println("POP " + old + " Was Removed From the Stack\n");
		
		return "";
		
	}
	
//	see what is at the top of the stack but don't remove it
	public String peek(){
		
		displayTheStack();
		
		System.out.println("PEEK " + stackArray[topOfStack]  + " Is at the Top of the Stack\n");
		
		return stackArray[topOfStack];
		
	}
	
	public void pushMany(String multipleValues){
		
		String[] tempString = multipleValues.split(" ");
		
		for(int i = 0; i < tempString.length; i++){
			
			push(tempString[i]);
//			we work with one value at a time
			
		}
		
	}
	
	public void popAll(){
		
		for(int i = topOfStack; i >= 0; i--){
			
			pop();
			
		}
		
	}
	
	public void popDisplayAll(){
		
		String theReverse = "";
		
		for(int i = topOfStack; i >= 0; i--){
			
			theReverse += stackArray[i];
			
		}
		
		System.out.println("The Reverse: " + theReverse);
		
		popAll();
		
	}

	public void displayTheStack(){
		
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
			
			for(int n = 0; n < stackSize; n++){
				
				System.out.format("| %2s "+ " ", n); // %2s -> string saða gider
				
			}
			
			System.out.println("|");
			
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
			
			for(int n = 0; n < stackSize; n++){
//			harf veya boþluk print edilir	
				
				
				if(stackArray[n].equals("-1")) System.out.print("|     ");
//				arrayi -1 ile doldurmuþtuk, o yüzden -1'e eþitledik
				
				else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
				
			}
			
			System.out.println("|");
			
			for(int n = 0; n < 61; n++)System.out.print("-");
			
			System.out.println();
		
	}
	
	public static void main(String[] args){
		
		TheStack theStack = new TheStack(10);
		
		theStack.push("10");
		theStack.push("17");
		theStack.push("13");
		
		// Look at the top value on the stack
		
		theStack.peek();
		
		// Remove values from the stack (LIFO)
		
		theStack.pop();
		theStack.pop();
		theStack.pop();
		theStack.pop();
		
		// Add many to the stack
		
		theStack.pushMany("R E D R U M");
		
		// Remove all from the stack
		
//		theStack.popAll();
		
		// Remove all from the stack and print them
		
		theStack.popDisplayAll();
//		popAll metodu üzerinden pop metodunu çaðýrýr
		
	}
	
}
/*
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 10  |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH 10 Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 10  | 17  |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH 17 Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 10  | 17  | 13  |     |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH 13 Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 10  | 17  | 13  |     |     |     |     |     |     |     |
-------------------------------------------------------------
PEEK 13 Is at the Top of the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 10  | 17  |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP 13 Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 10  |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP 17 Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|     |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP 10 Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|     |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
Sorry But the Stack is Empty
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH R Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH E Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |     |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH D Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |  R  |     |     |     |     |     |     |
-------------------------------------------------------------
PUSH R Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |  R  |  U  |     |     |     |     |     |
-------------------------------------------------------------
PUSH U Was Added to the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |  R  |  U  |  M  |     |     |     |     |
-------------------------------------------------------------
PUSH M Was Added to the Stack

The Reverse: MURDER
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |  R  |  U  |     |     |     |     |     |
-------------------------------------------------------------
POP M Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |  R  |     |     |     |     |     |     |
-------------------------------------------------------------
POP U Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |  D  |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP R Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |  E  |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP D Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|  R  |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP E Was Removed From the Stack

-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
|     |     |     |     |     |     |     |     |     |     |
-------------------------------------------------------------
POP R Was Removed From the Stack
*/