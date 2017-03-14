import java.util.Arrays;

// **When we partition data we are dividing it into
// two parts. All items with data above a defined value
// will go in one part and the rest will go in the other**

// The value that defines in which group data will go
// is known as the pivot value

public class Partitioning {

	private static int[] theArray;
//	***statik olmasý saçma, zira farklý arrayler yaratsak da 
//	sadece son yarattýðýmýz arrayin sonucuna ulaþabiliyoruz***

	private static int arraySize;

	public static void main(String[] args) {

		Partitioning partitionArray = new Partitioning(10);

		partitionArray.generateRandomArray();

		System.out.println(Arrays.toString(Partitioning.theArray));

		// Every item smaller than 35 will be on the left and
		// everything bigger will be on the right

		partitionArray.partitionArray(35); 
// ***35, rastgele oluþturduðumuz arraydeki medium item
//	ve partitioning yaparak array içindeki itemlarý 
//	büyüklüklerine göre saða ve sola ayýrmamýza yarýyor 
//	(eþit daðýlmak, yani 5 küçük solda, 5 büyük eþit saðda olmak zorunda deðil).
//	sað ve sol taraftaki sýralamayý saðlayan ise quick sort oluyor***

		System.out.println(Arrays.toString(Partitioning.theArray));

	}

	public void partitionArray(int pivot) {

		// **If leftPointer finds an item that is greater
		// than pivot it stops and waits for the rightPointer
		// to find a value less than pivot. Then the items
		// are switched**

		// **Starts at the left side of array before index 0**
		int leftPointer = -1;

		// **Starts at the right side of the array after the last index**
		int rightPointer = arraySize;

		while (true) {

			// **Cycle through array until the end is reached
			// or an item bigger than pivot is found. Then
			// wait for rightPointer to finish cycling**

			// **arraySize-1, denmesinin sebebi leftPointer'ýn -1'den baþlamasý**
			while (leftPointer < (arraySize - 1) // **alt: while (++leftPointer < (arraySize ) && theArray[leftPointer] < pivot) ;**
					&& theArray[++leftPointer] < pivot)
				; // **";" yerine "{}" denebilirdi**
//			***amacýmýz while loop'daki þart saðlandýðý müddetçe aksiyon gerçekleþtirmemek.
//			normalde code block'ta olan deðiþim ise condition'da "++leftPointer" denerek saðlanmýþ.
//			ki bu yüzden leftPointer -1'de baþlamýþtý (bu durum loopun en saðlýklý ve hýzlý hali)***

			printHorzArray(leftPointer, rightPointer);

			System.out.println(theArray[leftPointer] + " in index "
					+ leftPointer + " is bigger than (or equal to) the pivot value " + pivot);

			// Cycle through array until the beginning is reached
			// or an item smaller than pivot is found.

			while (rightPointer > 0 && theArray[--rightPointer] > pivot) 
				;
			// **alt: while (--rightPointer <= 0 && theArray[rightPointer] > pivot) ;**

			printHorzArray(leftPointer, rightPointer);

			System.out.println(theArray[rightPointer] + " in index "
					+ rightPointer + " is smaller than (or equal to) the pivot value "
					+ pivot);

			// When the 2 pointers meet at the middle break
			// out of the while loop

			if (leftPointer >= rightPointer) {
				
				printHorzArray(leftPointer, rightPointer); // **last graph**
				
				System.out.println("Partitioning ended");
				
				break;
				
			} else {

				// Swap the values in the pointers

				swapValues(leftPointer, rightPointer);
				
				printHorzArray(leftPointer, rightPointer); // **corresponding graph**
				
				System.out.println(theArray[leftPointer] + " was swapped for "
						+ theArray[rightPointer]);

			}

		}

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

	Partitioning(int newArraySize) {

		arraySize = newArraySize;

		theArray = new int[arraySize];

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

			int spacesBeforeFront = 5 * i + 1;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("L");

			// Number of spaces to put before the R

			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("H");

			System.out.println("\n");

		}

	}

}
/*
[22, 29, 13, 22, 14, 24, 14, 53, 18, 15]
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 22  | 29  | 13  | 22  | 14  | 24  | 14  | 53  | 18  | 15  |
-------------------------------------------------------------
                                    L              H

53 in index 7 is bigger than (or equal to) the pivot value 35
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 22  | 29  | 13  | 22  | 14  | 24  | 14  | 53  | 18  | 15  |
-------------------------------------------------------------
                                    L         H

15 in index 9 is smaller than (or equal to) the pivot value 35
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 22  | 29  | 13  | 22  | 14  | 24  | 14  | 15  | 18  | 53  |
-------------------------------------------------------------
                                    L         H

15 was swapped for 53
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 22  | 29  | 13  | 22  | 14  | 24  | 14  | 15  | 18  | 53  |
-------------------------------------------------------------
                                              LH

53 in index 9 is bigger than (or equal to) the pivot value 35
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 22  | 29  | 13  | 22  | 14  | 24  | 14  | 15  | 18  | 53  |
-------------------------------------------------------------
                                              LH

18 in index 8 is smaller than (or equal to) the pivot value 35
-------------------------------------------------------------
|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
-------------------------------------------------------------
| 22  | 29  | 13  | 22  | 14  | 24  | 14  | 15  | 18  | 53  |
-------------------------------------------------------------
                                              LH

Partitioning ended
[22, 29, 13, 22, 14, 24, 14, 15, 18, 53]
*/