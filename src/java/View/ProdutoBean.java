package View;
import DAO.PessoaDAO;
import DAO.ProdutoDAO;
import Model.Pessoa;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {
    
    private Produto produto = new Produto();
    private final ProdutoDAO pDAO = new ProdutoDAO();

    public Produto getProduto() {
        return produto;
    }

    public ProdutoDAO getpDAO() {
        return pDAO;
    }

    
    
    public void salvar() {
        pDAO.salvar(produto);
        produto = new Produto();
    }
    
    public void excluir(Produto p){
        pDAO.excluir(p);
    }
    
    public List<Produto> listar(){
        return pDAO.Listar();
    }

    public List getSelectItems(){  
        List<String> lista = new ArrayList<>();  
        lista.add(produto.getNome()); 
        return lista;  
   }  

    
    

}
