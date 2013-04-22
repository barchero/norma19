/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n19;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author DAW
 */
@Entity
@Table(name = "rebuts", catalog = "n19", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rebuts.findAll", query = "SELECT r FROM Rebuts r"),
    @NamedQuery(name = "Rebuts.findById", query = "SELECT r FROM Rebuts r WHERE r.id = :id"),
    @NamedQuery(name = "Rebuts.findByIdSoci", query = "SELECT r FROM Rebuts r WHERE r.idSoci = :idSoci"),
    @NamedQuery(name = "Rebuts.findByQuantitat", query = "SELECT r FROM Rebuts r WHERE r.quantitat = :quantitat"),
    @NamedQuery(name = "Rebuts.findByData", query = "SELECT r FROM Rebuts r WHERE r.data = :data"),
    @NamedQuery(name = "Rebuts.findByConcepte", query = "SELECT r FROM Rebuts r WHERE r.concepte = :concepte")})
public class Rebuts implements Serializable {
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
    @Column(name = "quantitat")
    private float quantitat;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "concepte")
    private String concepte;

    public Rebuts() {
    }

    public Rebuts(Integer id) {
        this.id = id;
    }

    public Rebuts(Integer id, int idSoci, float quantitat, Date data, String concepte) {
        this.id = id;
        this.idSoci = idSoci;
        this.quantitat = quantitat;
        this.data = data;
        this.concepte = concepte;
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

    public float getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(float quantitat) {
        float oldQuantitat = this.quantitat;
        this.quantitat = quantitat;
        changeSupport.firePropertyChange("quantitat", oldQuantitat, quantitat);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getConcepte() {
        return concepte;
    }

    public void setConcepte(String concepte) {
        String oldConcepte = this.concepte;
        this.concepte = concepte;
        changeSupport.firePropertyChange("concepte", oldConcepte, concepte);
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
        if (!(object instanceof Rebuts)) {
            return false;
        }
        Rebuts other = (Rebuts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "n19.Rebuts[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
