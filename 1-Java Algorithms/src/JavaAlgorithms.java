import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.*;

public class JavaAlgorithms extends JFrame {

	private JPanel contentPane;

	private JTextField arrayValueTextField;
	private JTable table;
	private JTextField arrayIndexTextField;
	private JButton insertButton, deleteButton, findButton, sortButton;
	JRadioButton linearSearchRadioButton, binarySearchRadioButton;
	JRadioButton descendingRadioButton, ascendingRadioButton;
	
	int cellToMark = -1;
	
	// Holds the array that goes in JTable
	
	Object[][] data = {
		    {new Integer(0), new Integer(0), ""},
		    {new Integer(1), new Integer(0), ""},
		    {new Integer(2), new Integer(0), ""},
		    {new Integer(3), new Integer(0), ""},
		    {new Integer(4), new Integer(0), ""},
		    {new Integer(5), new Integer(0), ""},
		    {new Integer(6), new Integer(0), ""},
		    {new Integer(7), new Integer(0), ""},
		    {new Integer(8), new Integer(0), ""},
		    {new Integer(9), new Integer(0), ""},
		}; 
	
	String[] columnNames = {"Index",
            "Value",
            "Selected"};
	
	
	DefaultTableModel dTableModel = new DefaultTableModel(data, columnNames);

	/**
	 * Create the frame.
	 */
	public JavaAlgorithms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel valueLabel = new JLabel("Value");
		valueLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		
		arrayValueTextField = new JTextField();
		arrayValueTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
		arrayValueTextField.setColumns(10);
		
		JLabel indexLabel = new JLabel("Index");
		indexLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		
		arrayIndexTextField = new JTextField();
		arrayIndexTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
		arrayIndexTextField.setColumns(10);
		
		insertButton = new JButton("Insert");
		insertButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		findButton = new JButton("Find");
		findButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		
		ascendingRadioButton = new JRadioButton("Ascending");
		ascendingRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		descendingRadioButton = new JRadioButton("Descending");
		descendingRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		// Stores the radio buttons so when one is selected the other is deselected
		
		ButtonGroup sortDirection = new ButtonGroup();
		
		sortDirection.add(ascendingRadioButton);
		
		sortDirection.add(descendingRadioButton);
		
		sortButton = new JButton("Sort");
		sortButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		// Sets up the radio buttons for the search type
		
		linearSearchRadioButton = new JRadioButton("Linear");
		linearSearchRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		binarySearchRadioButton = new JRadioButton("Binary");
		binarySearchRadioButton.setFont(new Font("Dialog", Font.BOLD, 30));
		
		ButtonGroup searchType = new ButtonGroup();
		
		searchType.add(linearSearchRadioButton);
		searchType.add(binarySearchRadioButton);
		
		JTextArea textArea = new JTextArea("Output");
		textArea.setFont(new Font("Dialog", Font.PLAIN, 30));
		
