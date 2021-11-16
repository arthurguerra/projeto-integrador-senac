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
    private Date inicio;
    private Date fim;

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
    
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
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

    public Campeonato(String nome, String localidade, Date inicio, Date fim) {
        this.nome = nome;
        this.localidade = localidade;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Campeonato() {
    }
    
}
