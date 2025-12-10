package com.example.biblo.application.services;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
