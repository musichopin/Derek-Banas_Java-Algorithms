public class BinaryTree {

//	***linklist nasýl ki linki referans ederse binary tree de nodeu referans eder***
	Node root;
//	***main metodda Binary Tree'ye ait tek bir object oluþtuðu için root object ve aþaðýdaki 
//	addNote metodunda root objecte baðlý oluþan focusNode object ile parent object tek 
//	bir tanedir (ki bu sayede nodelarýn navigasyonu saðlanýr)***

	public void addNode(int key, String name) {

		// Create a new Node and initialize it
		
		Node newNode = new Node(key, name);
		
		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {
			
			// ***Set root as the Node we will start with as we traverse the tree.
			//		  focus node'un konumu root'tan baþlayarak sürekli olarak deðiþecektir***
			Node focusNode = root;
			
			// **Future parent for our new Node**
			Node parent; // neden kullanýlýyor (?)

			while (true) {

				// root is the top parent so we start there
				parent = focusNode;

				// **Check if the new node should go on
				// the left side of the parent node**
				if (key < focusNode.key) {
//			    *alt: if (newNode.key < focusNode.key)*

					// ***Switch focus to the left child***
					focusNode = focusNode.leftChild;

					// If the left child has no children
//					***if it has children we reiterate the loop***
					if (focusNode == null) {

						// then place the new node on the left of it
						
						parent.leftChild = newNode; 
//						*!alt deðil: focusNode = newNode;*
						
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children
//					***if it has children we reiterate the loop***
					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						
						return; // All Done

					}

				}

			}
			
		}

	}

	
	// ***All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth 
	// (recursion yapýlýrken node'un leftChild'ý veya rightChild'ý null iken 
	// inOrderTraverseTree(null) dendiðinde inOrderTraverseTree 
	// metodundan hiç bir þey olmadan çýkmasýna dikkat (faktöriyel gibi deðil))***
	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);
//			***focusNode.leftChild ile focusNode.rightChild'ýn yerleri  
//			deðiþmiþ olsaydý sýralama descending olurdu***

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	
//	root node comes first
	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	
//	**root node comes last**
	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		// Start at the top of the tree

		Node focusNode = root;

		// *While we haven't found the Node keep looking*
		while (focusNode.key != key) {

			// *If we should search to the left*
			if (key < focusNode.key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found
//			**key'in bulunmamasý halinde infinite loopdan kurtarýr**
			if (focusNode == null)
				return null;

		}

		return focusNode;

	}

	public static void main(String[] args) {
	
			BinaryTree theTree = new BinaryTree();
	
			theTree.addNode(50, "Boss");
	
			theTree.addNode(25, "Vice President");
	
			theTree.addNode(15, "Office Manager");
	
			theTree.addNode(30, "Secretary");
	
			theTree.addNode(75, "Sales Manager");
	
			theTree.addNode(85, "Salesman 1");
	
//			there are 3 different ways to traverse binary trees:
			 System.out.println("***inOrderTraverseTree***");
			 theTree.inOrderTraverseTree(theTree.root);
			 System.out.println("***preorderTraverseTree***");
			 theTree.preorderTraverseTree(theTree.root);
			 System.out.println("***postOrderTraverseTree***");
			 theTree.postOrderTraverseTree(theTree.root);
	
			// Find the node with key 75
	
			System.out.println("\nNode with the key 75");
	
			System.out.println(theTree.findNode(75));
	
	}
	
}


class Node {

	int key; // **index olarak düþünülebilir**
	String name;

	Node leftChild;
	Node rightChild;
//	**leftChild and rightChild can be null, 
//	but at most there can be 2 children nodes belonging to a parent node**

	Node(int key, String name) {

		this.key = key;
		this.name = name;

	}

	public String toString() {

		return name + " has the key " + key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}

}

/*
***inOrderTraverseTree***
Office Manager has the key 15
Vice President has the key 25
Secretary has the key 30
Boss has the key 50
Sales Manager has the key 75
Salesman 1 has the key 85
***preorderTraverseTree***
Boss has the key 50
Vice President has the key 25
Office Manager has the key 15
Secretary has the key 30
Sales Manager has the key 75
Salesman 1 has the key 85
***postOrderTraverseTree***
Office Manager has the key 15
Secretary has the key 30
Vice President has the key 25
Salesman 1 has the key 85
Sales Manager has the key 75
Boss has the key 50

Node with the key 75
Sales Manager has the key 75
*/