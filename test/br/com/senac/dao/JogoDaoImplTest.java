/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Jogo;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ARTHUR
 */
public class JogoDaoImplTest {
    
    public JogoDaoImplTest() {
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Jogo jogo = null;
        JogoDaoImpl instance = new JogoDaoImpl();
        instance.salvar(jogo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Jogo jogo = null;
        JogoDaoImpl instance = new JogoDaoImpl();
        instance.alterar(jogo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Integer id = null;
        JogoDaoImpl instance = new JogoDaoImpl();
        Jogo expResult = null;
        Jogo result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        String nome = "";
        JogoDaoImpl instance = new JogoDaoImpl();
        List<Jogo> expResult = null;
        List<Jogo> result = instance.pesquisarPorNome(nome);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListar() {
        System.out.println("listar");
        JogoDaoImpl instance = new JogoDaoImpl();
        List<Jogo> expResult = null;
        List<Jogo> result = instance.listar();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Integer id = null;
        JogoDaoImpl instance = new JogoDaoImpl();
        instance.excluir(id);
        fail("The test case is a prototype.");
    }
    
}
