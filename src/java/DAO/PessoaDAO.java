package DAO;

import Model.Pessoa;
import Model.Produto;
import java.util.List;
import javax.persistence.Query;
import util.Conexao;

public class PessoaDAO {
     private Conexao conn = new Conexao();
    
    //serve para alterar uma pessoa que ja 
    //estiver na lista ou adcionar uma nova pessoa na lista
    public void salvar(Pessoa p){
        if(p.getIdPessoa()== null) {
            conn.incluir(p);
        } else {
            conn.alterar(p);
        }
    }
    
    public void excluir(Pessoa p){
        conn.excluir(p);
    }
    
    public List<Pessoa> Listar(){
        List<Pessoa> pessoas = null;     
        pessoas = conn.getEm().createNamedQuery("Pessoa.findAll").getResultList();
         return pessoas;
    }
    
    public Pessoa procurarPorid(Integer id){
        Pessoa p = conn.getEm().find(Pessoa.class, id);
        conn.desconectar();
        return p;
    }
    
    public Pessoa procurarPeloNome(String nome) {
        Query q = conn.getEm().
                createQuery("select p from "
                        + "pessoa p where p.nome "
                        + "like '%"+nome+"%'");
        Pessoa p = (Pessoa) q.getSingleResult();
        conn.desconectar();
        return p;
    }
    public List<Pessoa> procurarPeloNome2(String nome) {

        List<Pessoa> pessoas = conn.getEm().createNamedQuery("Pessoa.findByNome").setParameter("nome", nome)
                .getResultList();
        conn.desconectar();
        return pessoas;
    }

//    public Pessoa procurarByLoginSenha(Pessoa obj) {
//        
//        obj.setPassword( SecurityUtils.MD5(obj.getPassword()) );
//        
//        Pessoa usuarioModel = executeQueryLine("select p from tb_login p where p.login = '"+obj.getNome()+"' and p.password = '"+obj.getSenha()+"'");
//        return usuarioModel;
//    }
    
}
