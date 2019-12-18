package com.model;

import java.util.ArrayList;
import java.util.List;

import com.enums.Color;
import com.enums.DesignType;
import com.enums.ProductType;
import com.enums.UserId;

public class UserDB {
	
	List<PreferredProduct> preferences = new ArrayList<PreferredProduct>();
	List<String> suggestions = new ArrayList<String>();
	List<User> list = new ArrayList<User>();

	public User findById(String userId) {
		preferences.add(new PreferredProduct(Color.BLUE, ProductType.TYPE1, DesignType.TSHIRT));
		User user = null;
		
		list.add(new User(UserId.CBA321, "Sam", preferences, suggestions));
		list.add(new User(UserId.CBA123, "Tom", preferences, suggestions));
		
		for(User u : list) {
			if(u.getUserId().toString().equals(userId)) {
				user = u;
				break;
			}
		}
		/*User user = (User) list.stream().filter(e->e.getUserId().toString().equals(userId));
		return (User) list.stream().filter(e->e.getUserId().toString().equals(userId));*/
		return user;
	}

	public void save(User user) {
		list.add(user);
		System.out.println(list);
	}

}
