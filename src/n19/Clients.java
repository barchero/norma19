/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n19;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author DAW
 */
@Entity
@Table(name = "clients", catalog = "n19", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByNom", query = "SELECT c FROM Clients c WHERE c.nom = :nom"),
    @NamedQuery(name = "Clients.findByCognoms", query = "SELECT c FROM Clients c WHERE c.cognoms = :cognoms"),
    @NamedQuery(name = "Clients.findByNif", query = "SELECT c FROM Clients c WHERE c.nif = :nif"),
    @NamedQuery(name = "Clients.findByCcc", query = "SELECT c FROM Clients c WHERE c.ccc = :ccc")})
public class Clients implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "cognoms")
    private String cognoms;
    @Basic(optional = false)
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @Column(name = "ccc")
    private String ccc;

    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }

    public Clients(Integer id, String nom, String cognoms, String nif, String ccc) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.nif = nif;
        this.ccc = ccc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        changeSupport.firePropertyChange("nom", oldNom, nom);
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        String oldCognoms = this.cognoms;
        this.cognoms = cognoms;
        changeSupport.firePropertyChange("cognoms", oldCognoms, cognoms);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        changeSupport.firePropertyChange("nif", oldNif, nif);
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        String oldCcc = this.ccc;
        this.ccc = ccc;
        changeSupport.firePropertyChange("ccc", oldCcc, ccc);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "n19.Clients[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
