/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadeproduto;

import java.util.ArrayList;
import listadeproduto.view.Tela;

/**
 *
 * @author Alunos
 */
public class ListaDeProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO(Conexao.getConexao());
        Produto p1 = new Produto("cod1", "desc1");
        Produto p2 = new Produto("cod2", "desc2");
        Produto p3 = new Produto("cod3", "desc3");
        Produto p4 = new Produto("asdfdsf", "produto sem cod na descricao");
        
        System.out.println("Inserindo...");
        dao.insere(new ArrayList<Produto>(){ 
            {   
                add(p1); 
                add(p2); 
                add(p3);
                add(p4);
            }
        });
        
        System.out.println("TUDO::\n");
        imprime(dao.pegaTudo());
        
        System.out.println("Procura por 'cod'");
        imprime(dao.findByCod("cod"));
        
        new Tela(Conexao.getConexao()).setVisible(true);
    }
    
    public static void imprime(ArrayList<Produto> produtos) {
        for (Produto p : produtos) {
            System.out.println("id: " + p.getId() + " - cod:" + p.getCod() + " - descr " + p.getDescricao());
        }
    }
    
}
