package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gilson on 17/08/15.
 */
@Entity
@Table(name = "paises")
public class Paises implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_pais", columnDefinition = "smallint not null")
    private Integer id;

    @Column(name = "nm_pais", nullable = false, length = 40)
    private String nome;

    @Column(name = "fl_continente", nullable = false)
    private Boolean continente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getContinente() {
        return continente;
    }

    public void setContinente(Boolean continente) {
        this.continente = continente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paises paises = (Paises) o;

        return !(id != null ? !id.equals(paises.id) : paises.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Paises{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", continente=" + continente +
                '}';
    }
}