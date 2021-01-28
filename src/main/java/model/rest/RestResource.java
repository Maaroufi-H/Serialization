package model.rest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface RestResource 
{
	//must provide list of fields to export 
	String[] exportFields();
		
	RestAccessLevel getAccessLevel();
	
	default public Map<String,Object> toMap() 
	{
		Map<String,Object> res = new LinkedHashMap<String,Object>();
		
	

		for(String field:exportFields())
			for(Method m:this.getClass().getMethods())
				if(m.getName().toLowerCase().equals("get"+field))
				try
				{
					res.put(field, m.invoke(this));
				}
				catch (IllegalAccessException e) 
				{
					res.put
					(
						m.getName().replace("get", "").toLowerCase(),
						"FORBIDDEN"		
					);
				} 
				catch (IllegalArgumentException e) 
				{
					//Non succederà MAI, quindi me ne frego
				} 
				catch (InvocationTargetException e) 
				{
					// e.printStackTrace();
					res.put
					(
						m.getName().replace("get", "").toLowerCase(),
						"FORBBIDDEN"		
					);
				}
				catch(NullPointerException e)
				{
					res.put
					(
						m.getName().replace("get", "").toLowerCase(),
						""		
					);
				}
		return res;
	}
	
	default void fromMap(Map<String,String> data) throws Exception
	{
		for(Method m:this.getClass().getMethods())
			if(m.getName().startsWith("set"))
			{
				String fieldName = m.getName().replace("set", "").toLowerCase();
				//if map does not contain fieldname,go to next method 
				if(!data.containsKey(fieldName)) continue;
			
				String typeName = 
						m.getParameters()[0].getType().getName();
				
				switch(typeName)
				{
					case "java.lang.String":
							m.invoke(this, data.get(fieldName));
						break;
					case "int":
							m.invoke(this, Integer.parseInt(data.get(fieldName)));
						break;
					case "double":
						m.invoke(this, Double.parseDouble(data.get(fieldName)));
					break;
				
				}
			
		}
	}
	
}
