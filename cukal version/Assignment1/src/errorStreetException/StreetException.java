package errorStreetException;

public class StreetException extends Exception{
	
		
		public StreetException(String message){
			super(message);
		};

		public StreetException() throws StreetException{	
			throw new StreetException("No road left for the car to move");
		}
	}


