/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Campeonato;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.batista1
 */
public class CampeonatoDaoImplTest {

    private Campeonato campeonato;
    private CampeonatoDaoImpl campeonatoDaoImpl;

    public CampeonatoDaoImplTest() {
        campeonatoDaoImpl = new CampeonatoDaoImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("SALVAR");
        campeonato = new Campeonato("Campeonato América", "América", new Date(), new Date());
        campeonatoDaoImpl.salvar(campeonato);
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        campeonato = campeonatoDaoImpl.pesquisarPorId(6);
        campeonato.setNome("Olimpiadas 2024");
        campeonato.setLocalidade("Rússia");
        campeonato.setInicio(new Date());
        campeonato.setInicio(new Date(2020, 06, 28));
        campeonato.setFim(new Date());
        //ver como coloca uma data especifica
        campeonatoDaoImpl.alterar(campeonato);
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisar por ID");
        campeonato = campeonatoDaoImpl.pesquisarPorId(4);
        assertNotNull(campeonato);
        imprimeCampeonato(campeonato);

    }

//    @Test
    public void testListar() {
        System.out.println("listar");
        List<Campeonato> campeonatos = new ArrayList();
        campeonatos = campeonatoDaoImpl.listar();
        campeonatos.forEach((camp) -> {
            imprimeCampeonato(camp);
        });
    }

  @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisar por nome");
        List<Campeonato> campeonatos = new ArrayList();
        campeonatos = campeonatoDaoImpl.pesquisarPorNome("a");
        campeonatos.forEach((camp) -> {
            imprimeCampeonato(camp);
        });
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        campeonatoDaoImpl.excluir(6);
    }

    private void imprimeCampeonato(Campeonato camp) {
        System.out.println("ID: " + camp.getId());
        System.out.println("Nome: " + camp.getNome());
        System.out.println("Localidade: " + camp.getLocalidade());
        System.out.println("Início: " + camp.getInicio());
        System.out.println("Fim: " + camp.getFim());
        System.out.println("------------------------------------");
    }

}
