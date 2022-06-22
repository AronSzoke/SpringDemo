package aron.szoke.spring_demo.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @Value("${app.isThrowableValid:false}")
    private boolean isThrowableValid;

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
            ApiException apiException =  isThrowableValid ?
                    new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now()) :
                    new ApiExceptionWithoutThrowable(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now());
            System.out.println("app.isThrowableValid: " + isThrowableValid);
            System.out.println("class: " + apiException.getClass());
            return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(NotFoundException e){
        ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<Object>(apiException, HttpStatus.NOT_FOUND);
    }


}
