import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe GamePanel
 */
public class GamePanel extends JPanel {

    /**
     * Dimenssões da 'interface'.
     */
    private int screenWidth = 768;
    
    /**
     * Dimenssões da 'interface'.
     */
    private int screenHeight = 576;

    /**
     * Centro da 'interface'.
     */
    private int center = (screenWidth / 2);

    /**
     * Todos os butões utilizados na
     * ‘interface’ do programa.
     */
    protected JButton novoJogo, verRank, sairJogo, opc1, opc2, opc3, opc4, opc5, verdadeiro, falso, enviar, menuPrincipal;

    /**
     * Caixa de texto onde o player
     * vai escrever o seu nome.
     */
    protected JTextField nome;

    /**
     * Construtor da classe GamePanel.
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        novoJogo = new JButton("Novo Jogo");
        verRank = new JButton("Ver Rank");
        sairJogo = new JButton("Sair do Jogo");

        opc1 = new JButton();
        opc2 = new JButton();
        opc3 = new JButton();
        opc4 = new JButton();
        opc5 = new JButton();

        verdadeiro = new JButton("Verdadeiro");
        falso = new JButton("Falso");

        enviar = new JButton("Enviar Nome");

        nome = new JTextField();

        menuPrincipal = new JButton("Menu Principal");
    }

    /**
     * Método responsável pelo menu principal.
     */
    public void painelPrincipal() {
        removeAll();

        JLabel nomeJogo = new JLabel("POOTrivia");
        nomeJogo.setFont(new Font("Arial", Font.BOLD, 20));
        nomeJogo.setForeground(Color.BLACK);

        int xLabel = center - (nomeJogo.getPreferredSize().width / 2);
        int yLabel = 100;

        nomeJogo.setBounds(xLabel, yLabel, 100, 100);
        this.add(nomeJogo);

        int xButtons = center - 100;

        novoJogo.setBounds(xButtons, yLabel + 150, 200, 50);
        novoJogo.setFont(new Font("Arial", Font.PLAIN, 20));

        verRank.setBounds(xButtons, yLabel + 225, 200, 50);
        verRank.setFont(new Font("Arial", Font.PLAIN, 20));

        sairJogo.setBounds(xButtons, yLabel + 300, 200, 50);
        sairJogo.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(novoJogo);
        this.add(verRank);
        this.add(sairJogo);
    }

    /**
     * Método que vai fazer a ‘interface’ das
     * perguntas que possuem apenas 5 opções.
     *
     * @param categoria Categoria da pergunta.
     * @param pergunta Pergunta em questão.
     * @param opcoes Opções da pergunta.
     * @param score Pontuação do jogador até ao momento.
     */
    public void painelPerguntasOpcoes(String categoria, String pergunta, ArrayList<String> opcoes, int score) {
        removeAll();

        JLabel c = new JLabel(categoria);
        c.setFont(new Font("Verdana", Font.BOLD, 30));
        c.setForeground(Color.BLACK);

        JTextArea p = new JTextArea(pergunta, 3, 30);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);
        p.setWrapStyleWord(true);
        p.setLineWrap(true);
        p.setEditable(false);

        JLabel s = new JLabel("Score: " + score);
        s.setFont(new Font("Arial", Font.BOLD, 15));
        s.setForeground(Color.BLACK);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 100;

        int xScore = center - (s.getPreferredSize().width / 2);
        int yScore = screenHeight - 20;

        c.setBounds(xCategoria, yCategoria, 400, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);
        s.setBounds(xScore, yScore, 250, s.getPreferredSize().height);

        this.add(c);
        this.add(p);
        this.add(s);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        opc1.setText(opcoes.get(0));
        opc2.setText(opcoes.get(1));
        opc3.setText(opcoes.get(2));
        opc4.setText(opcoes.get(3));
        opc5.setText(opcoes.get(4));

        opc1.setBounds(xOpc, yOpc - 88, 300, 50);
        opc1.setFont(new Font("Arial", Font.PLAIN, 20));

        opc2.setBounds(xOpc, yOpc - 12, 300, 50);
        opc2.setFont(new Font("Arial", Font.PLAIN, 20));

        opc3.setBounds(xOpc, yOpc + 62, 300, 50);
        opc3.setFont(new Font("Arial", Font.PLAIN, 20));

        opc4.setBounds(xOpc, yOpc + 138, 300, 50);
        opc4.setFont(new Font("Arial", Font.PLAIN, 20));

