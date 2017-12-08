package View;

import DAO.IngredienteDAO;
import Model.Ingrediente;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class IngredienteBean {
    private Ingrediente ingrediente = new Ingrediente();
    private IngredienteDAO iDAO = new IngredienteDAO();
    
    
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public IngredienteDAO getiDAO() {
        return iDAO;
    }

    public void setiDAO(IngredienteDAO iDAO) {
        this.iDAO = iDAO;
    }
    
    public void salvar(){
        iDAO.salvar(ingrediente);
        ingrediente = new Ingrediente();
    }
    
    public void excluir(Ingrediente i){
        iDAO.excluir(i);
    }
    
    public List<Ingrediente> listar(){
        return iDAO.Listar();
    }
    
   
}

