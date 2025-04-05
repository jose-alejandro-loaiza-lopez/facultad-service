package co.empresa.facultadservice.domain.exception;

public class NoHayFacultadException extends RuntimeException {
    public NoHayFacultadException() {
        super("No hay facultades en la base de datos.");
    }
}