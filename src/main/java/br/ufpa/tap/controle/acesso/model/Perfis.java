package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gilson on 17/08/15.
 */
@Entity
@Table(name = "perfis")
public class Perfis implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_perfil", columnDefinition = "smallint not null")
    private Integer id;

    @Column(name = "nm_perfil", nullable = false, length = 20, unique = true)
    private String nome;

    @Column(name = "ds_perfil", nullable = false, length = 200)
    private String descricao;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuarios> usuarios;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

        Perfis perfis = (Perfis) o;

        return !(id != null ? !id.equals(perfis.id) : perfis.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Perfis{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
