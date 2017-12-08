package DAO;

import Model.Receita;
import java.util.List;
import javax.persistence.Query;
import util.Conexao;

public class ReceitaDAO {
     private Conexao conn = new Conexao();
    
    //serve para alterar uma pessoa que ja 
    //estiver na lista ou adcionar uma nova pessoa na lista
    public void salvar(Receita r){
        if(r.getId() == null) {
            conn.incluir(r);
        } else {
            conn.alterar(r);
        }
    }
    
    public void excluir(Receita r){
        conn.excluir(r);
    }
    
    public List<Receita> Listar(){
        Query q = conn.getEm().createQuery("select r from receita r");
        List<Receita> receitas = q.getResultList();
        conn.desconectar();
        return receitas;
    }
    
    public Receita procurarPorid(Integer id){
        Receita p = conn.getEm().find(Receita.class, id);
        conn.desconectar();
        return p;
    }
    
}
