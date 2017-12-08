package DAO;

import Model.ConsumoComanda;
import java.util.List;
import javax.persistence.Query;
import util.Conexao;

public class ConsumoComandaDAO {
    private Conexao conn = new Conexao();

    public void salvar(ConsumoComanda c){
        if(c.getIdConsumo()== null) {
            conn.incluir(c);
        } else {
            conn.alterar(c);
        }
    }
    public void calcular(){
        
    }
    
    public void excluir(ConsumoComanda c){
        conn.excluir(c);
    }
    
    public List<ConsumoComanda> Listar(){
        Query q = conn.getEm().
                createQuery("select c from consumo_comanda c");
        List<ConsumoComanda> comandas = q.getResultList();
        conn.desconectar();
        return comandas;
    }
    
    public ConsumoComanda procurarPorid(Integer id){
        ConsumoComanda p = conn.getEm().find(ConsumoComanda.class, id);
        conn.desconectar();
        return p;
    }
    
}
