public class Link {
// ***a link is an object
// link list has a reference to newest link
// each link holds the reference to the Link that was created before it
// so if link list wants to access links before the newest link (next link) then it has to call newest link
	
//	every element added to the list is also called as node. 
//	node has 2 parts, one of which is data and other is reference 
//	to the previous node added to the list***

// **data of link**	
	public String bookName;
	public int millionsSold;
	
	// ***Reference to next (previous; þekilde next zamanda previous) link made in the LinkList
	// Holds the reference to the Link that was created before it***
	// Set to null until it is connected to other links
	public Link next;  // **reference of link to previous links**	
	
	public Link(String bookName, int millionsSold){
		
		this.bookName = bookName;
		this.millionsSold = millionsSold;
		
	}
	
	public void display(){
		
		System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");
		
	}
	
	public String toString(){
		
		return bookName;
		
	}
	
	public static void main(String[] args) {
		
		LinkList theLinkedList = new LinkList();
		
		// Insert Link and add a reference to the book Link added just prior
		// to the field next
		
		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);
		
		theLinkedList.display(); // cycles the list
		
		System.out.println("Value of first link in LinkedList " + theLinkedList.firstLink);
		System.out.println("Value of second link in LinkedList " + theLinkedList.firstLink.next + "\n");
		
		// Removes the last Link entered
		theLinkedList.removeFirst();
		theLinkedList.display();
		
//		return edilen link üzerinden bookName variable çaðýrýlýr
		System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " Was Found");
		System.out.println("its next link is " + theLinkedList.find("The Lord of the Rings").next.bookName);
		System.out.println();
		
		theLinkedList.removeLink("A Tale of Two Cities");
		System.out.println("A Tale of Two Cities Removed\n");
		theLinkedList.display();
		
	}
	
}
/*
Current Link: Harry Potter and the Sorcerer's Stone
Harry Potter and the Sorcerer's Stone: 107,000,000 Sold
Next Link: The Lord of the Rings

Current Link: The Lord of the Rings
The Lord of the Rings: 150,000,000 Sold
Next Link: A Tale of Two Cities

Current Link: A Tale of Two Cities
A Tale of Two Cities: 200,000,000 Sold
Next Link: Don Quixote

Current Link: Don Quixote
Don Quixote: 500,000,000 Sold
Next Link: null

Value of first link in LinkedList Harry Potter and the Sorcerer's Stone
Value of second link in LinkedList The Lord of the Rings

First Link removed
Current Link: The Lord of the Rings
The Lord of the Rings: 150,000,000 Sold
Next Link: A Tale of Two Cities

Current Link: A Tale of Two Cities
A Tale of Two Cities: 200,000,000 Sold
Next Link: Don Quixote

Current Link: Don Quixote
Don Quixote: 500,000,000 Sold
Next Link: null

The Lord of the Rings Was Found
its next link is A Tale of Two Cities

FOUND A MATCH
currentLink: A Tale of Two Cities
A Tale of Two Cities Removed

Current Link: The Lord of the Rings
The Lord of the Rings: 150,000,000 Sold
Next Link: Don Quixote

Current Link: Don Quixote
Don Quixote: 500,000,000 Sold
Next Link: null
*/