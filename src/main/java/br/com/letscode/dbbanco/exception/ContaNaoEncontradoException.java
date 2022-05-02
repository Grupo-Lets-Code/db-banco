package br.com.letscode.dbbanco.exception;

public class ContaNaoEncontradoException extends RuntimeException{
    public ContaNaoEncontradoException(){
        super("Conta nao encontrada");
    }
}