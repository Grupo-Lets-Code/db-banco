package br.com.letscode.dbbanco.exception;

public class ClienteJaCadastradoException extends RuntimeException{
    public ClienteJaCadastradoException(){
        super("Cliente já foi cadastrado no banco!");
    }
}
