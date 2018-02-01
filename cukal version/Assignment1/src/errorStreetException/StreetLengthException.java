package errorStreetException;

public class StreetLengthException extends Exception{
	
		
		public StreetLengthException(String message){
			super(message);
		};

		public StreetLengthException() throws StreetLengthException{	
			throw new StreetLengthException("No road left for the car to move");
		}
		
		public String toString(){	
			return "No road left for the car to move";
			
		}
	}


