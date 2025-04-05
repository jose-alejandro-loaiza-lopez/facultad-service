package co.empresa.facultadservice.domain.service;

import co.empresa.facultadservice.domain.model.Facultad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface que define los métodos que se pueden realizar sobre la entidad Facultad
 */
public interface IFacultadService {
    Facultad save(Facultad facultad);
    void delete(Facultad facultad);
    Optional<Facultad> findById(Long id);
    Facultad update(Facultad facultad);
    List<Facultad> findAll();
    Page<Facultad> findAll(Pageable pageable);
}
