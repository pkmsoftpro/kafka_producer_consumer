package com.model;
import com.enums.Color;
import com.enums.DesignType;
import com.enums.ProductType;
import com.enums.UserId;
import com.github.javafaker.Faker;

public class EventGenerator {

	private Faker faker = new Faker();
	
	public Event generateEvent() {
		return Event.builder()
				.user(generateRandomUser())
				.product(generateRandomObject())
				.build();
	}

	private User generateRandomUser() {
		return User.builder()
				.userId(faker.options().option(UserId.class))
				.username(faker.name().lastName())
				.build();
	}

	private Product generateRandomObject() {
		return Product.builder()
				.color(faker.options().option(Color.class))
				.type(faker.options().option(ProductType.class))
				.designType(faker.options().option(DesignType.class))
				.build();
	}
}
