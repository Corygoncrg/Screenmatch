package br.com.Alura.Screenmatch.Service;

public interface IConvertData {
    <T> T getData(String json, Class<T> tClass);
}
