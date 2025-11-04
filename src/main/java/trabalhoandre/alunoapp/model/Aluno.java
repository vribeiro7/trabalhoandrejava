package trabalhoandre.alunoapp.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

    @Column
    private String nome;

    @Column
    private String serie;

    @Column
    private String texto;

    @Column
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSerie() {
        return serie;
    }

    public String getTexto() {
        return texto;
    }

    public Genero getGenero() {
        return genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
