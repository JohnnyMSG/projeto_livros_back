package br.com.unitri.livros.controller.dto;

import br.com.unitri.livros.enums.Genero;
import br.com.unitri.livros.modelo.Autor;
import br.com.unitri.livros.modelo.Avaliacao;
import br.com.unitri.livros.modelo.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

    private Long id;
    private String titulo;
    private String nomeAutor;
    private Genero genero;
    private String sinopse;
    private List<Avaliacao> avaliacaos = new ArrayList<>();

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getAutor().getNome();
        this.genero = livro.getGenero();
        this.sinopse = livro.getSinopse();
        this.avaliacaos = livro.getAvaliacoes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public List<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(List<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}
