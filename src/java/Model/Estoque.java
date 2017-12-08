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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByIdEstoque", query = "SELECT e FROM Estoque e WHERE e.idEstoque = :idEstoque"),
    @NamedQuery(name = "Estoque.findByQtdEstoque", query = "SELECT e FROM Estoque e WHERE e.qtdEstoque = :qtdEstoque"),
    @NamedQuery(name = "Estoque.findByMdReposicao", query = "SELECT e FROM Estoque e WHERE e.mdReposicao = :mdReposicao")})
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer idEstoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtd_estoque")
    private Float qtdEstoque;
    @Column(name = "md_reposicao")
    private Float mdReposicao;
    @JoinColumn(name = "fk_ingrediente", referencedColumnName = "id_ingrediente", unique = true)
    @OneToOne(optional = false)
    private Ingrediente ingrediente;
  

    public Estoque() {
    }

    

    public Estoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Float getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Float qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Float getMdReposicao() {
        return mdReposicao;
    }

    public void setMdReposicao(Float mdReposicao) {
        this.mdReposicao = mdReposicao;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoque != null ? idEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idEstoque == null && other.idEstoque != null) || (this.idEstoque != null && !this.idEstoque.equals(other.idEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "idEstoque=" + idEstoque + ", qtdEstoque=" + qtdEstoque + ", mdReposicao=" + mdReposicao + ", ingrediente=" + ingrediente + '}';
    }

    
    
    
}
