/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Campeonato;
import br.com.senac.entidade.Jogo;
import br.com.senac.entidade.Modalidade;
import br.com.senac.entidade.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ARTHUR
 */
public class JogoDaoImpl {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;
    private Jogo jogo;
    private ModalidadeImpl modalidadeImpl;
    private Modalidade modalidade;
    private CampeonatoDaoImpl campeonatoDaoImpl;
    private Campeonato campeonato;
    private TimeDaoImpl timeDaoImpl;
    private Time time;

    public JogoDaoImpl() {
        modalidadeImpl = new ModalidadeImpl();
        campeonatoDaoImpl = new CampeonatoDaoImpl();
        timeDaoImpl = new TimeDaoImpl();
    }

    public void salvar(Jogo jogo) {
        sql = "INSER INTO jogo (idmodalidade, idcampeonato, idtime1, idtime2) VALUES (?,?,?,?)";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, jogo.getModalidade().getId());
            ps.setInt(2, jogo.getCampeonato().getId());
            ps.setInt(3, jogo.getTime1().getId());
            ps.setInt(4, jogo.getTime2().getId());
            ps.executeUpdate();
            resultado = ps.getGeneratedKeys();
            resultado.next();
            jogo.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.err.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    public void alterar(Jogo jogo) {
        sql = "UPDATE jogo SET idmodalidade=?, idcampeonato=?, idtime1=?, idtime2=? WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, jogo.getModalidade().getId());
            ps.setInt(2, jogo.getCampeonato().getId());
            ps.setInt(3, jogo.getTime1().getId());
            ps.setInt(4, jogo.getTime2().getId());
            ps.setInt(5, jogo.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao alterar jogo: " + e.getMessage());
        }
    }

    public Jogo pesquisarPorId(Integer id) {
        sql = "SELECT * FROM jogo WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                jogo = new Jogo();
                jogo.setId(resultado.getInt("id"));
                modalidade = modalidadeImpl.pesquisarPorId(resultado.getInt("idmodalidade"));
                jogo.setModalidade(modalidade);
                campeonato = campeonatoDaoImpl.pesquisarPorId(resultado.getInt("idcampeonato"));
                jogo.setCampeonato(campeonato);
                time = timeDaoImpl.pesquisarPorId(resultado.getInt("idtime1"));
                jogo.setTime1(time);
                time = timeDaoImpl.pesquisarPorId(resultado.getInt("idtime2"));
                jogo.setTime2(time);
            }
        } catch (Exception e) {
            System.err.println("Erro ao pesquisar jogo por ID: " + e.getMessage());
        }
        return jogo;
    }

    public List<Jogo> pesquisarPorNome(String nome) {
        sql = "SELECT * FROM jogo WHERE nome LIKE ?";
        List<Jogo> jogos = new ArrayList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                jogo = new Jogo();
                jogo.setId(resultado.getInt("id"));
                modalidade = modalidadeImpl.pesquisarPorId(resultado.getInt("idmodalidade"));
                jogo.setModalidade(modalidade);
                campeonato = campeonatoDaoImpl.pesquisarPorId(resultado.getInt("idcampeonato"));
                jogo.setCampeonato(campeonato);
                time = timeDaoImpl.pesquisarPorId(resultado.getInt("idtime1"));
                jogo.setTime1(time);
                time = timeDaoImpl.pesquisarPorId(resultado.getInt("idtime2"));
                jogo.setTime2(time);
                jogos.add(jogo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao pesquisar jogo por nome: " + e.getMessage());
        }
        return jogos;
    }

    public List<Jogo> listar() {
        sql = "SELECT * FROM jogo";
        List<Jogo> jogos = new ArrayList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                jogo = new Jogo();
                jogo.setId(resultado.getInt("id"));
                modalidade = modalidadeImpl.pesquisarPorId(resultado.getInt("idmodalidade"));
                jogo.setModalidade(modalidade);
                campeonato = campeonatoDaoImpl.pesquisarPorId(resultado.getInt("idcampeonato"));
                jogo.setCampeonato(campeonato);
                time = timeDaoImpl.pesquisarPorId(resultado.getInt("idtime1"));
                jogo.setTime1(time);
                time = timeDaoImpl.pesquisarPorId(resultado.getInt("idtime2"));
                jogo.setTime2(time);
                jogos.add(jogo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar jogos: " + e.getMessage());
        }
        return jogos;
    }

    public void excluir(Integer id) {
        sql = "DELETE FROM jogo WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao excluir jogo: " + e.getMessage());
        }
    }
}
