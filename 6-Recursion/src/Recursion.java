public class Recursion {
	
	public static void main(String[] args) {
		
		Recursion recursionTool = new Recursion();
			
		// Demonstrate what a triangular number is
		// Triangular numbers can be visualized as triangles
		// Equals itself plus every number before it to 1
		// TN of 5 = 5+4+3+2+1
		
		recursionTool.calculateSquaresToPrint(10);
		
		System.out.println("\nTriangular Number: " + recursionTool.getTriangularNum(6) + "\n");
		
		System.out.println("GET TRIANGULAR NUMBER"); // **without recursion**
		
		// **with recursion**
		System.out.println("Recursion Triangular Number: " + recursionTool.getTriangularNumR(6));
		
		// **similar to getTriangularNumR() method**
		System.out.println("\nGET FACTORIAL");
		
		System.out.println("Factorial: " + recursionTool.getFactorial(3));
		
	}
	
	// **Calculate triangular number not using recursion**
	
	public int getTriangularNum(int number){
		
		int triangularNumber = 0;

		while(number > 0){
			
			triangularNumber = triangularNumber + number;
			number--;
			
		}
		
		// If number equals 3, you find TN by adding 3+2+1 = 6
		
		return triangularNumber;
		
	}
	
	// Calculate triangular number using recursion
	
	public int getTriangularNumR(int number){
		
		// Every recursive method must have a condition that
		// leads to the method no longer making another method
		// call on itself. This is known as the base case
		
		System.out.println("Method " + number);
		
		if(number == 1){
			
			System.out.println("Returned 1");
			
			return 1;
			
		} else {
			
			int result = number + getTriangularNumR(number - 1);
			
			System.out.print("Return " + result);
			
			System.out.println(" : " + number + " + getFactorial(" + number + " - 1)");
			
			return result;
			
		}
		
	}
	
	// Returns the factorial of a number
	// factorial(3) = 3 * 2 * 1
	
	public int getFactorial(int number){
		
		System.out.println("Method " + number);
		
		if(number == 1){
			
			System.out.println("Return 1");
			
			return 1;
			
		} else {
			
			int result = number * getFactorial(number - 1);
			
			System.out.print("Return " + result);
			
			System.out.println(" : " + number + " * getFactorial(" + number + " - 1)");
			
			return result;
			
		}
		
	}
	
	
	// USED TO DEMONSTRATE TRIANGULAR NUMBERS --------------------
	
	// Draws the number of squares that are passed in horizontally 
	
		public void drawSquares(int howManySquares){
			
			for(int i = 0; i < howManySquares; i++) System.out.print(" --  ");
			
			System.out.println();
				
			for(int i = 0; i < howManySquares; i++) System.out.print("|" + howManySquares + " | ");
			
			System.out.println();
				
			for(int i = 0; i < howManySquares; i++) System.out.print(" --  ");
				
			System.out.println("\n");
			
		}
		
		// Outputs the number of squares to print to represent a triangle
		
		public void calculateSquaresToPrint(int number){
			
			for(int i = 1; i <= number; i++){
				
				for(int j = 1; j < i; j++){
				
					drawSquares(j);
				
				
				}
				
				System.out.println("Triangular Number: " + calcTriangularNum(i));
				
			}
			
		}
		
		public double calcTriangularNum(int number){
			
			return .5 * number * (1 + number); // n*(n+1)/2
			
		}

}
/*
Triangular Number: 1.0
 --  
|1 | 
 --  

Triangular Number: 3.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

Triangular Number: 6.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

Triangular Number: 10.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

 --   --   --   --  
|4 | |4 | |4 | |4 | 
 --   --   --   --  

Triangular Number: 15.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

 --   --   --   --  
|4 | |4 | |4 | |4 | 
 --   --   --   --  

 --   --   --   --   --  
|5 | |5 | |5 | |5 | |5 | 
 --   --   --   --   --  

Triangular Number: 21.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

 --   --   --   --  
|4 | |4 | |4 | |4 | 
 --   --   --   --  

 --   --   --   --   --  
|5 | |5 | |5 | |5 | |5 | 
 --   --   --   --   --  

 --   --   --   --   --   --  
|6 | |6 | |6 | |6 | |6 | |6 | 
 --   --   --   --   --   --  

Triangular Number: 28.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

 --   --   --   --  
|4 | |4 | |4 | |4 | 
 --   --   --   --  

 --   --   --   --   --  
|5 | |5 | |5 | |5 | |5 | 
 --   --   --   --   --  

 --   --   --   --   --   --  
|6 | |6 | |6 | |6 | |6 | |6 | 
 --   --   --   --   --   --  

 --   --   --   --   --   --   --  
|7 | |7 | |7 | |7 | |7 | |7 | |7 | 
 --   --   --   --   --   --   --  

Triangular Number: 36.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

 --   --   --   --  
|4 | |4 | |4 | |4 | 
 --   --   --   --  

 --   --   --   --   --  
|5 | |5 | |5 | |5 | |5 | 
 --   --   --   --   --  

 --   --   --   --   --   --  
|6 | |6 | |6 | |6 | |6 | |6 | 
 --   --   --   --   --   --  

 --   --   --   --   --   --   --  
|7 | |7 | |7 | |7 | |7 | |7 | |7 | 
 --   --   --   --   --   --   --  

 --   --   --   --   --   --   --   --  
|8 | |8 | |8 | |8 | |8 | |8 | |8 | |8 | 
 --   --   --   --   --   --   --   --  

Triangular Number: 45.0
 --  
|1 | 
 --  

 --   --  
|2 | |2 | 
 --   --  

 --   --   --  
|3 | |3 | |3 | 
 --   --   --  

 --   --   --   --  
|4 | |4 | |4 | |4 | 
 --   --   --   --  

 --   --   --   --   --  
|5 | |5 | |5 | |5 | |5 | 
 --   --   --   --   --  

 --   --   --   --   --   --  
|6 | |6 | |6 | |6 | |6 | |6 | 
 --   --   --   --   --   --  

 --   --   --   --   --   --   --  
|7 | |7 | |7 | |7 | |7 | |7 | |7 | 
 --   --   --   --   --   --   --  

 --   --   --   --   --   --   --   --  
|8 | |8 | |8 | |8 | |8 | |8 | |8 | |8 | 
 --   --   --   --   --   --   --   --  

 --   --   --   --   --   --   --   --   --  
|9 | |9 | |9 | |9 | |9 | |9 | |9 | |9 | |9 | 
 --   --   --   --   --   --   --   --   --  

Triangular Number: 55.0

Triangular Number: 6

GET TRIANGULAR NUMBER
Method 6
Method 5
Method 4
Method 3
Method 2
Method 1
Returned 1
Return 3 : 2 + getFactorial(2 - 1)
Return 6 : 3 + getFactorial(3 - 1)
Return 10 : 4 + getFactorial(4 - 1)
Return 15 : 5 + getFactorial(5 - 1)
Return 21 : 6 + getFactorial(6 - 1)
Recursion Triangular Number: 21

GET FACTORIAL
Method 3
Method 2
Method 1
Returned 1
Return 2 : 2 * getFactorial(2 - 1)
Return 6 : 3 * getFactorial(3 - 1)
Factorial: 6
*/