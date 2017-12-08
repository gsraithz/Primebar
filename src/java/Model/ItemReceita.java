/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "item_receita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemReceita.findAll", query = "SELECT i FROM ItemReceita i"),
    @NamedQuery(name = "ItemReceita.findByIdItemReceita", query = "SELECT i FROM ItemReceita i WHERE i.idItemReceita = :idItemReceita"),
    @NamedQuery(name = "ItemReceita.findByQtd", query = "SELECT i FROM ItemReceita i WHERE i.qtd = :qtd")})
public class ItemReceita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_receita")
    private Integer idItemReceita;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtd")
    private Float qtd;
    @JoinColumn(name = "fk_ingrediente", referencedColumnName = "id_ingrediente")
    @ManyToOne(optional = true)
    private Ingrediente fkIngrediente;
    @JoinColumn(name = "fk_receita", referencedColumnName = "id_receita")
    @ManyToOne(optional = true)
    private Receita fkReceitaItemReceita;

    public ItemReceita() {
    }

    public ItemReceita(Integer idItemReceita) {
        this.idItemReceita = idItemReceita;
    }

    public Integer getIdItemReceita() {
        return idItemReceita;
    }

    public void setIdItemReceita(Integer idItemReceita) {
        this.idItemReceita = idItemReceita;
    }

    public Float getQtd() {
        return qtd;
    }

    public void setQtd(Float qtd) {
        this.qtd = qtd;
    }

    public Ingrediente getFkIngrediente() {
        return fkIngrediente;
    }

    public void setFkIngrediente(Ingrediente fkIngrediente) {
        this.fkIngrediente = fkIngrediente;
    }

    public Receita getFkReceitaItemReceita() {
        return fkReceitaItemReceita;
    }

    public void setFkReceitaItemReceita(Receita fkReceitaItemReceita) {
        this.fkReceitaItemReceita = fkReceitaItemReceita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemReceita != null ? idItemReceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemReceita)) {
            return false;
        }
        ItemReceita other = (ItemReceita) object;
        if ((this.idItemReceita == null && other.idItemReceita != null) || (this.idItemReceita != null && !this.idItemReceita.equals(other.idItemReceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ItemReceita[ idItemReceita=" + idItemReceita + " ]";
    }
    
}
