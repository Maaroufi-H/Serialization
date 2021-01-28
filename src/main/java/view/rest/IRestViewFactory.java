package view.rest;

import java.util.HashMap;
import java.util.Map;


public class IRestViewFactory 
{
	Map<String,IRestView> cache = new HashMap<String,IRestView>();
	
	private static IRestViewFactory instance = new IRestViewFactory();
	
	private IRestViewFactory() {}
	
	public static IRestViewFactory getInstance() {return instance;}
	
	public IRestView make(String format)
	{
		IRestView res = null;
		
		switch(format)
		{
			case "application/xml":
				if(cache.get("application/xml")==null)
					cache.put("application/xml", new RestXMLView());
				res = cache.get("application/xml");
			break;	
			case "application/json":
				if(cache.get("application/json")==null)
					cache.put("application/json", new RestJSONView());
				res = cache.get("application/json");
			default:
				if(cache.get("application/json")==null)
					cache.put("application/json", new RestJSONView());
				res = cache.get("application/json");
		}
		return res;
		
	}
	
	
	
	
}
