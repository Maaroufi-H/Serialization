package model.rest;

import java.util.ArrayList;
import java.util.List;

public class RestCollection implements RestResource
{

	List<RestResource> collection = new ArrayList<RestResource>();
	RestAccessLevel access = null;
	
	public RestCollection(List<Object> collection) 
	{
		for(Object o:collection)
			if(o!=null)
				this.collection.add((RestResource)o);
		access = new RestAccessLevel(0,0);
	}

	public RestCollection(List<Object> collection, RestAccessLevel access) 
	{
		for(Object o:collection)
			if(o!=null)
				this.collection.add((RestResource)o);
		this.access = access;
	}

	
	public List<RestResource> getCollection()
	{
		return collection;
	}

	@Override
	public String[] exportFields() 
	{
		return "".split(",");
	}

	@Override
	public RestAccessLevel getAccessLevel() 
	{
		return access;
	}
	
}
