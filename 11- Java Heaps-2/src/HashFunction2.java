import java.util.ArrayList;
import java.util.Arrays;

public class HashFunction2 {

	String[] theArray;
	int arraySize; 
	int itemsInArray = 0; // not used

	public static void main(String[] args) {
		HashFunction2 theFunc = new HashFunction2(31);

		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };

		// Demonstrate how data normally follows patterns and how
		// a non-prime sized array can cause havoc
//		***array size'ýn prime number olmasýndan ziyade eklenecek array 
//		elemanlarýna göre bölünemez olmasý önemli (?)***
		String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
				"210", "240", "270", "300", "330", "360", "390", "420", "450",
				"480", "510", "540", "570", "600", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };

		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

		// theFunc.modThirty();
		
//		part 1
		theFunc.increaseArraySize(60);

		theFunc.displayTheHash();
		
		
//		part 2
		theFunc.fillArrayWithNeg1(); // *resets the values of array to -1*
		
		theFunc.doubleHashFunc(elementsToAdd2, theFunc.theArray);
		
		theFunc.displayTheHash();

//		part 3
		theFunc.findKeyDblHashed("990");

	}

	// Outputs the matches that would put an item in
	// index 0 if arraySize was 31

	public void modThirty() {

		for (int i = 1; i < 999; i++) {

			if (i % 30 == 0) {

				System.out.println(i);

			}

		}

	}

	public boolean isPrime(int number) {

		// Eliminate the need to check versus even numbers

		if (number != 2 && number % 2 == 0)
			return false;

		// Check against all odd numbers

		for (int i = 3; i * i <= number; i += 2) {

			if (number % i == 0)
				return false;

		}

		// If we make it here we know it is odd

		return true;

	}

	// Receives a number and returns the next prime
	// number that follows
	public int getNextPrime(int minNumberToCheck) {
		
//		**infinite loop (return sta ile kýrýldý)**
		for (int i = minNumberToCheck; true; i++) {

			if (isPrime(i))
				return i;
//				**exits from the method and the loop**
		}

	}

	// **Increase array size to a prime number**
	public void increaseArraySize(int minArraySize) {

		// **Get a prime number bigger than the array requested**
		int newArraySize = getNextPrime(minArraySize);

		// **Move the array into a bigger array with the
		// larger prime size**
		moveOldArray(newArraySize);

	}

	public void moveOldArray(int newArraySize) {

		// **Create an array that has all of the values of
		// theArray, but no empty spaces**
		String[] cleanArray = removeEmptySpacesInArray(theArray);
//		***theArrayin kendi deðiþmez, sadece boþluk olmayacak biçimde 
//		liste aktarýlýr ve list arraye çevrilerek return edilir 
//		(theArray'in subarrayi yaratýlýr diye düþünülebilir)
//		liste çevrim sýrasýnda array elemanlarýnýn yerleri deðiþebilir*** 
		
		// Increase the size for theArray
//		***ilk baþta yarattýðýmýz (ve içerisine sayýlarý eklediðimiz) 
//		array override ediliyor***
		theArray = new String[newArraySize]; // *theArray override ediliyor*

		arraySize = newArraySize; // *arraySize override ediliyor*

		// Fill theArray with -1 in every space
		fillArrayWithNeg1(); // *bu kýsým da constructorda yapýlmýþtý ilk baþta*

		// Send the values previously in theArray into
		// the new larger array
		hashFunction2(cleanArray, theArray);

	}

	// Will remove all empty spaces in an array

	public String[] removeEmptySpacesInArray(String[] arrayToClean) {

//		**list created so that we can dynamically add values to it**
		ArrayList<String> stringList = new ArrayList<String>();

		// **Cycle through the array and if a space doesn't
		// contain -1, or isn't empty add it to the ArrayList**
		for (String theString : arrayToClean)
			if (!theString.equals("-1") && !theString.equals(""))
				stringList.add(theString);

		return stringList.toArray(new String[stringList.size()]);
//		**converts list to array before returning**
	}

