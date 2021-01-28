package view.rest;

import java.util.List;
import java.util.Map;

import model.rest.RestResource;
import model.rest.RestCollection;

//Json is entirely in string,does not provide integer values in json
public class RestJSONView implements IRestView
{

	@Override
	public String render(RestResource resource) 
	{
		return 	resource instanceof RestCollection 			?
				renderCollection((RestCollection) resource)	:
				renderSingle(resource)							;
	}

	
	public String renderSingle(RestResource resource) 
	{
		String res = "{";
		Map<String,Object> state = resource.toMap();
		for(String key:state.keySet())
			res+="\""+key+"\":"+renderObject(state.get(key))+",";
		res = res.substring(0, res.length()-1);
		res+="}";
		return res;
	}


	public String renderCollection(RestCollection resource) 
	{
		String res = "[";
		for(RestResource single:resource.getCollection())
			res+=renderSingle(single)+",";
		res = res.substring(0, res.length()-1);
		res+="]";
		return res;
	}

	@Override
	public String getMIMEType() 
	{
		return "application/json";
	}

	@Override
	public String renderObject(Object object) 
	{
		//Io potrei essere:
		//Un intero, un double, una stringa... in questi casi, toString()
		//potrei essere un singolo IRestResource. In questo caso, render()
		//potrei essere una LISTA
		if(object instanceof RestResource)
			return render((RestResource)object);
		
		if(object instanceof List)
		{
			String res = "";
			List<Object> l = (List<Object>) object;
			if(l.size()<1)
				return "[]";
			
			res+="[";
			for(Object o:l)
				res+=renderObject(o) +",";
			res=res.substring(0, res.length()-1);
			res+="]";
			return res;
		}
		
		return object==null ? "" : "\""+object.toString()+"\"";
	}

}