        opc5.setBounds(xOpc, yOpc + 213, 300, 50);
        opc5.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(opc1);
        this.add(opc2);
        this.add(opc3);
        this.add(opc4);
        this.add(opc5);
    }

    /**
     * Método que vai fazer a ‘interface’ das
     * perguntas que possuem apenas 3 opções.
     *
     * @param categoria Categoria da pergunta.
     * @param pergunta Pergunta em questão.
     * @param opcoes Opções da pergunta.
     * @param score Pontuação do jogador até ao momento.
     */
    public void painelPerguntasOpcoesArtes(String categoria, String pergunta, ArrayList<String> opcoes, int score) {
        removeAll();

        JLabel c = new JLabel(categoria);
        c.setFont(new Font("Verdana", Font.BOLD, 30));
        c.setForeground(Color.BLACK);

        JTextArea p = new JTextArea(pergunta, 3, 30);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);
        p.setWrapStyleWord(true);
        p.setLineWrap(true);
        p.setEditable(false);

        JLabel s = new JLabel("Score: " + score);
        s.setFont(new Font("Arial", Font.BOLD, 15));
        s.setForeground(Color.BLACK);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 100;

        int xScore = center - (s.getPreferredSize().width / 2);
        int yScore = screenHeight - 20;

        c.setBounds(xCategoria, yCategoria, 400, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);
        s.setBounds(xScore, yScore, 250, s.getPreferredSize().height);

        this.add(c);
        this.add(p);
        this.add(s);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        opc1.setText(opcoes.get(0));
        opc2.setText(opcoes.get(1));
        opc3.setText(opcoes.get(2));

        opc1.setBounds(xOpc, yOpc - 88, 300, 50);
        opc1.setFont(new Font("Arial", Font.PLAIN, 20));

        opc2.setBounds(xOpc, yOpc - 12, 300, 50);
        opc2.setFont(new Font("Arial", Font.PLAIN, 20));

        opc3.setBounds(xOpc, yOpc + 62, 300, 50);
        opc3.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(opc1);
        this.add(opc2);
        this.add(opc3);
    }

    /**
     * Método que vai fazer a 'interface' das
     * perguntas de verdadeiro ou falso.
     *
     * @param categoria Categoria da pergunta.
     * @param pergunta Pergunta em questão.
     * @param score Pontuação do jogador até ao momento.
     */
    public void painelPerguntasVF(String categoria, String pergunta, int score) {
        removeAll();

        JLabel c = new JLabel(categoria);
        c.setFont(new Font("Verdana", Font.BOLD, 30));
        c.setForeground(Color.BLACK);

        JTextArea p = new JTextArea(pergunta, 3, 30);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);
        p.setWrapStyleWord(true);
        p.setLineWrap(true);
        p.setEditable(false);

        JLabel s = new JLabel("Score: " + score);
        s.setFont(new Font("Arial", Font.BOLD, 15));
        s.setForeground(Color.BLACK);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 100;

        int xScore = center - (s.getPreferredSize().width / 2);
        int yScore = screenHeight - 20;

        c.setBounds(xCategoria, yCategoria, 400, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);
        s.setBounds(xScore, yScore, 250, s.getPreferredSize().height);

        this.add(c);
        this.add(p);
        this.add(s);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        verdadeiro.setBounds(xOpc, yOpc - 37, 300, 50);
        verdadeiro.setFont(new Font("Arial", Font.PLAIN, 20));

        falso.setBounds(xOpc, yOpc + 37, 300, 50);
        falso.setFont(new Font("Arial", Font.PLAIN, 20));


        this.add(verdadeiro);
        this.add(falso);
    }

    /**
     * Método responsável pela disponibilização de uma
     * caixa de texto para o jogador inserir o seu nome.
     */
    public void painelNomePlayer() {
        removeAll();

        JLabel nomeTexto = new JLabel("Escreve o teu nome no campo a baixo!");
        nomeTexto.setFont(new Font("Verdana", Font.PLAIN, 30));
        nomeTexto.setForeground(Color.BLACK);

        int xNomeTexto = center - (nomeTexto.getPreferredSize().width / 2);
        int yNomeTexto = 200;

        nomeTexto.setBounds(xNomeTexto, yNomeTexto, 720, nomeTexto.getPreferredSize().height);

        this.add(nomeTexto);

        int xNome = center - 150;
        int yNome = (screenHeight / 2) - (nome.getPreferredSize().height / 2);

        nome.setBounds(xNome, yNome, 300, 25);
        nome.setEditable(true);

        this.add(nome);

        int xEnviar = center - 100;
        int yEnviar = screenHeight / 2 + 50;

        enviar.setBounds(xEnviar, yEnviar , 200, 50);
        enviar.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(enviar);
    }

    /**
     * Método que vai mostrar o painel de fim de jogo.
     *
     * @param certas Quantidade de respostas certas.
     * @param score Pontuação feita pelo jogador.
     * @param top3Jogadores Top 3 jogadores.
     */
    public void painelFimJogo(int certas, int score, ArrayList<String> top3Jogadores) {
        removeAll();

        JLabel parabens = new JLabel("Parabéns acertaste um total de " + certas + " perguntas!");
        parabens.setFont(new Font("Verdana", Font.PLAIN, 30));
        parabens.setForeground(Color.BLACK);

        JLabel pontuacao = new JLabel("O teu score foi de: " + score);
        pontuacao.setFont(new Font("Verdana", Font.PLAIN, 30));
        pontuacao.setForeground(Color.BLACK);

        JLabel ranking = new JLabel("TOP 3 JOGADORES");
        ranking.setFont(new Font("Arial", Font.BOLD, 25));
        ranking.setForeground(Color.BLACK);



        int xParabens = center - (parabens.getPreferredSize().width / 2);
        int yParabens = 50;

        int xScore = center - (pontuacao.getPreferredSize().width / 2);
        int yScore = 100;

        int xRanking = center - (ranking.getPreferredSize().width / 2);
        int yRanking = 175;

        parabens.setBounds(xParabens, yParabens, 720, parabens.getPreferredSize().height);
        pontuacao.setBounds(xScore, yScore, pontuacao.getPreferredSize().width, pontuacao.getPreferredSize().height);
        ranking.setBounds(xRanking, yRanking, ranking.getPreferredSize().width, ranking.getPreferredSize().height);

        menuPrincipal.setBounds(screenWidth/2 - 100, screenHeight - 55, 200, 50);
        menuPrincipal.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(menuPrincipal);
        this.add(parabens);
        this.add(pontuacao);
        this.add(ranking);



        if(!top3Jogadores.isEmpty()) {
            if (!top3Jogadores.get(0).isEmpty()) {
                JLabel top1 = new JLabel("1º " + top3Jogadores.get(0));
                int xOpc = center - (top1.getPreferredSize().width / 2 + 40);
                top1.setFont(new Font("Arial", Font.BOLD, 20));
                top1.setBounds(xOpc, yRanking + 50, 300, 50);
                this.add(top1);
            }

            if (top3Jogadores.size() >= 2 && !top3Jogadores.get(1).isEmpty()) {
                JLabel top2 = new JLabel("2º " + top3Jogadores.get(1));
                int xOpc = center - (top2.getPreferredSize().width / 2 + 40);
                top2.setFont(new Font("Arial", Font.BOLD, 20));
                top2.setBounds(xOpc, yRanking +125 , 300, 50);
                this.add(top2);
            }

            if (top3Jogadores.size() == 3 && !top3Jogadores.get(2).isEmpty()) {
                JLabel top3 = new JLabel("3º " + top3Jogadores.get(2));
                int xOpc = center - (top3.getPreferredSize().width / 2 + 40);
                top3.setFont(new Font("Arial", Font.BOLD, 20));
                top3.setBounds(xOpc, yRanking + 200, 300, 50);
                this.add(top3);
            }
        }

    }

    /**
     * Método que faz o painel dos top 3 jogadores.
     *
     * @param top3Jogadores Array com os top 3 jogadores.
     */
    public void painelTop3(ArrayList<String> top3Jogadores){
        removeAll();

        JLabel ranking = new JLabel("TOP 3 JOGADORES");
        ranking.setFont(new Font("Arial", Font.BOLD, 25));
        ranking.setForeground(Color.BLACK);
        int xRanking = center - (ranking.getPreferredSize().width / 2);
        int yRanking = 50;
        ranking.setBounds(xRanking, yRanking, ranking.getPreferredSize().width, ranking.getPreferredSize().height);

        if(!top3Jogadores.isEmpty()){
            if(!top3Jogadores.get(0).isEmpty()){
                JLabel top1 = new JLabel("1º " + top3Jogadores.get(0));
                int xOpc = center - (top1.getPreferredSize().width / 2 + 40);
                top1.setFont(new Font("Arial", Font.BOLD, 20));
                top1.setBounds(xOpc, yRanking + 75, 300, 50);
                this.add(top1);
            }

            if(top3Jogadores.size() >= 2 && !top3Jogadores.get(1).isEmpty()){
                JLabel top2 = new JLabel("2º " + top3Jogadores.get(1));
                int xOpc = center - (top2.getPreferredSize().width / 2 + 40);
                top2.setFont(new Font("Arial", Font.BOLD, 20));
                top2.setBounds(xOpc, yRanking + 175, 300, 50);
                this.add(top2);
            }

            if(top3Jogadores.size() == 3 && !top3Jogadores.get(2).isEmpty()){
                JLabel top3 = new JLabel("3º " + top3Jogadores.get(2));
                int xOpc = center - (top3.getPreferredSize().width / 2 + 40);
                top3.setFont(new Font("Arial", Font.BOLD, 20));
                top3.setBounds(xOpc, yRanking + 275, 300, 50);
                this.add(top3);
            }
        }else {
            JLabel semJogadores = new JLabel("Ainda não existem registos de jogadores");
            semJogadores.setFont(new Font("Arial", Font.BOLD, 25));
            semJogadores.setForeground(Color.BLACK);
            int xsemJogadores = center - (semJogadores.getPreferredSize().width / 2);
            int ysemJogadores = center - 125 ;
            semJogadores.setBounds(xsemJogadores, ysemJogadores, semJogadores.getPreferredSize().width, semJogadores.getPreferredSize().height);
            this.add(semJogadores);
        }


        menuPrincipal.setBounds(screenWidth/2 - 100, screenHeight - 55, 200, 50);
        menuPrincipal.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(ranking);
        this.add(menuPrincipal);
    }
}