//	**we are trying to prevent cluster which occurs due to collisions**
	public void doubleHashFunc(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			// Store value in array index

			String newElementVal = stringsForArray[n];

			// Create an index to store the value in by taking
			// the modulus

			int arrayIndex = Integer.parseInt(newElementVal) % arraySize;

			// *Get the distance to skip down in the array
			// after a collision occurs. We are doing this
			// rather than just going to the next index to
			// avoid creating clusters* 
//			***arrayIndex'in deðil newElementVal'ýn modunun alýnmasýna dikkat.
//			7 yerine baþka sayý da verilebilirdi***
			int stepDistance = 7 - (Integer.parseInt(newElementVal) % 7);
			// **stepDistance, loop dýþýnda kalmýþ**

			System.out.println("step distance: " + stepDistance);

			/*
			 * System.out.println("Modulus Index= " + arrayIndex + " for value "
			 * + newElementVal);
			 */

			// Cycle through the array until we find an empty space

			while (theArray[arrayIndex] != "-1") {

				arrayIndex += stepDistance;

				 System.out.println("Collision Try " + arrayIndex + " Instead");

				// If we get to the end of the array go back to index 0

				arrayIndex %= arraySize;

			}

			theArray[arrayIndex] = newElementVal;

		}

	}

	
	// Returns the value stored in the Double Hashed Hash Table
	public String findKeyDblHashed(String value) {

		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(value) % arraySize;

		// Find the keys original step distance
//***doubleHashFunc'da da stepDistance 7'nin moduydu***
		int stepDistance = 7 - (Integer.parseInt(value) % 7);

		while (theArray[arrayIndexHash] != "-1") {

			if (theArray[arrayIndexHash] == value) {

				// Found the key so return it
				System.out.println(value + " was found in index "
						+ arrayIndexHash);

				return theArray[arrayIndexHash];

			}

			// Look in the next index

			arrayIndexHash += stepDistance;

			// If we get to the end of the array go back to index 0

			arrayIndexHash %= arraySize;

		}

		// Couldn't locate the key

		return null;

	}

	public void hashFunction2(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			// Create an index to store the value in by taking
			// the modulus

			int arrayIndex = Integer.parseInt(newElementVal) % arraySize;

			/*
			 * 
			 * System.out.println("Modulus Index= " + arrayIndex + " for value "
			 * + newElementVal);
			 */

			// Cycle through the array until we find an empty space

			while (theArray[arrayIndex] != "-1") {

				++arrayIndex;

				System.out.println("Collision Try " + arrayIndex + " Instead");

				// If we get to the end of the array go back to index 0

				arrayIndex %= arraySize;

			}

			theArray[arrayIndex] = newElementVal;

		}

	}

	// Returns the value stored in the Hash Table
