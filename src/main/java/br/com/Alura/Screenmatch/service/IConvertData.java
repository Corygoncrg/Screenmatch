package br.com.Alura.Screenmatch.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> tClass);
}
