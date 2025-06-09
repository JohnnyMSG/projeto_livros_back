package br.com.unitri.livros.repository;

import br.com.unitri.livros.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNome(String nome);

}
