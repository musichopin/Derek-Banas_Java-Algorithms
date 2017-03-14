import java.util.Arrays;

//**If we think of a Hash Table as an array
//then a hash function is used to generate
//a unique key for every item in the array.
//The position the item goes in is known
//as the slot. Hashing doesn't work very well
//in situations in which duplicate data
//is stored. Also it isn't good for searching
//for anything except a specific key. 
//However a Hash Table is a data structure that 
//offers fast insertion and searching capabilities.**

public class HashFunction {

	String[] theArray;
	int arraySize;
	int itemsInArray = 0;

	public static void main(String[] args) {

		HashFunction theFunc = new HashFunction(30);

		// 1. Simplest Hash Function

		// String[] elementsToAdd = { "1", "5", "17", "21", "26" };

		// theFunc.hashFunction1(elementsToAdd, theFunc.theArray);

		
		// 2. Mod Hash Function
		// ***This contains exactly 30 items to show how collisions
		// will work (collision olmasýnda array size kadar item yerleþecek olmasýndan 
		// ziyade (no%30 sonrasýnda) ayný nolu/indeksli itemlarýn yerleþecek olmasý rol oynadý)
		// because of collision arraysize should be at least twice as big as items to be inserted***
		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };

		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
		// ***theFunc.theArray'in pass edilmesine gerek yok***

		// Locate the value 660 in the Hash Table

		theFunc.findKey("660");

