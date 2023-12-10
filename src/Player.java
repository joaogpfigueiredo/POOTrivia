import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Player
 */
public class Player implements Serializable {

    /**
     * Nome do jogador.
     */
    private String name;

    /**
     * Inciais do nome do jogador.
     */
    protected String iniciaisNome;

    /**
     * Array com as respostas dadas pelo jogador.
     */
    private ArrayList<Pergunta> respostasDadas;

    /**
     * Data e hora do começo do jogo.
     */
    private String dataeHora;

    /**
     * Construtor da classe Player
     *
     * @param name Nome do jogador.
     * @param respostasDadas Respostas dadas pelo jogador.
     * @param dataeHora Data e hora de começo do jogo.
     */
    public Player(String name, ArrayList<Pergunta> respostasDadas, String dataeHora) {
        this.name = name;
        this.respostasDadas = respostasDadas;
        this.iniciaisNome = getIniciaisNome();
        this.dataeHora = dataeHora;
    }

    /**
     * Retorna as iniciais do nome do player.
     *
     * @return iniciais do nome do player.
     */
    public String getIniciaisNome() {
        String iniciaisNome = "";
        int contaMinusculas = 0;
        String nome = getName();
        for(int n = 0; n < nome.length(); n++){
            if(Character.isUpperCase(nome.charAt(n))){
                iniciaisNome += nome.charAt(n);
            } else{
                contaMinusculas++;
            }
            if(contaMinusculas == nome.length()){
               iniciaisNome += Character.toUpperCase(nome.charAt(0));
            }
        }
        return iniciaisNome;
    }

    /**
     * Define as iniciais do nome do player.
     *
     * @param iniciaisNome iniciais a serem inseridas.
     */
    public void setIniciaisNome(String iniciaisNome) {
        this.iniciaisNome = iniciaisNome;
    }

    /**
     * Retorna a data e hora do começo do jogo.
     *
     * @return data e hora de começo do jogo.
     */
    public String getDataeHora() {
        return dataeHora;
    }

    /**
     * Define a data e hora do jogo do player.
     *
     * @param dataeHora data e hora a serei substituídas.
     */
    public void setDataeHora(String dataeHora) {
        this.dataeHora = dataeHora;
    }

    /**
     * Retorna o nome do player.
     *
     * @return nome do player.
     */
    public String getName() {
        return name;
    }

    /**
     * Define um novo nome para o player em questão.
     *
     * @param name novo nome para o player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna as respostas dadas pelo player.
     *
     * @return respostas que o player deu.
     */
    public ArrayList<Pergunta> getRespostasDadas() {
        return respostasDadas;
    }

    /**
     * Define novas respostas dadas pelo player.
     *
     * @param respostasDadas novas respostas a serem substituídas.
     */
    public void setRespostasDadas(ArrayList<Pergunta> respostasDadas) {
        this.respostasDadas = respostasDadas;
    }

    /**
     * Método toString() da classe Player.
     *
     * @return String com o username do player e as duas respostas dadas.
     */
    @Override
    public String toString() {
        return "Username: " + getName() + "\nRespostas Dadas: " + getRespostasDadas();
    }
}
