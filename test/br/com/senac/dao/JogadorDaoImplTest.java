/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Jogador;
import br.com.senac.entidade.Time;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.batista1
 */
public class JogadorDaoImplTest {
    
    private Jogador jogador;
    private JogadorDaoImpl jogadorDaoImpl;
    private Time time;
    private TimeDaoImpl timeDaoImpl;
    
    public JogadorDaoImplTest() {
        jogadorDaoImpl = new JogadorDaoImpl();
        timeDaoImpl = new TimeDaoImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        jogador = new Jogador();
        jogador.setNome("Robinho");
        time = timeDaoImpl.pesquisarPorId(1);
        jogador.setTime(time);
        jogadorDaoImpl.salvar(jogador);
    }

   //@Test
    public void testAlterar() {
       
        jogador = jogadorDaoImpl.pesquisarPorId(3);
       
        
        time = timeDaoImpl.pesquisarPorId(4);
        jogador.setTime(time);
        jogadorDaoImpl.alterar(jogador);
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        jogador = jogadorDaoImpl.pesquisarPorId(2);
        imprimeJogador(jogador);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        List<Jogador> jogadores = new ArrayList();
        jogadores = jogadorDaoImpl.pesquisarPorNome("Ronald");
        jogadores.forEach((jogador)->{
            imprimeJogador(jogador);
        });
    }

//    @Test
    public void testListar() {
        System.out.println("listar");
        List<Jogador> jogadores = new ArrayList();
        jogadores = jogadorDaoImpl.listar();
        jogadores.forEach((jogador) -> {
            imprimeJogador(jogador);
        });
    }


    public void testExcluir() {
        System.out.println("excluir");
        jogadorDaoImpl.excluir(5);
    }
    
    public void imprimeJogador(Jogador jogador){
        System.out.println("");
        System.out.println("ID do Jogador: "+jogador.getId());
        System.out.println("Nome: "+jogador.getNome());
        System.out.println("Time: "+jogador.getTime().getNome());
    }    
}
