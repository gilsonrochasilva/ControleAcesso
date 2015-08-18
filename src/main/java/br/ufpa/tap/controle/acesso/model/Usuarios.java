package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by gilson on 17/08/15.
 */
@Entity
@Table(name = "usuarios")
@NamedQueries(value = {
    @NamedQuery(name = "Usuarios.listar", query = "select u from Usuarios as u")
})
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "fl_sexo", nullable = false)
    private Boolean sexo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nasc", nullable = false)
    private Date nascimento;

    @Column(name = "fl_interno", nullable = false)
    private Boolean interno;

    @Column(name = "ds_email", nullable = false, length = 60, unique = true)
    private String email;

    @Column(name = "nm_usuario", nullable = false, length = 60)
    private String nome;

    @Column(name = "nm_tratamento", nullable = false, length = 30)
    private String tratamento;

    @Column(name = "nu_cpf", nullable = false, unique = true)
    private Integer cpf;

    @Column(name = "vl_senha", columnDefinition = "char(32)")
    private String senha;

    @Column(name = "nm_loginad", length = 30)
    private String login;

    @Column(name = "nu_fonres", length = 20)
    private String telefoneResidencial;

    @Column(name = "nu_foncom", length = 20)
    private String telefoneComercial;

    @Column(name = "celular", length = 20)
    private String celular;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_paisnac", referencedColumnName = "id_pais")
    private Paises paisNascimento;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_paisend", referencedColumnName = "id_pais")
    private Paises paisEndereco;

    @OneToMany(mappedBy = "usuarios")
    private List<EnderecosNacionais> enderecosNacionaisList;

    @OneToMany(mappedBy = "usuarios")
    private List<EnderecosExterior> enderecosExteriorList;

    @ManyToMany
    @JoinTable(
        name = "atividades_usuarios",
        joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "id_atividade", nullable = false)
    )
    private List<Atividades> atividades;

    @ManyToMany
    @JoinTable(
        name = "usuarios_perfis",
        joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "id_perfil", nullable = false)
    )
    private List<Perfis> perfis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Boolean getInterno() {
        return interno;
    }

    public void setInterno(Boolean interno) {
        this.interno = interno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Paises getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(Paises paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public Paises getPaisEndereco() {
        return paisEndereco;
    }

    public void setPaisEndereco(Paises paisEndereco) {
        this.paisEndereco = paisEndereco;
    }

    public List<EnderecosNacionais> getEnderecosNacionaisList() {
        return enderecosNacionaisList;
    }

    public void setEnderecosNacionaisList(List<EnderecosNacionais> enderecosNacionaisList) {
        this.enderecosNacionaisList = enderecosNacionaisList;
    }

    public List<EnderecosExterior> getEnderecosExteriorList() {
        return enderecosExteriorList;
    }

    public void setEnderecosExteriorList(List<EnderecosExterior> enderecosExteriorList) {
        this.enderecosExteriorList = enderecosExteriorList;
    }

    public List<Atividades> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividades> atividades) {
        this.atividades = atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuarios usuarios = (Usuarios) o;

        return !(id != null ? !id.equals(usuarios.id) : usuarios.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", sexo=" + sexo +
                ", nascimento=" + nascimento +
                ", interno=" + interno +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", tratamento='" + tratamento + '\'' +
                ", cpf=" + cpf +
                ", senha='" + senha + '\'' +
                ", login='" + login + '\'' +
                ", telefoneResidencial='" + telefoneResidencial + '\'' +
                ", telefoneComercial='" + telefoneComercial + '\'' +
                ", celular='" + celular + '\'' +
                ", paisNascimento=" + paisNascimento +
                ", paisEndereco=" + paisEndereco +
                ", enderecosNacionaisList=" + enderecosNacionaisList +
                ", enderecosExteriorList=" + enderecosExteriorList +
                ", atividades=" + atividades +
                '}';
    }
}
