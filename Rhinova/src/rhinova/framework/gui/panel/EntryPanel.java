package rhinova.framework.gui.panel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rhinova.framework.entity.tableable.ObjectGetter;
import rhinova.framework.entity.tableable.exceptions.ConstraintViolatedException;
import rhinova.framework.entity.tableable.exceptions.IncorrectDataType;
import rhinova.framework.entity.tableable.exceptions.NullInputException;
import net.miginfocom.swing.MigLayout;


/**
 * Class to automatically generate a gui for creating new values for an object.
 *
 */
public abstract class EntryPanel <T extends ObjectGetter> extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/** x - variable to keep track of the x position of adding components**/
	private int xPos=0;
	
	/** y - variable to keep track of the y position of adding components */
	private int yPos=0;
	
	/** title labels */
	protected String[] labelTitles;
	
	/** */
	public EntryPanel(T objGetter) {
		this.setLayout(new MigLayout());
		this.objGetter = objGetter;
		this.labelTitles = objGetter.getHeading();
	}
	
	/** Constructor used by spring, simply sets the layout */
	public EntryPanel() {
		this.setLayout(new MigLayout());
	}
	
	/** this must be called after the before the  */
	@PostConstruct
	public void addComponents() {
		this.createEntries();
		this.addCreateButton();
		
	}
	
	
	/** Method for creating all the text fields and entries */
	public void createEntries() {
		for (String title: labelTitles) {
			this.newLabelAndEntry(title);
		}
	}
	
	/** Create button method for creating a new Tableable object */
	public void addCreateButton() {
		JButton jBtn = new JButton("Create");
		jBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						// test if the Tableable object can be created
						objGetter.createTableable(getUserInputArray());
						
						// ask for confirmation
						int response = JOptionPane.showConfirmDialog(null, "Do you wish to create this Componenet?", "Confirm?", JOptionPane.YES_NO_CANCEL_OPTION);
						if (response == 0)
						{
							// create the object
							objGetter.createAndAddNewInstance(getUserInputArray());
							JOptionPane.showMessageDialog(null, "Model Component Created", "Success", JOptionPane.INFORMATION_MESSAGE);
						}
						// report exceptions to the user
					} catch (IncorrectDataType e) {
						onIncorrectDataType(e.getMessage());
					} catch (ConstraintViolatedException e) {
						onConstraintViolateException(e.getMessage());
					} catch (NullInputException e) {
						onNullInputException(e.getMessage());
					}

			}});
		this.add(jBtn,"dock south");
	}
	
	protected void onIncorrectDataType(String message)          {JOptionPane.showMessageDialog(null, message	, "Incorrect Data Type Error",  JOptionPane.ERROR_MESSAGE);}	
	protected void onConstraintViolateException(String message) {JOptionPane.showMessageDialog(null, message	, "Constraint Error", 			JOptionPane.ERROR_MESSAGE);}
	protected void onNullInputException(String message)         {JOptionPane.showMessageDialog(null, message	, "Null Entry", 				JOptionPane.ERROR_MESSAGE);}
	
	/** ObjectGetter responsible for creating new data */
	protected T objGetter = null;
	
//	/** you must set the objGetter with this method, this is for the purpose of ensuring users inject it themselves*/
//	public abstract void addObjectGetter(ObjectGetter objGetter);
	
	/** reference to the entries for retrieving user input*/
	private List<JTextField> entries = new ArrayList<JTextField>();
	
	
	/** Method to access entries
	 * @param i
	 * @return
	 */
	protected JTextField getEntry(int i) {
		return entries.get(i);
	}
	
	
	/**
	 * Get an entry by its heading
	 * @param heading
	 * @return
	 */
	protected JTextField getEntry(String heading) {
		for (int i=0; i<labelTitles.length; i++){
			if (heading == labelTitles[i]) {
				return this.entries.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * Method for creating a pair of label and text field
	 * @param lblName
	 * @return
	 */
	void newLabelAndEntry(String lblName) {
		// add the label
		this.add(new JLabel(lblName), "cell "+xPos+" "+yPos);
		
		// add the text field
		JTextField jTextField = new JTextField(10);
		xPos++;
		entries.add(jTextField);
		this.add(jTextField, "cell "+xPos+" "+yPos);
		yPos++;
		xPos=0;
		
	}
	
	/**
	 * @return user input as a list of strings
	 */
	public List<String> getUserInputList() {
		List<String> userInput = new ArrayList<String>();
		for(JTextField txt: this.entries){
			userInput.add(txt.getText());
		}
		return userInput;
	}
	
	/**
	 * @return user input as an array of strings
	 */
	public String[] getUserInputArray() {
		String[] userInput = new String[this.entries.size()];
		for(int i=0; i<this.entries.size(); i++){
			userInput[i] = entries.get(i).getText();
		}
		return userInput;
	}
	
	public T getObjectGetter() {
		return this.objGetter;
	}
	
}
