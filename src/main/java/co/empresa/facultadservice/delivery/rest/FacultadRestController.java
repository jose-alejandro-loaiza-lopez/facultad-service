package co.empresa.facultadservice.delivery.rest;

import co.empresa.facultadservice.domain.exception.NoHayFacultadException;
import co.empresa.facultadservice.domain.exception.PaginaSinFacultadException;
import co.empresa.facultadservice.domain.exception.FacultadNoEncontradoException;
import co.empresa.facultadservice.domain.exception.ValidationException;
import co.empresa.facultadservice.domain.model.Facultad;
import co.empresa.facultadservice.domain.service.IFacultadService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/facultad-service")
public class FacultadRestController {

    private final IFacultadService facultadService;

    private static final String MENSAJE = "mensaje";
    private static final String FACULTAD = "facultad";
    private static final String FACULTADES = "facultades";

    public FacultadRestController(IFacultadService facultadService) {
        this.facultadService = facultadService;
    }

    /**
     * Listar todas las facultades.
     */
    @GetMapping("/facultads")
    public ResponseEntity<Map<String, Object>> getFacultades() {
        List<Facultad> facultades = facultadService.findAll();
        if (facultades.isEmpty()) {
            throw new NoHayFacultadException();
        }
        Map<String, Object> response = new HashMap<>();
        response.put(FACULTADES, facultades);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar facultades con paginación.
     */
    @GetMapping("/facultad/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Facultad> facultades = facultadService.findAll(pageable);
        if (facultades.isEmpty()) {
            throw new PaginaSinFacultadException(page);
        }
        return ResponseEntity.ok(facultades);
    }

    /**
     * Crear una nueva facultad.
     */
    @PostMapping("/facultads")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Facultad facultad, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        Map<String, Object> response = new HashMap<>();
        Facultad nuevaFacultad = facultadService.save(facultad);
        response.put(MENSAJE, "La facultad ha sido creada con éxito!");
        response.put(FACULTAD, nuevaFacultad);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Eliminar una facultad.
     */
    @DeleteMapping("/facultads")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Facultad facultad) {
        facultadService.findById(facultad.getId())
                .orElseThrow(() -> new FacultadNoEncontradoException(facultad.getId()));
        facultadService.delete(facultad);
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "La facultad ha sido eliminada con éxito!");
        response.put(FACULTAD, null);
        return ResponseEntity.ok(response);
    }

    /**
     * Actualizar una facultad.
     */
    @PutMapping("/facultads")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Facultad facultad, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        facultadService.findById(facultad.getId())
                .orElseThrow(() -> new FacultadNoEncontradoException(facultad.getId()));
        Map<String, Object> response = new HashMap<>();
        Facultad facultadActualizada = facultadService.update(facultad);
        response.put(MENSAJE, "La facultad ha sido actualizada con éxito!");
        response.put(FACULTAD, facultadActualizada);
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener una facultad por su ID.
     */
    @GetMapping("/facultads/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Facultad facultad = facultadService.findById(id)
                .orElseThrow(() -> new FacultadNoEncontradoException(id));
        Map<String, Object> response = new HashMap<>();
        response.put(MENSAJE, "La facultad ha sido encontrada con éxito!");
        response.put(FACULTAD, facultad);
        return ResponseEntity.ok(response);
    }
}
