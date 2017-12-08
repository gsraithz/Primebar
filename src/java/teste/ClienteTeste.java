 package teste;

import DAO.PessoaDAO;
import DAO.ProdutoDAO;
import DAO.ReceitaDAO;
import Model.Pessoa;
import Model.Produto;
import Model.Receita;
import java.util.Date;
import java.util.List;
import util.Conexao;

public class ClienteTeste {
    
    public static void main(String[] args) {
    
        Conexao conn = new Conexao();
        
        ReceitaDAO rDAO = new ReceitaDAO();
        ProdutoDAO pDAO = new ProdutoDAO();
        
        Receita rec = new Receita();
        rec.setNome("Receita de Esfirra");
        rec.setModoPreparo("Modo de preparo da Esfirra");
        rec.setCustoReceita(5000.00);
       
        rDAO.salvar(rec);
       

      
        
        Pessoa matheus = new Pessoa();
        matheus.setIdPessoa(124);
        matheus.setNome("Matheus");
        matheus.setBairro("Itoupavazinha");
        matheus.setDtNasc(new Date(1997, 12, 9));
        matheus.setEmail("matheus@email.com");
        matheus.setEstado("Santa Catarina");
        matheus.setMunicipio("Blumenau");
        matheus.setNumero(226);
        matheus.setRua("Jardim Germânico");
        matheus.setSaldoConta(110.50);
        matheus.setSenha("123");
        matheus.setSobrenome("Henrique Raymundo");
        matheus.setTelefone("(47) 3338 - 4740");
        matheus.setPermissao("ROLE_ADMIN");
        
        Pessoa raithz = new Pessoa();
        raithz.setNome("Gabriel");
        raithz.setBairro("Somewhere");
        raithz.setDtNasc(new Date(1997, 11, 21));
        raithz.setEmail("raithz@email.com");
        raithz.setEstado("Santa Catarina");
        raithz.setMunicipio("Blumenau");
        raithz.setNumero(26);
        raithz.setRua("Rua Ant. da Veiga");
        raithz.setSaldoConta(110.50);
        raithz.setSenha("123");
        raithz.setSobrenome("Raithz");
        raithz.setTelefone("(47) 3333 - 3333");
        raithz.setPermissao("ROLE_FUNC");
        
        PessoaDAO peDAO = new PessoaDAO();
        peDAO.salvar(matheus);
        peDAO.salvar(raithz);
       

        

    }
}
