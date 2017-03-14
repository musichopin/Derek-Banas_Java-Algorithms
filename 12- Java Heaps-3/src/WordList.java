import java.util.Scanner;

class HashFunction3 {

	WordList[] theArray;
	int arraySize;
	int itemsInArray = 0; // not used

	public String[][] elementsToAdd = {
			{ "ace", "Very good" },
			{ "act", "Take action" },
			{ "add", "Join (something) to something else" },
			{ "age", "Grow old" },
			{ "ago", "Before the present" },
			{ "aid", "Help, assist, or support" },
			{ "aim", "Point or direct" },
			{ "air", "Invisible gaseous substance" },
			{ "all", "Used to refer to the whole quantity" },
			{ "amp",
					"Unit of measure for the strength of an electrical current" },
			{ "and", "Used to connect words" }, { "ant", "A small insect" },
			{ "any", "Used to refer to one or some of a thing" },
			{ "ape", "A large primate" },
			{ "apt", "Appropriate or suitable in the circumstances" },
			{ "arc", "A part of the circumference of a curve" },
			{ "are", "Unit of measure, equal to 100 square meters" },
			{ "ark", "The ship built by Noah" },
			{ "arm", "Two upper limbs of the human body" },
			{ "art", "Expression or application of human creative skill" },
			{ "ash", "Powdery residue left after the burning" },
			{ "ask", "Say something in order to obtain information" },
			{ "asp", "Small southern European viper" },
			{ "ass", "Hoofed mammal" },
			{ "ate", "To put (food) into the mouth and swallow it" },
			{ "atm", "Unit of pressure" },
			{ "awe", "A feeling of reverential respect" },
			{ "axe", "Edge tool with a heavy bladed head" },
			{ "aye", "An affirmative answer" } 
			
	};

//	***hashes string into a number.
//	md arrayin ilk elemanýný (theword) hash eder***
	public int stringHashFunction(String wordToHash) {

		int hashKeyValue = 0;

		for (int i = 0; i < wordToHash.length(); i++) {

			// **'a' has the character code of 97 so 
			// subtract to make our letters start at 1**
			int charCode = wordToHash.charAt(i) - 96;
//			***wordToHash.charAt(i) olarak print edilseydi stringin karakteri
//			print edilecekti ama int olarak store edildiði için karakterin numara 
//			versionu print edildi (yani a->97, b->98 vs)***

			int hKVTemp = hashKeyValue;

			// Calculate the hash key using the 26 letters plus blank
//			***bizim için önemli olan son hashkeyvalue ve onu loop dýþýnda return etmek.
//			The hashkey is just the indexes where the word objects are stored (each
//			wordlist object index might store multiple word objects)***
			hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize; // formula

			System.out.println("Hash Key Value " + hKVTemp
					+ " * 27 + Character Code " + charCode + " % arraySize "
					+ arraySize + " = " + hashKeyValue);

		}
		System.out.println();

		return hashKeyValue;

	}

	HashFunction3(int size) {

		arraySize = size;

		theArray = new WordList[size];
//		***arrayimiz (önceki 2 örnekteki gibi string deðil) wordList türünde. türü word olan 
//		objectleri türü wordlist olan bu arraye eklemek için insert metodu kullanýlýyor.
//		sonuç olarak 11 elemanlý wordlist arrayine 29 elemanlý word eklenebiliyor***

		// **Fill the array with WordLists
//		instead of "-1" as opposed to previous 2 lessons**
		for (int i = 0; i < arraySize; i++) {
			
//			***theArray, WordList türünde olduðundan ona eklenecek 
//			array elemanlarý da bu türden (veya subclassý) olmalý***
			theArray[i] = new WordList(); // ***arraySize kadar WordList object yaratýlýr***
//			***instead of adding an item to the next index we store a list in each 
//			index of the array (which is called as separate chaining) so instead of 
//			indexes holding singular values they hold lists***

		}

		addTheArray(elementsToAdd);

	}
	
	public void addTheArray(String[][] elementsToAdd) {
		
//		***md array var diye 2 tane for loop kullanmak zorunda deðiliz***
		for (int i = 0; i < elementsToAdd.length; i++) {

			String word = elementsToAdd[i][0];
			String definition = elementsToAdd[i][1];

			// Create the Word with the word name and
			// definition

			Word newWord = new Word(word, definition);

			// Add the Word to theArray

			insert(newWord);

		}

	}

	public void insert(Word newWord) {
		
		String wordToHash = newWord.theWord;
		
		System.out.println(newWord);
		
//		**theWord will be used as a key/index (being number)**
		// Calculate the hashkey for the Word
		int hashKey = stringHashFunction(wordToHash);
		
		// Add the new word to the array and set the key for the word
//		***array size 11 (11 tane object), array elemanlarýnýn insert metoduna  
//		ekelenecek objectler de 29 adet olduðu için bazý hashkey ler ayný oluyor***
		theArray[hashKey].insert(newWord, hashKey);
//		***wordlist classýndan array oluþturduktan sonra bu arrayin her 
//		bir object elemaný wordlist classýný çaðýrýr (array olmadan object yaratýlmasý gibi). 
//		bu örnekte de wordlist classýna ait insert metodu çaðýrýlmýþ***

	}

