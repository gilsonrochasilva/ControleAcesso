package br.ufpa.tap.controle.acesso.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gilson on 18/08/15.
 */
@Entity
@Table(name = "permissoes_perfis")
public class PermissoesPerfis implements Serializable {

    @EmbeddedId
    private PermissoesPerfisPK permissoesPerfisPK;

    @Column(name = "fl_manut", nullable = false)
    private Boolean manutencao;

    @Column(name = "fl_filtro", nullable = false)
    private Boolean filtro;

    @Column(name = "fl_log", nullable = false)
    private Boolean log;

    public PermissoesPerfisPK getPermissoesPerfisPK() {
        return permissoesPerfisPK;
    }

    public void setPermissoesPerfisPK(PermissoesPerfisPK permissoesPerfisPK) {
        this.permissoesPerfisPK = permissoesPerfisPK;
    }

    public Boolean getManutencao() {
        return manutencao;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }

    public Boolean getFiltro() {
        return filtro;
    }

    public void setFiltro(Boolean filtro) {
        this.filtro = filtro;
    }

    public Boolean getLog() {
        return log;
    }

    public void setLog(Boolean log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissoesPerfis that = (PermissoesPerfis) o;

        if (permissoesPerfisPK != null ? !permissoesPerfisPK.equals(that.permissoesPerfisPK) : that.permissoesPerfisPK != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return permissoesPerfisPK != null ? permissoesPerfisPK.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PermissoesPerfis{" +
                "permissoesPerfisPK=" + permissoesPerfisPK +
                ", manutencao=" + manutencao +
                ", filtro=" + filtro +
                ", log=" + log +
                '}';
    }
}
