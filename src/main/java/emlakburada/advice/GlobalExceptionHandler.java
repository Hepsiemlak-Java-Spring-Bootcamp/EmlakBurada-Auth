package emlakburada.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import emlakburada.exception.UserNotFoundException;
import emlakburada.exception.UserPasswordNotValidException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(UserNotFoundException exception) {
		log.error("user not found error occured." + exception.getMessage());
		ErrorResponse response = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ExceptionHandler(UserPasswordNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(UserPasswordNotValidException exception) {
		log.error("user not found error occured." + exception.getMessage());
		ErrorResponse response = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
