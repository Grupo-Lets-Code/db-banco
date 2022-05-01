package br.com.letscode.dbbanco.exception;

public class ClienteDuplicadoException extends  RuntimeException{

        public ClienteDuplicadoException (){
            super("Cliente Já Existe");
        }

}
