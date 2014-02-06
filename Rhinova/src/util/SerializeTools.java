package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTools {

	
	
	/**
	 * Method to save an object to a file with the Serialiable interface
	 * @param fileName
	 * @param obj
	 */
	public static void save(String fileName, Object obj) {
	      try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(fileName);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(obj);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	/**
	 * Generic method to read an object back from a file
	 * @param fileName
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T open(String fileName, Class<T> cls) {
		
	      T t = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream(fileName);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         t = (T) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         c.printStackTrace();
	         return null;
	      }
		
		return t;
	}
	
	
}
