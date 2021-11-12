/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Modalidade;
import br.com.senac.entidade.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author arthur.batista1
 */
public class TimeDaoImpl {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;
    private Time time;
    private ModalidadeImpl modalidadeImpl = new ModalidadeImpl();

    public void salvar(Time time) {
        sql = "INSERT INTO time(nome, idmodalidade) VALUES (?, ?)";

        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, time.getNome());
            ps.setInt(2, time.getModalidade().getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao SALVAR time " + e.getMessage());
        }
    }

    public void alterar(Time time) {
        sql = "UPDATE time SET nome=?, idmodalidade=? WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, time.getNome());
            ps.setInt(2, time.getModalidade().getId());
            ps.setInt(3, time.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao ALTERAR time: " + e.getMessage());
        }
    }

    public Time pesquisarPorId(Integer id) {
        sql = "SELECT * FROM time WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                time = new Time();
                time.setId(resultado.getInt("id"));
                time.setNome(resultado.getString("nome"));
                time.setModalidade(modalidadeImpl.pesquisarPorId(resultado.getInt("idmodalidade")));
            }
        } catch (Exception e) {
            System.err.println("Erro ao PESQUISAR time POR ID: " + e.getMessage());
        }
        return time;
    }

    public List<Time> pesquisarPorNome(String nome) {
        sql = "SELECT * FROM time WHERE nome LIKE ?";
        List<Time> times = new LinkedList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                time = new Time();
                time.setId(resultado.getInt("id"));
                time.setNome(resultado.getString("nome"));
                time.setModalidade(modalidadeImpl.pesquisarPorId(resultado.getInt("idmodalidade")));
                times.add(time);
            }
        } catch (Exception e) {
            System.err.println("Erro ao PESQUISAR time POR NOME: " + e.getMessage());
        }
        return times;
    }

    public List<Time> listar() {
        sql = "SELECT * FROM time";
        List<Time> times = new ArrayList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                time = new Time();
                time.setId(resultado.getInt("id"));
                time.setNome(resultado.getString("nome"));
                time.setModalidade(modalidadeImpl.pesquisarPorId(resultado.getInt("idmodalidade")));
                times.add(time);
            }
        } catch (Exception e) {
            System.err.println("Erro ao LISTAR times: " + e.getMessage());
        }
        return times;
    }
    
    public void excluir(Integer id){
        sql = "DELETE FROM time WHERE id=?";
        List<Time> times = new ArrayList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao LISTAR time: "+e.getMessage());
        }
    }

}
