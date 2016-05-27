public class ArrayStructure {
	
	private int[] theArray = new int[50]; // Creates an array with 50 indexes
	
	private int arraySize = 10; // Elements in theArray
	
	
	// Fills the Array with random values
	
	public void generateRandomArray(){
		
		for(int i = 0; i < arraySize; i++){
			
			theArray[i] = (int)(Math.random()*9)+10;
			
		}
		
	}
	
	public int[] getTheArray(){
		
		return theArray;
		
	}
	
	public int getArraySize(){
		
		return arraySize;
		
	}
	
	
	
	// Used to slow down calculations
	
	public void pauseAndUpdate(){
		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			
			for(int i = index; i < (arraySize - 1); i++){
				
				pauseAndUpdate();
				
				theArray[i] = theArray[i+1];
		
			}
			
			arraySize--;
			
		}
		
	}
	
	public void insertValue(int value){
		
		if(arraySize < 50){
			
			pauseAndUpdate();
			
			theArray[arraySize] = value;
			
			arraySize++;
			
		}
		
	}
	
	// Linear Search : Every index must be looked at
	
	public String linearSearchForValue(int value){
		
		boolean valueInArray = false;
		
		String indexsWithValue = "";
			
		System.out.print("The Value was Found in the Following Indexes: ");
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == value) {
				valueInArray = true;
				
				System.out.print(i + " ");
				
				indexsWithValue+= i + " ";
			}
			
		}
		
		if(!valueInArray){
			indexsWithValue = "None";
			
			System.out.print(indexsWithValue);
		}
			
		System.out.println();
		
		return indexsWithValue;
			
	}
	
	// This bubble sort will sort everything from 
	// smallest to largest
	
	public void bubbleSort(){
		
		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted
		
		for(int i = arraySize - 1; i > 1; i--){
			
			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped
			
			for(int j = 0; j < i; j++){
				
				if(theArray[j] > theArray[j + 1]){
					
					swapValues(j, j+1);
					
				}
				
			}
			
		}
		
	}
	
	// This bubble sort will sort everything from 
	// largest to smallest
	
	public void bubbleSortDescending(){
		
		// i starts at the beginning of the array
		
		for(int i = 0; i < arraySize; i++){
			
			// The inner loop starts at the beginning of 
			// the array 1 index in more than i. 
			
			for(int j = 1; j < (arraySize - i); j++){
				
				// Here we check if the 1st index is less
				// than the next during the first run through
				// Then we just increase the indexes until
				// they have all been checked
				
				if(theArray[j-1] < theArray[j]){
					
					swapValues(j-1, j);
					
				}
				
			}
			
		}
		
	}
	
	public void swapValues(int indexOne, int indexTwo){
		
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
		
	}
	
	// The Binary Search is quicker than the linear search
	// because all the values are sorted. Because everything
	// is sorted once you get to a number larger than what
	// you are looking for you can stop the search. Also
	// you be able to start searching from the middle 
	// which speeds the search. It also works best when 
	// there are no duplicates
	
	public void binarySearchForValue(int value){
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex){
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
			
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
			
			else {
				
				System.out.println("Found a Match for " + value + " at Index " + middleIndex);
				
				lowIndex = highIndex + 1;
				
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		
		ArrayStructure newArray = new ArrayStructure();
		
		newArray.generateRandomArray();
		
		newArray.printArray();
		
		System.out.println(newArray.getValueAtIndex(9));
		
		System.out.println(newArray.doesArrayContainThisValue(11));
		
		newArray.deleteIndex(3);
		
		newArray.insertValue(100);
		
		newArray.bubbleSort();
		
		newArray.printArray();
		
		newArray.linearSearchForValue(11);
		
		newArray.binarySearchForValue(12);
		
		newArray.bubbleSortDescending();
		
		newArray.printArray();
		
		
	}

}
/*
----------
| 0 | 18 |
----------
| 1 | 10 |
----------
| 2 | 16 |
----------
| 3 | 12 |
----------
| 4 | 17 |
----------
| 5 | 18 |
----------
| 6 | 16 |
----------
| 7 | 18 |
----------
| 8 | 17 |
----------
| 9 | 17 |
----------
17
false
----------
| 0 | 10 |
----------
| 1 | 16 |
----------
| 2 | 16 |
----------
| 3 | 17 |
----------
| 4 | 17 |
----------
| 5 | 17 |
----------
| 6 | 18 |
----------
| 7 | 18 |
----------
| 8 | 18 |
----------
| 9 | 100 |
----------
The Value was Found in the Following Indexes: None
----------
| 0 | 100 |
----------
| 1 | 18 |
----------
| 2 | 18 |
----------
| 3 | 18 |
----------
| 4 | 17 |
----------
| 5 | 17 |
----------
| 6 | 17 |
----------
| 7 | 16 |
----------
| 8 | 16 |
----------
| 9 | 10 |
----------
*/