package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gilson on 17/08/15.
 */
@Entity
@Table(name = "atividades")
public class Atividades implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_atividade", columnDefinition = "smallint not null")
    private Integer id;

    @Column(name = "ds_atividade", nullable = false, length = 40)
    private String descricao;

    @Column(name = "fl_ativa", nullable = false)
    private Boolean ativa;

    @ManyToMany(mappedBy = "atividades")
    private List<Usuarios> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividades that = (Atividades) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Atividades{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", ativa=" + ativa +
                '}';
    }
}
