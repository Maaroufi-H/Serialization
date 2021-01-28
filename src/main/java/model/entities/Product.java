package model.entities;

import java.io.Serializable;

import model.rest.RestAccessLevel;
import model.rest.RestResource;


/**
 * The persistent class for the product database table.
 * 
 */

public class Product implements Serializable, RestResource
{
	public Product(int id, String image, String name, int price, int quantity, String type) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}

	public Product() {
	}

	private static final long serialVersionUID = 1L;
	
	public static final RestAccessLevel ACCESS = new RestAccessLevel(0,2);

	private static final String[] EXPORTFIELDS = "id,name,type,image,price,quantity,origin".split(",");

	
	private int id;

	private String image;

	private String name;

	private int price;

	private int quantity;

	private String type;

	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String[] exportFields() 
	{
		return EXPORTFIELDS;
	}

	@Override
	public RestAccessLevel getAccessLevel() 
	{
		return ACCESS;
	}

	public String getOrigin()
	{
		return "Marof technologies S.R.L.";
	}
	
}