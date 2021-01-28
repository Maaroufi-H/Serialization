package view.rest;

import java.util.Map;

import model.rest.RestResource;
import model.rest.RestCollection;

public class RestXMLView implements IRestView
{
	
	public String renderCollection(RestCollection resource) 
	{
		String res = "<"+resource.getClass().getSimpleName().toLowerCase()+">";
		for(RestResource single:resource.getCollection())
			res+=renderSingle(single);
		res+="</"+resource.getClass().getSimpleName().toLowerCase()+">";
		return res;
	}

	public String renderSingle(RestResource resource)
	{
		String res = "<"+resource.getClass().getSimpleName().toLowerCase()+">";
		Map<String,Object> state = resource.toMap();
		for(String key:state.keySet())
			res+="<"+key+">"+ renderObject(state.get(key)) +"</"+key+">";
		res+="</"+resource.getClass().getSimpleName().toLowerCase()+">";
		return res;
	}


	@Override
	public String getMIMEType() 
	{
		return "application/xml";
	}

	@Override
	public String render(RestResource resource) 
	{
		return 	resource instanceof RestCollection 			?
				renderCollection((RestCollection) resource)	:
				renderSingle(resource)							;
	}
	
}
