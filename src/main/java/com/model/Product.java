package com.model;

import com.enums.Color;
import com.enums.DesignType;
import com.enums.ProductType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private Color color;
	private ProductType type;
	private DesignType designType;
}
