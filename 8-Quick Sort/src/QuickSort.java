import java.util.Arrays;

// The Quick Sort is normally the fastest sorting algorithm

public class QuickSort {

	private static int[] theArray;

	private static int arraySize;

	public static void main(String[] args) {

		QuickSort theSort = new QuickSort(10);

		System.out.println(Arrays.toString(QuickSort.theArray));

		theSort.quickSort(0, 9); // **en soldaki 0., en saðdaki ise 9. index**

		System.out.println(Arrays.toString(QuickSort.theArray));

	}

	QuickSort(int newArraySize) {

		arraySize = newArraySize;

		theArray = new int[arraySize];

		generateRandomArray();

	}
	
	// ***quick sort 3 aþamalý gerçekleþir:
	// 1. pivot value bulunur (en sað kýsým)
	// 2. pivot value ile leftpointer yer deðiþtirir
	// 3. array sub arraylere ayrýlýr ve yukarýdaki iþlemler 
	// sub arrayler için de (array kalmayýncaya kadar) gerçekleþtirilir*** //
	public void quickSort(int left, int right) {

		if (right - left <= 0)
			return; // Everything is sorted

		else {

			// ***It doesn't matter what the pivot is, but it must be a value in the array.
			// sub-arraylerin de en saðdaki deðeri pivot olarak belirleniyor. 
			// Quick Sort's job is to make smaller and smaller arrays to be partitioned with recursion***
			int pivot = theArray[right];
			
			System.out.println("\nLeft value in new (sub)array " + theArray[left]);
			
			System.out.println("Value in right " + theArray[right]
					+ " is made the pivot");

			System.out.println("left = " + left + " right= " + right
					+ " pivot= " + pivot + " sent to be partitioned");

			int pivotLocation = partitionArray(left, right, pivot);

			// ***recursion'ýn mantýðýný (her iterationda azalýyor) 
			// ve iteration sýrasýný anlamak önem arz ediyor 
			// (aðaç gibi dallanýyor diye düþünmeli)***
			quickSort(left, pivotLocation - 1); // Sorts the left side. 
//			***pivotLocation is index of pivot***

			quickSort(pivotLocation + 1, right); // sorts the right side

		}

	}

