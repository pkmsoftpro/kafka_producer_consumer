package com.model;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enums.Color;
import com.enums.DesignType;
import com.enums.ProductType;

public class SuggestionEngine {
	
	final Logger logger = LoggerFactory.getLogger(SuggestionEngine.class);

	private UserDB userDB = new UserDB();
	
	public void processSuggestions(String product, String userId) {
		String[] valueSplit = product.split(",");
		String productType = valueSplit[0];
		String productColor = valueSplit.length<2?"***EmptyString*": valueSplit[1];
		String productDesign = valueSplit.length<3?"***EmptyString2*": valueSplit[2];
		
		
		
		logger.info("user with Id: " + userId + " showed interest over " + productType + " of color " + productColor + " and design " + productDesign);
		
		User user = userDB.findById(userId);
		
		user.getPreferences().add(new PreferredProduct(Color.valueOf(productColor), ProductType.valueOf(productType),
				DesignType.valueOf(productDesign)));
		
		user.setSuggestions(generateSuggestions(user.getPreferences()));
		
		userDB.save(user);
	}
	
	private List<String> generateSuggestions(List<PreferredProduct> preferences) {
		return Arrays.asList("Tshirt,BLUE","Design,RED,Rocket", "Tshirt,YELLOW,car");
	}
	
	
}
