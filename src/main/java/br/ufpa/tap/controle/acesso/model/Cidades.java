package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gilson on 17/08/15.
 */
@Entity
@Table(name = "cidades")
public class Cidades implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_cidade")
    private Integer id;

    @Column(name = "nm_cidade", nullable = false, length = 60)
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false, name = "uf_estado", referencedColumnName = "uf_estado")
    private Estados estados;

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidades cidades = (Cidades) o;

        return !(id != null ? !id.equals(cidades.id) : cidades.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cidades{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estados=" + estados +
                '}';
    }
}