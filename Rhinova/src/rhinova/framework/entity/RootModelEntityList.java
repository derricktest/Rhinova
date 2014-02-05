package rhinova.framework.entity;

import java.util.ArrayList;
import java.util.List;




/**
 * @author Derrick
 * Base List to implement id functionality
 *
 * @param <T>
 */
public abstract class RootModelEntityList <T extends RootModelEntity> extends ArrayList<RootModelEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * Constructor which takes a List of T
	 * @param lst
	 */
	public RootModelEntityList(List<T> lst) {
		super();
		this.replace(lst);
	}
	
	/**
	 * Method to replace all objects inside the list with the list passed
	 * @param lst
	 */
	public void replace(List<T> lst) {
		this.clear();
		for (T t: lst) {
			this.add(t);
		}
	}
	
	
	@Override
	public void clear() {
		super.clear();
		RootModelEntity.clearIds();
	}
	
	
	/**
	 * Method to add a List of T to the current list
	 * @param lst
	 */
	public void add(List<T> lst) {
		for (T t: lst) {
			this.add(t);
		}
	}
	
	/** Parameterless Constructor*/
	public RootModelEntityList() {
		super();
	}
	
	
	/**
	 * Find an entity by its id, returns null if unsuccessful
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getById(int id) {
		for (RootModelEntity t: this) {
			if (t.getId() == id) {
				return  (T) t;
			}
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(int i) {
		return (T) super.get(i);
	}
	
	
	
	/**
	 * Will only add the {@code Entity} if there is ot
	 * @param t
	 */
	public void add(T t) {
		if (this.getById(t.getId())==null && !this.contains(t)){
			super.add(t);
		}
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public
	List<T> getList() {
		return new ArrayList<T>((List) this);
	}
	
	
	public void removeById(int id) {
		this.remove(this.getById(id));
	}

	
	/** Method to print the contents of the list */
	public void printAll() {
		
		if (this.size()==0) {
			System.out.println("Empty List");
			return;
		}
		
		for (RootModelEntity r: this) {
			@SuppressWarnings("unchecked")
			T t = (T) r;
			System.out.println(t);
			System.out.println("...");
		}
	}
	
	
	public int findPlace(T o){
		for (int i=0; i<this.size(); i++) {
			T t = this.get(i);
			if (t == o) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Integer> getIds() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<this.size(); i++) {
			list.add(this.get(i).getId());
		}
		return list;
	}

}
