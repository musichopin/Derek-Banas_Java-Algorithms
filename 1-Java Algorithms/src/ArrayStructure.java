public class ArrayStructure {
	
	private int[] theArray = new int[50]; // Creates an array with 50 indexes
//	***each of the values corresponding each of these 50 indexes 
//	become null until value is given***
	
	private int arraySize = 10; // Elements in theArray
//	***manual olarak yazýlmasý ve arrayin gerçek boyutundan (50) kucuk olmasý önemli
//	cunku arraysize a theArray.length denseydi arraye insertion yapýlamazdý***
	
	
	// Fills the Array with random values
	
	public void generateRandomArray(){
		
		for(int i = 0; i < arraySize; i++){
			
			theArray[i] = (int) ((Math.random()*9)+10);
//			*with casting to int, it takes numbers from 10 to 18*
			
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
//			*alt: System.out.println(getTheArray()[i] + " |");*
			
			System.out.println("----------");
			
		}
		
	}
	
	// Gets value at provided index
	
	public int getValueAtIndex(int index){
		
		if(0 < index && index < arraySize) return theArray[index];
		
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

		if(0 < index && index < arraySize){
			
			// Overwrite the value for the supplied index
			// and then keep overwriting every index that follows
			// until you get to the last index in the array

			for(int i = index; i < (arraySize - 1); i++){
//				**iterationda arraySize 1 azaltýlýyor ama aþaðýda 
//				(theArray[i+1] ifadesinde) +1 deniyor ve telafi yapýlýyor**
				
				pauseAndUpdate();

				theArray[i] = theArray[i+1];
		
			}
			
			arraySize--;
//			**sizeýn azaltýlmasý önemli aksi halde 
//			duplicate value olacaktý**
			
		}
		
	}
	
	public void insertValue(int value){
		
		if(arraySize < theArray.length){
			
			pauseAndUpdate();
			
			theArray[arraySize] = value;
			
			arraySize++;
			
		}
		
	}
	
	// Linear Search : Every index must be looked at
//	*doesArrayContainThisValue metoduna benzer*
	public String linearSearchForValue(int value){
		
		boolean valueInArray = false;
		
		String indexsWithValue = "";
			
		System.out.print("The Value "+value+" was Found in the Following Indexes: ");
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == value) {
				valueInArray = true;
				
				indexsWithValue+= i + " ";
				
				System.out.print(i + " ");
//				**alt olarak for loopun hemen sonrasýnda
//				System.out.print(indexsWithValue); denebilirdi**
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
//		***bubbleSortDescending'deki yöntem alternatif (ama ayný kapýya çýkýyor).
//		tek farklý yapýlmasý gereken "if(theArray[j-1] > theArray[j])" demek***
		
		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted
		
		for(int i = arraySize - 1; i > 0; i--){
			
			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped
			
			for(int j = 0; j < i; j++){
				
				if(theArray[j] > theArray[j + 1]){
					
					swapValues(j, j+1);
					
				}
				
			}
			
//			alt: inner for loop için
//			for(int j = 1; j < i+1; j++){
//				
//				if(theArray[j-1] > theArray[j]){
//					
//					swapValues(j-1, j);
//					
//				}
//				
//			}
			
		}
		
	}
	
	// This bubble sort will sort everything from 
	// largest to smallest
	
	public void bubbleSortDescending(){
		
		// i starts at the beginning of the array
		
		for(int i = 0; i < arraySize-1; i++){
//			**for(int i = 0; i < arraySize; i++)
//			dense de sorun yok**
			
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
			
//			***alt: algýlamasý daha kolay***
//			for(int j = 0; j < (arraySize - 1 - i); j++){	
//				if(theArray[j] < theArray[j+1]){
//					swapValues(j, j+1);
//				}
//			}
			
		}
		
	}
	
	public void swapValues(int indexOne, int indexTwo){
		
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
		
	}
	
	// *The Binary Search is quicker than the linear search
	// when all the values are sorted. Because 
	// once you get to a number larger than what
	// you are looking for you can stop searching bigger values 
	// (by getting the higher index down). Also
	// you be able to start searching from the middle 
	// which speeds the search. It also works best when 
	// there are no duplicates*
	
	public String binarySearchForValue(int value){
		
//		***for loop version: önemli***
//		for(int lowIndex = 0, highIndex = arraySize - 1; lowIndex <= highIndex;){
//			
//			 int middleIndex = (highIndex + lowIndex) / 2;
//			
//			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
//			
//			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
//			
//			else {
//				
//				System.out.println("Found a Match for " + value + " at Index " + middleIndex);
//				
//				lowIndex = highIndex + 1;
//				
//			}
//			
//		}
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		boolean found = false;
		
//		**lowIndex > highIndex veya highIndex < lowIndex olur ise 
//		sorgulanan value'nun array'de olmadýðý anlaþýlýr**
		while(lowIndex <= highIndex){
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
			
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
			
			else {
				
				System.out.println("Found a Match for " + value + " at Index " + middleIndex);
				
				lowIndex = highIndex + 1; // useless since we return
				
				found = true; // useless since we return
				
				return Integer.toString(middleIndex);

			}
			
		}
		
		if(!found) {
			System.out.println("The Value " + value + " not found");
		}
		return null;
		
	}
	
	public static void main(String[] args){
		
		
		ArrayStructure newArray = new ArrayStructure();
		
		newArray.generateRandomArray();
		
		newArray.printArray();
		
		System.out.println(newArray.getValueAtIndex(9));
		
		System.out.println(newArray.doesArrayContainThisValue(11));
		
		newArray.deleteIndex(3);
		
		newArray.insertValue(100);
		
		System.out.println("\nbubble sort: ascending");
		newArray.bubbleSort();
		
		newArray.printArray();
		
		newArray.linearSearchForValue((int) ((Math.random()*12)+10));
		
		newArray.binarySearchForValue((int) ((Math.random()*12)+10));
		
		System.out.println("\nbubble sort: descending");
		newArray.bubbleSortDescending();
		
		newArray.printArray();
		
		
	}

}

/*
----------
| 0 | 13 |
----------
| 1 | 12 |
----------
| 2 | 13 |
----------
| 3 | 15 |
----------
| 4 | 16 |
----------
| 5 | 11 |
----------
| 6 | 11 |
----------
| 7 | 12 |
----------
| 8 | 13 |
----------
| 9 | 15 |
----------
15
true

bubble sort: ascending
----------
| 0 | 11 |
----------
| 1 | 11 |
----------
| 2 | 12 |
----------
| 3 | 12 |
----------
| 4 | 13 |
----------
| 5 | 13 |
----------
| 6 | 13 |
----------
| 7 | 15 |
----------
| 8 | 16 |
----------
| 9 | 100 |
----------
The Value 15 was Found in the Following Indexes: 7 
Found a Match for 15 at Index 7

bubble sort: descending
----------
| 0 | 100 |
----------
| 1 | 16 |
----------
| 2 | 15 |
----------
| 3 | 13 |
----------
| 4 | 13 |
----------
| 5 | 13 |
----------
| 6 | 12 |
----------
| 7 | 12 |
----------
| 8 | 11 |
----------
| 9 | 11 |
----------
*/