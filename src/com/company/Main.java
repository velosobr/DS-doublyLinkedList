package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner tecladoAluno = new Scanner(System.in);

    public static void main(String[] args) {

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

        ListaDuplamenteEncadeada<Aluno> alunos = new ListaDuplamenteEncadeada<>();

        alunos.insereNoComeco(aluno1);
        alunos.insereNoComeco(aluno2);
        alunos.insereNaPosicao(1, aluno3);
        alunos.insereNoFim(aluno4);
        alunos.insereAntesAtual(aluno5);
        alunos.excluirPrimeiro();
        alunos.insereNoFim(aluno6);
        alunos.insereNoComeco(aluno7);
        alunos.insereNoFim(aluno8);
        alunos.insereNoComeco(aluno9);
        alunos.insereAntesAtual(aluno3);
        alunos.insereNoFim(aluno9);

        alunos.insereAposAtual(aluno8);
        alunos.insereNoFim(aluno7);
        alunos.insereNoFim(aluno6);
        alunos.insereNoFim(aluno5);
        String x = alunos.busca(3) ? "existe": "Não existe";
        System.out.println("o elemento de id igual a 3 existe?"+ x);
        Scanner teclado = new Scanner(System.in);


        int opcao;
        do {
            System.out.println("---------Lista Duplamente Encadeada---------");
            System.out.println("Opções: ");
            System.out.println("1 - Insere no comeco");
            System.out.println("2 - insere no fim");
            System.out.println("3 - Insere apos atual");
            System.out.println("4 - insere antes atual");
            System.out.println("5 - Insere na posicao");
            System.out.println("6 - Exclui primeiro");
            System.out.println("7 - Exclui último");
            System.out.println("8 - Exclui Atual");
            System.out.println("9 - Acessa Atual");
            System.out.println("10 - Mostra a Lista na tela");
            System.out.println("---------------------------");

            System.out.println("opcao: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case (1):
                    alunos.insereNoComeco(criaAluno());
                    break;
                case (2):
                    alunos.insereNoFim(criaAluno());
                    break;
                case (3):
                    alunos.insereAposAtual(criaAluno());
                    break;
                case (4):
                    alunos.insereAntesAtual(criaAluno());
                    break;
                case (5):
                    alunos.insereNaPosicao(perguntaPos(), criaAluno());
                case (6):
                    alunos.excluirPrimeiro();
                    break;
                case (7):
                    alunos.excluirUltimo();
                    break;
                case (8):
                    alunos.excluiAtual();
                    break;
                case (9):
                    alunos.acessaAtual();
                    break;
                case (10):
                    alunos.imprimeLista("Está é a lista: ");
                    break;
            }

        } while (opcao != 0);

    }

    private static int perguntaPos() {
        System.out.println("---Qual posição você quer inserir?---");
        return tecladoAluno.nextInt();
    }

    private static Aluno criaAluno() {
        System.out.println("ID: ");
        int id = tecladoAluno.nextInt();
        tecladoAluno.nextLine();
        System.out.println("Nome: ");
        String nome = tecladoAluno.nextLine();
        System.out.println("Idade: ");
        int idade = tecladoAluno.nextInt();
        tecladoAluno.nextLine();
        System.out.println("Curso: ");
        String curso = tecladoAluno.nextLine();

        return new Aluno(id, nome, idade, curso);
    }
}

