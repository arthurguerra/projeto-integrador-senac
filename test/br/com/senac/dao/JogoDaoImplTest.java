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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ARTHUR
 */
public class JogoDaoImplTest {
    
    private Jogo jogo;
    private JogoDaoImpl jogoDaoImpl;
    private Modalidade modalidade;
    private ModalidadeImpl modalidadeImpl;
    private Campeonato campeonato;
    private CampeonatoDaoImpl campeonatoDaoImpl;
    private Time time;
    private TimeDaoImpl timeDaoImpl;
    
    public JogoDaoImplTest() {
        jogoDaoImpl = new JogoDaoImpl();
        modalidadeImpl = new ModalidadeImpl();
        campeonatoDaoImpl = new CampeonatoDaoImpl();
        timeDaoImpl = new TimeDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        jogo = new Jogo();
        modalidade = modalidadeImpl.pesquisarPorId(3);
        jogo.setModalidade(modalidade);
        campeonato = campeonatoDaoImpl.pesquisarPorId(6);
        jogo.setCampeonato(campeonato);
        time = timeDaoImpl.pesquisarPorId(1);
        jogo.setTime1(time);
        time = timeDaoImpl.pesquisarPorId(2);
        jogo.setTime2(time);
        jogoDaoImpl.salvar(jogo);
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        jogo = jogoDaoImpl.pesquisarPorId(1);
        campeonato = campeonatoDaoImpl.pesquisarPorId(4);
        jogo.setCampeonato(campeonato);
        time = timeDaoImpl.pesquisarPorId(3);
        jogo.setTime1(time);
        time = timeDaoImpl.pesquisarPorId(4);
        jogo.setTime2(time);
        jogoDaoImpl.alterar(jogo);
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        jogo = jogoDaoImpl.pesquisarPorId(1);
        imprimeJogo(jogo);
    }

//    @Test
    public void testListar() {
        System.out.println("listar");
        List<Jogo> jogos = new ArrayList<>();
        jogos = jogoDaoImpl.listar();
        jogos.stream().forEach((j) -> {
            imprimeJogo(j);
        });
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        jogoDaoImpl.excluir(2);
    }
    
    public void imprimeJogo(Jogo jogo){
        System.out.println("");
        System.out.println("ID do jogo: "+jogo.getId());
        System.out.println("Modalidade: "+jogo.getModalidade().getNome());
        System.out.println("Campeonato: "+jogo.getCampeonato().getNome());
        System.out.println("Time 1: "+jogo.getTime1().getNome());
        System.out.println("Time 2: "+jogo.getTime2().getNome());
    }
}
