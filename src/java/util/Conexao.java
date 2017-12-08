package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * classe para conectar, desconectar, incluir, alterar exlcuir e listar objetos
 * do banco
 *
 * @author Aluno
 */
public class Conexao {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private boolean conectou = false;
    private static final String PU = "JPA2PU";
    // nome do persistence                      ↑

    public Conexao() {
        conectar();
    }

    public boolean conectar() {
        if (!conectou) {
            try {
                emf = Persistence.createEntityManagerFactory(PU);
                em = emf.createEntityManager();
                conectou = true;
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao tentar conectar no banco: " + e.getMessage());
            }
        }
        return conectou;
    }

    public void conectar2() {
         try 
        {
            if (this.emf == null || this.em == null) 
            {
                this.emf = Persistence.createEntityManagerFactory(PU);
                this.em = this.emf.createEntityManager();
            }
        } catch (Exception e) 
        {
            System.out.println("Ocorreu um erro ao tentar conectar no banco: " + e.getMessage());
        }
    }

    public void desconectar() {
        em.close();
        emf.close();
        conectou = false;
    }

    public void incluir(Object o) {
        if (conectar()) {
            try {
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                desconectar();
            }
        }
    }

    public void alterar(Object o) {
        if (conectar()) {
            try {
                em.getTransaction().begin();
                em.merge(o);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                desconectar();
            }
        }
    }

    public void excluir(Object o) {
        if (conectar()) {
            try {
                em.getTransaction().begin();
                em.remove(em.merge(o));
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                desconectar();
            }
        }
    }

    public EntityManager getEm() {
        if (!conectou) {
            conectar();
        }
        return em;
    }

}
