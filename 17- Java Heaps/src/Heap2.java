import java.util.Arrays;

public class Heap2 {

	private Data3[] theHeap;

	private int itemsInArray = 0;

	private int maxSize;

	
	public Heap2(int maxSize) {

		this.maxSize = maxSize;

		theHeap = new Data3[maxSize];

	}

//	**inserts new data to the array and to the heap**
	public void insert(int index, Data3 newData) {

		theHeap[index] = newData;

	}

//	**heapsort()'dan dolayý insert metodunun içinde deðil, but how (?)**
	public void incrementTheArray() {

		itemsInArray++;

	}

	
//	**removes item from the heap**
	public Data3 pop() {

		// if (itemsInArray != 0) {

		int tempItemsInArray = itemsInArray - 1;

		// Used to show how data is moved during sorting

		System.out.println("Store " + theHeap[0] + " in root. Store "
				+ theHeap[tempItemsInArray] + " in index 0");

		System.out.println(Arrays.toString(theHeap) + "\n");

		Data3 root = theHeap[0];

		theHeap[0] = theHeap[--itemsInArray];
//		itemsInArray 1 azalýr

		// Send to the array heap method starting with index 0

		heapTheArray(0); 
		// **corrects the format of heap making the parent nodes larger than children**

		return root;
//		**returns the deleted node**

		// }

		// return null;

	}

	
//	**we saw this method being constructed in tutorial, "solving programming problems"** 
	public void printTree2(int rows) {
//		**rows loop sayýsýný ve treenin row sayýsýný belirler**

		// Number of spaces between items in tree

		int spaces = 0;

		int iteration = 1;

		// Generate all of the indents that are
		// needed depending on the number of rows
		// to print

		int[] indent = getIndentArray(rows);

		while (iteration <= rows) {

			// Find first Index : .5 * (-2 + 2^n)

			int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));

			// Number of Items per Row : 2^(n - 1)

			int itemsPerRow = (int) (Math.pow(2, iteration - 1));

			int maxIndexToPrint = indexToPrint + itemsPerRow;

			// Print the indents needed

			for (int j = 0; j < indent[iteration - 1]; j++)
				System.out.print(" ");

			// Print all of the index values for each row
			// indexToPrint represents the first index in the
			// row, while maxIndexToPrint equals the last

			for (int l = indexToPrint; l < maxIndexToPrint; l++) {

				// If the array isn't full don't try to print
				// indexes that don't exist

				if (l < itemsInArray) {

					System.out.print(String.format("%02d", theHeap[l].key));

					for (int k = 0; k < spaces; k++)
						System.out.print(" ");

				}

			}

			// In a tree the spaces get bigger in the
			// same way that indents get smaller

			spaces = indent[iteration - 1];

			iteration++;

			System.out.println();

		}

	}

	
	// Calculate each indent per row for the tree
	// then reverse their order to go from biggest
	// to smallest
//	**we saw this method being constructed in tutorial, "solving programming problems"** 
	public int[] getIndentArray(int rows) {

		int[] indentArray = new int[rows];

		for (int i = 0; i < rows; i++) {

			indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));

		}

		Arrays.sort(indentArray);

		indentArray = reverseArray(indentArray);

		return indentArray;

	}

	// Reverse the indent values in the array
	// so that they go from biggest to smallest
