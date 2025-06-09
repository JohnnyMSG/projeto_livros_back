package br.com.unitri.livros.controller.form;

import br.com.unitri.livros.modelo.Autor;
import br.com.unitri.livros.repository.AutorRepository;
import org.hibernate.annotations.NotFound;

public class AutorForm {

    @NotFound
    private String nome;
    @NotFound
    private int idade;
    @NotFound
    private String biografia;

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

    public Autor converter() {
        return new Autor(nome, idade, biografia);
    }

    public Autor atualizar(Long id, AutorRepository autorRepository) {
        Autor autor = autorRepository.getReferenceById(id);
        autor.setNome(nome);
        autor.setIdade(idade);
        autor.setBiografia(biografia);

        return autor;
    }

}
