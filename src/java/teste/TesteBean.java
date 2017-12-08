package teste;

import DAO.IngredienteDAO;
import Model.Ingrediente;
import View.IngredienteBean;
import util.Conexao;

public class TesteBean {
    
    public static void main(String[] args) {
        
    Conexao conn = new Conexao();
    IngredienteDAO iDAO = new IngredienteDAO();
    
    Ingrediente ingrediente = new Ingrediente();

     
    ingrediente.setNome("Ingrediente novo");
    ingrediente.setPreco(7.50);
    ingrediente.setQtd(new Float(1000.0));
    ingrediente.setDescricao("Descrição do ing novo");
    
    iDAO.salvar(ingrediente);
    }
    
}
