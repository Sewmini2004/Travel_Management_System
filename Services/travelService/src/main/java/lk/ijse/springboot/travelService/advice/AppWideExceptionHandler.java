package lk.ijse.springboot.travelService.advice;

import lk.ijse.springboot.travelService.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin

public class AppWideExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception e) {
        return new ResponseEntity(new ResponseUtil(500, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
}
}