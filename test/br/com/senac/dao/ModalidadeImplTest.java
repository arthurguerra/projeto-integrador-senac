/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Modalidade;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.batista1
 */
public class ModalidadeImplTest {
    
    private Modalidade modalidade;
    private ModalidadeImpl modalidadeImpl;
    
    public ModalidadeImplTest() {
        modalidadeImpl = new ModalidadeImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        modalidade = new Modalidade();
        modalidade.setNome("Críquete");
        modalidadeImpl.salvar(modalidade);
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        modalidade = modalidadeImpl.pesquisarPorId(2);
        modalidade.setNome("Tênis de Mesa");
        modalidadeImpl.alterar(modalidade);
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        modalidade = modalidadeImpl.pesquisarPorId(2);
        imprimeModalidade(modalidade);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        List<Modalidade> modalidades = new LinkedList<>();
        modalidades = modalidadeImpl.pesquisarPorNome("Tênis");
        for(Modalidade modalidade : modalidades){
            imprimeModalidade(modalidade);
        }
    }

//    @Test
    public void testListar() {
        System.out.println("listar");
        List<Modalidade> modalidades = new LinkedList<>();
        modalidades = modalidadeImpl.listar();
        modalidades.stream().forEach((modalidade) -> {
            imprimeModalidade(modalidade);
        });
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        modalidadeImpl.excluir(5);
    }
    
    public void imprimeModalidade(Modalidade modalidade){
        System.out.println("ID: "+modalidade.getId());
        System.out.println("Nome: "+modalidade.getNome());
        System.out.println("---------------------------------");
    }
    
}
