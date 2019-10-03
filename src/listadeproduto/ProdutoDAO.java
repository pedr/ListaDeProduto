/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadeproduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class ProdutoDAO {

    private Connection conn;
    
    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void insere(String cod, String descricao) {
        try {
            PreparedStatement pt = this.conn.prepareStatement("INSERT INTO produtos (cod, descricao) VALUES (?,?)");
            pt.setString(1, cod);
            pt.setString(2, descricao);
            pt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Produto> pegaTudo() {
        try {
            PreparedStatement pt = this.conn.prepareStatement("SELECT * FROM produtos");
            ResultSet rs = pt.executeQuery();
            ArrayList<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                Produto produto =  new Produto(rs.getString("cod"), rs.getString("descricao"));
                produto.setId(rs.getInt("id"));
                produtos.add(produto);
            }
            return produtos;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
}
