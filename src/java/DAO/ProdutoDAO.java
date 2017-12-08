package DAO;

import Model.Produto;
import java.util.List;
import javax.persistence.Query;
import util.Conexao;

public class ProdutoDAO {
    
     private Conexao conn = new Conexao();
    
    public void salvar(Produto p){
        if(p.getIdProduto() == null) {
            conn.incluir(p);
        } else {
            conn.alterar(p);
        }
    }
    
    public void excluir(Produto p){
        conn.excluir(p);
    }
    
    public Produto procurarPorid(Integer id){
        Produto p = conn.getEm().find(Produto.class, id);
        conn.desconectar();
        return p;
    }
    

    public List<Produto> Listar() {
                List<Produto> produtos = null;
        
        produtos = conn.getEm().createNamedQuery("Produto.findAll").getResultList();
         return produtos;}
    
}
