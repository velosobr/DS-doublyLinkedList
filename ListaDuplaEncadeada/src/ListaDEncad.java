import java.util.ArrayList;

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
     * insere após posição atual do cursor
     */
    public void InsereAposAtual(String nome, int idade, String curso);

    /**
     * Insere antes da atual posição do cursor
     */
    public void insereAntesAtual(String nome, int idade, String curso);

    /**
     * Insere o Objeto na posição informada por pos
     * @param pos
     */
    public void insereNaPosicao(int pos, String nome, int idade, String curso);

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
     * @return 
     *
     */
    public Object acessaAtual();

}
