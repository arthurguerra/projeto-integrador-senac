/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Campeonato;
import br.com.senac.entidade.Time;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthur.batista1
 */
public class TimeDaoImplTest {

    private Time time;
    private TimeDaoImpl timeDaoImpl;
    

    public TimeDaoImplTest() {
        timeDaoImpl = new TimeDaoImpl();
    }

    @Test
    public void testSalvar() throws Exception {
       time = new Time("TESTE X");
       Campeonato campeonato = new Campeonato("TESTE", "BRASIL", new Date());
       time.setCampeonato(campeonato);
        timeDaoImpl.salvar(time);
        System.out.println("time salvo com sucesso");
    }

}
