package model.entities;

import java.io.Serializable;


import model.rest.RestAccessLevel;
import model.rest.RestResource;


/**
 * The persistent class for the customer database table.
 * 
 */

public class Customer implements Serializable, RestResource
{
	public Customer(int id, String email, int level, String name, String password) {
		this.id = id;
		this.email = email;
		this.level = level;
		this.name = name;
		this.password = password;
	}

	public Customer() {
	}

	private static final long serialVersionUID = 1L;

	public static final RestAccessLevel ACCESS = new RestAccessLevel(2,2);

	
	private int id;

	private String avatar;

	private String email;

	private int level;

	private String name;

	private String password;


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String[] exportFields() 
	{
		return "id,name,level".split(",");
	}

	@Override
	public RestAccessLevel getAccessLevel() 
	{
		return ACCESS;
	}


}