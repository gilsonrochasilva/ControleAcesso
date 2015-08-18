package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gilson on 18/08/15.
 */
@Entity
@Table(name = "modulos")
public class Modulos implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_modulo", columnDefinition = "smallint not null")
    private Integer id;

    @Column(name = "nm_sigla", nullable = false, length = 4, unique = true)
    private String sigla;

    @Column(name = "nm_modulo", nullable = false, length = 40)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modulos modulos = (Modulos) o;

        return !(id != null ? !id.equals(modulos.id) : modulos.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Modulos{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
