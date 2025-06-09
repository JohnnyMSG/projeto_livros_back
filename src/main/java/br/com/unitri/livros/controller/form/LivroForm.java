package br.com.unitri.livros.controller.form;

import br.com.unitri.livros.enums.Genero;
import br.com.unitri.livros.modelo.Autor;
import br.com.unitri.livros.modelo.Livro;
import br.com.unitri.livros.repository.AutorRepository;
import br.com.unitri.livros.repository.AvaliacaoRepository;
import br.com.unitri.livros.repository.LivroRepository;
import org.hibernate.annotations.NotFound;

public class LivroForm {

    @NotFound
    private String titulo;
    @NotFound
    private String nomeAutor;
    @NotFound
    private Genero genero;
    @NotFound
    private String sinopse;

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

    public Livro converter(AutorRepository autorRepository) {
        Autor autor = autorRepository.findByNome(nomeAutor);

        return new Livro(titulo, autor, genero, sinopse);
    }

    public Livro atualizar(Long id, LivroRepository livroRepository, AutorRepository autorRepository, AvaliacaoRepository avaliacaoRepository) {
        Autor autor = autorRepository.findByNome(nomeAutor);
        Livro livro = livroRepository.getReferenceById(id);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setSinopse(sinopse);
        livro.setTitulo(titulo);

        return livro;
    }

}
