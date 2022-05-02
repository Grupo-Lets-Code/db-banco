package br.com.letscode.dbbanco.exception;

public class ContaExistenteException extends RuntimeException{
    public ContaExistenteException(){
        super("Conta já Existe na Base de Dados");
    }
}
