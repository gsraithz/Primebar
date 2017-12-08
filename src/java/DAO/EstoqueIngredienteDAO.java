package DAO;

import Controle.ControleEstoque;
import Model.Estoque;
import java.util.List;
import util.Conexao;

public class EstoqueIngredienteDAO {
    
private Conexao conn = new Conexao();
private final ControleEstoque controle = new ControleEstoque();
    

    public void salvar(Estoque e){
        if(e.getIdEstoque() == null) {        
            conn.incluir(ControleEstoque.novoEstoqueIngrediente(e.getIngrediente()));
        } else {
            conn.alterar(e);
        }
    }
    public void salvarById(Estoque e){
        System.out.println(e);
            conn.alterar(e);
    }
    
    public void excluir(Estoque e){
        conn.excluir(e);
    }
    
    public Estoque procurarPorId(int id) {
        Estoque e = conn.getEm().find(Estoque.class, id);
        //Estoque e = conn.getEm().createQuery("select p from tb_estoque p where p. ")
        conn.desconectar();
        return e;
    }
    
    public List<Estoque> Listar(){
        List<Estoque> estoqueingredientes = null;     
        estoqueingredientes = conn.getEm().createNamedQuery("Estoque.findAll").getResultList();
        return estoqueingredientes;
    }
    
}
