/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author arthur.batista1
 */
public class JogadorDaoImpl {
    
 
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;

    
    public void salvar(Jogador jogador) throws Exception{
        sql = "INSERT INTO jogador(nome, localidade) VALUES (?, ?)";
        
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, jogador.getNome());
            ps.executeUpdate();
            resultado = ps.getGeneratedKeys();
            resultado.next();
            jogador.setId(resultado.getInt(1));
        } catch (Exception e) {
            throw new Exception("erro ao SALVAR jogador" + e.getMessage());
        }
    }
    
    
    
    
}
