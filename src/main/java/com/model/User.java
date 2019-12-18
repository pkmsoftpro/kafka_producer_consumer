package com.model;

import java.util.List;

import com.enums.UserId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private UserId userId;
	private String username;
	
	private List<PreferredProduct> preferences;
	private List<String> suggestions;
}
