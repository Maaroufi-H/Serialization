package main;

import java.util.ArrayList;
import java.util.List;

import model.entities.Customer;
import model.entities.Product;
import model.rest.RestCollection;
import model.rest.RestResource;
import view.rest.RestJSONView;
import view.rest.RestXMLView;

public class Driver {

	public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        
		Customer Mockcustomer = new Customer(1, "hello@yopmail.com", 0, "Hatem", "thank you for watching");
        Product Mockproduct = new Product(1, "h.png", "hi", 100, 10, "shoes");
        list.add(Mockcustomer);
        list.add(Mockproduct);
	    RestCollection collection = new RestCollection(list);
        System.out.println("init test  ... : \n");
        System.out.println("JSON Customer : \n"+new RestJSONView().render(Mockcustomer));
		System.out.println("JSON Product  : \n"+new RestJSONView().render(Mockproduct));
		System.out.println("JSON List : \n"+new RestJSONView().render(collection));

		System.out.println("XML Customer : \n"+new RestXMLView().render(Mockcustomer));
        System.out.println("XML Product : \n"+new RestXMLView().render(Mockproduct));
		System.out.println("XML List : \n"+new RestXMLView().render(collection)+"\n");
        System.out.println("end test ... :");

	}
}
