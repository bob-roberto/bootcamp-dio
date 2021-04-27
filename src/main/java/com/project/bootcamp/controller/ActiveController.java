package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.ActiveDTO;
import com.project.bootcamp.service.ActiveService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/active")
public class ActiveController {

    @Autowired
    private ActiveService service;

    @ApiOperation(value = "Save active in the database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> save(@Valid @RequestBody ActiveDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @ApiOperation(value = "Change active in the database")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> update(@Valid @RequestBody ActiveDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @ApiOperation(value = "Delete active in the database")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @ApiOperation(value = "Find all actives in the database")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActiveDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation(value = "Find active by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActiveDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @ApiOperation(value = "Find actives by current date")
    @GetMapping(value = "/find-by-current-date", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActiveDTO>> findByCurrentDate() {
        return ResponseEntity.ok(service.findByCurrentDate());
    }


}
