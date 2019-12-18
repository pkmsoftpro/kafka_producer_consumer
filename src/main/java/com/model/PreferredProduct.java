package com.model;

import com.enums.Color;
import com.enums.DesignType;
import com.enums.ProductType;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PreferredProduct {

	private Color color;
	private ProductType type;
	private DesignType designType;
	
	public PreferredProduct(Color color, ProductType type, DesignType designType) {
		super();
		this.color = color;
		this.type = type;
		this.designType = designType;
	}
	
	
}