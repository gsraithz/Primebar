package DAO;

import Controle.ControleEstoque;
import Model.Estoque;
import Model.Ingrediente;
import Model.Pessoa;
import java.util.List;
import java.util.Objects;
import util.Conexao;

public class IngredienteDAO {
     private Conexao conn = new Conexao();
    
    //serve para alterar uma pessoa que ja 
    //estiver na lista ou adcionar uma nova pessoa na lista
    public void salvar(Ingrediente i){
        if(i.getIdIngrediente() == null) {
            conn.incluir(i);
         // Aqui estarei cadastrando um estoque zerado para o Ingrediente que
         // acabou de ser cadastrado
         Estoque e = ControleEstoque.novoEstoqueIngrediente(i);
         conn.incluir(e);
        } else {
            conn.alterar(i);
        }
    }
    
    
    public void excluir(Ingrediente i){
        conn.excluir(i);
    }
    
    public Ingrediente procurarPorId(int id) {
        Ingrediente i = conn.getEm().find(Ingrediente.class, id);
        conn.desconectar();
        return i;
    }
    
    
    public List<Ingrediente> Listar(){
        List<Ingrediente> ingredientes = null;     
        ingredientes = conn.getEm().createNamedQuery("Ingrediente.findAll").getResultList();
        return ingredientes;
    }
    
    
    
    
}