		// ------------------------
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(ascendingRadioButton)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(descendingRadioButton))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(valueLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(arrayValueTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(indexLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(arrayIndexTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(insertButton)
										.addGap(26)
										.addComponent(deleteButton)
										.addGap(26)
										.addComponent(findButton))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(sortButton)
										.addGap(18)
										.addComponent(linearSearchRadioButton)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(binarySearchRadioButton)))))
						.addContainerGap(75, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(valueLabel)
								.addComponent(insertButton)
								.addComponent(deleteButton)
								.addComponent(findButton)
								.addComponent(arrayValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(indexLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addComponent(arrayIndexTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGap(2)))
						.addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(ascendingRadioButton)
							.addComponent(descendingRadioButton)
							.addComponent(sortButton)
							.addComponent(linearSearchRadioButton)
							.addComponent(binarySearchRadioButton))
						.addGap(42)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textArea)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
						.addContainerGap(94, Short.MAX_VALUE))
			);
			
			table = new JTable(dTableModel);
			
			// Set the font for the table column titles
			
			table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 30));
			
			// Set the font for the data in the columns
			
			table.setFont(new Font("Dialog", Font.BOLD, 30));
			
			// Increase the row height so that the larger font fits
			
			table.setRowHeight(table.getRowHeight()+30);
			
			scrollPane.setViewportView(table);
		
		
		contentPane.setLayout(groupLayout);
	}
	
	// Set up all the listeners
	
	void addInsertButtonListener(ActionListener listenerForInsertButton){
		
		insertButton.addActionListener(listenerForInsertButton);
		
	}
	
	void addDeleteButtonListener(ActionListener listenerForDeleteButton){
		
		deleteButton.addActionListener(listenerForDeleteButton);
		
	}
	
	void addFindButtonListener(ActionListener listenerForFindButton){
		
		findButton.addActionListener(listenerForFindButton);
		
	}
	
	void addSortButtonListener(ActionListener listenerForSortButton){
		
		sortButton.addActionListener(listenerForSortButton);
		
	}
	
	// Other Random Methods Needed
	
	void sendMessageToUser(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
	public int getTheValue(){
		
		return Integer.parseInt(arrayValueTextField.getText());
		
	}
	
	public int getTheIndex(){
		
		return Integer.parseInt(arrayIndexTextField.getText());
		
	}
	
	public void updateTheTable(int[] newArray, int rows){
		
		Object[] tempRow;
		
		dTableModel.setRowCount(0); // Clear JTable
		
		for(int i = 0; i < rows; i++){
			
			if(i == this.cellToMark)tempRow = new Object[]{i, newArray[i], "XXXXX"};
			
			else tempRow = new Object[]{i, newArray[i], ""};
			
			dTableModel.addRow(tempRow);
			
		}
		
	}
	
}

class AlgorithmsMVC{
	
	public static void main(String[] args) {
		
		JavaAlgorithms theView = new JavaAlgorithms();
		ArrayStructure theModel = new ArrayStructure();
		
		AlgorithmsController theController = new AlgorithmsController(theView, theModel);
		
		theView.setVisible(true);
		
	}
	
}

class AlgorithmsController{
	
	private JavaAlgorithms theView;
	private ArrayStructure theModel;
	
	public AlgorithmsController(JavaAlgorithms theView, ArrayStructure theModel){
		
		this.theView = theView;
		this.theModel = theModel;
		
		theModel.generateRandomArray();
		
		// Add button listeners
		
		this.theView.addInsertButtonListener(new InsertButtonListener());
		this.theView.addDeleteButtonListener(new DeleteButtonListener());
		this.theView.addFindButtonListener(new FindButtonListener());
		this.theView.addSortButtonListener(new SortButtonListener());
		
		// Put random array data in the table model
		
		theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
		
	}
	
	// ActionListener for the Insert Button
	
	class InsertButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			
			try{
				
				theModel.insertValue(theView.getTheValue());
				
				// Take the array data from the model & move it to the JTable
				
				theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
				
			}
			
			catch(NumberFormatException ex){
				
				theView.sendMessageToUser("You Need a Value in the Value Box");
				
			}
			
		}
		
	}
	
	// ActionListener for the Insert Button
	
	class DeleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			try{
				
				theModel.deleteIndex(theView.getTheIndex());
				
				theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
				
			}
			
			catch(NumberFormatException ex){
				
				theView.sendMessageToUser("You Need a Index in the Index Box");
				
			}
			
		}
		
	}
	
	// ActionListener for the Find Button
	
	class FindButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			String indexWithValue = "";
			
			try{
				
				if(theView.linearSearchRadioButton.isSelected()){
					
					indexWithValue = theModel.linearSearchForValue(theView.getTheValue());
					
				}
				
				theView.sendMessageToUser("Found in Index: " + indexWithValue);
				
			}
			
			catch(NumberFormatException ex){
				
				theView.sendMessageToUser("You Need a Value in the Value Box");
				
			}
			
		}
		
	}
	
	// ActionListener for the Sort Button
	
	class SortButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			try{
				
				if(theView.ascendingRadioButton.isSelected()){
					
					theModel.bubbleSort();
					
				} else {
					
					theModel.bubbleSortDescending();
					
				}
				
				theView.updateTheTable(theModel.getTheArray(), theModel.getArraySize());
				
			}
			
			catch(NumberFormatException ex){
				
				theView.sendMessageToUser("Something Went Wrong");
				
			}
			
		}
		
	}
	
	
	
}
