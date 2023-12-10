import java.io.Serializable;
import java.util.ArrayList;

/**
 * Subclasse Futebol da classe Pergunta.
 */
public class Futebol extends Pergunta implements Serializable {

    /**
     * Array com todas as opções possiveis para a questão.
     */
    private ArrayList<String> opcoes;

    /**
     * Construtor da classe Futebol.
     *
     * @param categoria Categoria da Pergunta.
     * @param pergunta Pergunta a ser respondida.
     * @param opcoes Opções da Pergunta.
     * @param index Nível da pergunta.
     * @param pontuacaoBase Pontuação base da pergunta.
     */
    public Futebol(String categoria, String pergunta, ArrayList<String> opcoes, int index, int pontuacaoBase) {
        super(categoria, pergunta, index, pontuacaoBase);
        this.opcoes = escolheOpcoes(opcoes);
    }

    /**
     * Retorna as opções que o jogador pode responder.
     *
     * @return opções possiveis para a pergunta.
     */
    @Override
    public ArrayList<String> getOpcoes() {
            return this.opcoes;
    }

    /**
     * Define novas opções para a pergunta em questão.
     *
     * @param opcoes novas opções da pergunta.
     */
    @Override
    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }

    /**
     * Retorna a opção correta da pergunta em questão.
     *
     * @return opção correta da pergunta
     */
    @Override
    public String getCorreta() {
        return this.opcoes.get(0);
    }

    /**
     * Método encarregue pela escolha das opções da pergunta
     * dependendo do seu nível de dificuldade.
     *
     * @param opcoes opções da pergunta.
     * @return opções com os nomes dos futebolistas ou opções com o número da camisola dos futebolistas.
     */
    public ArrayList<String> escolheOpcoes(ArrayList<String> opcoes) {
        if (getIndex() < 3) {
            opcoes.subList(5, 10).clear();
        }else {
            opcoes.subList(0, 5).clear();
        }
        return opcoes;
    }

    /**
     * Método responsável pelo cálculo da pontuação
     * a receber por dar a resposta correta.
     *
     * @return pontuação ganha por acertar a pergunta.
     */
    public int pontuacao() {
        return getPontuacaoBase() + 4;
    }

    /**
     * Método toString() da classe Futebol.
     *
     * @return String que contém a categoria, pergunta, opções e opção correta.
     */
    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
