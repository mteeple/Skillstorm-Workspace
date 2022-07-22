package factory;

public class Customer {
	public void consumeBean(String type) {
		//tightly coupled
		//JavaBean bean = new JavaBean();
		
		//interface reference
		Bean bean = BeanFactory.createBean(type);
		bean.go();
	}
	//java Customer coffee
	//args set in run configuration
	public static void main(String[] args) {
		new Customer().consumeBean(args[0]);
		
	}
}
