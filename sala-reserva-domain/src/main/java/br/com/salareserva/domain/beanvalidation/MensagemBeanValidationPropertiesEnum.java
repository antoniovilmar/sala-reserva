package br.com.salareserva.domain.beanvalidation;

public enum MensagemBeanValidationPropertiesEnum {

    SALA_OCUPADA_NO_PERIODO("salaOcupadaNoPeriodo.message");

    private String chave;

    MensagemBeanValidationPropertiesEnum(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }
}