// **!not used**
	public String findKey(String key) {

		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % arraySize;

		while (theArray[arrayIndexHash] != "-1") {

			if (theArray[arrayIndexHash] == key) {

				// Found the key so return it
				System.out.println(key + " was found in index "
						+ arrayIndexHash);

				return theArray[arrayIndexHash];

			}

			// Look in the next index

			++arrayIndexHash;

			// If we get to the end of the array go back to index 0

			arrayIndexHash %= arraySize;

		}

		// Couldn't locate the key

		return null;

	}

	HashFunction2(int size) {

		arraySize = size;

		theArray = new String[size];

		// Fill Array with -1 for each empty space

		fillArrayWithNeg1();

	}

	public void fillArrayWithNeg1() {

		Arrays.fill(theArray, "-1");

	}

	public void displayTheHash() {

		int increment = 0;

		int numberOfRows = (arraySize / 10) + 1;

		for (int m = 0; m < numberOfRows; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (n >= arraySize)
					System.out.print("|      ");

				else if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}

	}

}
/*
Collision Try 2 Instead
Collision Try 8 Instead
Collision Try 18 Instead
Collision Try 19 Instead
Collision Try 28 Instead
Collision Try 29 Instead
Collision Try 30 Instead
Collision Try 29 Instead
Collision Try 30 Instead
Collision Try 31 Instead
Collision Try 11 Instead
Collision Try 12 Instead
Collision Try 13 Instead
Collision Try 29 Instead
Collision Try 30 Instead
Collision Try 31 Instead
Collision Try 1 Instead
Collision Try 2 Instead
Collision Try 3 Instead
Collision Try 13 Instead
Collision Try 14 Instead
Collision Try 15 Instead
Collision Try 16 Instead
Collision Try 17 Instead
Collision Try 18 Instead
Collision Try 19 Instead
Collision Try 20 Instead
Collision Try 21 Instead
Collision Try 17 Instead
Collision Try 18 Instead
Collision Try 19 Instead
Collision Try 20 Instead
Collision Try 21 Instead
Collision Try 22 Instead
Collision Try 23 Instead
Collision Try 24 Instead
Collision Try 20 Instead
Collision Try 21 Instead
Collision Try 22 Instead
Collision Try 23 Instead
Collision Try 24 Instead
Collision Try 25 Instead
Collision Try 23 Instead
Collision Try 24 Instead
Collision Try 17 Instead
Collision Try 53 Instead
Collision Try 25 Instead
Collision Try 24 Instead
Collision Try 25 Instead
Collision Try 26 Instead
Collision Try 51 Instead
Collision Try 15 Instead
Collision Try 16 Instead
Collision Try 17 Instead
Collision Try 18 Instead
-----------------------------------------------------------------------
|   0  |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |
-----------------------------------------------------------------------
|      |   1  | 978  |      |      |      |      |      | 984  | 802  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  10  |  11  |  12  |  13  |  14  |  15  |  16  |  17  |  18  |  19  |
-----------------------------------------------------------------------
|      |      | 988  | 989  | 624  | 320  | 321  |  16  | 990  |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  20  |  21  |  22  |  23  |  24  |  25  |  26  |  27  |  28  |  29  |
-----------------------------------------------------------------------
|      |      | 998  | 999  | 510  | 268  | 450  |      | 699  |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  30  |  31  |  32  |  33  |  34  |  35  |  36  |  37  |  38  |  39  |
-----------------------------------------------------------------------
|      | 214  | 398  |      | 400  |      | 890  |      |      | 100  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  40  |  41  |  42  |  43  |  44  |  45  |  46  |  47  |  48  |  49  |
-----------------------------------------------------------------------
|      |      |      |      |      |      | 900  |      | 170  | 415  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  50  |  51  |  52  |  53  |  54  |  55  |  56  |  57  |  58  |  59  |
-----------------------------------------------------------------------
| 660  |  50  | 723  | 235  | 725  |      |      |      |      |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  60  |  61  |  62  |  63  |  64  |  65  |  66  |  67  |  68  |  69  |
-----------------------------------------------------------------------
|      |      |      |      |      |      |      |      |      |      |
-----------------------------------------------------------------------
step distance: 5
step distance: 1
step distance: 5
step distance: 3
step distance: 5
step distance: 1
step distance: 3
step distance: 3
step distance: 3
step distance: 5
Collision Try 57 Instead
step distance: 1
step distance: 6
step distance: 5
step distance: 2
step distance: 6
step distance: 3
step distance: 3
Collision Try 25 Instead
step distance: 2
step distance: 6
step distance: 4
step distance: 5
step distance: 3
step distance: 2
step distance: 1
Collision Try 17 Instead
step distance: 6
step distance: 5
step distance: 5
Collision Try 28 Instead
Collision Try 33 Instead
step distance: 6
step distance: 5
Collision Try 55 Instead
step distance: 6
Collision Try 20 Instead
-----------------------------------------------------------------------
|   0  |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |
-----------------------------------------------------------------------
|      |   1  | 978  |      |      |      |      |      | 984  | 802  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  10  |  11  |  12  |  13  |  14  |  15  |  16  |  17  |  18  |  19  |
-----------------------------------------------------------------------
|      |      | 988  | 989  | 990  | 320  |  16  | 321  |      |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  20  |  21  |  22  |  23  |  24  |  25  |  26  |  27  |  28  |  29  |
-----------------------------------------------------------------------
| 624  |      | 510  | 999  | 268  | 998  |      |      | 699  |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  30  |  31  |  32  |  33  |  34  |  35  |  36  |  37  |  38  |  39  |
-----------------------------------------------------------------------
|      | 214  | 398  | 450  | 400  |      | 890  |      |      | 100  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  40  |  41  |  42  |  43  |  44  |  45  |  46  |  47  |  48  |  49  |
-----------------------------------------------------------------------
|      |      |      |      |      |      | 900  |      | 170  | 415  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  50  |  51  |  52  |  53  |  54  |  55  |  56  |  57  |  58  |  59  |
-----------------------------------------------------------------------
|  50  |      | 235  |      | 725  | 660  |      | 723  |      |      |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  60  |  61  |  62  |  63  |  64  |  65  |  66  |  67  |  68  |  69  |
-----------------------------------------------------------------------
|      |      |      |      |      |      |      |      |      |      |
-----------------------------------------------------------------------
990 was found in index 14
 */