package br.ufpa.tap.controle.acesso.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by gilson on 18/08/15.
 */
@Embeddable
public class PermissoesPerfisPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_int", nullable = false)
    private Interfaces interfaces;

    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false)
    private Perfis perfis;

    public Interfaces getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Interfaces interfaces) {
        this.interfaces = interfaces;
    }

    public Perfis getPerfis() {
        return perfis;
    }

    public void setPerfis(Perfis perfis) {
        this.perfis = perfis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissoesPerfisPK that = (PermissoesPerfisPK) o;

        if (interfaces != null ? !interfaces.equals(that.interfaces) : that.interfaces != null) return false;
        return !(perfis != null ? !perfis.equals(that.perfis) : that.perfis != null);

    }

    @Override
    public int hashCode() {
        int result = interfaces != null ? interfaces.hashCode() : 0;
        result = 31 * result + (perfis != null ? perfis.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PermissoesPerfisPK{" +
                "interfaces=" + interfaces +
                ", perfis=" + perfis +
                '}';
    }
}