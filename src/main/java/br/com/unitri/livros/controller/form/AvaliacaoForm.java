package br.com.unitri.livros.controller.form;

import br.com.unitri.livros.modelo.Avaliacao;
import br.com.unitri.livros.modelo.Livro;
import br.com.unitri.livros.repository.AvaliacaoRepository;
import br.com.unitri.livros.repository.LivroRepository;
import org.hibernate.annotations.NotFound;

public class AvaliacaoForm {

    @NotFound
    private int nota;
    @NotFound
    private String titulo;
    @NotFound
    private String comentario;
    @NotFound
    private String livroTitulo;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
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

    public Avaliacao converter(LivroRepository livroRepository) {
        Livro livro = livroRepository.findByTitulo(livroTitulo);

        return new Avaliacao(nota, titulo, comentario, livro);
    }

    public Avaliacao atualizar(Long id, AvaliacaoRepository avaliacaoRepository, LivroRepository livroRepository) {
        Livro livro = livroRepository.findByTitulo(livroTitulo);
        Avaliacao avaliacao = avaliacaoRepository.getReferenceById(id);
        avaliacao.setNota(nota);
        avaliacao.setTitulo(titulo);
        avaliacao.setComentario(comentario);
        avaliacao.setLivro(livro);

        return avaliacao;
    }

}
