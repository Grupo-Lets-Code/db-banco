package br.com.letscode.dbbanco.exception;

public class ContaInvalidaException extends RuntimeException {
    public ContaInvalidaException(){
        super("Conta inválida para a operação solicitada");
    }
}
