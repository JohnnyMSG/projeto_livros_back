package br.com.unitri.livros.repository;

import br.com.unitri.livros.modelo.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