//	**we saw this method being constructed in tutorial, "solving programming problems"** 
	public int[] reverseArray(int[] theArray) {

		// Index of the first element
		int leftIndex = 0;

		// Index of last element
		int rightIndex = theArray.length - 1;

		while (leftIndex < rightIndex) {
			// Exchange the left and right elements
			int temp = theArray[leftIndex];
			theArray[leftIndex] = theArray[rightIndex];
			theArray[rightIndex] = temp;

			// Move the indexes to check towards the middle
			leftIndex++;
			rightIndex--;
		}

		return theArray;
	}

	
	// Fill the heap with random numbers based on
	// the number that is passed in
	public void generateFilledArray(int randNum) {

		Data3 randomData1;

		for (int i = 0; i < this.maxSize; i++) {

			randomData1 = new Data3((int) (Math.random() * randNum) + 1);

			this.insert(i, randomData1);
//			**inserts Data3 class objects to array**

			// Need to do this in a separate function because
			// later when I sort the array I need to use insert
			// without incrementing the array

			incrementTheArray();

		}

	}

	// **corrects the format of heaps making the parent nodes larger than children**
	public void heapTheArray(int index) {
		
		int largestChild;

		Data3 root = theHeap[index];

		while (index < itemsInArray / 2) {

			// Get the index for the leftChild

			int leftChild = 2 * index + 1;

			// Get the index for the rightChild

			int rightChild = leftChild + 1;

			// If leftChild is less then rightChild
			// save rightChild in largestChild
			
			if (rightChild < itemsInArray
					&& theHeap[leftChild].key < theHeap[rightChild].key) {

				System.out.println("Put Value " + theHeap[rightChild]
						+ " in largestChild");

				largestChild = rightChild;

			} else {

				System.out.println("Put Value " + theHeap[leftChild]
						+ " in largestChild");

				// Otherwise save leftChild in largestChild

				largestChild = leftChild;

			}

			// **If root is greater then the largestChild jump out of while**
			if (root.key >= theHeap[largestChild].key)
				break;

			System.out.println("Put Index Value " + theHeap[largestChild]
					+ " in Index " + index);

			// Save the value in largest child into the top
			// index

			theHeap[index] = theHeap[largestChild];

			index = largestChild;
//			**while loop'a yeniden girerken index yenilenir (sub tree için)**

			System.out.println();

			printTree2(4);

			System.out.println();

		}

		theHeap[index] = root;

	}

	// Cycle through the array and pop off each so
	// the array goes from smallest to largest

	public void heapSort() {

		for (int k = maxSize - 1; k >= 0; k--) {

			Data3 largestNode = pop();
//			***arrayin baþýndan delete edilen en büyük node olan 
//			largestNode'u arrayin sonuna insert eder ve bu iþlem 
//			arraysize kadar gerçekleþince array küçükten büyüðe 
//			sýralanmýþ olur***
			insert(k, largestNode);
			
			System.out.println(Arrays.toString(theHeap));

		}

	}

	public static void main(String args[]) {

		Heap2 newHeap = new Heap2(7);

		newHeap.generateFilledArray(90);

		// Print out the array before it is sorted
		System.out.println("**Original Array**");
		System.out.println(Arrays.toString(newHeap.theHeap));
		
		System.out.println();
		System.out.println("**Tree but not really a heap**");
		newHeap.printTree2(4); // **prints as tree (not in heap structure though)**
		System.out.println();
		
		System.out.println("**Heaping the array**");
//		*"newHeap.maxSize / 2 - 1" denerek 7 elemanlý array 3 kere iterate edilir 
//		(çünkü son row ignore ediliyormuþ)*
		for (int j = newHeap.maxSize / 2 - 1; j >= 0; j--) {

			newHeap.heapTheArray(j);
//			**forms the tree in heap structure**

		}

		System.out.println("**Heaped Array**");
		System.out.println(Arrays.toString(newHeap.theHeap) + "\n");
		
		System.out.println("**Printing the heap**");
		newHeap.printTree2(4);
		
//		System.out.println("\n**First Item removed");
//		newHeap.pop();
//		System.out.println(newHeap.itemsInArray);
//		System.out.println(newHeap.maxSize);
//		System.out.println(Arrays.toString(newHeap.theHeap));

		System.out.println("**HEAPED SORTED**");
		newHeap.heapSort();

		// Print the sorted array
		System.out.println("\n**Sorted Array**");
		System.out.println(Arrays.toString(newHeap.theHeap));
		
	}

}

class Data3 {
// ***binary tree'deki gibi leftchild ve rightchild bulunmaz, 
//	zira heap elemanlarýna array üzerinden ulaþýlabilir***
	
	public int key;

	public Data3(int key) {

		this.key = key;

	}

	public String toString() {

		return Integer.toString(key);

	}

}
/*
**Original Array**
[58, 57, 4, 33, 74, 70, 5]

**Tree but not really a heap**
              58
      57              04              
  33      74      70      05      


**Heaping the array**
Put Value 70 in largestChild
Put Index Value 70 in Index 2

              58
      57              70              
  33      74      70      05      


Put Value 74 in largestChild
Put Index Value 74 in Index 1

              58
      74              70              
  33      74      04      05      


Put Value 74 in largestChild
Put Index Value 74 in Index 0

              74
      74              70              
  33      57      04      05      


Put Value 57 in largestChild
**Heaped Array**
[74, 58, 70, 33, 57, 4, 5]

**Printing the heap**
              74
      58              70              
  33      57      04      05      

**HEAPED SORTED**
Store 74 in root. Store 5 in index 0
[74, 58, 70, 33, 57, 4, 5]

Put Value 70 in largestChild
Put Index Value 70 in Index 0

              70
      58              70              
  33      57      04      


Put Value 4 in largestChild
[70, 58, 5, 33, 57, 4, 74]
Store 70 in root. Store 4 in index 0
[70, 58, 5, 33, 57, 4, 74]

Put Value 58 in largestChild
Put Index Value 58 in Index 0

              58
      58              05              
  33      57      


Put Value 57 in largestChild
Put Index Value 57 in Index 1

              58
      57              05              
  33      57      


[58, 57, 5, 33, 4, 70, 74]
Store 58 in root. Store 4 in index 0
[58, 57, 5, 33, 4, 70, 74]

Put Value 57 in largestChild
Put Index Value 57 in Index 0

              57
      57              05              
  33      


Put Value 33 in largestChild
Put Index Value 33 in Index 1

              57
      33              05              
  33      


[57, 33, 5, 4, 58, 70, 74]
Store 57 in root. Store 4 in index 0
[57, 33, 5, 4, 58, 70, 74]

Put Value 33 in largestChild
Put Index Value 33 in Index 0

              33
      33              05              
  


[33, 4, 5, 57, 58, 70, 74]
Store 33 in root. Store 5 in index 0
[33, 4, 5, 57, 58, 70, 74]

Put Value 4 in largestChild
[5, 4, 33, 57, 58, 70, 74]
Store 5 in root. Store 4 in index 0
[5, 4, 33, 57, 58, 70, 74]

[4, 5, 33, 57, 58, 70, 74]
Store 4 in root. Store 4 in index 0
[4, 5, 33, 57, 58, 70, 74]

[4, 5, 33, 57, 58, 70, 74]

**Sorted Array**
[4, 5, 33, 57, 58, 70, 74]
*/