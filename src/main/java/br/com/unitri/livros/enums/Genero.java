package br.com.unitri.livros.enums;

public enum Genero {
    ROMANCE("Romance"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    FANTASIA("Fantasia"),
    TERROR("Terror / Horror"),
    SUSPENSE("Suspense / Thriller"),
    DRAMA("Drama"),
    POLICIAL("Romance Policial / Mistério"),
    BIOGRAFIA("Biografia / Autobiografia"),
    NAO_FICCAO("Não Ficção"),
    AUTOAJUDA("Autoajuda / Desenvolvimento Pessoal");

    private final String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
