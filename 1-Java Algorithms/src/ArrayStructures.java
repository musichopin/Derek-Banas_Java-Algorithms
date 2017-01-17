public class ArrayStructures {
	
	private int[] theArray = new int[50]; // Creates an array with 50 indexes
	
	private int arraySize = 10; // Elements in theArray
//	we don't wanna print out the default size of 50
//	we wanna print out the parts of the array having values
	
	// Fills the Array with random values
	
	public void generateRandomArray(){
		
		for(int i = 0; i < arraySize; i++){
			
			// Random number 10 through 19
			
			theArray[i] = (int)(Math.random()*10)+10;
			
		}
		
	}
	
	public int[] getTheArray(){
		
		return theArray;
		
	}
	
	public int getArraySize(){
		
		return arraySize;
		
	}
	
	// Prints the Array on the screen in a grid
	
	public void printArray(){
		
		System.out.println("----------");
		
		for(int i = 0; i < arraySize; i++){
			
			System.out.print("| " + i + " | ");
			
			System.out.println(theArray[i] + " |");
			
			System.out.println("----------");
			
		}
		
	}
	
	// Gets value at provided index
	
	public int getValueAtIndex(int index){
		
		if(index < arraySize) return theArray[index];
		
		return 0;
		
	}
	
	// Returns true or false if a value is in the Array
	
	public boolean doesArrayContainThisValue(int searchValue){
		
		boolean valueInArray = false;
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == searchValue){
				
				valueInArray = true;
				
			}
			
		}
		
		return valueInArray;
		
	}
	
	
	// Delete Array row for the index and move elements up
	
	public void deleteIndex(int index){
		
		if(index < arraySize){
			
			// Overwrite the value for the supplied index
			// and then keep overwriting every index that follows
			// until you get to the last index in the array
			
//			we have 1 less actual value than our array size
//			because of deleted index
			for(int i = index; i < (arraySize - 1); i++){
				
				theArray[i] = theArray[i+1];
		
			}
			
			arraySize--;
			
		}
		
	}
	
	public void insertValue(int value){
		
		if(arraySize < 50){ // maximum capacity of the array is 50
			
			theArray[arraySize] = value; // arraySize 9 olmuþtu
			
			arraySize++;
			
		}
		
	}
	
	// Linear Search : Every index must be looked at
	
	public void linearSearchForValue(int value){
		
		boolean valueInArray = false;
		
		String indexsWithValue = "";
			
		System.out.print("The Value was Found in the Following Indexes: ");
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == value) {
				valueInArray = true;
				
				System.out.print(i + " ");
				
				indexsWithValue+= i + " "; // useless for now
//				storing for returning or whatever the reason
			}
			
		}
		
		if(!valueInArray){ // if not true
			indexsWithValue = "None"; 
			
			System.out.print(indexsWithValue); 
		}
			
		System.out.println(); // useless: printing a space
		
	}
	
	public static void main(String[] args){
		
		ArrayStructures newArray = new ArrayStructures();
		
		System.out.println("default array: ");
		newArray.generateRandomArray();
		
		newArray.printArray();
		
		System.out.print("\ngetvalueatindex(3): ");
		System.out.println(newArray.getValueAtIndex(3));
		
		System.out.print("\ndoesArrayContainThisValue(18): ");
		System.out.println(newArray.doesArrayContainThisValue(18));
		
		System.out.println("\ndeleteIndex(4): ");
		newArray.deleteIndex(4);
		
		newArray.printArray();
		
		System.out.println("\ninsertValue(55): ");
		newArray.insertValue(55);
		
		newArray.printArray();
		
		System.out.println("\nlinearSearchForValue(17): ");
		newArray.linearSearchForValue(17);
	}

}
/*
 default array: 
----------
| 0 | 11 |
----------
| 1 | 12 |
----------
| 2 | 19 |
----------
| 3 | 16 |
----------
| 4 | 11 |
----------
| 5 | 12 |
----------
| 6 | 19 |
----------
| 7 | 10 |
----------
| 8 | 13 |
----------
| 9 | 17 |
----------

getvalueatindex(3): 16

doesArrayContainThisValue(18): false

deleteIndex(4): 
----------
| 0 | 11 |
----------
| 1 | 12 |
----------
| 2 | 19 |
----------
| 3 | 16 |
----------
| 4 | 12 |
----------
| 5 | 19 |
----------
| 6 | 10 |
----------
| 7 | 13 |
----------
| 8 | 17 |
----------

insertValue(55): 
----------
| 0 | 11 |
----------
| 1 | 12 |
----------
| 2 | 19 |
----------
| 3 | 16 |
----------
| 4 | 12 |
----------
| 5 | 19 |
----------
| 6 | 10 |
----------
| 7 | 13 |
----------
| 8 | 17 |
----------
| 9 | 55 |
----------

linearSearchForValue(17): 
The Value was Found in the Following Indexes: 8 
*/
