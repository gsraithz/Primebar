package View;
import DAO.PessoaDAO;
import Model.Pessoa;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PessoaBean {
    
    private Pessoa pessoa = new Pessoa();
    private final PessoaDAO pDAO = new PessoaDAO();

    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public PessoaDAO getpDAO() {
        return pDAO;
    }
    
    public void salvar() {
        pDAO.salvar(pessoa);
        pessoa = new Pessoa();
    }
    
    public void excluir(Pessoa p){
        pDAO.excluir(p);
    }
    
    public List<Pessoa> listar(){
        return pDAO.Listar();
    }

    
    

}
