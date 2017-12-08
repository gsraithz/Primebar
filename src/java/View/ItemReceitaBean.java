package View;

import DAO.ItemReceitaDao;
import Model.ItemReceita;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ItemReceitaBean {
    ItemReceita itemReceita = new ItemReceita();
    ItemReceitaDao iDAO = new ItemReceitaDao();
    List<String> listTarget;
    ReceitaBean receita;

    public List<String> getListTarget() {
        return listTarget;
    }

    public void setListTarget(List<String> listTarget) {
        this.listTarget = receita.getTargets();
    }

    public ItemReceita getItemReceita() {
        return itemReceita;
    }

    public void setItemReceita(ItemReceita itemReceita) {
        this.itemReceita = itemReceita;
    }

    public ItemReceitaDao getiDAO() {
        return iDAO;
    }

    public void setiDAO(ItemReceitaDao iDAO) {
        this.iDAO = iDAO;
    }
    public void salvar(){
        setListTarget(listTarget);
        
        iDAO.salvar(itemReceita);
        
    }

    
    
}
