public class ArrayStructures {
		
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	public void generateRandomArray(){
		
		for(int i = 0; i < arraySize; i++){
			
			theArray[i] = (int)(Math.random()*10)+10;
			
		}
		
	}
	
	public void printArray(){
		
		System.out.println("----------");
		for(int i = 0; i < arraySize; i++){
			
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			
			System.out.println("----------");
			
		}
		
	}
	
	public int getValueAtIndex(int index){
		
		if(index < arraySize) return theArray[index];
		
		return 0;
		
	}
	
	public boolean doesArrayContainThisValue(int searchValue){
		
		boolean valueInArray = false;
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == searchValue){
				
				valueInArray = true;
				
			}
			
		}
		
		return valueInArray;
		
	}
	
	public void deleteIndex(int index){
		
		if(index < arraySize){
			
			for(int i = index; i < (arraySize - 1); i++){
				
				theArray[i] = theArray[i+1];
				
			}
			
			arraySize--;
			
		}
		
	}
	
	public void insertValue(int value){
		
		if(arraySize < 50){
			
			theArray[arraySize] = value;
			
			arraySize++;
			
		}
		
	}
	
	public String linearSearchForValue(int value){
		
		boolean valueInArray = false;
		
		String indexsWithValue = "";
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == value){
				
				valueInArray = true;
				
				indexsWithValue+= i + " "; // useless
				
			}
			
			printHorzArray(i, -1);
			
		}
		
		if(!valueInArray){
			
			indexsWithValue = "None";
			
		}
		
		System.out.print("The Value was Found in the Following: " + indexsWithValue);
		
		System.out.println();
		
		return indexsWithValue; // useless
		
	}
	
