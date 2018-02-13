package br.com.salareserva.api.handler;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerValidationHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ApiError processValidationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();

    List<String> erros = result
        .getAllErrors()
        .stream()
        .map(error -> {
          FieldError fieldError = (FieldError) error;
          return fieldError.getField() + ": " + fieldError.getDefaultMessage();
        })
        .collect(Collectors.toList());

    return new ApiError(erros);
  }
}
