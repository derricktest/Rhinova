package rhinova.framework.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RootModelEntity implements Comparable<RootModelEntity> {
	
	/** id of an entity */
	protected int id;
	
	/** creator of an entity */
	protected static List<Integer> ids = new ArrayList<Integer>();
	
	
	/**
	 * Sets the id such that if an Entity already contains the same if as the one being passed to this function, it will
	 * keep incrementing the value passes till it is not contained in the list.
	 *
	 * @param id the new Reserve's id
	 */
	protected void setId(int id)
	{

		if (ids.size() == 0)
		{
			ids.add(id);
			this.id = id;
		}
		else
		{
			// if there is already a reserve with an id, increment this by 1
			while (ids.contains(id))
			{
				id++;
			}
			this.id = id;
			ids.add(id);
		}
	}
	
	
	/** Automatically set the ID of an Entity */
	protected void setId()
	{
		// if there are no Links yet, assign an id of 1
		if (ids.size() == 0)
		{
			this.id = 0;
			ids.add(0);
		}
		else
		{
			int max = Collections.max(ids);
			int next_id = max + 1;
			this.id = next_id;
			ids.add(next_id);
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public static void clearIds() {
		ids.clear();
	}


	@Override
	public int compareTo(RootModelEntity o) {
		return +this.getId() - o.getId();
	}
	
	

}
