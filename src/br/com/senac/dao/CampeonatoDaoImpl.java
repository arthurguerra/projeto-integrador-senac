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
    private Campeonato campeonato;
    
    public void salvar(Campeonato campeonato){
        sql = "INSERT INTO campeonato(nome, localidade, dtcampeonato) VALUES (?, ?, ?)";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, campeonato.getNome());
            ps.setString(2, campeonato.getLocalidade());
            ps.setDate(3, new Date(campeonato.getDtcampeonato().getTime()));
            ps.executeUpdate();
            resultado = ps.getGeneratedKeys();
            resultado.next();
            campeonato.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("erro ao SALVAR " + e.getMessage());
        }
    }
    
    public void alterar(Campeonato campeonato) {
        sql = "UPDATE campeonato SET nome=?, localidade=?, dtcampeonato=? WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, campeonato.getNome());
            ps.setString(2, campeonato.getLocalidade());
            ps.setDate(3, new Date(campeonato.getDtcampeonato().getTime()));
            ps.setInt(4, campeonato.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao ALTERAR campeonato: "+e.getMessage());
        }
    }
    
    public Campeonato pesquisarPorId(Integer id){
        sql = "SELECT * FROM campeonato WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            if(resultado.next()){
                campeonato = new Campeonato();
                campeonato.setId(resultado.getInt("id"));
                campeonato.setNome(resultado.getString("nome"));
                campeonato.setLocalidade(resultado.getString("localidade"));
                campeonato.setDtcampeonato(resultado.getDate("dtcampeonato"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao PESQUISAR campeonato POR ID: "+e.getMessage());
        }
        return campeonato;
    }
}
