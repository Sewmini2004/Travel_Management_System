package lk.ijse.springboot.userService.bo.exception;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String message){
        super(message);
    }
}