	public void find(String wordToFind) {

		// Calculate the hash key for the word

		int hashKey = stringHashFunction(wordToFind);

		// NEW

		Word theWord = theArray[hashKey].find(hashKey, wordToFind);
		
		System.out.println(theWord);
		
		System.out.println("first (last added) word in this specific list object = " + theArray[hashKey].firstWord);

	}

	public void displayTheArray() {

		for (int i = 0; i < arraySize; i++) {

			System.out.println("theArray Index " + i);

			theArray[i].displayWordList();

		}

	}

}



class Word {

	public String theWord;
	public String definition;

	public int key;

	// ***Reference to next Word made in the WordList***
	public Word next;

	public Word(String theWord, String definition) {

		this.theWord = theWord;
		this.definition = definition;

	}

	public String toString() {

		return theWord + " : " + definition;

	}

}



public class WordList {
//	***bu class listin uygulanýþýdýr: ayný object içerisindeki (wordlist array elemaný 
//	11 olduðundan wordlist içinde hashkeye göre 11 object oluþuyor) wordler birbirini 
//	refere ederken 11 adet firstWord her bir object içerisindeki ilk wordü refere eder***

	// ***Reference to first Link in list, the last Link added to the LinkedList 
	// (hashkey'e göre 11 adet firstWord olup her biri en son eklenen kelimeyi refere eder)***
	public Word firstWord = null;

	public void insert(Word newWord, int hashKey) {
//		***insert metodundaki amaç Word objectlerin key'ini ve next'ini yaratmak ve 
//		firstWord variable'ýný her bir objectin son eklenen elemanýna atamak***
		
		Word previous = null;
		Word current = firstWord; 

		newWord.key = hashKey; // **number**
		
//		***bu loop hiç yürütülemeyeceðinden gereksiz. zira WordList arrayinin ayný 
//		indexinde (yani ayný objectte) bulunan insert metoduna gönderilen Word 
//		objectlerin keyleri zaten birbiri ile aynýdýr**
		while (current != null && newWord.key > current.key) {

			previous = current;
			current = current.next;

		}
		
//		***yukarýdaki while loopa girmemiþ (her objectteki yeni kelimenin hashi bir  
//		önceki kelimeden büyük olmadýðýndan firstword yeni kelime olur)***
		if (previous == null)
			firstWord = newWord;
		
//		***yukarýdaki while loopa girseydi (bu nedenle firstWord etkilenmezdi)***
		else
			previous.next = newWord;

		newWord.next = current;
//		**list usulü wordleri birbirine baðlar/refere ettirir**
	}

	public void displayWordList() {

		Word current = firstWord;

		while (current != null) {
			
//			**prints the toString method of word object**
			System.out.println(current);
			
			current = current.next;

		}

	}

