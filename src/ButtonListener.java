import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe ButtonListener
 */
public class ButtonListener implements ActionListener {

    /**
     * Data e hora do começo do jogo.
     */
    private String dataHora;

    /**
     * Objeto da classe GamePanel.
     */
    private GamePanel panel;

    /**
     * Objeto da classe Ficheiro.
     */
    private Ficheiro ficheiro;

    /**
     * Objeto da classe POOTrivia.
     */
    private POOTrivia pooTrivia;

    /**
     * ArrayList onde estão presentes
     * as perguntas a serem disponibilizadas.
     */
    private ArrayList<Pergunta> perguntas;

    /**
     * ArrayList de todos os jogadores.
     */
    private ArrayList<Player> jogadores;

    /**
     * ArrayList das respostas dadas pelo jogador.
     */
    private ArrayList<Pergunta> respostasDadas;

    /**
     * Resposta correta da pergunta.
     */
    private String resp;

    /**
     * Pontuação do jogador.
     */
    private int pontuacao;

    /**
     * Contador de respostas corretas que o jogador deu.
     */
    private int contaCertas;

    /**
     * Indíce da pergunta.
     */
    private int pergunta;

    /**
     * Construtor da classe ButtonListener.
     *
     * @param panel Objeto da classe GamePanel.
     * @param ficheiro Objeto da classe Ficheiro.
     * @param pooTrivia Objeto da classe POOTrivia.
     * @param perguntas Perguntas que foram escolhidas.
     * @param jogadores Jogadores que já jogaram o jogo.
     */
    public ButtonListener(GamePanel panel, Ficheiro ficheiro, POOTrivia pooTrivia, ArrayList<Pergunta> perguntas, ArrayList<Player> jogadores) {
        this.panel = panel;
        this.pooTrivia = pooTrivia;
        this.perguntas = perguntas;
        this.jogadores = jogadores;
        this.ficheiro = ficheiro;
    }

    /**
     * Método responsável pela funcionalidade dos butões do jogo.
     *
     * @param e evento a ser processado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Novo Jogo")) {
            this.dataHora = pooTrivia.dataEHora();
            ficheiro.sortearPerguntas();
            pooTrivia.criarPerguntas();

            panel.nome.setText("");
            respostasDadas = new ArrayList<>();

            novaPergunta(pergunta);
        } else if (e.getActionCommand().equals("Ver Rank")) {
            mostarPainelTop3();

        } else if (e.getActionCommand().equals("Menu Principal")) {
            mostrarPainelPrincipal();
        } else if (e.getActionCommand().equals("Sair do Jogo")) {
            if (JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                ficheiro.escreverFicheiroJogadores();
                System.exit(0);
            }
        } else if (e.getActionCommand().equals("Enviar Nome")) {
            if (!panel.nome.getText().isEmpty()) {
                if(panel.nome.getText().charAt(0) == ' ' || Character.isDigit(panel.nome.getText().charAt(0))){
                    JOptionPane.showMessageDialog(null, "Não é permitido usar espaços ou números antes do nome!");
                } else{
                    jogadores.add(new Player(panel.nome.getText(), respostasDadas, dataHora));
                    pooTrivia.rankingTop3(jogadores);
                    for(Player player: jogadores) {
                        if(player.getName().equals(panel.nome.getText())) {
                            mostrarPainelFinal(contaCertas, pontuacao, player);
                        }
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "Um nome tem que ser inserido!");
            }
        }else if (e.getActionCommand().equals(resp)) {
            pontuacao += perguntas.get(pergunta).pontuacao();
            contaCertas++;
            respostasDadas.add(perguntas.get(pergunta));
            JOptionPane.showMessageDialog(null, "Acertou!");
            perguntas.get(pergunta).setAcertou();
            if(pergunta != perguntas.size() - 1) {
                pergunta++;
                novaPergunta(pergunta);
            }else {
                mostrarPainelNomePlayer();
            }
        }else if (!e.getActionCommand().equals(resp)) {
            respostasDadas.add(perguntas.get(pergunta));
            JOptionPane.showMessageDialog(null, "Errou!");
            if (pergunta != 4) {
                pergunta++;
                novaPergunta(pergunta);
            }else {
                mostrarPainelNomePlayer();
            }
        }
    }

    /**
     * Método que está encarregue da disponibilização
     * da pergunta seguinte à que foi respondida.
     *
     * @param index indíce da pergunta.
     */
    public void novaPergunta(int index) {
        panel.repaint();
        String cat = perguntas.get(index).getCategoria();
        String perg = perguntas.get(index).getPergunta();
        ArrayList<String> opcoes = perguntas.get(index).getOpcoes();
        resp = perguntas.get(index).getCorreta();
        Collections.shuffle(opcoes);
        if (opcoes.size() == 2) {
            panel.painelPerguntasVF(cat, perg, pontuacao);
        } else if (opcoes.size() == 3) {
            panel.painelPerguntasOpcoesArtes(cat, perg, opcoes, pontuacao);
        } else {
            panel.painelPerguntasOpcoes(cat, perg, opcoes, pontuacao);
        }
    }

    /**
     * Método para mostrar o painel em que
     * o jogador vai inserir o seu nome.
     */
    public void mostrarPainelNomePlayer() {
        panel.repaint();
        panel.painelNomePlayer();
    }

    /**
     * Metodo para voltar ao menu principal do jogo.
     */
    public void mostrarPainelPrincipal(){
        panel.repaint();
        panel.painelPrincipal();
    }

    /**
     * Método responsável por fazer aparecer o painel
     * final do jogo onde será mostrada a pontuação
     * que o jogador obteve assim como quantas perguntas
     * foram dadas corretamente e o top 3 jogadores.
     *
     * @param certas Respostas corretas.
     * @param score Pontuação do jogador.
     * @param player Jogador em expecífico.
     */
    public void mostrarPainelFinal(int certas, int score, Player player) {
        panel.repaint();
        panel.painelFimJogo(certas, score, pooTrivia.topJogadores);
        String nomeFicheiro = ficheiro.nomeFicheiro(player.getIniciaisNome(), this.dataHora);
        ficheiro.escreverFicheiroObjetos(nomeFicheiro, player);

        pergunta = 0;
        pontuacao = 0;
        contaCertas = 0;
    }

    /**
     * Método que mostra o painel do top 3 jogadores.
     */
    public void mostarPainelTop3(){
        panel.repaint();
        panel.painelTop3(pooTrivia.topJogadores);
    }
}

