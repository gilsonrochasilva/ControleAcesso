package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gilson on 18/08/15.
 */
@Entity
@Table(name = "interfaces")
public class Interfaces implements Serializable {

    private Integer id;

    private String descricao;

    private byte[] imagem;

    private Modulos modulos;

    @Id
    @GeneratedValue
    @Column(name = "id_int")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "ds_int", nullable = false, length = 300)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "im_int", nullable = false)
    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_modulo", referencedColumnName = "id_modulo")
    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interfaces that = (Interfaces) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Interfaces{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
