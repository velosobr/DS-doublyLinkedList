package com.company;

import com.sun.media.sound.ModelStandardTransform;

import java.awt.*;
import java.util.ArrayList;

public class ListaDuplamenteEncadeada<T> {

    private Caixa comeco;
    private Caixa fim;
    private Caixa cursor;
    private int contadorElem;

    public boolean busca(int ref) {
        vaParaPrimeiro();
        Aluno alunoBuscado = (Aluno) pegaCaixa(ref).getElemento();
        if (alunoBuscado.getId() == ref)
            return true;

        return false;
    }

    public void insereNoComeco(T elemento) {

        Caixa caixaNova = new Caixa(elemento);

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
            Caixa caixaNova = new Caixa(elemento);
            caixaNova.setAnterior(fim);
            this.fim.setProximo(caixaNova);
            this.fim = caixaNova;
            this.cursor = caixaNova;
            this.contadorElem++;
        }

    }

    public void InsereAposAtual(T elemento) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        }if(this.cursor.getProximo()==null) {
            System.out.println("Caiu na condição de this.cursor.getProximo()==nu");
            this.insereNoFim(elemento);
        }else {
            Caixa caixaNova = new Caixa(elemento);
            caixaNova.setAnterior(cursor);
            caixaNova.setProximo(cursor.getProximo());
            this.cursor.getProximo().setAnterior(caixaNova);
            this.cursor.setProximo(caixaNova);
            this.cursor = caixaNova;
            this.contadorElem++;
        }
    }


    public void insereAntesAtual(T elemento) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        } if(this.cursor.getAnterior() == null){
            this.insereNoComeco(elemento);

        }else {
            Caixa caixaNova = new Caixa(elemento);

            caixaNova.setAnterior(this.cursor.getAnterior());
            caixaNova.setProximo(this.cursor);
            this.cursor.getAnterior().setProximo(caixaNova);
            this.cursor.setAnterior(caixaNova);
            this.cursor = caixaNova;
            this.contadorElem++;
        }

    }

    public void insereNaPosicao(int pos, T elemento) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(elemento);
        } else if (pos == 0) {
            this.insereNoComeco(elemento);
        } else if (pos == contadorElem) {
            this.insereNoFim(elemento);
        } else {
            Caixa caixaAux = pegaCaixa(pos - 1);
            Caixa caixaNova = new Caixa(elemento);

            caixaNova.setAnterior(caixaAux);
            caixaNova.setProximo(caixaAux.getProximo());
            caixaAux.getProximo().setAnterior(caixaNova);
            caixaAux.setProximo(caixaNova);
            cursor = caixaNova;
            this.contadorElem++;

        }
    }

    public void excluirPrimeiro() {
        if (!posicaoOcupada(0))
            throw new IllegalArgumentException("Posição não existe");

        this.comeco = comeco.getProximo();
        this.contadorElem--;
    }

    public void excluirUltimo() {
        if (!this.posicaoOcupada(this.contadorElem - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        } else {
            Caixa caixaAux = this.fim.getAnterior();
            caixaAux.setProximo(null);
            this.fim = caixaAux;
            this.contadorElem--;
        }

    }

    public void excluiAtual() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.cursor.setElemento(null);
    }

    public Object acessaAtual() {
        if (this.cursor == null) {
            throw new IllegalArgumentException("Posição não existe");
        }
        return this.cursor;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.contadorElem;
    }

    private Caixa pegaCaixa(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Caixa atual = comeco;
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
        vaParaPrimeiro();
        Aluno aux = null;
        StringBuilder mostraNaTela = new StringBuilder();
        mostraNaTela.append("[");
        while (this.cursor.getProximo() != null) {
            aux = (Aluno) this.cursor.getElemento();//FIXME - não consigo não criar uma variavel aux;
            mostraNaTela.append(aux.getNome());
            mostraNaTela.append(", ");
            this.cursor = this.cursor.getProximo();
        }
        aux = (Aluno) this.fim.getElemento();
        mostraNaTela.append(aux.getNome());
        mostraNaTela.append("]");
        System.out.println(mostraNaTela);


    }

    public void imprimeLista(String message) {
        vaParaPrimeiro();
        Aluno aux = null;
        StringBuilder mostraNaTela = new StringBuilder();
        mostraNaTela.append("[");
        while (this.cursor.getProximo() != null) {
            aux = (Aluno) this.cursor.getElemento();//FIXME - não consigo não criar uma variavel aux;
            mostraNaTela.append(aux.getNome());
            mostraNaTela.append(", ");
            this.cursor = this.cursor.getProximo();
        }
        aux = (Aluno) this.fim.getElemento();
        mostraNaTela.append(aux.getNome());
        mostraNaTela.append("]");
        System.out.println(message + mostraNaTela);

    }

}
