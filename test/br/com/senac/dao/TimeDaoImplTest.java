/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Campeonato;
import br.com.senac.entidade.Modalidade;
import br.com.senac.entidade.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.batista1
 */
public class TimeDaoImplTest {

    private Time time;
    private TimeDaoImpl timeDaoImpl;
    private Modalidade modalidade;
    private ModalidadeImpl modalidadeImpl;

    public TimeDaoImplTest() {
        timeDaoImpl = new TimeDaoImpl();
        modalidadeImpl = new ModalidadeImpl();
    }

//    @Test 
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        time = new Time();
        time.setNome("time do teste excluir");
        modalidade = modalidadeImpl.pesquisarPorId(1);
        time.setIdmodalidade(modalidade.getId());
        timeDaoImpl.salvar(time);
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        time = timeDaoImpl.pesquisarPorId(4);
        time.setNome("Vasco");
        time.setIdmodalidade(4);
        timeDaoImpl.alterar(time);
    }
    
//    @Test
    public void testPesquisarPorId(){
        System.out.println("Pesquisar por ID");
        time = timeDaoImpl.pesquisarPorId(2);
        imprimeTime(time);
    }
    
//    @Test
    public void testPesquisarPorNome() {
        System.out.println("Pesquisar por NOME");
        List<Time> times = new LinkedList<>();
        times = timeDaoImpl.pesquisarPorNome("Atlético");
        times.stream().forEach((time) -> {
            imprimeTime(time);
        });
    }
    
//    @Test
    public void testListar(){
        System.out.println("listar");
        List<Time> times = new LinkedList<>();
        times = timeDaoImpl.listar();
        times.forEach((time) -> {
            imprimeTime(time);
        });
    }
    
    @Test
    public void testExcluir(){
        System.out.println("excluir");
        timeDaoImpl.excluir(8);
    }
    
    private void imprimeTime(Time time){
        System.out.println("ID: "+time.getId());
        System.out.println("Nome: "+time.getNome());
        System.out.println("ID Modalidade: "+time.getIdmodalidade());
        System.out.println("--------------------------------");
    }
    
}
