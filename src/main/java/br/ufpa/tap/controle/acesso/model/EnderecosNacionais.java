package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gilson on 18/08/15.
 */
@Entity
@Table(name = "enderecos_nacionais")
public class EnderecosNacionais implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_cidade", referencedColumnName = "id_cidade")
    private Cidades cidades;

    @Column(name = "nu_cep", nullable = false)
    private Integer cep;

    @Column(name = "nm_logradouro", nullable = false, length = 80)
    private String logradouro;

    @Column(name = "nm_bairro", nullable = false, length = 40)
    private String bairro;

    @Column(name = "nu_numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "ds_complemento", length = 40)
    private String complemento;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Cidades getCidades() {
        return cidades;
    }

    public void setCidades(Cidades cidades) {
        this.cidades = cidades;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnderecosNacionais that = (EnderecosNacionais) o;

        return !(usuarios != null ? !usuarios.equals(that.usuarios) : that.usuarios != null);

    }

    @Override
    public int hashCode() {
        return usuarios != null ? usuarios.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EnderecosNacionais{" +
                "usuarios=" + usuarios +
                ", cidades=" + cidades +
                ", cep=" + cep +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
