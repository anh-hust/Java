package BackEnd_Project;

public class ValueNotAvailableInDatabase extends Exception{
    public ValueNotAvailableInDatabase(String errorMessage){
        super(errorMessage);
    }
}
