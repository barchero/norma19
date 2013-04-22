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
@Table(name = "domiciliacions", catalog = "n19", schema = "")
@NamedQueries({
    @NamedQuery(name = "Domiciliacions.findAll", query = "SELECT d FROM Domiciliacions d"),
    @NamedQuery(name = "Domiciliacions.findById", query = "SELECT d FROM Domiciliacions d WHERE d.id = :id"),
    @NamedQuery(name = "Domiciliacions.findByIdSoci", query = "SELECT d FROM Domiciliacions d WHERE d.idSoci = :idSoci"),
    @NamedQuery(name = "Domiciliacions.findByEuros", query = "SELECT d FROM Domiciliacions d WHERE d.euros = :euros"),
    @NamedQuery(name = "Domiciliacions.findByPeriodicitat", query = "SELECT d FROM Domiciliacions d WHERE d.periodicitat = :periodicitat")})
public class Domiciliacions implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_soci")
    private int idSoci;
    @Basic(optional = false)
    @Column(name = "euros")
    private float euros;
    @Basic(optional = false)
    @Column(name = "periodicitat")
    private String periodicitat;

    public Domiciliacions() {
    }

    public Domiciliacions(Integer id) {
        this.id = id;
    }

    public Domiciliacions(Integer id, int idSoci, float euros, String periodicitat) {
        this.id = id;
        this.idSoci = idSoci;
        this.euros = euros;
        this.periodicitat = periodicitat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getIdSoci() {
        return idSoci;
    }

    public void setIdSoci(int idSoci) {
        int oldIdSoci = this.idSoci;
        this.idSoci = idSoci;
        changeSupport.firePropertyChange("idSoci", oldIdSoci, idSoci);
    }

    public float getEuros() {
        return euros;
    }

    public void setEuros(float euros) {
        float oldEuros = this.euros;
        this.euros = euros;
        changeSupport.firePropertyChange("euros", oldEuros, euros);
    }

    public String getPeriodicitat() {
        return periodicitat;
    }

    public void setPeriodicitat(String periodicitat) {
        String oldPeriodicitat = this.periodicitat;
        this.periodicitat = periodicitat;
        changeSupport.firePropertyChange("periodicitat", oldPeriodicitat, periodicitat);
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
        if (!(object instanceof Domiciliacions)) {
            return false;
        }
        Domiciliacions other = (Domiciliacions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "n19.Domiciliacions[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
