/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadeproduto;

/**
 *
 * @author Alunos
 */
public class Produto {
    
    private int id;
    private String cod;
    private String descricao;

    public Produto(String cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
