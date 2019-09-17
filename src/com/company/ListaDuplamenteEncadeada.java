package com.company;

import com.sun.media.sound.ModelStandardTransform;

import java.awt.*;
import java.util.ArrayList;

public class ListaDuplamenteEncadeada<T> {

    private Caixa<T> comeco;
    private Caixa<T> fim;
    private Caixa<T> cursor;
    private int contadorElem;

    {
        System.out.println("Lista ja esta vazia");
    }

    public boolean busca(int ref) {
        vaParaPrimeiro();
        return pegaCaixa(ref).getElemento() != null;
    }

    public void insereNoComeco(T elemento) {
        Caixa<T> caixaNova = new Caixa<>(elemento);

        if (comeco == null && fim == null) {
            this.comeco = caixaNova;
            this.fim = caixaNova;
            this.cursor = caixaNova;
        } else {
            caixaNova.setProximo(comeco);
            comeco.setAnterior(caixaNova);
            this.comeco = caixaNova;
            this.cursor = caixaNova; //ACREDITO QUE DA PARA TIRAR A ATRIBUIÇÃO DO CURSOR DA AQUI DE COLOCAR ELE EM UM ESCOPO ACIMA
        }
        this.contadorElem++;

    }

    public void insereNoFim(T elemento) {
        //FIX ME verificando duas vezes
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        } else {
            Caixa<T> caixaNova = new Caixa<>(elemento);
            caixaNova.setAnterior(fim);
            this.fim.setProximo(caixaNova);
            this.fim = caixaNova;
            this.cursor = caixaNova;
            this.contadorElem++;
        }

    }

    /**
     * insere após posição atual do cursor
     */
    public void insereAposAtual(T elemento) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        }
        if (this.cursor.getProximo() == null) {
            System.out.println("Caiu na condição de this.cursor.getProximo()==nu");
            this.insereNoFim(elemento);
        } else {
            Caixa<T> caixaNova = new Caixa<>(elemento);
            caixaNova.setAnterior(cursor);
            caixaNova.setProximo(cursor.getProximo());
            this.cursor.getProximo().setAnterior(caixaNova);
            this.cursor.setProximo(caixaNova);
            this.cursor = caixaNova;
            this.contadorElem++;
        }
    }

    /**
     * Insere antes da atual posição do cursor
     */
    public void insereAntesAtual(T elemento) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        }
        if (this.cursor.getAnterior() == null) {
            this.insereNoComeco(elemento);

        } else {
            Caixa<T> caixaNova = new Caixa<>(elemento);

            caixaNova.setAnterior(this.cursor.getAnterior());
            caixaNova.setProximo(this.cursor);
            this.cursor.getAnterior().setProximo(caixaNova);
            this.cursor.setAnterior(caixaNova);
            this.cursor = caixaNova;
            this.contadorElem++;
        }

    }

    /**
     * Insere o Objeto na posição informada por pos
     *
     * @param pos      - posicao na lista a ser inserida
     * @param elemento - Elemento a ser inserido na lista
     */
    public void insereNaPosicao(int pos, T elemento) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        } else if (pos == 0) {
            this.insereNoComeco(elemento);
        } else if (pos == contadorElem) {
            this.insereNoFim(elemento);
        } else {
            Caixa<T> caixaAux = pegaCaixa(pos - 1);
            Caixa<T> caixaNova = new Caixa<>(elemento);

            caixaNova.setAnterior(caixaAux);
            caixaNova.setProximo(caixaAux.getProximo());
            caixaAux.getProximo().setAnterior(caixaNova);
            caixaAux.setProximo(caixaNova);
            cursor = caixaNova;
            this.contadorElem++;

        }
    }

    /**
     * Exclui primeiro elemento da lista
     */
    public void excluirPrimeiro() {
        if (!posicaoOcupada(0))
            throw new IllegalArgumentException("Posição não existe");

        Caixa aux = comeco.getProximo();

        aux.setAnterior(null);
        comeco = aux;
        this.cursor = comeco;
        this.contadorElem--;
    }

    /**
     * Exclui ultimo elemento da lista
     */
    public void excluirUltimo() {
        if (contadorElem == 0) {
            throw new IllegalArgumentException("Lista está vazia");
        } else {
            Caixa aux = fim.getAnterior();
            fim.setAnterior(null);
            fim = aux;
            aux.setProximo(null);

            this.cursor = fim;
            this.contadorElem--;
        }

    }

    /**
     * Exclui atual elemento, onde o cursor está e move o cursor para o elemento anterior;
     */
    public void excluiAtual() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (acessaAtual() == comeco) {
            excluirPrimeiro();
        } else if (acessaAtual() == fim) {
            excluirUltimo();
        } else {
            Caixa temp = acessaAtual();
            temp.getAnterior().setProximo(temp.getProximo());
            temp.getProximo().setAnterior(temp.getAnterior());
            this.cursor = temp.getAnterior();
            temp.setAnterior(null);
            temp.setProximo(null);
            contadorElem--;
        }
    }


    /**
     * Retorna a caixa do elemento e mostra na tela um valor dos atributos do elemento.
     */
    public Caixa<T> acessaAtual() {
        System.out.println("Este é o nome do elemento no cursor: " + this.cursor.getElemento().toString());
        return this.cursor;
    }

    /**
     * Metodo auxiliar que valida se a posição passada por parametro é valida.
     */
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.contadorElem;
    }

    /**
     * metodo auxiliar que ajuda a retornar a caixa, atraves da posição passada
     */
    private Caixa<T> pegaCaixa(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Caixa<T> atual = comeco;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }
    /**
     METODOS CURSOR
     */

    /**
     * método que desloca o cursor para a primeira posição
     */


    private void vaParaPrimeiro() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor = this.comeco;
    }

    /**
     * método que desloca o cursor para a ultima posição
     */
    private void vaParaUltimo() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor = this.fim;
    }

    /**
     * método que avança o cursor em N posições, de acordo com a qtd informada no parametro
     *
     * @param qtd - quantidade de posições para movimentação do cursos
     */
    private void avancaNPos(int qtd) {

        for (int i = 0; i < qtd; i++) {
            if (this.cursor.getProximo() != null) {
                this.cursor = this.cursor.getProximo();
            } else {
                throw new IllegalArgumentException("Posição não existe");
            }
        }
    }

    /**
     * método que retrocede o cursor em N posições, de acordo com a qtd informada no parametro
     *
     * @param qtd - quantidade de posições para movimentação do cursos
     */
    private void retrocedeNPos(int qtd) {

        for (int i = 0; i < qtd; i++) {
            if (this.cursor.getAnterior() != null) {
                this.cursor = this.cursor.getAnterior();
            } else {
                throw new IllegalArgumentException("Posição não existe");
            }
        }
    }

    public void imprimeLista() {
        imprimeLista("");
    }

    public void imprimeLista(String message) {
        vaParaPrimeiro();
        StringBuilder mostraNaTela = new StringBuilder();
        try {
            mostraNaTela.append("[");
            while (this.cursor.getProximo() != null) {
                mostraNaTela.append(this.cursor.getElemento().toString());
                mostraNaTela.append(", ");
                this.cursor = this.cursor.getProximo();
            }
            mostraNaTela.append(this.fim.getElemento().toString());
            mostraNaTela.append("]");
            System.out.println(message + mostraNaTela);
        } catch (NullPointerException e) {

            System.out.println("Foi tentado acessar informação nula");
        }

    }

}
