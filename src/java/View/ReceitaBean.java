package View;

import DAO.IngredienteDAO;
import DAO.ReceitaDAO;
import Model.Ingrediente;
import Model.Receita;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;


@ManagedBean
public class ReceitaBean{
   
    private Receita receita = new Receita();
    private ReceitaDAO rDAO = new ReceitaDAO();
    private IngredienteDAO iDAO = new IngredienteDAO();

    private DualListModel<Ingrediente> ingredientesList;

    ItemReceitaBean itemReceita = new ItemReceitaBean();
     
    public List<String> getTargets(){    
        return itemReceita.getListTarget();
    }   
    
    @PostConstruct
    public void init() {
    
        List<Ingrediente> ingredienteFonte = new ArrayList<Ingrediente>();
        ingredienteFonte = iDAO.Listar();
        List<Ingrediente> ingredienteAlvo = new ArrayList<Ingrediente>();
       

        ingredientesList = new DualListModel<Ingrediente>(ingredienteFonte, ingredienteAlvo);
    }    

    public DualListModel<Ingrediente> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(DualListModel<Ingrediente> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
                
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public ReceitaDAO getrDAO() {
        return rDAO;
    }

    public void setrDAO(ReceitaDAO rDAO) {
        this.rDAO = rDAO;
    }

    public void salvarIngredientes(){
        ingredientesList.getTarget();
    }
    
    
    public void salvar(){
        rDAO.salvar(receita);
        receita = new Receita();
        itemReceita.salvar();
        
    }

    public void excluir(Receita i){
        rDAO.excluir(i);
    }
    
    public List<Receita> listar(){
        return rDAO.Listar();
    }
    
}