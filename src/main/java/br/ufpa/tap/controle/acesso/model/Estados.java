package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gilson on 17/08/15.
 */
@Entity
@Table(name = "estados")
public class Estados implements Serializable {

    @Id
    @Column(name = "uf_estado", columnDefinition = "char(2) not null")
    private String uf;

    @Column(name = "ds_estado", nullable = false, length = 40)
    private String descricao;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estados estados = (Estados) o;

        return !(uf != null ? !uf.equals(estados.uf) : estados.uf != null);

    }

    @Override
    public int hashCode() {
        return uf != null ? uf.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Estados{" +
                "uf=" + uf +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}