package factory;

public class JavaBean implements Bean{

	@Override //annotation (meta data)
	public void go() {
		System.out.println("JavaBean");
		
	}

}
