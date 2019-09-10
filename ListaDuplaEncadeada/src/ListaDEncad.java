public interface ListaDEncad {


    public boolean busca(int ref);

    /**
     * Metódos de manipulação da caixa
     */

    /**
     *
     */

    public void insereNoComeco(String nome, int idade, String curso);

    /**
     *
     */
    public void insereNoFim(String nome, int idade, String curso);

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
