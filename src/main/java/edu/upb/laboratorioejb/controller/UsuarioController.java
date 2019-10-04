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
import javax.ejb.EJB;
import javax.faces.model.DataModel;

/**
 *
 * @author informatica
 */
@Named
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario actual;
    private DataModel listado = null;

    @EJB
    UsuarioDAO ejbDAO;

    public UsuarioController() {
        actual = new Usuario();
    }
    
    public Usuario getActual() {
        return actual;
    }

    public void setActual(Usuario actual) {
        this.actual = actual;
    }
    
    
    public String login(){
        
        Usuario result =ejbDAO.findByAuth(actual);
        
        if(result == null){
            actual = new Usuario();
            return "index?faces-redirect=true";
        }else{
            actual = result;
            return "home?faces-redirect=true";
        }
    }

    
    
}
