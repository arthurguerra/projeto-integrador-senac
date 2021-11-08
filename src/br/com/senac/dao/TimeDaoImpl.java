/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author arthur.batista1
 */
public class TimeDaoImpl {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;
    
    

    public void salvar(Time time) {
        sql = "INSERT INTO time(nome, campeonato) VALUES (?, ?)";

        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, time.getNome());
            ps.setObject(2, time.getCampeonato());
            ps.executeUpdate();
//            resultado = ps.getGeneratedKeys();
//            resultado.next();
//            time.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("erro ao SALVAR time " + e.getMessage());
        }
    }

}
