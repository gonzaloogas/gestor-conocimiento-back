package com.getronics.gestor_conocimiento_back.exception;

public class ClienteNotFoundException extends Exception{
    public ClienteNotFoundException(String msjError) {
        super(msjError);
    }
}
