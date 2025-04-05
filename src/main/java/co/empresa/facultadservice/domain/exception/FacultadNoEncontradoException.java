package co.empresa.facultadservice.domain.exception;

public class FacultadNoEncontradoException extends RuntimeException {
    public FacultadNoEncontradoException(Long id) {
        super("La facultad con ID " + id + " no fue encontrado.");
    }
}