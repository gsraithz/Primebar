package Controle;

import Model.Estoque;
import Model.Ingrediente;

public class ControleEstoque {
    
    public void reporEstoque(Ingrediente ingrediente, float peso) {
        
    }
    
    public static Estoque novoEstoqueIngrediente(Ingrediente ingrediente) {
        Estoque estoqueNovo = new Estoque();
        estoqueNovo.setIngrediente(ingrediente);
        estoqueNovo.setMdReposicao(new Float(0.0f));
        estoqueNovo.setQtdEstoque(new Float(0.0f));
        
        return estoqueNovo;
    }
    
}
