package com.example.demo.controller;


import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    final EstudianteRepository estudianteRepository;

    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    //LISTAR
    @GetMapping(value = {"/list", ""})
    public List<Estudiante> listaEstudiante() {
        return estudianteRepository.findAll();
    }

    //OBTENER
    @GetMapping(value = "/{id}")
    public ResponseEntity<HashMap<String, Object>> buscarestudianteo(@PathVariable("id") String idStr) {


        try {
            int id = Integer.parseInt(idStr);
            Optional<Estudiante> byId = estudianteRepository.findById(id);

            HashMap<String, Object> respuesta = new HashMap<>();

            if (byId.isPresent()) {
                respuesta.put("result", "ok");
                respuesta.put("estudianteo", byId.get());
            } else {
                respuesta.put("result", "no existe");
            }
            return ResponseEntity.ok(respuesta);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // CREAR /estudiante y /estudiante/
    @PostMapping(value = {"", "/"})
    public ResponseEntity<HashMap<String, Object>> guardarEstudiante(
            @RequestBody Estudiante estudiante,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        estudianteRepository.save(estudiante);
        if (fetchId) {
            responseJson.put("id", estudiante.getId());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }

    // ACTUALIZAR
    @PutMapping(value = {"", "/"}, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> actualizar(Estudiante estudiante) {

        HashMap<String, Object> rpta = new HashMap<>();

        if (estudiante.getId() != null && estudiante.getId() > 0) {

            Optional<Estudiante> byId = estudianteRepository.findById(estudiante.getId());
            if (byId.isPresent()) {
                Estudiante estudianteFromDb = byId.get();

                if (estudiante.getNombres() != null)
                    estudianteFromDb.setNombres(estudiante.getNombres());

                if (estudiante.getApellidos() != null)
                    estudianteFromDb.setApellidos(estudiante.getApellidos());

                if (estudiante.getDni() != null)
                    estudianteFromDb.setDni(estudiante.getDni());

                if (estudiante.getCodigoPucp() != null)
                    estudianteFromDb.setCodigoPucp(estudiante.getCodigoPucp());

                if (estudiante.getFechaDeNacimiento() != null)
                    estudianteFromDb.setFechaDeNacimiento(estudiante.getFechaDeNacimiento());

                if (estudiante.getSexo() != null)
                    estudianteFromDb.setSexo(estudiante.getSexo());

                if (estudiante.getCorreoInstitucional() != null)
                    estudianteFromDb.setDni(estudiante.getCorreoInstitucional());

                if (estudiante.getCorreoPersonal() != null)
                    estudianteFromDb.setCorreoPersonal(estudiante.getCorreoPersonal());

                if (estudiante.getTelefono() != null)
                    estudianteFromDb.setTelefono(estudiante.getTelefono());

                if (estudiante.getDireccion() != null)
                    estudianteFromDb.setDireccion(estudiante.getDireccion());

                if(estudiante.getDepartamento() != null)
                    estudianteFromDb.setDepartamento(estudiante.getDepartamento());

                if (estudiante.getProvincia() != null)
                    estudianteFromDb.setProvincia(estudiante.getProvincia());

                if (estudiante.getCarrera() != null)
                    estudianteFromDb.setCarrera(estudiante.getCarrera());

                //Nada
                //if (estudiante.getFechaDeRegistro() != null)
                //    estudianteFromDb.setFechaDeRegistro(estudiante.getFechaDeRegistro());

                if (estudiante.getUltimaActualizacion() != null)
                    estudianteFromDb.setUltimaActualizacion(estudiante.getUltimaActualizacion());

                if (estudiante.getEstado() != null)
                    estudianteFromDb.setEstado(estudiante.getEstado());

                estudianteRepository.save(estudianteFromDb);
                rpta.put("result", "ok");
                return ResponseEntity.ok(rpta);
            } else {
                rpta.put("result", "error");
                rpta.put("msg", "El ID del estudiante enviado no existe");
                return ResponseEntity.badRequest().body(rpta);
            }
        } else {
            rpta.put("result", "error");
            rpta.put("msg", "debe enviar un estudiante con ID");
            return ResponseEntity.badRequest().body(rpta);
        }
    }

    // /estudiante?id
    @DeleteMapping("")
    public ResponseEntity<HashMap<String, Object>> borrar(@RequestParam("id") String idStr){

        try{
            int id = Integer.parseInt(idStr);

            HashMap<String, Object> rpta = new HashMap<>();

            Optional<Estudiante> byId = estudianteRepository.findById(id);
            if(byId.isPresent()){
                estudianteRepository.deleteById(id);
                rpta.put("result","ok");
            }else{
                rpta.put("result","no ok");
                rpta.put("msg","el ID enviado no existe");
            }

            return ResponseEntity.ok(rpta);
        }catch (NumberFormatException e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}