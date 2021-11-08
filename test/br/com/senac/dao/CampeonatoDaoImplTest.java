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

    @Test
    public void testSalvar() throws Exception {
        System.out.println("SALVAR");
//        campeonato = new Campeonato("TESTA SALVAR CAMPEONATO", "PAÍS", new Date());
//        campeonatoDaoImpl.salvarTime(campeonato, id, null);
        
        campeonato = new Campeonato("TESTE SALVAR", "TESTE SALVAR", new Date());
        campeonatoDaoImpl.salvar(campeonato);
    }
    
}
