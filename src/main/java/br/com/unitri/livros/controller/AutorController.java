package br.com.unitri.livros.controller;

import br.com.unitri.livros.controller.dto.AutorDto;
import br.com.unitri.livros.controller.form.AutorForm;
import br.com.unitri.livros.modelo.Autor;
import br.com.unitri.livros.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<AutorDto> listarAutores() {
        return AutorDto.converter(autorRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Validated AutorForm autorForm,
                                                   UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorForm.converter();
        autorRepository.save(autor);

        URI uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDto(autor));
    }

    @GetMapping("/{id}")
    public AutorDto leitura(@PathVariable("id") Long id) {
        Autor autor = autorRepository.getReferenceById(id);

        return new AutorDto(autor);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AutorDto> atualizar(@PathVariable("id") Long id, @RequestBody @Validated AutorForm autorForm) {
        Autor autor = autorForm.atualizar(id, autorRepository);

        return ResponseEntity.ok(new AutorDto(autor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
