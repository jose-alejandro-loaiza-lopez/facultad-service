package co.empresa.facultadservice.domain.service;

import co.empresa.facultadservice.domain.model.Facultad;
import co.empresa.facultadservice.domain.repository.IFacultadRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa los métodos de la interfaz IFacultadService
 * para realizar las operaciones de negocio sobre la entidad Facultad
 */
@Service
public class FacultadServiceImpl implements IFacultadService {

    private final IFacultadRepository facultadRepository;

    public FacultadServiceImpl(IFacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @Override
    @Transactional
    public Facultad save(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    @Transactional
    public void delete(Facultad facultad) {
        facultadRepository.delete(facultad);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Facultad> findById(Long id) {
        return facultadRepository.findById(id);
    }

    @Override
    @Transactional
    public Facultad update(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Facultad> findAll() {
        return facultadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Facultad> findAll(Pageable pageable) {
        return facultadRepository.findAll(pageable);
    }
}
