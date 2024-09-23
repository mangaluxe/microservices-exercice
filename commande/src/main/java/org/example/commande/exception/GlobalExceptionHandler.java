package org.example.commande.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;


@ControllerAdvice // Pour gérer les exceptions
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementException exception) {
        return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
    }

}
