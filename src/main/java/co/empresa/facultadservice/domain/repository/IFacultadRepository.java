package co.empresa.facultadservice.domain.repository;

import co.empresa.facultadservice.domain.model.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que hereda de JpaRepository para realizar las
 * operaciones de CRUD paginacion y ordenamiento sobre la entidad Producto
 */
public interface IFacultadRepository extends JpaRepository<Facultad, Long> {
}
