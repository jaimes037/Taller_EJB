/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.laboratorioejb.dao;

import edu.upb.laboratorioejb.model.Usuario;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author informatica
 */
@Stateless
public class UsuarioDAO {

    @PersistenceContext(unitName = "LabEJB_PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDAO() {
    }

    public void create(Usuario entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Usuario entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Usuario entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Usuario find(Object id) {
        return getEntityManager().find(Usuario.class, id);
    }

    public List<Usuario> findAll() {

        CriteriaQuery cq;
        cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));

        return getEntityManager().createQuery(cq).getResultList();
    }

    public Usuario findByAuth(Usuario u) {


        Query query = em.createNamedQuery("findLoginUser");
        query.setParameter("correo", u.getCorreo());
        query.setParameter("clave", u.getClave());

        try{
            return (Usuario) query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }

    }

}
