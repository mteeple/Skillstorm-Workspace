package exceptions;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		try{ //risky calls that might fail
			skydive();
			System.out.println("Finished Dive");
		}catch(ChuteDidNotDeployException | PulledWrongChuteException e) {
			System.out.println("Pull Secondary Chute");
			//recovery process
		}catch (Exception e) {
			System.out.println("Default Catch");
		}catch(Throwable t) { //most default (superclass)
			
		}
		finally { //"Always executes" if exception is thrown or not thrown 
			//Network connections, filestreams, "resources" close using finally- Helps clean up resources basically
			System.out.println("Finally");
		}
	}
	//stackOverFlowError    OutOfMemoryError (error shouldn't be recovered)
	//exceptions are things you can recover from
	// SQLException   ConnectionException    FileNotFoundException
	static void skydive() throws ChuteDidNotDeployException, PulledWrongChuteException { //method declaration - this method MIGHT throw an exception
		if(Math.random()> 0.5) {
			System.out.println("deployed");
		}else {
			throw new ChuteDidNotDeployException(); //create exception object throw = HALT EXECUTION 
		}
	}
}
//checked exception --- domain-specific exception
class ChuteDidNotDeployException extends Exception {}
class PulledWrongChuteException extends Exception{}