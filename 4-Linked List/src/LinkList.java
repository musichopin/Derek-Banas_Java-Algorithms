class LinkList{
//	knows last link added
	
	// ***Reference to first Link in list
	// The "last" Link added to the LinkedList***
	public Link firstLink; 
	
	LinkList(){
		
		// Here to show the first Link always starts as null
		firstLink = null;
		
	}
	
	// **Returns true if "LinkList is empty"**
	public boolean isEmpty(){
		
		return(firstLink == null);
		
	}
	
	public void insertFirstLink(String bookName, int millionsSold){
		
		Link newLink = new Link(bookName, millionsSold);
		
		// **newlink's next is assigned a reference to the previous link created**
		newLink.next = firstLink;
//		***Link, data (I) ve reference (->) olmak üzere 2 kýsýmdan oluþur
//		bir linkin referansý önceden eklenen linkin datasýný iþaret eder:
//		II->I1->null (newLink.next=null; 1. reference newlink iken 2. referance newlink.next olur)
//		II->I2->I1->null (newLink.next.next=null)
//		II->I3->I2->I1->null (newLink.next.next.next=null)
//		II->I4->I3->I2->I1->null (newLink.next.next.next.next=null)
//		try {System.out.println(newLink);} catch (Exception e) {}
//		try {System.out.println(newLink.next);} catch (Exception e) {}
//		try {System.out.println(newLink.next.next);} catch (Exception e) {}***
		firstLink = newLink;
//		**linkedlist's first link is assigned a reference to the newest link added.
//		try {System.out.println(firstLink);} catch (Exception e) {}
//		try {System.out.println(firstLink.next);} catch (Exception e) {}
//		try {System.out.println(firstLink.next.next);} catch (Exception e) {}**
	}
	
	public Link removeFirst(){
		
//		**linkReference references to the last link added**
		Link linkReference = firstLink; 
		// ***linkReference gereksiz çünkü delete ettiði
		//  için global variable olan firstLink'in etkilenmesini istiyoruz***
		
		if(!isEmpty()){
		
			// *Removes the Link from the List*

			firstLink = firstLink.next;
			
			System.out.println("First Link removed");
		
		} else {
			
			System.out.println("Empty LinkedList");
			
		}
		
		return linkReference; // *not used*
		
	}
	
	public void display(){
		
//		**firstLink'e eþit olduðundan yeni object oluþmaz**
		Link theLink = firstLink;
		// ***bu kýsmýn mantýðý çok önemli:
		// firstLink'in deðiþmesini istemiyoruz (çünkü sadece display ediyoruz), 
		// theLink'e assign edildiði için while loop'un baþýnda da sonunda da 
		// firstLink deðiþmez***
		
		// Start at the reference stored in firstLink and
		// keep getting the references stored in next for
		// every Link until next returns null
		
		while(theLink != null){ // alt: if(!isEmpty())
			
			System.out.println("Current Link: " + theLink);
			
			theLink.display();
			
			System.out.println("Next Link: " + theLink.next);
			
			theLink = theLink.next; 
			
			System.out.println();
			
		}
		
	}
	
	public Link find(String bookName){
		
		Link theLink = firstLink;
		// ***bu kýsmýn mantýðý çok önemli:
		// firstLink'in deðiþmesini istemiyoruz (çünkü sadece find ediyoruz), 
		// theLink'e assign edildiði için while loop'un baþýnda da sonunda da 
		// firstLink deðiþmez***
		
		if(!isEmpty()){ // alt: if(theLink != null)
//		alt2: while(theLink != null & theLink.bookName != bookName)
			while(theLink.bookName != bookName){
			
				// ***Checks if at the end of the LinkedList***
				if(theLink.next == null){
				
					// Got to the end of the Links in LinkedList
					// without finding a match
				
					return null;
				
				} else {
				
					// Found a matching Link in the LinkedList
				
					theLink = theLink.next;
				
				}
			
			}
			
		} else {
			
			System.out.println("Empty LinkedList");
			
		}
		
		return theLink;
		
	}
	
	public Link removeLink(String bookName){
		
		Link currentLink = firstLink;
		Link previousLink = firstLink; // *"null" dense de olurdu (?)*
		
		// Keep searching as long as a match isn't made
		
		while(currentLink.bookName != bookName){
			
			// Check if at the last Link in the LinkedList
			
			if(currentLink.next == null){
				
				// bookName not found so leave the method
				
				return null; 
				
			} else {
				
				// We checked here so let's look in the
				// next Link on the list
				
				previousLink = currentLink; 
				
				currentLink = currentLink.next;
				
			}
			
		}
		
		if(currentLink == firstLink){
			
			// If you are here that means there was a match
			// in the reference stored in firstLink in the
			// LinkedList so just assign next to firstLink
			System.out.println("FOUND A MATCH");
			System.out.println("firstLink: " + firstLink);
			
			firstLink = firstLink.next; // **deletes**
			// alt: **previousLink = currentLink.next;** 
			
		} else {
			
			// If you are here there was a match in a Link other 
			// than the firstLink. Assign the value of next for
			// the Link you want to delete to the Link that's 
			// next previously pointed to the reference to remove
			
			System.out.println("FOUND A MATCH");
			System.out.println("currentLink: " + currentLink);
			
			previousLink.next = currentLink.next; 
			// **deletes but how does it effect the real data, firstlink(?)**
			
		}
		
		return currentLink; // not used
		// returns deleted link
		
	}
	
}