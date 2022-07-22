package factory;

//Design Patterns
//Factory - centralize objection creation
//Decouples component
//Loose coupling - Objects aren't highly dependent
public class BeanFactory {
	//create a bean
	public static Bean createBean(String type) {
		switch(type) {
		case "java": 
			return new JavaBean();
		case "coffee": 
			return new CoffeeBean();
		default: return new JavaBean();
		}
			
	}
}
