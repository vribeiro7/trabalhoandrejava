package trabalhoandre.alunoapp.model;

public enum Genero {
    MASCULINO ("Masculino"),
    FEMININO("Feminino"),
    PREFIRO_NAO_DIZER("Prefiro não dizer");

    private String nomeGenero;

    Genero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }
}
