package br.com.letscode.dbbanco.exception;

public class ContaAutenticacaoException extends RuntimeException {
    public ContaAutenticacaoException(){
        super("Número de conta ou senha inválidos");
    }
}
