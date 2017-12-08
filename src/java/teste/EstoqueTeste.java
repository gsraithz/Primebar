
package teste;

import DAO.EstoqueIngredienteDAO;
import DAO.IngredienteDAO;
import Model.Estoque;
import Model.Ingrediente;
import util.Conexao;

/**
 *
 * @author Gabriel
 */
public class EstoqueTeste {
    public static void main(String[] args) {
        Conexao conn = new Conexao();
        
        IngredienteDAO iDAO = new IngredienteDAO();
        EstoqueIngredienteDAO eDAO = new EstoqueIngredienteDAO();
        
        Ingrediente ingrediente = new Ingrediente();
        Estoque estoque = new Estoque();
        
        ingrediente.setDescricao("123132123333333333333333333");
        ingrediente.setIdIngrediente(88);
        ingrediente.setNome("asdasdddddddddddddddd");
        ingrediente.setPreco(12.22);
        ingrediente.setQtd(14.00f);
        
        estoque.setIdEstoque(88);
        estoque.setIngrediente(ingrediente);
        estoque.setMdReposicao(1.1f);
        estoque.setQtdEstoque(1.1f);
        
        iDAO.salvar(ingrediente);
        eDAO.salvarById(estoque);
        
       
    }
            
}
