package rhinova.framework.entity.exceptions;

import javax.swing.JOptionPane;

public class EntityExceptionDialogs {
	public static void onIncorrectDataType(String message)          {JOptionPane.showMessageDialog(null, message	, "Incorrect Data Type Error",  JOptionPane.ERROR_MESSAGE);}	
	public static void onConstraintViolateException(String message) {JOptionPane.showMessageDialog(null, message	, "Constraint Error", 			JOptionPane.ERROR_MESSAGE);}
	public static void onNullInputException(String message)         {JOptionPane.showMessageDialog(null, message	, "Null Entry", 				JOptionPane.ERROR_MESSAGE);}
}
