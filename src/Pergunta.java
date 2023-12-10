import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe abstrata Pergunta
 */
public abstract class Pergunta implements Serializable {

    /**
     * Categoria da pergunta e a pergunta em si.
     */
    private String categoria, pergunta;

    /**
     * Pontuação base de cada pergunta e
     * nível de dificuldade de cada uma delas.
     */
    private int pontuacaoBase, index;

    /**
     * Resposta certa ou resposta incorreta
     */
    private boolean acertou;

    /**
     * Construtor da classe Pergunta.
     *
     * @param categoria Categoria da Pergunta.
     * @param pergunta Pergunta a ser disponibilizada.
     * @param index Nível de dificuldade da pergunta.
     * @param pontuacaoBase Pontuação base de cada pergunta.
     */
    public Pergunta(String categoria, String pergunta, int index, int pontuacaoBase){
        this.categoria = categoria;
        this.pergunta = pergunta;
        this.pontuacaoBase = pontuacaoBase;
        this.index = index;
    }

    /**
     * Define se a resposta dada está correta.
     */
    public void setAcertou() {
        this.acertou = true;
    }

    /**
     * Retorna true ou false consoante a resposta dada.
     *
     * @return true caso a resposta for a correta, false caso contrário.
     */
    public boolean isAcertou() {
        return acertou;
    }

    /**
     * Retorna a categoria da pergunta em questão.
     *
     * @return categoria da pergunta.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define uma nova categoria para a pergunta.
     *
     * @param categoria nova categoria da pergunta.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna a pergunta a ser disponibilizada na interface.
     *
     * @return pergunta.
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     * Define uma nova pergunta.
     *
     * @param pergunta nova pergunta.
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    /**
     * Retorna a pontuação base da pergunta em questão.
     *
     * @return pontuação base da pergunta.
     */
    public int getPontuacaoBase() {
        return pontuacaoBase;
    }

    /**
     * Define uma nova pontuação base para a pergunta.
     *
     * @param pontuacao nova pontuação base da pergunta.
     */
    public void setPontuacaoBase(int pontuacao) {
        this.pontuacaoBase = pontuacao;
    }

    /**
     * Retorna o indíce de dificuldade da pergunta.
     *
     * @return indíce de dificuldade.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Define um novo indíce para a pergunta escolhida.
     *
     * @param index novo indíce.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Método abstrato que retorna as opções da pergunta.
     *
     * @return opções da pergunta.
     */
    public abstract ArrayList<String> getOpcoes();

    /**
     * Método abstrato que define novas opções para a pergunta.
     *
     * @param opcoes novas opções da pergunta.
     */
    public abstract void setOpcoes(ArrayList<String> opcoes);

    /**
     * Método abstrato que retorna a resposta correta
     * da pergunta em questão.
     *
     * @return resposta correta.
     */
    public abstract String getCorreta();

    /**
     * Método abstrato responsável pelo
     * cálculo da pontuação de cada pergunta.
     *
     * @return pontuação obtida.
     */
    public abstract int pontuacao();

    /**
     * Método toString() da classe Pergunta
     *
     * @return String que contém a categoria, pergunta, e opções.
     */
    @Override
    public String toString() {
        return "Pergunta " + getIndex() + "\nCategoria: " + getCategoria() + "\nPergunta: " + getPergunta() + "\nOpcoes: " + getOpcoes();
    }
}
