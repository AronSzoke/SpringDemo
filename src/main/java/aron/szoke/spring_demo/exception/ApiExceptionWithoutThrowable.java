package aron.szoke.spring_demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptionWithoutThrowable extends ApiException {

    @JsonIgnore
    private Throwable throwable;

    public ApiExceptionWithoutThrowable(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        super(message, throwable, httpStatus, zonedDateTime);
    }
}
