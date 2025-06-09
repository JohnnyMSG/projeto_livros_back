package br.com.unitri.livros.controller.dto;

import br.com.unitri.livros.modelo.Avaliacao;
import br.com.unitri.livros.modelo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoDto {

    private Long id;
    private Integer nota;
    private String titulo;
    private String comentario;
    private String livroTitulo;

    public AvaliacaoDto(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.nota = avaliacao.getNota();
        this.titulo = avaliacao.getTitulo();
        this.comentario = avaliacao.getComentario();
        this.livroTitulo = avaliacao.getLivro().getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLivroTitulo() {
        return livroTitulo;
    }

    public void setLivroTitulo(String livroTitulo) {
        this.livroTitulo = livroTitulo;
    }

    public static List<AvaliacaoDto> converter(List<Avaliacao> avaliacaos) {
        return avaliacaos.stream().map(AvaliacaoDto::new).collect(Collectors.toList());
    }
}
