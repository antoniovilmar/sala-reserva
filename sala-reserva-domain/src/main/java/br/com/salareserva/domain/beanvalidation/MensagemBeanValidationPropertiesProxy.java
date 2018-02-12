package br.com.salareserva.domain.beanvalidation;

import org.springframework.context.support.MessageSourceResourceBundle;

import java.util.ResourceBundle;

public class MensagemBeanValidationPropertiesProxy {

    private static final String properties = "ValidationMessages";
    private static final ResourceBundle bundle = MessageSourceResourceBundle.getBundle(properties);

    private MensagemBeanValidationPropertiesProxy() {
    }

    public static String getMensagem(MensagemBeanValidationPropertiesEnum propertiesEnum){
        return bundle.getString(propertiesEnum.getChave());
    }


}
