/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Modalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arthur.batista1
 */
public class ModalidadeImpl {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet resultado;
    private String sql;
    private Modalidade modalidade;

    public void salvar(Modalidade modalidade){
        sql = "INSERT INTO modalidade (nome) VALUES (?)";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, modalidade.getNome());
            ps.executeUpdate();
            resultado = ps.getGeneratedKeys();
            resultado.next();
            modalidade.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.err.println("Erro ao SALVAR modalidade: "+e.getMessage());
        }
    }
    
    public void alterar(Modalidade modalidade){
        sql = "UPDATE modalidade SET nome=? WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, modalidade.getNome());
            ps.setInt(2, modalidade.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro ao ALTERAR modalidade: "+e.getMessage());
        }
    }
    
    public Modalidade pesquisarPorId(Integer id){
        sql = "SELECT * FROM modalidade WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            if(resultado.next()){
                modalidade = new Modalidade();
                modalidade.setId(id);
                modalidade.setNome(resultado.getString("nome"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao PESQUISAR modalidade POR ID: "+e.getMessage());
        }
        return modalidade;
    }
    
    public List<Modalidade> pesquisarPorNome(String nome){
        sql = "SELECT * FROM modalidade WHERE nome LIKE ?";
        List<Modalidade> modalidades = new LinkedList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            resultado = ps.executeQuery();
            while(resultado.next()){
                modalidade = new Modalidade();
                modalidade.setId(resultado.getInt("id"));
                modalidade.setNome(resultado.getString("nome"));
                modalidades.add(modalidade);
            }
        } catch (Exception e) {
            System.err.println("Erro ao PESQUISAR modalidade POR NOME: "+e.getMessage());
        }
        return modalidades;
    }
    
    public List<Modalidade> listar(){
        sql = "SELECT * FROM modalidade";
        List<Modalidade> modalidades = new LinkedList<>();
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery();
            while(resultado.next()){
                modalidade = new Modalidade();
                modalidade.setId(resultado.getInt("id"));
                modalidade.setNome(resultado.getString("nome"));
                modalidades.add(modalidade);
            }
        } catch (Exception e) {
            System.err.println("Erro ao LISTAR modalidades: "+e.getMessage());
        }
        return modalidades;
    }
    
    public void excluir(Integer id){
        sql = "DELETE FROM modalidade WHERE id=?";
        try {
            conexao = FabricaConexao.abreConexao();
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modalidade excluída com sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao EXCLUIR modalidade: "+e.getMessage());
            JOptionPane.showMessageDialog(null, "Existem times vinculados a essa modalidade");
        }
    }
}
