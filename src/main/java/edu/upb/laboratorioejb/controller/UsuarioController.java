/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.laboratorioejb.controller;

import edu.upb.laboratorioejb.dao.UsuarioDAO;
import edu.upb.laboratorioejb.model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author informatica
 */
@Named
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario actual;
    private DataModel<Usuario> listado = null;

    @EJB
    UsuarioDAO ejbDAO;
    private Object JsfUtil;

    public UsuarioController() {
        actual = new Usuario();
    }

    public Usuario getActual() {
        return actual;
    }

    public void setActual(Usuario actual) {
        this.actual = actual;
    }

    public String login() {

        Usuario result = ejbDAO.findByAuth(actual);

        if (result == null) {
            actual = new Usuario();
            return "index?faces-redirect=true";
        } else {
            actual = result;
            return "userlist?faces-redirect=true";
        }
    }

    public DataModel<Usuario> getListado() {
        if (listado == null) {
            listado = new ListDataModel<Usuario>(ejbDAO.findAll());
        }
        return listado;
    }

    public String prepareEdit() {
        actual = listado.getRowData();
        return "edit?faces-redirect=true";
    }

    public String edit() {
        ejbDAO.edit(actual);
        return "userlist?faces-redirect=true";
    }

    public String prepareList() {
        listado = null;
        return "userlist?faces-redirect=true";
    }

    public String prepareCreate() {
        actual = new Usuario();
        return "create?faces-redirect=true";
    }

    public String create() {
        ejbDAO.create(actual);
        prepareList();
        return "userlist?faces-redirect=true";
    }

    public String delete() {
        actual = listado.getRowData();
        ejbDAO.remove(actual);
        prepareList();
        return "userlist?faces-redirect=true";
    }
}
