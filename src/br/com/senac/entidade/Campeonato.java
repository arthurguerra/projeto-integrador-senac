/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

import java.util.Date;

/**
 *
 * @author arthur.batista1
 */
public class Campeonato {
    
    private int id;
    private String nome;
    private String localidade;
    private Date dtcampeonato;

    public Date getDtcampeonato() {
        return dtcampeonato;
    }

    public void setDtcampeonato(Date dtcampeonato) {
        this.dtcampeonato = dtcampeonato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Campeonato(String nome, String localidade, Date dtcampeonato) {
        this.nome = nome;
        this.localidade = localidade;
        this.dtcampeonato = dtcampeonato;
    }

    public Campeonato() {
    }
    
}
