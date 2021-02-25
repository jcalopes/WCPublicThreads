/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//import enumerations.EstadoPorta;
//import enumerations.EstadoWC;
//import enumerations.ModoUtilizacaoWC;
//import enumerations.PosicaoChave;

/**
 * 
 *  Nome:João Carlos Abreu Lopes 
    Número:8190221
    Turma:T1
 */
public class SharedInfo {
    String botao;
    EstadoWC estado;
    ModoUtilizacaoWC modo;
    float preco;
    double dinheiroInserido;
    int tempo;
    EstadoPorta porta;
    PosicaoChave posicao;
    String avisos;
    Boolean troco;
    
    public SharedInfo(){
        posicao=PosicaoChave.NEUTRA;
        estado=EstadoWC.LIVRE;
        modo=ModoUtilizacaoWC.USAR;
        porta=EstadoPorta.FECHADA;
        dinheiroInserido=0;
        preco=0;
        tempo=0;
        botao=null;    
        avisos=null;
        troco=false;
    }

    public EstadoPorta getPorta() {
        return porta;
    }

    public void setPorta(EstadoPorta porta) {
        this.porta = porta;
    }

    public EstadoWC getEstado() {
        return estado;
    }

    public void setEstado(EstadoWC estado) {
        this.estado = estado;
    }

    public ModoUtilizacaoWC getModo() {
        return modo;
    }

    public void setModo(ModoUtilizacaoWC modo) {
        this.modo = modo;
    }

    public void setBotao(String botao) {
        this.botao = botao;
    }

    public String getBotao() {
        return botao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    } 

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getDinheiroInserido() {
        return dinheiroInserido;
    }

    public void setDinheiroInserido(double dinheiroInserido) {
        this.dinheiroInserido = dinheiroInserido;
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }

    public PosicaoChave getPosicao() {
        return posicao;
    }

    public void setPosicao(PosicaoChave posicao) {
        this.posicao = posicao;
    }

    public Boolean getTroco() {
        return troco;
    }

    public void setTroco(Boolean troco) {
        this.troco = troco;
    }
  
}
