package View;

import DAO.EstoqueIngredienteDAO;
import Model.Estoque;
import Model.Ingrediente;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
@ViewScoped
@ManagedBean
public class EstoqueBean {
    private Estoque estoque = new Estoque();
    private final EstoqueIngredienteDAO eDAO = new EstoqueIngredienteDAO();
    private Integer ingredienteGetted;
    private Float estoqueAdd = new Float(0.0);
    
    
    public EstoqueBean()
    {
        //this.estoque = eDAO.procurarPorId(11);
    }

    public Float getEstoqueAdd() {
        return estoqueAdd;
    }

    public void setEstoqueAdd(Float estoqueAdd) {
        this.estoqueAdd = estoqueAdd;
    }

    
        
    public Integer getIngredienteGetted() {
        return ingredienteGetted;
    }

    public void setIngredienteGetted(Integer ingredienteGetted) {
        this.ingredienteGetted = ingredienteGetted;
    }
    
//    @ManagedProperty(value="#{ingrediente}")  
    private Ingrediente ingrediente;  
  
    public void setItemBean(Ingrediente ingrediente) {  
    this.ingrediente = ingrediente;  
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    public void salvar() {
        
        eDAO.salvar(estoque);
        estoque = new Estoque();
    }
    
    
    public void excluir(Estoque e){
        eDAO.excluir(e);
    }
    
    public List<Estoque> listar(){
        return eDAO.Listar();
    }
    
    public void saveById(){
        eDAO.salvarById(estoque);
    }
    public void saveEstoque(){
        
        estoque.setQtdEstoque( estoque.getQtdEstoque() + estoqueAdd);
        eDAO.salvarById(estoque);
    }
          
    public void select(){
       estoque = eDAO.procurarPorId(ingredienteGetted);
    }
        
        
   
    
}    

