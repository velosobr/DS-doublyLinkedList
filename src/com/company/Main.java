package com.company;

public class Main {

    public static void main(String[] args){

        //Alunos
        Aluno aluno1 = new Aluno(1, "Lino", 26, "Sistemas");
        Aluno aluno2 = new Aluno(2, "Karla", 26, "Sistemas");
        Aluno aluno3 = new Aluno(3, "Maria", 26, "Prezinho");
        Aluno aluno4 = new Aluno(4, "Manarin", 26, "Sistemas");
        Aluno aluno5 = new Aluno(5, "Thiago", 34, "Sistemas");
        Aluno aluno6 = new Aluno(6, "Emanuela", 5, "Preescolar");
        Aluno aluno7 = new Aluno(7, "Joana", 22, "Sistemas");
        Aluno aluno8 = new Aluno(8, "Manu", 24, "Sistemas");
        Aluno aluno9 = new Aluno(9, "Vitor", 29, "Medicina");
        Aluno aluno10 = new Aluno(10, "Vinicius", 2, "Maternal");

        ListaDuplamenteEncadeada alunos = new ListaDuplamenteEncadeada();


        alunos.insereNoComeco(aluno1);
        alunos.imprimeLista("insereNoComeco: ");

        alunos.insereNoComeco(aluno2);
        alunos.imprimeLista("insereNoComeco: ");

        alunos.insereNaPosicao(1, aluno3);
        alunos.imprimeLista("insereNaPosicao: ");

        alunos.insereNoFim(aluno4);
        alunos.imprimeLista("insereNoFim: ");

        alunos.insereAntesAtual(aluno5);
        alunos.imprimeLista("insereAntesAtual: ");
        alunos.excluirPrimeiro();
        alunos.imprimeLista("excluirPrimeiro: ");
        alunos.insereNoFim(aluno6);
        alunos.imprimeLista("insereNoFim: ");
        alunos.insereNoComeco(aluno7);
        alunos.imprimeLista("insereNoComeco: ");
        alunos.insereNoFim(aluno8);
        alunos.imprimeLista("insereNoFim: ");
        alunos.insereNoComeco(aluno9);
        alunos.imprimeLista("insereNoComeco: ");
        alunos.insereAntesAtual(aluno3);
        alunos.imprimeLista("insereAntesAtual: ");
        alunos.insereNoFim(aluno9);
        alunos.imprimeLista("insereNoFim: ");

        alunos.InsereAposAtual(aluno8);
        alunos.imprimeLista("InsereAposAtual: ");
        alunos.insereNoFim(aluno7);
        alunos.imprimeLista("insereNoFim: ");
        alunos.insereNoFim(aluno6);
        alunos.imprimeLista("insereNoFim: ");
        alunos.insereNoFim(aluno5);
        String x = alunos.busca(3) ? "existe": "Não existe";
        System.out.println("o elemento de id igual a 3 existe?"+ x);
        alunos.imprimeLista("insereNoFim: ");

    }
}
