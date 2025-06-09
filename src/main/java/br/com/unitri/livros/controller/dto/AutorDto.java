package br.com.unitri.livros.controller.dto;

import br.com.unitri.livros.modelo.Autor;

import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

    private Long id;
    private String nome;
    private int idade;
    private String biografia;
    private List<LivroDto> livros;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.idade = autor.getIdade();
        this.biografia = autor.getBiografia();
        this.livros = LivroDto.converter(autor.getLivros());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public static List<AutorDto> converter(List<Autor> autores) {
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
    }
}
