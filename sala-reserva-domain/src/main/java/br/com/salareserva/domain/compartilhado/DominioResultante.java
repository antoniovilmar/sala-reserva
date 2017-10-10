package br.com.salareserva.domain.compartilhado;

import java.util.function.Supplier;

public class DominioResultante<T>{

    private DominioResultanteBase _resultadoBase;
    private T objeto;

    public Boolean sucesso(){
        return _resultadoBase.sucesso;
    }
//    public string MensagemDeErro => _resultadoBase.MensagemDeErro;
    public String mensagemDeErro()
    {
        return "";
    }
//    public T Objeto { get; private set; }
//
    public DominioResultante()
    {
        //_resultadoBase = new DominioResultanteBase(false, "");
    }

    public DominioResultante<T> construir(Supplier<T> map) {
        this.objeto = map.get();
        return this;
    }

    public DominioResultante<T> GarantirQue(Supplier<Boolean> predicado, String mensagemDeErro){
        if(!predicado.get()){
            return registrarInconsistencia(mensagemDeErro);
        }
        return this;
    }

    private DominioResultante<T> registrarInconsistencia(String mensagemDeErro) {
    }

    public T getObjeto() {
        return objeto;
    }


    //
//    internal DominioResultante(bool temFalha, T objeto, string mensagemDeErro)
//    {
//        _resultadoBase = new DominioResultanteBase(temFalha, mensagemDeErro);
//        Objeto = objeto;
//    }
//
//    private DominioResultante<T> RegistrarFalha(string mensagemDeErro)
//    {
//        return new DominioResultante<T>(true, default(T), mensagemDeErro);
//    }
//
//    private DominioResultante<T> RegistrarSucesso(T value)
//    {
//        return new DominioResultante<T>(false, value, "");
//    }
//
//    public DominioResultante<T> GarantirQue(Func<bool> predicate, string mensagemDeErro)
//    {
//        //if (!predicate())
//            //return RegistrarFalha(mensagemDeErro);
//
//        return this;
//    }

//    public DominioResultante<T> Mapear(/*Func<T> map*/)
//    {
////        if (Sucesso)
////            Objeto = map();
//
//        return this;
//    }

//
//    public static implicit operator DominioResultante(DominioResultante<T> resultado)
//    {
//        if (resultado.Sucesso)
//            return DominioResultante.Ok();
//        else
//            return DominioResultante.RegistrarFalha(resultado.MensagemDeErro);
//    }

}
