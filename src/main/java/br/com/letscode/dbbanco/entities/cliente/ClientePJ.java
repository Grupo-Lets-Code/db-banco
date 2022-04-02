package br.com.letscode.dbbanco.entities.cliente;

public class ClientePJ extends Cliente {

    protected String CNPJ;

    public ClientePJ(String nome, String CNPJ) {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public String toString() {
        return "\nPessoa Jurídica" +
                "\nNome: " + this.getNome() +
                "\nCNPJ: " + this.getCNPJ();
    }
}
