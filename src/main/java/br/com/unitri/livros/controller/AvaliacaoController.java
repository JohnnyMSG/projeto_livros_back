package br.com.unitri.livros.controller;

import br.com.unitri.livros.controller.dto.AvaliacaoDto;
import br.com.unitri.livros.controller.form.AvaliacaoForm;
import br.com.unitri.livros.modelo.Avaliacao;
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
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<AvaliacaoDto> listarAvaliacoes() {
        return AvaliacaoDto.converter(avaliacaoRepository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AvaliacaoDto> cadastrarAvaliacao(@RequestBody @Validated AvaliacaoForm avaliacaoForm,
                                                           UriComponentsBuilder uriBuilder) {
        Avaliacao avaliacao = avaliacaoForm.converter(livroRepository);
        avaliacaoRepository.save(avaliacao);

        URI uri = uriBuilder.path("/avaliacoes/{id}").buildAndExpand(avaliacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new AvaliacaoDto(avaliacao));
    }

    @GetMapping("/{id}")
    public AvaliacaoDto leitura(@PathVariable("id") Long id) {
        Avaliacao avaliacao = avaliacaoRepository.getReferenceById(id);

        return new AvaliacaoDto(avaliacao);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AvaliacaoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Validated AvaliacaoForm avaliacaoForm) {
        Avaliacao avaliacao = avaliacaoForm.atualizar(id, avaliacaoRepository, livroRepository);

        return ResponseEntity.ok(new AvaliacaoDto(avaliacao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        avaliacaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
