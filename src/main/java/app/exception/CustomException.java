package app.exception;

public class CustomException extends RuntimeException {

    private String message ;

    public static void throwExceptio(String msg){
        CustomException c = new CustomException();
        c.setMessage(msg);
        throw c ;
    }

    private CustomException(){

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
