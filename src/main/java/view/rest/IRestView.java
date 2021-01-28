package view.rest;

import java.util.List;

import model.rest.RestResource;

public interface IRestView 
{
	String render(RestResource resource); 

	default String renderObject(Object object) 
	{
		// I could be:
		//-An integer,a double,a String...in these cases ,toString()
		//-I could be a single IRestResource .In this case,render ()
		//-Otherwise i can be a LIST
		if(object instanceof RestResource)
			return render((RestResource)object);
		
		if(object instanceof List)
		{
			String res = "";
			List<Object> l = (List<Object>) object;
			for(Object o:l)
				res+=renderObject(o);
			return res;
		}
		
		return object==null ? "" : object.toString();
	}


	String getMIMEType();
	
}
