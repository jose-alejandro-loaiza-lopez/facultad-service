package co.empresa.facultadservice.domain.exception;

public class FacultadExistenteException extends RuntimeException {
    public FacultadExistenteException(String nombre) {
        super("La facultad con nombre '" + nombre + "' ya existe.");
    }
}
