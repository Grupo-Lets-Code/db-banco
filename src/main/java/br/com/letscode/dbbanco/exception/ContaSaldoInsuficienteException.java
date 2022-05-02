package br.com.letscode.dbbanco.exception;

public class ContaSaldoInsuficienteException extends RuntimeException {
    public ContaSaldoInsuficienteException(){
        super("Saldo insuficiente para a operação");
    }
}
