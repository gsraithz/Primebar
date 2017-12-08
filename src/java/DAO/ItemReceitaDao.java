package DAO;

import Model.ItemReceita;
import java.util.List;
import util.Conexao;

public class ItemReceitaDao {
    private Conexao conn = new Conexao();
    
    //serve para alterar uma pessoa que ja 
    //estiver na lista ou adcionar uma nova pessoa na lista
    public void salvar(ItemReceita i){
        if(i.getIdItemReceita()== null) {
            conn.incluir(i);
         // Aqui estarei cadastrando um estoque zerado para o Ingrediente que
         // acabou de ser cadastrado
        } else {
            conn.alterar(i);
        }
    }
    
    public void excluir(ItemReceita i){
        conn.excluir(i);
    }
    
    public ItemReceita procurarPorId(int id) {
        ItemReceita i = conn.getEm().find(ItemReceita.class, id);
        conn.desconectar();
        return i;
    }
    
    
    public List<ItemReceita> Listar(){
        List<ItemReceita> itemReceita = null;     
        itemReceita = conn.getEm().createNamedQuery("ItemReceita.findAll").getResultList();
        return itemReceita;
    }
}