		theFunc.displayTheHash();

	}

	// **Simple Hash Function that puts values in the same
	// index that matches their value**
	public void hashFunction1(String[] stringsForArray, String[] theArray) {
		
		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			theArray[Integer.parseInt(newElementVal)] = newElementVal;

		}

	}

	// Now let's say we have to hold values between 0 & 999
	// but we never plan to have more than 15 values in all.
	// It wouldn't make sense to make a 1000 item array, so
	// what can we do?

	// ***One way to fit these numbers into a 30 item array is
	// to use the mod function. All you do is take the modulus
	// of the value versus the array size

	// The goal is to make the array big enough to avoid
	// collisions, but not so big that we waste memory***
	public void hashFunction2(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			// Create an index to store the value in by taking
			// the modulus

			int arrayIndex = Integer.parseInt(newElementVal) % arraySize;

			System.out.println("Modulus Index= " + arrayIndex + " for value "
					+ newElementVal);

			// **Cycle through the array until we find an empty space**
			while (theArray[arrayIndex] != "-1") {

				++arrayIndex;

				System.out.println("Collision Try " + arrayIndex + " Instead");

				// **If we get to the end of the array go back to index 0**
				arrayIndex %= arraySize;

			}

			theArray[arrayIndex] = newElementVal;

		}

	}

	// Returns the value stored in the Hash Table

	public String findKey(String value) {

		// *Find the keys original hash key*
		int arrayIndexHash = Integer.parseInt(value) % arraySize;

		while (theArray[arrayIndexHash] != "-1") {
			
			for(int i = 0; i < arraySize; i++) {
//				**value'nun array'de olmamasýna karþýlýk for loop kullanýldý (ben kullandým)**
				
	//			**önceki valuelar bu indekse yerleþmiþ olabileceðinden dolayý check eder**
				if (theArray[arrayIndexHash] == value) {
	
					// Found the key so return it
					System.out.println(value + " was found in index "
							+ arrayIndexHash);
					
	//				**exits the method and the loop**
					return theArray[arrayIndexHash];
	
				}
	
				// Look in the next index
	
				++arrayIndexHash;
	
				// If we get to the end of the array go back to index 0
	
				arrayIndexHash %= arraySize;
			}
			
			System.out.println("value not found"); 
			// Couldn't locate the key
			return null;
			
		}
		
		System.out.println("value not found"); 
		// Couldn't locate the key
		return null;

	}

	HashFunction(int size) {

		arraySize = size;

		theArray = new String[size];

		Arrays.fill(theArray, "-1");

	}

	public void displayTheHash() {

		int increment = 0;

		for (int m = 0; m < 3; m++) {

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

				if (theArray[n].equals("-1"))
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
Modulus Index= 13 for value 100
Modulus Index= 17 for value 510
Modulus Index= 25 for value 170
Modulus Index= 11 for value 214
Modulus Index= 7 for value 268
Modulus Index= 21 for value 398
Modulus Index= 3 for value 235
Modulus Index= 19 for value 802
Modulus Index= 1 for value 900
Modulus Index= 27 for value 723
Modulus Index= 3 for value 699
Collision Try 4 Instead
Modulus Index= 1 for value 1
Collision Try 2 Instead
Modulus Index= 16 for value 16
Modulus Index= 13 for value 999
Collision Try 14 Instead
Modulus Index= 20 for value 890
Modulus Index= 0 for value 725
Modulus Index= 12 for value 998
Modulus Index= 21 for value 978
Collision Try 22 Instead
Modulus Index= 2 for value 988
Collision Try 3 Instead
Collision Try 4 Instead
Collision Try 5 Instead
Modulus Index= 4 for value 990
Collision Try 5 Instead
Collision Try 6 Instead
Modulus Index= 3 for value 989
Collision Try 4 Instead
Collision Try 5 Instead
Collision Try 6 Instead
Collision Try 7 Instead
Collision Try 8 Instead
Modulus Index= 27 for value 984
Collision Try 28 Instead
Modulus Index= 1 for value 320
Collision Try 2 Instead
Collision Try 3 Instead
Collision Try 4 Instead
Collision Try 5 Instead
Collision Try 6 Instead
Collision Try 7 Instead
Collision Try 8 Instead
Collision Try 9 Instead
Modulus Index= 2 for value 321
Collision Try 3 Instead
Collision Try 4 Instead
Collision Try 5 Instead
Collision Try 6 Instead
Collision Try 7 Instead
Collision Try 8 Instead
Collision Try 9 Instead
Collision Try 10 Instead
Modulus Index= 23 for value 400
Modulus Index= 9 for value 415
Collision Try 10 Instead
Collision Try 11 Instead
Collision Try 12 Instead
Collision Try 13 Instead
Collision Try 14 Instead
Collision Try 15 Instead
Modulus Index= 15 for value 450
Collision Try 16 Instead
Collision Try 17 Instead
Collision Try 18 Instead
Modulus Index= 21 for value 50
Collision Try 22 Instead
Collision Try 23 Instead
Collision Try 24 Instead
Modulus Index= 22 for value 660
Collision Try 23 Instead
Collision Try 24 Instead
Collision Try 25 Instead
Collision Try 26 Instead
Modulus Index= 15 for value 624
Collision Try 16 Instead
Collision Try 17 Instead
Collision Try 18 Instead
Collision Try 19 Instead
Collision Try 20 Instead
Collision Try 21 Instead
Collision Try 22 Instead
Collision Try 23 Instead
Collision Try 24 Instead
Collision Try 25 Instead
Collision Try 26 Instead
Collision Try 27 Instead
Collision Try 28 Instead
Collision Try 29 Instead
660 was found in index 26
-----------------------------------------------------------------------
|   0  |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |
-----------------------------------------------------------------------
| 725  | 900  |   1  | 235  | 699  | 988  | 990  | 268  | 989  | 320  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  10  |  11  |  12  |  13  |  14  |  15  |  16  |  17  |  18  |  19  |
-----------------------------------------------------------------------
| 321  | 214  | 998  | 100  | 999  | 415  |  16  | 510  | 450  | 802  |
-----------------------------------------------------------------------
-----------------------------------------------------------------------
|  20  |  21  |  22  |  23  |  24  |  25  |  26  |  27  |  28  |  29  |
-----------------------------------------------------------------------
| 890  | 398  | 978  | 400  |  50  | 170  | 660  | 723  | 984  | 624  |
-----------------------------------------------------------------------
*/