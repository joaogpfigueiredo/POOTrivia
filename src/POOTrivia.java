import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe principal do nosso Jogo, aqui é onde vai ser criado o nosso JFrame
 * responsável pela criação da interface que irá suportar o nosso jogo.
 *
 * @author João Figueiredo e José Pedro
 * @version 1.17
 */


public class POOTrivia implements Serializable{

    /**
     * ArrayList onde são guardadas todas as perguntas do ficheiro Perguntas.txt.
     */
    private ArrayList<String> perguntasFicheiro = new ArrayList<>();

    /**
     * ArrayList responsável por armazenar as perguntar que vão ser apresentadas no jogo.
     */
    private ArrayList<Pergunta> perguntas = new ArrayList<>();

    /**
     * ArrayList onde são armazenados todos os players que já jogaram o jogo e que futuramente jogarão.
     */
    private ArrayList<Player> jogadores = new ArrayList<>();

    /**
     * ArrayList onde são guardados os jogadores com melhores pontuações.
     */
    protected ArrayList<String> topJogadores = new ArrayList<>();

    /**
     * Objeto da classe Ficheiro.
     */
    private Ficheiro ficheiro;

    /**
     * Construtor da nossa classe POOTrivia, aqui vamos ler pela primeira vez
     * as perguntas do ficheiro Perguntas.txt e armazenar no array de perguntas
     * de seguida vai ser feita a leitura do ficheiro Jogadores.txt que por sua
     * vez adiciona os players existentes ao array de players e por fim o top 3
     * vai ser cáculado.
     */
    public POOTrivia() {

        this.ficheiro = new Ficheiro(this.perguntasFicheiro, this.jogadores);

        this.ficheiro.sortearPerguntas();
        this.ficheiro.lerFicheiroJogadores();

        criarPerguntas();
        rankingTop3(this.jogadores);
    }

    /**
     * Na main vai ser criado o nosso jogo em si, vamos criar um objeto
     * JFrame responsável pela janela onde vai estar presente tudo sobre o jogo
     * outro objeto GamePanel que por sua vez extende JPanel que está ocupado
     * por fazer a ‘interface’ desde texto até butões, e por fim um objeto
     * ButtonListener encarregue por fazer os butões funcionarem.
     * @param args args vazio.
     */
    public static void main(String[] args) {

        POOTrivia pooTrivia = new POOTrivia();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        GamePanel panel = new GamePanel();
        panel.painelPrincipal();

        ButtonListener buttonListener = new ButtonListener(panel, pooTrivia.ficheiro, pooTrivia, pooTrivia.perguntas, pooTrivia.jogadores);
        panel.opc1.addActionListener(buttonListener);
        panel.opc2.addActionListener(buttonListener);
        panel.opc3.addActionListener(buttonListener);
        panel.opc4.addActionListener(buttonListener);
        panel.opc5.addActionListener(buttonListener);
        panel.novoJogo.addActionListener(buttonListener);
        panel.verRank.addActionListener(buttonListener);
        panel.sairJogo.addActionListener(buttonListener);
        panel.menuPrincipal.addActionListener(buttonListener);
        panel.verdadeiro.addActionListener(buttonListener);
        panel.falso.addActionListener(buttonListener);
        panel.enviar.addActionListener(buttonListener);


        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    /**
     * Método encarregue da criação de cada pergunta.
     */
    public void criarPerguntas() {
        perguntas.clear();
        int idx = 1;
        for (String p: perguntasFicheiro) {
            String[] infoPergunta = p.split(" / ");
            String categoria = infoPergunta[0];
            ArrayList<String> opcoes = new ArrayList<>(Arrays.asList(infoPergunta).subList(3, infoPergunta.length));
            switch (categoria) {
                case "Artes":
                    perguntas.add(new Artes(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                    break;
                case "Ciências":
                    perguntas.add(new Ciencia(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                    break;
                case "Natação":
                    perguntas.add(new Natacao(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                    break;
                case "Ski":
                    perguntas.add(new Ski(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                    break;
                case "Futebol":
                    perguntas.add(new Futebol(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                    break;
                default:
                    System.out.println("A categoria não existe, logo a pergunta não foi criada.");
                    break;
            }
            idx++;
        }
    }

    /**
     * Método responsável pela verificação da data e hora em que um jogo começou.
     * @return data e hora em que o jogo começou.
     */
    public String dataEHora(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * Este método vai fazer o cálculo dos 3 jogadores com
     * as maiores pontuações do jogo POOTrivia.
     * @param player Array com todos os players existentes.
     */
    public void rankingTop3(ArrayList<Player> player) {
        topJogadores.clear();
        if(!player.isEmpty()){
            ArrayList<Integer> Pontuacoes = new ArrayList<>();
            for(Player p : player){
                int pontuacao = 0;
                for(Pergunta pergunta : p.getRespostasDadas()){
                    if(pergunta.isAcertou()){
                        pontuacao += pergunta.pontuacao();
                    }
                }
                Pontuacoes.add(pontuacao);
            }

            int paragem = Math.min(Pontuacoes.size(), 3);

            for(int i = 0; i < paragem; i++){
                int max = 0;
                for(int pontuacao : Pontuacoes){
                    if(pontuacao > max){
                        max = pontuacao;
                    }
                }
                topJogadores.add(jogadores.get(Pontuacoes.indexOf(max)).getName() + ": " + max);
                Pontuacoes.set(Pontuacoes.indexOf(max), -1);
            }
        }else{
            System.out.println("Ainda não existem jogadores");
        }
    }
}