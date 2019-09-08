public class Caixa {

    Aluno aluno;
    Caixa anterior;
    Caixa proximo;


    public Caixa(Aluno aluno) {
        this.aluno = aluno;
        this.anterior = null;
        this.proximo = null;
    }

    public Aluno getAluno() {
        return this.aluno;
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
