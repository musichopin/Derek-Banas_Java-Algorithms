import java.util.Arrays;

public class ShellSort {

	public void sort() {

		int inner, outer, temp;

		int interval = 1;
		//while (interval <= arraySize / 3){
			// ***!bu while loop infinite loop yap�yor***

			// Define an interval sequence

			interval = interval * 3 + 1;

		// **Keep looping until the interval is 1
		// Then this becomes an insertion sort**
			while (interval > 0) {
	
				// Continue incrementing outer until the end of the array is reached
				for (outer = interval; outer < arraySize; outer++) {
//					***for loop i�inde bu k�s�mdan sonras� insertion sorta benzer
//					(bkz: java sort algorithms exercise);
//					(insertion sortta interval olarak 0 al�nm��t�)***
	
					// Store the value of the array in temp unless it has to be
					// copied to a space occupied by a bigger number closer to the
					// beginning of the array
					temp = theArray[outer];
	
					System.out.println("Copy " + theArray[outer] + " into temp");
	
					// inner is assigned the value of the highest index to check
					// against all values the proceed it. Along the way if a
					// number is greater than temp it will be moved up in the array
	
					inner = outer;
	
					System.out.println("Checking if " + theArray[inner - interval]
							+ " in index " + (inner - interval)
							+ " is bigger than " + temp);
	
					// While there is a number bigger than temp move it further
					// up in the array
	
					while (inner > interval - 1
							&& theArray[inner - interval] >= temp) {
	
						System.out.println("In While, Checking if "
								+ theArray[inner - interval] + " in index "
								+ (inner - interval) + " is bigger than " + temp);
	
						printHorzArray(inner, outer, interval);
	
						// Make room for the smaller temp by moving values in the
						// array
						// up one space if they are greater than temp
	
						theArray[inner] = theArray[inner - interval];
	
						System.out.println(theArray[inner - interval]
								+ " moved to index " + inner);
	
						inner -= interval;
//						*inner de�i�ir (outer ise sabittir)*
	
						System.out.println("inner= " + inner);
	
						printHorzArray(inner, outer, interval);
	
						System.out.println("outer= " + outer);
						System.out.println("temp= " + temp);
						System.out.println("interval= " + interval);
	
					}
	
					// Now that everything has been moved into place put the value
					// stored in temp into the index above the first value smaller
					// than it is
	
					theArray[inner] = temp;
	
					System.out.println(temp + " moved to index " + inner);
	
					printHorzArray(inner, outer, interval);
	
				}
	
				// Once we get here we have interval sorted our array
				// so we decrement interval and go again
	
				interval = (interval - 1) / 3;
			}
		
	//	}

	}

	public static void main(String[] args) {

		ShellSort theSort = new ShellSort(10);

		System.out.println(Arrays.toString(theSort.theArray));

		theSort.sort();

		System.out.println(Arrays.toString(theSort.theArray));

	}

	private int[] theArray;

	private int arraySize;

