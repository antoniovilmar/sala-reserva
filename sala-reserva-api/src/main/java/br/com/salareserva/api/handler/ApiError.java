package br.com.salareserva.api.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApiError {

  private List<String> mensagens;

  public ApiError(List<String> mensagens) {
    this.mensagens = mensagens;
  }

  public ApiError(String mensagem) {
    this.mensagens = Arrays.stream(mensagem.split(" \n ")).collect(Collectors.toList());
  }

  public List<String> getMensagens() {
    return mensagens;
  }

}
