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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthur.batista1
 */
public class JogadorDaoImpl {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;
    private Jogador jogador;

    public void salvar(Jogador jogador) throws Exception {

        sql = "INSERT INTO jogador(nome, idtime) VALUES (?, ?)";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getIdtime());
            ps.executeUpdate();
            resultado = ps.getGeneratedKeys();
            resultado.next();
            jogador.setId(resultado.getInt(1));
        } catch (Exception e) {
            throw new Exception("erro ao SALVAR jogador" + e.getMessage());
        }
    }

    public void alterar(Jogador jogador) {

        sql = "UPDATE jogador SET nome=?, idtime=? WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getIdtime());
            ps.setInt(3, jogador.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao alterar jogador: " + e.getMessage());
        }
    }

    public Jogador pesquisarPorId(Integer id) {

        sql = "SELECT * FROM jogador WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                jogador = new Jogador();
                jogador.setId(resultado.getInt("id"));
                jogador.setNome(resultado.getString("nome"));
                jogador.setIdtime(resultado.getInt("idtime"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao pesquisar jogador por ID: " + e.getMessage());
        }
        return jogador;
    }

    public List<Jogador> pesquisarPorNome(String nome) {

        sql = "SELECT * FROM jogador WHERE nome LIKE ?";
        List<Jogador> jogadores = new ArrayList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                jogador = new Jogador();
                jogador.setId(resultado.getInt("id"));
                jogador.setNome(resultado.getString("nome"));
                jogador.setIdtime(resultado.getInt("idtime"));
                jogadores.add(jogador);
            }
        } catch (Exception e) {
            System.err.println("Erro ao pesquisar jogador por nome: " + e.getMessage());
        }
        return jogadores;
    }

    public List<Jogador> listar() {

        sql = "SELECT * FROM jogador";
        List<Jogador> jogadores = new ArrayList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                jogador = new Jogador();
                jogador.setId(resultado.getInt("id"));
                jogador.setNome(resultado.getString("nome"));
                jogador.setIdtime(resultado.getInt("idtime"));
                jogadores.add(jogador);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar jogadores: " + e.getMessage());
        }
        return jogadores;
    }

    public void excluir(Integer id) {

        sql = "DELETE FROM jogador WHERE id = ?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao excluir jogador: " + e.getMessage());
        }
    }
}
