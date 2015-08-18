package br.ufpa.tap.controle.acesso.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by gilson on 12/08/15.
 */
public abstract class DAO<T> {

    protected static EntityManagerFactory emf;

    protected EntityManager em;

    protected static boolean autoCommit = true;


    public  EntityManager getEM() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("controleAcessoPU");
        }

        if(em == null) {
            em = emf.createEntityManager();
        }

        return em;
    }

    public static void setAutoCommit(boolean autoCommit) {
        DAO.autoCommit = autoCommit;
    }

    public void salvar(T t) {
        if(autoCommit) {
            getEM().getTransaction().begin();
            getEM().persist(t);
            getEM().getTransaction().commit();
        } else {
            getEM().persist(t);
        }
    }

    public void atualizar(T t) {
        if(autoCommit) {
            getEM().getTransaction().begin();
            getEM().merge(t);
            getEM().getTransaction().commit();
        } else {
            getEM().merge(t);
        }
    }

    public void excluir(Class<T> clazz, Object id) {
        if(autoCommit) {
            getEM().getTransaction().begin();
            getEM().remove(getUm(clazz, id));
            getEM().getTransaction().commit();
        } else {
            getEM().remove(getUm(clazz, id));
        }
    }

    public T getUm(Class<T> clazz, Object id) {
        return (T) getEM().find(clazz, id);
    }

    public Query getQuery(String namedQuery) {
        return getEM().createNamedQuery(namedQuery);
    }
}
