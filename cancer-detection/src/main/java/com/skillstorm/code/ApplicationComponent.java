package com.skillstorm.code;

/*
 * This class checks if you're old enough to purchase restricted items.
 * 
 * Code Convention = compile, and follows good practices
 * 
 * Linter- SonarLint plugin (sonarqube)
 */
public class ApplicationComponent {
	public boolean checkId(int age) {
		if (age< 0 ) {
			throw new IllegalArgumentException("You haven't been born yet."); // doesnt need text in ()
		}
		if (age < 18) {
			return false;
		}else {
			return true;
		}
	}

	//TDD - Write Actual Code Second
	public boolean checkId(int age, String item) {
		//  stub
		switch(item) {
			case "beer":{
				return age >=21;
			}
			case "lottery":{
				return age <18;
			}
			default:
				return false;
		}
	}
}
