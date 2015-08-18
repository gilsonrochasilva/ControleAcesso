package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gilson on 18/08/15.
 */
@Entity
@Table(name = "enderecos_exterior")
public class EnderecosExterior implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuarios;

    @Column(name = "ds_endereco", nullable = false, length = 80)
    private String endereco;

    @Column(name = "ds_cidade", nullable = false, length = 40)
    private String cidade;

    @Column(name = "ds_complemento", nullable = false, length = 40)
    private String complemento;

    @Column(name = "nu_codpostal")
    private Integer codigoPostal;

    @Column(name = "ds_estado", length = 40)
    private String estado;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnderecosExterior that = (EnderecosExterior) o;

        return !(usuarios != null ? !usuarios.equals(that.usuarios) : that.usuarios != null);

    }

    @Override
    public int hashCode() {
        return usuarios != null ? usuarios.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EnderecosExterior{" +
                "usuarios=" + usuarios +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", estado='" + estado + '\'' +
                '}';
    }
}
