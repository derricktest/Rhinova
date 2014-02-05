package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



/**
 * @author Derrick
 * 
 * Symbolic class for a+b*3 - 2*a + c.. etc.
 *
 */
public class SymbolicVariable implements Serializable {


	private static final long serialVersionUID = 1L;

	private double number = 0;

	private final Map<String, Double> mapSys = new HashMap<String, Double>();

	private final static Map<String, String> mapKeys = new HashMap<String, String>();

	public SymbolicVariable(){}

	public static void reset() {
		mapKeys.clear();
	}
	
	
	/**
	 * Symbolic variable with only a number
	 * @param number - number
	 */
	public SymbolicVariable(double number) {
		this.number = number;
	}

	public static void addVariableName(String name) {
		mapKeys.put(name, name);
	}

	public Entry<String, Double> getOnlyVal() {
		for (Entry<String, Double> entry : this.mapSys.entrySet()) {
			return entry;
		}
		return null;
	}


	/**
	 * @param name - name of symbolic variable
	 * @param value - constant value
	 * @param number - optional number 
	 */
	public SymbolicVariable(String name, double value, double number) {

		this.mapSys.put(name, value);

		if (!mapKeys.containsKey(name)){
			mapKeys.put(name, name);
		}

		this.number = number;
	}

	/**
	 * @param name - name of symbolic variable
	 * @param value - constant value
	 */
	public SymbolicVariable(String name, double value) {
		this(name, value, 0.0);
	}

	public double getNumber() {
		return this.number;
	}

	
	private static List<String> skeys = null;

	/**
	 * @return list of all names of symbolic variables
	 */
	public static List<String> getKeysList() {
		
		if (skeys != null) {
			return skeys;
		}
		
		List<String> keys = new ArrayList<String>();
		for (Entry<String, String> entry : mapKeys.entrySet()) {
			keys.add(entry.getKey());
		}
		Collections.sort(keys);
		skeys = keys;
		return skeys;
	}


	/**
	 * @return array representation of symbolic variable
	 */
	public double[] getAsArray() {
		
		List<String> keys = getKeysList();

		// construct an array
		double[] array = new double[keys.size()];
		for (Entry<String, Double> entry : this.mapSys.entrySet()) {
			array[findLocation(keys, entry.getKey())] = entry.getValue();
		}
		return array;
	}


	/**
	 * Print the array representation of the symblic variable
	 */
	public void printArray(){

		double[] vals = this.getAsArray();

		System.out.print(number + " ");

		for (double v : vals) {
			System.out.print(v+" ");
		}

	}

	/**
	 * Method to find the array position given a variable name
	 * @param list
	 * @param varName
	 * @return
	 */
	public static int findLocation(List<String> list, String varName) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).equals(varName)){
				return i;
			}
		}
		return -1;
	}


	/** Add 2 symbolic variables together
	 * @param var
	 * @return
	 */
	public SymbolicVariable add(SymbolicVariable var){

		this.number+=var.getNumber();

		Map<String, Double> map2 = var.getMap();
		for (Entry<String, Double> entry : map2.entrySet()) {

			String key = entry.getKey();

			if (mapSys.containsKey(key)) {
				double newValue = mapSys.get(key)+map2.get(key);
				mapSys.put(key, newValue);
			} else {
				mapSys.put(key, entry.getValue());
			}
		}
		return this;
	}


	/**
	 * Subtract 2 symbolic variables together
	 * @param var
	 * @return
	 */
	public SymbolicVariable subtract(SymbolicVariable var){

		this.number-=var.getNumber();

		Map<String, Double> map2 = var.getMap();
		for (Entry<String, Double> entry : map2.entrySet()) {

			String key = entry.getKey();

			if (mapSys.containsKey(key)) {
				double newValue = mapSys.get(key)-map2.get(key);
				mapSys.put(key, newValue);
			} else {
				mapSys.put(key, -entry.getValue());
			}
		}
		return this;
	}


	/**
	 * Multiply the symbolic variable by a scalar
	 * @param scalar
	 * @return
	 */
	public SymbolicVariable multiply(double scalar) {

		this.number*=scalar;

		for (Entry<String, Double> entry : mapSys.entrySet()) {
			entry.setValue(entry.getValue()*scalar);
		}
		return this;
	}


	/**
	 * Divide the symbolic variable by a scalar
	 * @param scalar
	 * @return
	 */
	public SymbolicVariable divide(double scalar) {

		this.number/=scalar;

		for (Entry<String, Double> entry : mapSys.entrySet()) {
			entry.setValue(entry.getValue()/scalar);
		}
		return this;
	}


	/**
	 * Map representation of the symbolic variable
	 * @return 
	 */
	public Map<String, Double> getMap() {
		return mapSys;
	}


	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(""+this.number);

		for (Entry<String, Double> entry : mapSys.entrySet()) {

			double value = entry.getValue();
			String name = entry.getKey();

			if (value>=0){
				sb.append(" +"+value+"*"+name);
			} else {
				sb.append(" -"+Math.abs(value)+"*"+name);
			}
		}
		return sb.toString();
	}


	/**
	 * Method to retrieve a symbolic variable from an array.
	 * @param array
	 * @return
	 */
	public static SymbolicVariable getVaribleFromArray(double[] array) {
		List<String> values = getKeysList() ;
		SymbolicVariable var = new SymbolicVariable();
		for (int i=0; i<array.length; i++) {
			double value = array[i];
			String name = values.get(i);
			var.add(new SymbolicVariable(name, value));
		}
		return var;
	}

	public static SymbolicVariable getSingleVariableFromArray(double[] array) {
		List<String> values = getKeysList();
		SymbolicVariable var = new SymbolicVariable(0.0);
		for (int i=0; i<array.length; i++) {
			double value = array[i];
			if (Math.abs(value) <= 0.00001){
				String name = values.get(i);
				var.add(new SymbolicVariable(name, value));
				return var;
			}
		}
		return var;
	}





}