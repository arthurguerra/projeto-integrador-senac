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
import java.util.ArrayList;
import java.util.List;

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

    public void salvar(Campeonato campeonato) {
        sql = "INSERT INTO campeonato(nome, localidade, inicio, fim) VALUES (?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, campeonato.getNome());
            ps.setString(2, campeonato.getLocalidade());
            ps.setDate(3, new Date(campeonato.getInicio().getTime()));
            ps.setDate(4, new Date(campeonato.getFim().getTime()));
            ps.executeUpdate();
            resultado = ps.getGeneratedKeys();
            resultado.next();
            campeonato.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("Erro ao SALVAR campeonato: " + e.getMessage());
        }
    }

    public void alterar(Campeonato campeonato) {
        sql = "UPDATE campeonato SET nome=?, localidade=?, inicio=?, fim=? WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, campeonato.getNome());
            ps.setString(2, campeonato.getLocalidade());
            ps.setDate(3, new Date(campeonato.getInicio().getTime()));
            ps.setDate(4, new Date(campeonato.getFim().getTime()));
            ps.setInt(5, campeonato.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao ALTERAR campeonato: " + e.getMessage());
        }
    }

    public Campeonato pesquisarPorId(Integer id) {
        sql = "SELECT * FROM campeonato WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                campeonato = new Campeonato();
                campeonato.setId(resultado.getInt("id"));
                campeonato.setNome(resultado.getString("nome"));
                campeonato.setLocalidade(resultado.getString("localidade"));
                campeonato.setInicio(resultado.getDate("inicio"));
                campeonato.setFim(resultado.getDate("fim"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao PESQUISAR campeonato POR ID: " + e.getMessage());
        }
        return campeonato;
    }

    public List<Campeonato> pesquisarPorNome(String nome) {
        sql = "SELECT * FROM campeonato WHERE nome LIKE ?";
        List<Campeonato> campeonatos = new ArrayList();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                campeonato = new Campeonato();
                campeonato.setId(resultado.getInt("id"));
                campeonato.setNome(resultado.getString("nome"));
                campeonato.setLocalidade(resultado.getString("localidade"));
                campeonato.setInicio(new Date(resultado.getDate("inicio").getTime()));
                campeonato.setFim(new Date(resultado.getDate("fim").getTime()));
                campeonatos.add(campeonato);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar campeonatos: " + e.getMessage());
        }
        return campeonatos;
    }

    public List<Campeonato> listar() {
        sql = "SELECT * FROM campeonato";
        List<Campeonato> campeonatos = new ArrayList();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                campeonato = new Campeonato();
                campeonato.setId(resultado.getInt("id"));
                campeonato.setNome(resultado.getString("nome"));
                campeonato.setLocalidade(resultado.getString("localidade"));
                campeonato.setInicio(new Date(resultado.getDate("inicio").getTime()));
                campeonato.setFim(new Date(resultado.getDate("fim").getTime()));
                campeonatos.add(campeonato);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar campeonatos: " + e.getMessage());
        }
        return campeonatos;
    }

    public void excluir(int id) {
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement("DELETE FROM campeonato WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar campeonato" + e.getMessage());
        }
    }
}
