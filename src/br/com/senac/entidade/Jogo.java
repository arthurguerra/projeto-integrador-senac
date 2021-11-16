/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

/**
 *
 * @author ARTHUR
 */
public class Jogo {
    
    private Integer id;
    private Integer idmodalidade;
    private Integer idcampeonato;
    private Integer idtime1;
    private Integer idtime2;    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdmodalidade() {
        return idmodalidade;
    }

    public void setIdmodalidade(Integer idmodalidade) {
        this.idmodalidade = idmodalidade;
    }

    public Integer getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public Integer getIdtime1() {
        return idtime1;
    }

    public void setIdtime1(Integer idtime1) {
        this.idtime1 = idtime1;
    }

    public Integer getIdtime2() {
        return idtime2;
    }

    public void setIdtime2(Integer idtime2) {
        this.idtime2 = idtime2;
    }    
}
