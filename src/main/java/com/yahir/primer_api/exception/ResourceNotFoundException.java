package com.yahir.primer_api.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
