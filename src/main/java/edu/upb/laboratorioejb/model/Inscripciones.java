/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.laboratorioejb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "inscripciones")
public class Inscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer evento_id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario_correo")
    private String usuario_correo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;

    public int getId() {
        return evento_id;
    }

    public void setId(int evento_id) {
        this.evento_id = evento_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evento_id != null ? evento_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripciones)) {
            return false;
        }
        Inscripciones other = (Inscripciones) object;
        if ((this.evento_id == null && other.evento_id != null) || (this.evento_id != null && !this.evento_id.equals(other.evento_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upb.laboratorioejb.model.Inscripciones[ id=" + evento_id + " ]";
    }

    public Integer getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Integer evento_id) {
        this.evento_id = evento_id;
    }

    public String getUsuario_correo() {
        return usuario_correo;
    }

    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
