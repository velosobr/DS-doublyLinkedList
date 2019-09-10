import java.awt.*;
import java.util.ArrayList;

public class ListaDuplamenteEncadeada implements ListaDEncad {

    private Caixa comeco;
    private Caixa fim;
    private Caixa cursor;
    private int contadorElem;

    public ListaDuplamenteEncadeada() {
        this.comeco = new Caixa();
        this.fim = new Caixa();
        this.cursor = comeco;

    }

    @Override
    public boolean busca(int ref) {
        return false;
    }

    @Override
    public void insereNoComeco(String nome, int idade, String curso) {
        Aluno aluno = new Aluno(nome, idade, curso);
        Caixa caixaNova = new Caixa(aluno);

        if (comeco == null && fim == null) {
            this.comeco = caixaNova;
            this.fim = caixaNova;
            this.cursor = caixaNova;
        } else {
            caixaNova.setProximo(comeco);
            comeco.setAnterior(caixaNova);
            this.comeco = caixaNova;
            this.cursor = caixaNova;
        }
        this.contadorElem++;

    }

    @Override
    public void insereNoFim(String nome, int idade, String curso) {
        //FIX ME verificando duas vezes
        if (comeco == null && fim == null) {
            this.insereNoComeco(nome, idade, curso);
        } else {
            Aluno aluno = new Aluno(nome, idade, curso);
            Caixa caixaNova = new Caixa(aluno);
            caixaNova.setAnterior(fim);
            this.fim.setProximo(caixaNova);
            this.fim = caixaNova;
            this.cursor = caixaNova;
            this.contadorElem++;
        }

    }

    @Override
    public void InsereAposAtual(String nome, int idade, String curso) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(nome, idade, curso);
        } else {
            Aluno aluno = new Aluno(nome, idade, curso);
            Caixa caixaNova = new Caixa(aluno);
            caixaNova.setAnterior(cursor);
            caixaNova.setProximo(cursor.getProximo());
            this.cursor.getProximo().setAnterior(caixaNova);
            this.cursor.setProximo(caixaNova);
            this.cursor = caixaNova;
            this.contadorElem++;
        }
    }


    @Override
    public void insereAntesAtual(String nome, int idade, String curso) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(nome, idade, curso);
        } else {
            Aluno aluno = new Aluno(nome, idade, curso);
            Caixa caixaNova = new Caixa(aluno);

            caixaNova.setAnterior(cursor.getAnterior());
            caixaNova.setProximo(cursor);
            this.cursor.getAnterior().setProximo(caixaNova);
            this.cursor.setAnterior(caixaNova);
            this.cursor = caixaNova;
            this.contadorElem++;
        }

    }

    @Override
    public void insereNaPosicao(int pos, String nome, int idade, String curso) {
        if (comeco == null && fim == null) {
            this.insereNoComeco(nome, idade, curso);
        } else if (pos == 0) {
            this.insereNoComeco(nome, idade, curso);
        } else if (pos == contadorElem) {
            this.insereNoFim(nome, idade, curso);
        } else {
            Caixa caixaAux = pegaCaixa(pos - 1);
            Aluno aluno = new Aluno(nome, idade, curso);
            Caixa caixaNova = new Caixa(aluno);

            caixaNova.setAnterior(caixaAux);
            caixaNova.setProximo(caixaAux.getProximo());
            caixaAux.getProximo().setAnterior(caixaNova);
            caixaAux.setProximo(caixaNova);
            cursor = caixaNova;
            this.contadorElem++;

        }
    }

    @Override
    public void excluirPrimeiro() {
        if (!posicaoOcupada(0))
            throw new IllegalArgumentException("Posição não existe");

        this.comeco = comeco.getProximo();
        this.contadorElem--;
    }

    @Override
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

    @Override
    public void excluiAtual() {

    }

    @Override
    public void acessaAtual() {

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

    }

    /**
     * método que desloca o cursor para a ultima posição
     */
    private void vaParaUltimo() {

    }

    /**
     * método que avança o cursor em N posições, de acordo com a qtd informada no parametro
     *
     * @param qtd - quantidade de posições para movimentação do cursos
     */
    private void avancaNPos(int qtd) {

    }

    /**
     * método que retrocede o cursor em N posições, de acordo com a qtd informada no parametro
     *
     * @param qtd - quantidade de posições para movimentação do cursos
     */
    private void retrocedeNPos(int qtd) {

    }

}
