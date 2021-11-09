/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Campeonato;
import java.util.Date;
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
        campeonato = new Campeonato("Copa Libertadores da América", "América do Sul", new Date());
        campeonatoDaoImpl.salvar(campeonato);
    }

//    @Test
//    public void testAlterar() {
//        System.out.println("ALTERAR");        
//}
    //@Test
    public void testPesquisarPorId() {
        campeonato = campeonatoDaoImpl.pesquisarPorId(2);
        assertNotNull(campeonato);
        System.out.println(campeonato.getNome());
        //imprimeCampeonato(campeonato);
        
    }
    
    private void imprimeCampeonato(Campeonato camp) {
        System.out.println("ID: " + camp.getId());
        System.out.println("Nome: " + camp.getNome());
        System.out.println("Localidade: " + camp.getLocalidade());
        System.out.println("Data: " + camp.getDtcampeonato());
        System.out.println("------------------------------------");
    }

    @Test
    public void testAlterar() {
        campeonato = campeonatoDaoImpl.pesquisarPorId(1);
        campeonato.setNome("Olimpiadas 2021");
        campeonato.setLocalidade("Japao");
        campeonato.setDtcampeonato(new Date());
        //ver como coloca uma data especifica
        campeonatoDaoImpl.alterar(campeonato);
    }

    @Test
    public void testExcluir() {
       campeonatoDaoImpl.excluir(2);
    }
    
}