	ShellSort(int arraySize) {

		this.arraySize = arraySize;

		theArray = new int[arraySize];

		generateRandomArray();

	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;
			// **10 (dahil) ile 60 (dahil de�il) aras�nda value atar**
		}

	}

	public void printHorzArray(int i, int j, int h) {

		if (i == j)
			i = i - h;

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + theArray[n] + " ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			int spacesBeforeFront = 5 * i + 1;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("I");

			// Number of spaces to put before the R

			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("O");

			System.out.println("\n");

		}

	}

}
/*
 [58, 35, 23, 29, 50, 16, 15, 56, 53, 53]
Copy 50 into temp
Checking if 58 in index 0 is bigger than 50
In While, Checking if 58 in index 0 is bigger than 50
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 58 | 35 | 23 | 29 | 50 | 16 | 15 | 56 | 53 | 53 |
---------------------------------------------------
 I                   O

58 moved to index 4
inner= 0
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 58 | 35 | 23 | 29 | 58 | 16 | 15 | 56 | 53 | 53 |
---------------------------------------------------
 I                   O

outer= 4
temp= 50
interval= 4
50 moved to index 0
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 35 | 23 | 29 | 58 | 16 | 15 | 56 | 53 | 53 |
---------------------------------------------------
 I                   O

Copy 16 into temp
Checking if 35 in index 1 is bigger than 16
In While, Checking if 35 in index 1 is bigger than 16
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 35 | 23 | 29 | 58 | 16 | 15 | 56 | 53 | 53 |
---------------------------------------------------
      I                   O

35 moved to index 5
inner= 1
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 35 | 23 | 29 | 58 | 35 | 15 | 56 | 53 | 53 |
---------------------------------------------------
      I                   O

outer= 5
temp= 16
interval= 4
16 moved to index 1
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 23 | 29 | 58 | 35 | 15 | 56 | 53 | 53 |
---------------------------------------------------
      I                   O

Copy 15 into temp
Checking if 23 in index 2 is bigger than 15
In While, Checking if 23 in index 2 is bigger than 15
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 23 | 29 | 58 | 35 | 15 | 56 | 53 | 53 |
---------------------------------------------------
           I                   O

23 moved to index 6
inner= 2
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 23 | 29 | 58 | 35 | 23 | 56 | 53 | 53 |
---------------------------------------------------
           I                   O

outer= 6
temp= 15
interval= 4
15 moved to index 2
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 58 | 35 | 23 | 56 | 53 | 53 |
---------------------------------------------------
           I                   O

Copy 56 into temp
Checking if 29 in index 3 is bigger than 56
56 moved to index 7
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 58 | 35 | 23 | 56 | 53 | 53 |
---------------------------------------------------
                I                   O

Copy 53 into temp
Checking if 58 in index 4 is bigger than 53
In While, Checking if 58 in index 4 is bigger than 53
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 58 | 35 | 23 | 56 | 53 | 53 |
---------------------------------------------------
                     I                   O

58 moved to index 8
inner= 4
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 58 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                     I                   O

outer= 8
temp= 53
interval= 4
53 moved to index 4
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                     I                   O

Copy 53 into temp
Checking if 35 in index 5 is bigger than 53
53 moved to index 9
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                          I                   O

Copy 16 into temp
Checking if 50 in index 0 is bigger than 16
In While, Checking if 50 in index 0 is bigger than 16
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 16 | 15 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
 I    O

50 moved to index 1
inner= 0
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 50 | 50 | 15 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
 I    O

outer= 1
temp= 16
interval= 1
16 moved to index 0
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 16 | 50 | 15 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
 I    O

Copy 15 into temp
Checking if 50 in index 1 is bigger than 15
In While, Checking if 50 in index 1 is bigger than 15
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 16 | 50 | 15 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
      I    O

50 moved to index 2
inner= 1
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 16 | 50 | 50 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
      I    O

outer= 2
temp= 15
interval= 1
In While, Checking if 16 in index 0 is bigger than 15
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 16 | 50 | 50 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
      I    O

16 moved to index 1
inner= 0
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 16 | 16 | 50 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
 I         O

outer= 2
temp= 15
interval= 1
15 moved to index 0
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 50 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
 I         O

Copy 29 into temp
Checking if 50 in index 2 is bigger than 29
In While, Checking if 50 in index 2 is bigger than 29
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 50 | 29 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
           I    O

50 moved to index 3
inner= 2
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 50 | 50 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
           I    O

outer= 3
temp= 29
interval= 1
29 moved to index 2
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 50 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
           I    O

Copy 53 into temp
Checking if 50 in index 3 is bigger than 53
53 moved to index 4
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 50 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                I    O

Copy 35 into temp
Checking if 53 in index 4 is bigger than 35
In While, Checking if 53 in index 4 is bigger than 35
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 50 | 53 | 35 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                     I    O

53 moved to index 5
inner= 4
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 50 | 53 | 53 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                     I    O

outer= 5
temp= 35
interval= 1
In While, Checking if 50 in index 3 is bigger than 35
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 50 | 53 | 53 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                     I    O

50 moved to index 4
inner= 3
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 50 | 50 | 53 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                I         O

outer= 5
temp= 35
interval= 1
35 moved to index 3
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 50 | 53 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                I         O

Copy 23 into temp
Checking if 53 in index 5 is bigger than 23
In While, Checking if 53 in index 5 is bigger than 23
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 50 | 53 | 23 | 56 | 58 | 53 |
---------------------------------------------------
                          I    O

53 moved to index 6
inner= 5
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 50 | 53 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                          I    O

outer= 6
temp= 23
interval= 1
In While, Checking if 50 in index 4 is bigger than 23
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 50 | 53 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                          I    O

50 moved to index 5
inner= 4
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 50 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                     I         O

outer= 6
temp= 23
interval= 1
In While, Checking if 35 in index 3 is bigger than 23
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 50 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                     I         O

35 moved to index 4
inner= 3
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                I              O

outer= 6
temp= 23
interval= 1
In While, Checking if 29 in index 2 is bigger than 23
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 35 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                I              O

29 moved to index 3
inner= 2
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 29 | 29 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
           I                   O

outer= 6
temp= 23
interval= 1
23 moved to index 2
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
           I                   O

Copy 56 into temp
Checking if 53 in index 6 is bigger than 56
56 moved to index 7
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                               I    O

Copy 58 into temp
Checking if 56 in index 7 is bigger than 58
58 moved to index 8
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                                    I    O

Copy 53 into temp
Checking if 58 in index 8 is bigger than 53
In While, Checking if 58 in index 8 is bigger than 53
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 58 | 53 |
---------------------------------------------------
                                         I    O

58 moved to index 9
inner= 8
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 58 | 58 |
---------------------------------------------------
                                         I    O

outer= 9
temp= 53
interval= 1
In While, Checking if 56 in index 7 is bigger than 53
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 58 | 58 |
---------------------------------------------------
                                         I    O

56 moved to index 8
inner= 7
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 56 | 58 |
---------------------------------------------------
                                    I         O

outer= 9
temp= 53
interval= 1
In While, Checking if 53 in index 6 is bigger than 53
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 56 | 56 | 58 |
---------------------------------------------------
                                    I         O

53 moved to index 7
inner= 6
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 53 | 56 | 58 |
---------------------------------------------------
                               I              O

outer= 9
temp= 53
interval= 1
53 moved to index 6
---------------------------------------------------
| 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
---------------------------------------------------
| 15 | 16 | 23 | 29 | 35 | 50 | 53 | 53 | 56 | 58 |
---------------------------------------------------
                               I              O

[15, 16, 23, 29, 35, 50, 53, 53, 56, 58] 
 */