public void printHorzArray(int i, int j){
		
		for(int n = 0; n < 47; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + n + " ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 47; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("|" + theArray[n] + "");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 47; n++)System.out.print("-");
		
		System.out.println();
		
		// END OF FIRST PART
		
		
		// *ADDED FOR BUBBLE SORT (for inner for loop)*
		if(j != -1){
		
			// **ADD THE +1.5 TO FIX SPACING
//			alt olarak indeksi 1 arttýrarak 
//			(int k = 0; k < ((j+1)*5.2); k++) tarzý biþi de denebilirdi**
			for(int k = 0; k < ((j*5.8)+1.5); k++)System.out.print(" ");
			
			System.out.print(j);
			
		}
		
		
		// *THEN ADD THIS CODE (not only for bubble sort)*
		if(i != -1){
			
			// ADD THE -1 TO FIX SPACING
			// spacing eklenir
			for(int l = 0; l < (4*(1.4*i - 1.5*j)-1); l++)System.out.print(" ");
			
			System.out.print(i);
			
		}
		
		System.out.println();
		
	}
	
	// This bubble sort will sort everything from 
		// smallest to largest or (by changing one tiny piece of code
		// from largest to smallest)
		
		public void bubbleSort(){
			// i starts at the end of the Array
			// As it is decremented all indexes greater
			// than it are sorted 
//			(çünkü inner loop büyük indexleri sortlamýþ oluyor)
			
			for(int i = arraySize - 1; i > 1; i--){
//				i > 1 olunca inner loop için 0 ve 1 deðerleri kalýyor
				
				// The inner loop starts at the beginning of 
				// the array and compares each value next to each 
				// other. If the value is greater then they are 
				// swapped
				for(int j = 0; j < i; j++){
					
					// To change sort to Descending change to <
					
					if(theArray[j] > theArray[j + 1]){
						
						swapValues(j, j+1);
						
						printHorzArray(i, j);
						// sadece swap edileceði zaman print ediliyor
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
//				we start the search from the middle, which increases the speed
				
				if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
				
				else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
				
				else {
					
					System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
					
					lowIndex = highIndex + 1; // loopu durdurmak için
					
				}
				
				printHorzArray(middleIndex, -1);
				
			}
			
		}
		
		// Selection sort search for the smallest number in the array
		// saves it in the minimum spot and then repeats searching
		// through the entire array each time

		public void selectionSort(){
			
			for(int x=0; x < arraySize; x++){
				  int minimum = x;
				  
				  for(int y=x; y < arraySize; y++){
				  
					  // To change direction of sort just change 
					  // this from > to <
					  
					  if(theArray[minimum]>theArray[y]){
						  minimum = y;
					  }
				  }
//				**bubble sortun aksine sýralamayý soldan saða doðru yapar**
				  swapValues(x, minimum);
				  
				  printHorzArray(x, -1);
			}
			
		}
		
		// *The Insertion Sort is normally the best of 
		// the elementary sorts. Unlike the other sorts that
		// had a group sorted at any given time, groups are
		// only partially sorted here.*
		
		public void insertionSort(){
			
			for (int i = 1; i < arraySize; i++){
				  int j = i;
				  int toInsert = theArray[i]; 
				  // **toInsert sonradan kullanýlacak ve deðiþtiði için var a atanýyor**
				  while ((j > 0) && (theArray[j-1] > toInsert)){
					  // **toInsert yerine theArray[i] veya theArray[j] kullanýlamaz, 
					  //   çünkü theArray manipule ediliyor**
					  theArray[j] = theArray[j-1];
					  j--; // loop dursun diye
					  
					  printHorzArray(i, j);
					  
				  }
				  theArray[j] = toInsert;
//				  **0. indeksi son indekse eþitler**
				  
				  printHorzArray(i, j);
				  
				  System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");
				  
			}
			
		}
	
	public static void main(String[] args){
		
		ArrayStructures newArray = new ArrayStructures();
		
		newArray.generateRandomArray();
		
		newArray.printHorzArray(-1,-1);
		
		System.out.println("\n\nlinearSearchForValue: ");
		newArray.linearSearchForValue(10);
		
		System.out.println("\n\n\nbubbleSort: ");
		newArray.bubbleSort();
		
		// We must Sort first
		System.out.println("\n\n\nbinarySearchForValue(17): ");
		newArray.binarySearchForValue(17);
		
		System.out.println("\n\n\nselectionSort: ");
		newArray.selectionSort();
		
		System.out.println("\n\n\ninsertionSort: ");
		newArray.insertionSort();
		
	}

}
/*
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------



linearSearchForValue: 
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
     0
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
           1
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                 2
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                      3
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                            4
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                                 5
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                                       6
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                                             7
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                                                  8
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|18|13|13|11|18|14|18|18|
-----------------------------------------------
                                                        9
The Value was Found in the Following: None



bubbleSort: 
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|13|18|13|11|18|14|18|18|
-----------------------------------------------
              2                                      9
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|13|13|18|11|18|14|18|18|
-----------------------------------------------
                   3                                9
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|13|13|11|18|18|14|18|18|
-----------------------------------------------
                         4                          9
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|18|13|13|11|18|14|18|18|18|
-----------------------------------------------
                                     6              9
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|13|18|13|11|18|14|18|18|18|
-----------------------------------------------
        1                                      8
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|13|13|18|11|18|14|18|18|18|
-----------------------------------------------
              2                                8
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|13|13|11|18|18|14|18|18|18|
-----------------------------------------------
                   3                          8
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|13|13|11|18|14|18|18|18|18|
-----------------------------------------------
                               5              8
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|13|11|13|18|14|18|18|18|18|
-----------------------------------------------
              2                           7
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|13|11|13|14|18|18|18|18|18|
-----------------------------------------------
                         4               7
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|12|11|13|13|14|18|18|18|18|18|
-----------------------------------------------
        1                           6
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
  0                           5



binarySearchForValue(17): 
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                            4
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                             7
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                 5



selectionSort: 
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
     0
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
           1
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                 2
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                      3
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                            4
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                 5
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                       6
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                             7
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                                  8
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                                        9



insertionSort: 
-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
        11

Array[i] = 12 Array[j] = 12 toInsert = 12

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
              22

Array[i] = 13 Array[j] = 13 toInsert = 13

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                   33

Array[i] = 13 Array[j] = 13 toInsert = 13

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                         44

Array[i] = 14 Array[j] = 14 toInsert = 14

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                               55

Array[i] = 18 Array[j] = 18 toInsert = 18

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                     66

Array[i] = 18 Array[j] = 18 toInsert = 18

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                           77

Array[i] = 18 Array[j] = 18 toInsert = 18

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                                88

Array[i] = 18 Array[j] = 18 toInsert = 18

-----------------------------------------------
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
-----------------------------------------------
|11|12|13|13|14|18|18|18|18|18|
-----------------------------------------------
                                                      99

Array[i] = 18 Array[j] = 18 toInsert = 18
*/