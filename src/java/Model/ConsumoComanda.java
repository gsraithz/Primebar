/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "consumo_comanda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumoComanda.findAll", query = "SELECT c FROM ConsumoComanda c"),
    @NamedQuery(name = "ConsumoComanda.findByIdConsumo", query = "SELECT c FROM ConsumoComanda c WHERE c.idConsumo = :idConsumo"),
    @NamedQuery(name = "ConsumoComanda.findByValorConsumo", query = "SELECT c FROM ConsumoComanda c WHERE c.valorConsumo = :valorConsumo"),
    @NamedQuery(name = "ConsumoComanda.findByNumeroMesa", query = "SELECT c FROM ConsumoComanda c WHERE c.numeroMesa = :numeroMesa"),
    @NamedQuery(name = "ConsumoComanda.findByHoraInicio", query = "SELECT c FROM ConsumoComanda c WHERE c.horaInicio = :horaInicio"),
    @NamedQuery(name = "ConsumoComanda.findByHoraFim", query = "SELECT c FROM ConsumoComanda c WHERE c.horaFim = :horaFim")})
public class ConsumoComanda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumo")
    private Integer idConsumo;
    @Basic(optional = false)
    @Column(name = "valor_consumo")
    private double valorConsumo;
    @Column(name = "numero_mesa")
    private Integer numeroMesa;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.DATE)
    private Date horaInicio;
    @Column(name = "hora_fim")
    @Temporal(TemporalType.DATE)
    private Date horaFim;
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_pessoa")
    @ManyToOne(optional = false)
    private Pessoa fkCliente;

    public ConsumoComanda() {
    }

    public ConsumoComanda(Integer idConsumo) {
        this.idConsumo = idConsumo;
    }

    public ConsumoComanda(Integer idConsumo, double valorConsumo) {
        this.idConsumo = idConsumo;
        this.valorConsumo = valorConsumo;
    }

    public Integer getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(Integer idConsumo) {
        this.idConsumo = idConsumo;
    }

    public double getValorConsumo() {
        return valorConsumo;
    }

    public void setValorConsumo(double valorConsumo) {
        this.valorConsumo = valorConsumo;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Pessoa getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Pessoa fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsumo != null ? idConsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoComanda)) {
            return false;
        }
        ConsumoComanda other = (ConsumoComanda) object;
        if ((this.idConsumo == null && other.idConsumo != null) || (this.idConsumo != null && !this.idConsumo.equals(other.idConsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ConsumoComanda[ idConsumo=" + idConsumo + " ]";
    }
    
}
