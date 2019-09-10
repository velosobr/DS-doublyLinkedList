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

    }

    @Override
    public void InsereAposAtual() {

    }

    @Override
    public void insereAntesAtual() {

    }

    @Override
    public void insereNaPosicao(int pos) {

    }

    @Override
    public void excluirPrimeiro() {

    }

    @Override
    public void excluirUltimo() {

    }

    @Override
    public void excluiAtual() {

    }

    @Override
    public void acessaAtual() {

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
