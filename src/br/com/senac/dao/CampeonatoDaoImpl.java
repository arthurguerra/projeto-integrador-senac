/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Campeonato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author arthur.batista1
 */
public class CampeonatoDaoImpl {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;
    
//    public void salvarTime(Campeonato campeonato, int id, Connection conexao){
//        sql = "INSERT INTO campeonato(nome, localidade, dtcampeonato) VALUES (?, ?, ?)";
//        
//        salvar(campeonato, id, sql, conexao);
//    }
//    
//    private void salvar(Campeonato campeonato, int id, String sql, Connection conexao){        
//        try {
//            conexao = FabricaConexao.abreConexao();
//            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setString(1, campeonato.getNome());
//            ps.setString(2, campeonato.getLocalidade());
//            ps.setDate(3, new Date(campeonato.getDtcampeonato().getTime()));
//            ps.executeUpdate();            
//            resultado = ps.getGeneratedKeys();
//            resultado.next();
//            time.getId();
//        } catch (Exception e) {
//            System.out.println("erro ao SALVAR time "+e.getMessage());
//        }
//    }
    
    public void salvar(Campeonato campeonato){
        sql = "INSERT INTO campeonato(nome, localidade, dtcampeonato) VALUES (?, ?, ?)";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, campeonato.getNome());
            ps.setString(2, campeonato.getLocalidade());
            ps.setDate(3, new Date(campeonato.getDtcampeonato().getTime()));
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao SALVAR " + e.getMessage());
        }
    }
}
