package com.example.demorest.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demorest.model.Prestador;
import com.example.demorest.repository.PrestadorRepository;

@RestController
@RequestMapping("/prestadores") // 
public class PrestadorController {

    private final PrestadorRepository repository;

    public PrestadorController(PrestadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Prestador> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestador> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(prestador -> ResponseEntity.ok().body(prestador))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prestador create(@RequestBody Prestador prestador) {
        return repository.save(prestador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestador> update(@PathVariable Long id, @RequestBody Prestador prestador) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNome(prestador.getNome());
                    existing.setTelefone(prestador.getTelefone());
                    existing.setServico(prestador.getServico());
                    Prestador updated = repository.save(existing);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(prestador -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
