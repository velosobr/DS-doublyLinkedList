package com.company;

public class Caixa<T> {

    private T elemento;
    private Caixa anterior;
    private Caixa proximo;


    public Caixa(T elemento) {
        this.elemento = elemento;
    }

    public Caixa() {

    }

    public T getElemento() {
        return this.elemento;
    }
    
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Caixa getAnterior() {
        return this.anterior;
    }

    public Caixa getProximo() {
        return this.proximo;
    }

    public void setAnterior(Caixa anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Caixa topo) {
        this.proximo = topo;
    }
}
