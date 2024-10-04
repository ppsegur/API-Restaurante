package com.salesianostriana.dam.bar.controller;

import com.salesianostriana.dam.bar.model.Bar;
import com.salesianostriana.dam.bar.model.Tag;
import com.salesianostriana.dam.bar.repositorio.BarRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class BarControlador {

    private final BarRepositorio barRepositorio;

    @GetMapping("/")
    public ResponseEntity<List<Bar>> todos() {
        List<Bar> listado =  barRepositorio.findAll();

        if (listado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(listado);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> porId(@PathVariable  Long id) {
        return ResponseEntity.of(barRepositorio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Bar> crearNuevo(
            @RequestBody Bar bar) {

        return ResponseEntity
                //.status(201)
                .status(HttpStatus.CREATED)
                .body(barRepositorio.save(bar));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Bar> editarTodoMenosTags(
            @PathVariable Long id,
            @RequestBody Bar bar
    ) {

        return ResponseEntity.of(
               barRepositorio.findById(id)
                        .map(antiguo -> {
                            antiguo.setNombre(bar.getNombre());
                            antiguo.setDireccion(bar.getDireccion());
                            antiguo.setUrl(bar.getUrl());
                            antiguo.setLocalizacion(bar.getLocalizacion());
                            antiguo.setDescripcion(bar.getDescripcion());
                            return barRepositorio.save(antiguo);
                        })
        );


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(
            @PathVariable Long id
    ) {
        if (barRepositorio.existsById(id))
            barRepositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/tag/add/{nuevo}")
    public ResponseEntity<Bar> addTag(
            @PathVariable Long id,
            @PathVariable List<Tag> nuevo
    ) {
        return ResponseEntity.of(
                barRepositorio.findById(id)
                        .map(bar -> {
                            if (!bar.getTags().contains(nuevo)) {
                                bar.setTags(bar.getTags() + ", " + nuevo);
                                return barRepositorio.save(bar);
                            }

                            return bar;
                        })
        );


    }


    }
