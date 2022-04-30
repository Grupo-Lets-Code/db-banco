package br.com.letscode.dbbanco.exception;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException(){
        super("Cliente nao encontrado");
    }
}
