package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.exception.ContaAutenticacaoException;
import br.com.letscode.dbbanco.exception.ContaInvalidaException;
import br.com.letscode.dbbanco.exception.ContaNaoEncontradoException;
import br.com.letscode.dbbanco.exception.ContaSaldoInsuficienteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TransacaoAdvice {
    private final Logger LOGGER = LoggerFactory.getLogger(TransacaoAdvice.class);

    @ExceptionHandler
    public ResponseEntity tratarContaNaoEncontrada(ContaNaoEncontradoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarContaAutenticacao(ContaAutenticacaoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        return response;
    }
    @ExceptionHandler
    public ResponseEntity tratarContaInvalida(ContaInvalidaException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarContaSaldoInsuficiente(ContaSaldoInsuficienteException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarRestricoesBean(MethodArgumentNotValidException e){
        Map<String, String> erros = new HashMap<>();

        for (int indice = 0; indice < e.getBindingResult().getAllErrors().size(); indice++){

            String fieldName =  ((FieldError) e.getBindingResult().getAllErrors().get(indice)).getField();
            String errorMessage = ((FieldError) e.getBindingResult().getAllErrors().get(indice)).getDefaultMessage();
            String erroFormatado = String.format("Erro no campo %s : %s",fieldName,errorMessage);
            erros.put(String.format("Erro %s ",indice ), String.format("Erro no campo %s : %s",fieldName,errorMessage));
            LOGGER.debug(erroFormatado);
        }


        return new ResponseEntity(erros, HttpStatus.BAD_REQUEST);
    }
}