	public int partitionArray(int left, int right, int pivot) {

		int leftPointer = left - 1;

		int rightPointer = right;
//		***rightPointer'ýn array size'a deðil arraysize'ýn 1 eksiðine eþit olmasýna dikkat***

		while (true) {

			while (theArray[++leftPointer] < pivot)
				;
//			***alt: more readable*** 
//			while (++leftPointer < arraySize && theArray[leftPointer] < pivot)
//				;

			printHorzArray(leftPointer, rightPointer);

			System.out.println(theArray[leftPointer] + " in index "
					+ leftPointer + " is bigger than the pivot value " + pivot);

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;
//			***alt: more readable***
//			while (--rightPointer >= 0 && theArray[rightPointer] > pivot)
//				;

			printHorzArray(leftPointer, rightPointer);

			System.out.println(theArray[rightPointer] + " in index "
					+ rightPointer + " is smaller than the pivot value "
					+ pivot);

			if (leftPointer >= rightPointer) {
				
				printHorzArray(leftPointer, rightPointer);

				System.out.println("left is >= right so start again");

				break;

			}

			else {

				swapValues(leftPointer, rightPointer);
				
				printHorzArray(leftPointer, rightPointer);

				System.out.println(theArray[leftPointer] + " was swapped for "
						+ theArray[rightPointer]);

			}

		}

		swapValues(leftPointer, right); // ***indekslerin deðil valuelarýn yerleri deðiþir
		// while loop'u break ettikten sonra pivot index (right)'in valuesu ile 
		//	leftpointer indeksin valuesu yer deðiþir*** 
		
		printHorzArray(leftPointer, rightPointer);
		
		System.out.println(theArray[leftPointer] + " was swapped for "
				+ theArray[right]);

		return leftPointer;

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;

		}

	}

	static void printHorzArray(int i, int j) {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print(String.format("| %2s " + " ", theArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			int spacesBeforeFront = 6 * (i + 1) - 5;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("L" + i);

			// Number of spaces to put before the R

			int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("R" + j);

			System.out.println("\n");

		}

	}

}
/*
[38, 52, 54, 11, 26, 48, 19, 36, 40, 21]

Left value in new (sub)array 38
Value in right 21 is made the pivot
left = 0 right= 9 pivot= 21 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 38  | 52  | 54  | 11  | 26  | 48  | 19  | 36  | 40  | 21  |
-------------------------------------------------------------
 L0                                                 R9

38 in index 0 is bigger than the pivot value 21
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 38  | 52  | 54  | 11  | 26  | 48  | 19  | 36  | 40  | 21  |
-------------------------------------------------------------
 L0                                  R6

19 in index 6 is smaller than the pivot value 21
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 52  | 54  | 11  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
 L0                                  R6

19 was swapped for 38
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 52  | 54  | 11  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
       L1                            R6

52 in index 1 is bigger than the pivot value 21
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 52  | 54  | 11  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
       L1             R3

11 in index 3 is smaller than the pivot value 21
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 54  | 52  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
       L1             R3

11 was swapped for 52
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 54  | 52  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
             L2       R3

54 in index 2 is bigger than the pivot value 21
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 54  | 52  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
             L2R1

11 in index 1 is smaller than the pivot value 21
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 54  | 52  | 26  | 48  | 38  | 36  | 40  | 21  |
-------------------------------------------------------------
             L2R1

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
             L2R1

21 was swapped for 54

Left value in new (sub)array 19
Value in right 11 is made the pivot
left = 0 right= 1 pivot= 11 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
 L0         R1

19 in index 0 is bigger than the pivot value 11
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
 L0    R0

19 in index 0 is smaller than the pivot value 11
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 19  | 11  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
 L0    R0

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
 L0    R0

11 was swapped for 19

Left value in new (sub)array 52
Value in right 54 is made the pivot
left = 3 right= 9 pivot= 54 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
                                                       L9R9

54 in index 9 is bigger than the pivot value 54
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
                                                       L9R8

40 in index 8 is smaller than the pivot value 54
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
                                                       L9R8

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
                                                       L9R8

54 was swapped for 54

Left value in new (sub)array 52
Value in right 40 is made the pivot
left = 3 right= 8 pivot= 40 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
                   L3                          R8

52 in index 3 is bigger than the pivot value 40
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 52  | 26  | 48  | 38  | 36  | 40  | 54  |
-------------------------------------------------------------
                   L3                     R7

36 in index 7 is smaller than the pivot value 40
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 48  | 38  | 52  | 40  | 54  |
-------------------------------------------------------------
                   L3                     R7

36 was swapped for 52
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 48  | 38  | 52  | 40  | 54  |
-------------------------------------------------------------
                               L5         R7

48 in index 5 is bigger than the pivot value 40
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 48  | 38  | 52  | 40  | 54  |
-------------------------------------------------------------
                               L5    R6

38 in index 6 is smaller than the pivot value 40
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 48  | 52  | 40  | 54  |
-------------------------------------------------------------
                               L5    R6

38 was swapped for 48
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 48  | 52  | 40  | 54  |
-------------------------------------------------------------
                                     L6R6

48 in index 6 is bigger than the pivot value 40
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 48  | 52  | 40  | 54  |
-------------------------------------------------------------
                                     L6R5

38 in index 5 is smaller than the pivot value 40
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 48  | 52  | 40  | 54  |
-------------------------------------------------------------
                                     L6R5

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                                     L6R5

40 was swapped for 48

Left value in new (sub)array 36
Value in right 38 is made the pivot
left = 3 right= 5 pivot= 38 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                               L5R5

38 in index 5 is bigger than the pivot value 38
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                               L5R4

26 in index 4 is smaller than the pivot value 38
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                               L5R4

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                               L5R4

38 was swapped for 38

Left value in new (sub)array 36
Value in right 26 is made the pivot
left = 3 right= 4 pivot= 26 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                   L3      R4

36 in index 3 is bigger than the pivot value 26
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                   L3R2

21 in index 2 is smaller than the pivot value 26
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 36  | 26  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                   L3R2

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 26  | 36  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                   L3R2

26 was swapped for 36

Left value in new (sub)array 52
Value in right 48 is made the pivot
left = 7 right= 8 pivot= 48 sent to be partitioned
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 26  | 36  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                                           L7  R8

52 in index 7 is bigger than the pivot value 48
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 26  | 36  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                                           L7R6

40 in index 6 is smaller than the pivot value 48
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 26  | 36  | 38  | 40  | 52  | 48  | 54  |
-------------------------------------------------------------
                                           L7R6

left is >= right so start again
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 11  | 19  | 21  | 26  | 36  | 38  | 40  | 48  | 52  | 54  |
-------------------------------------------------------------
                                           L7R6

48 was swapped for 52
[11, 19, 21, 26, 36, 38, 40, 48, 52, 54]
*/