	public Word find(int hashKey, String wordToFind) {

		Word current = firstWord;

		// Search for key, but stop searching if
		// the hashKey < what we are searching for
		// Because the list is sorted this allows
		// us to avoid searching the whole list
		// ***aslýnda current.key <= hashKey demek gereksiz çünkü
		// zaten current.key hashkey'e eþit olur***
		while (current != null && current.key <= hashKey) {
			
			// NEW

			if (current.theWord.equals(wordToFind))
				return current;

			current = current.next;

		}

		return null;

	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		// **Make an 11 item array whose indexes might hold 
		// multiple words and definitions (of total 29 words and 
		// definitions) through 11 lists**
		HashFunction3 wordHashTable = new HashFunction3(11);

		String wordLookUp = "a";

		// Keep retrieve requests until x is entered
//		**wordLookUp x'e veya X'e eþit olmadýðý müddetçe while loop yürür**
		while (!wordLookUp.equalsIgnoreCase("x")) {
//			**do while loop kullanýlabilirdi**

			System.out.println(": ");

			wordLookUp = input.nextLine();

			// Look for the word requested and print
			// it out to screen

			wordHashTable.find(wordLookUp);

		}

		// Display every item in the array with
		// the index they are associated with

		wordHashTable.displayTheArray();

	}
	
}
/*
ace : Very good
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 3 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 5 % arraySize 11 = 1

act : Take action
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 3 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 20 % arraySize 11 = 5

add : Join (something) to something else
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 4 % arraySize 11 = 9
Hash Key Value 9 * 27 + Character Code 4 % arraySize 11 = 5

age : Grow old
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 7 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 5 % arraySize 11 = 10

ago : Before the present
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 7 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 15 % arraySize 11 = 9

aid : Help, assist, or support
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 9 % arraySize 11 = 3
Hash Key Value 3 * 27 + Character Code 4 % arraySize 11 = 8

aim : Point or direct
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 9 % arraySize 11 = 3
Hash Key Value 3 * 27 + Character Code 13 % arraySize 11 = 6

air : Invisible gaseous substance
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 9 % arraySize 11 = 3
Hash Key Value 3 * 27 + Character Code 18 % arraySize 11 = 0

all : Used to refer to the whole quantity
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 12 % arraySize 11 = 6
Hash Key Value 6 * 27 + Character Code 12 % arraySize 11 = 9

amp : Unit of measure for the strength of an electrical current
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 13 % arraySize 11 = 7
Hash Key Value 7 * 27 + Character Code 16 % arraySize 11 = 7

and : Used to connect words
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 14 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 4 % arraySize 11 = 0

ant : A small insect
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 14 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 20 % arraySize 11 = 5

any : Used to refer to one or some of a thing
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 14 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 25 % arraySize 11 = 10

ape : A large primate
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 16 % arraySize 11 = 10
Hash Key Value 10 * 27 + Character Code 5 % arraySize 11 = 0

apt : Appropriate or suitable in the circumstances
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 16 % arraySize 11 = 10
Hash Key Value 10 * 27 + Character Code 20 % arraySize 11 = 4

arc : A part of the circumference of a curve
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 18 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 3 % arraySize 11 = 8

are : Unit of measure, equal to 100 square meters
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 18 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 5 % arraySize 11 = 10

ark : The ship built by Noah
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 18 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 11 % arraySize 11 = 5

arm : Two upper limbs of the human body
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 18 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 13 % arraySize 11 = 7

art : Expression or application of human creative skill
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 18 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 20 % arraySize 11 = 3

ash : Powdery residue left after the burning
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 19 % arraySize 11 = 2
Hash Key Value 2 * 27 + Character Code 8 % arraySize 11 = 7

ask : Say something in order to obtain information
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 19 % arraySize 11 = 2
Hash Key Value 2 * 27 + Character Code 11 % arraySize 11 = 10

asp : Small southern European viper
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 19 % arraySize 11 = 2
Hash Key Value 2 * 27 + Character Code 16 % arraySize 11 = 4

ass : Hoofed mammal
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 19 % arraySize 11 = 2
Hash Key Value 2 * 27 + Character Code 19 % arraySize 11 = 7

ate : To put (food) into the mouth and swallow it
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 20 % arraySize 11 = 3
Hash Key Value 3 * 27 + Character Code 5 % arraySize 11 = 9

atm : Unit of pressure
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 20 % arraySize 11 = 3
Hash Key Value 3 * 27 + Character Code 13 % arraySize 11 = 6

awe : A feeling of reverential respect
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 23 % arraySize 11 = 6
Hash Key Value 6 * 27 + Character Code 5 % arraySize 11 = 2

axe : Edge tool with a heavy bladed head
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 24 % arraySize 11 = 7
Hash Key Value 7 * 27 + Character Code 5 % arraySize 11 = 7

aye : An affirmative answer
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 25 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 5 % arraySize 11 = 1

: 
ace
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 3 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 5 % arraySize 11 = 1

ace : Very good
first (last added) word in this specific list object = aye : An affirmative answer
: 
act
Hash Key Value 0 * 27 + Character Code 1 % arraySize 11 = 1
Hash Key Value 1 * 27 + Character Code 3 % arraySize 11 = 8
Hash Key Value 8 * 27 + Character Code 20 % arraySize 11 = 5

act : Take action
first (last added) word in this specific list object = ark : The ship built by Noah
: 
x
Hash Key Value 0 * 27 + Character Code 24 % arraySize 11 = 2

null
first (last added) word in this specific list object = awe : A feeling of reverential respect
theArray Index 0
ape : A large primate
and : Used to connect words
air : Invisible gaseous substance
theArray Index 1
aye : An affirmative answer
ace : Very good
theArray Index 2
awe : A feeling of reverential respect
theArray Index 3
art : Expression or application of human creative skill
theArray Index 4
asp : Small southern European viper
apt : Appropriate or suitable in the circumstances
theArray Index 5
ark : The ship built by Noah
ant : A small insect
add : Join (something) to something else
act : Take action
theArray Index 6
atm : Unit of pressure
aim : Point or direct
theArray Index 7
axe : Edge tool with a heavy bladed head
ass : Hoofed mammal
ash : Powdery residue left after the burning
arm : Two upper limbs of the human body
amp : Unit of measure for the strength of an electrical current
theArray Index 8
arc : A part of the circumference of a curve
aid : Help, assist, or support
theArray Index 9
ate : To put (food) into the mouth and swallow it
all : Used to refer to the whole quantity
ago : Before the present
theArray Index 10
ask : Say something in order to obtain information
are : Unit of measure, equal to 100 square meters
any : Used to refer to one or some of a thing
age : Grow old
*/