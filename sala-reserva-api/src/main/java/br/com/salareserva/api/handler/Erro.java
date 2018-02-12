package br.com.salareserva.api.handler;

public class Erro {

    private String mensagem;

    protected Erro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
