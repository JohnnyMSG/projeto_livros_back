package br.com.unitri.livros.controller;

import br.com.unitri.livros.controller.dto.LivroDto;
import br.com.unitri.livros.controller.form.LivroForm;
import br.com.unitri.livros.modelo.Livro;
import br.com.unitri.livros.repository.AutorRepository;
import br.com.unitri.livros.repository.AvaliacaoRepository;
import br.com.unitri.livros.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<LivroDto> listarLivros() {
        return LivroDto.converter(livroRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody @Validated LivroForm livroForm,
                                                   UriComponentsBuilder uriComponentsBuilder) {
        Livro livro = livroForm.converter(autorRepository);
        livroRepository.save(livro);

        URI uri = uriComponentsBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDto(livro));
    }

    @GetMapping("/{id}")
    public LivroDto leitura(@PathVariable("id") Long id) {
        Livro livro = livroRepository.getReferenceById(id);

        return new LivroDto(livro);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LivroDto> atualizar(@PathVariable("id") Long id, @RequestBody @Validated LivroForm livroForm) {
       Livro livro = livroForm.atualizar(id, livroRepository, autorRepository, avaliacaoRepository);

        return ResponseEntity.ok(new LivroDto(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
