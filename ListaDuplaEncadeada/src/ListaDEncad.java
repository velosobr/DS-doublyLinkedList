public interface ListaDEncad {


    //METODOS CURSOR


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

    /**
     * posiciona o cursor apontando p/ elemento encontrado
     *
     * @param ref - referencia para retorno
     * @return - retorna o elemento buscado
     */
    public boolean busca(int ref);

    /**
     * Metódos de manipulação da caixa
     */

    /**
     *
     */
    public void insereNaFrente();

    /**
     *
     */
    public void insereNoFim();

    /**
     *
     */
    public void InsereAposAtual();

    /**
     *
     */
    public void insereAntesAtual();

    /**
     * @param pos
     */
    public void insereNaPosicao(int pos);

    /**
     *
     */
    public void excluirPrimeiro();

    /**
     *
     */
    public void excluirUltimo();


    /**
     * - onde está o cursor
     */
    public void excluiAtual();

    /**
     *
     */
    public void acessaAtual();

}
