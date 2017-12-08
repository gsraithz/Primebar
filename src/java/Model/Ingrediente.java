/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingrediente.findAll", query = "SELECT i FROM Ingrediente i"),
    @NamedQuery(name = "Ingrediente.findByIdIngrediente", query = "SELECT i FROM Ingrediente i WHERE i.idIngrediente = :idIngrediente"),
    @NamedQuery(name = "Ingrediente.findByNome", query = "SELECT i FROM Ingrediente i WHERE i.nome = :nome"),
    @NamedQuery(name = "Ingrediente.findByDescricao", query = "SELECT i FROM Ingrediente i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Ingrediente.findByPreco", query = "SELECT i FROM Ingrediente i WHERE i.preco = :preco"),
    @NamedQuery(name = "Ingrediente.findByQtd", query = "SELECT i FROM Ingrediente i WHERE i.qtd = :qtd")})
public class Ingrediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingrediente")
    private Integer idIngrediente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private Double preco;
    @Column(name = "qtd")
    private Float qtd;
    @OneToMany(mappedBy = "fkIngrediente")
    private List<ItemReceita> itemReceitaList;

    public Ingrediente() {
    }

    public Ingrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Float getQtd() {
        return qtd;
    }

    public void setQtd(Float qtd) {
        this.qtd = qtd;
    }

    
    @XmlTransient
    public List<ItemReceita> getItemReceitaList() {
        return itemReceitaList;
    }

    public void setItemReceitaList(List<ItemReceita> itemReceitaList) {
        this.itemReceitaList = itemReceitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngrediente != null ? idIngrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.idIngrediente == null && other.idIngrediente != null) || (this.idIngrediente != null && !this.idIngrediente.equals(other.idIngrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ingrediente[ idIngrediente=" + idIngrediente + " ]";
    }
    
}
