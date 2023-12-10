import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Classe Ficheiro
 */
public class Ficheiro implements Serializable {

    /**
     * ArrayList onde são guardadas todas as perguntas do ficheiro Perguntas.txt.
     */
    private ArrayList<String> perguntasFicheiro;

    /**
     * ArrayList onde são armazenados todos os players que já jogaram o jogo e que futuramente jogarão.
     */
    private ArrayList<Player> jogadores;

    /**
     * Construtor da classe Ficheiro.
     *
     * @param perguntasFicheiro perguntas presentes no ficheiro de texto.
     * @param jogadores jogadores que já jogaram ou que ainda jogarão o nosso jogo.
     */
    public Ficheiro(ArrayList<String> perguntasFicheiro, ArrayList<Player> jogadores) {
        this.perguntasFicheiro = perguntasFicheiro;
        this.jogadores = jogadores;
    }

    /**
     * Método que está encarregue pelo nome do
     * ficheiro de objetos referente a um jogo
     * feito por um player em específico.
     *
     * @param iniciaisNome iniciais do nome do player.
     * @param dataHora data e hora de começo do jogo.
     * @return nome do ficheiro de objetos.
     */
    public String nomeFicheiro(String iniciaisNome, String dataHora){
        return "pootrivia_jogo_" + dataHora + "_" + iniciaisNome;
    }

    /**
     * Método responsável pela seleção das perguntas
     * que vão ser disponibilizadas na ‘interface’ do jogo.
     */
    public void sortearPerguntas(){
        Random rand = new Random();
        File f = new File("Perguntas.txt");
        if(f.exists() && f.isFile()){
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null){
                    perguntasFicheiro.add(linha);
                }

                while(perguntasFicheiro.size() > 5) {
                    perguntasFicheiro.remove(rand.nextInt(perguntasFicheiro.size()));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }
        else{
            System.out.println("O ficheiro não existe!");
        }
    }

    /**
     * Método que está encarregue por ler o ficheiro
     * de texto Jogadores.txt e por sua vez adicionar
     * os players existentes ao array de players.
     */
    public void lerFicheiroJogadores() {
        try {
            File f = new File("Jogadores.txt");
            if (f.createNewFile()) {
                System.out.println("Ficheiro Jogadores.txt foi criado!");
            }

            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null) {
                    if(lerFicheiroObjetos(linha) != null) {
                        Player player = lerFicheiroObjetos(linha);
                        jogadores.add(player);
                    }
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }catch (IOException e) {
            System.out.println("Problema ao criar o ficheiro Jogadores.txt!");
        }
    }

    /**
     * Método para escrever o ficheiro de jogadores
     * quando o programa é encerrado.
     */
    public void escreverFicheiroJogadores() {
        try {
            File f = new File("Jogadores.txt");
            if (f.createNewFile()) {
                System.out.println("Ficheiro Jogadores.txt foi criado!");
            }

            try {
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Player player : jogadores) {
                    bw.write(nomeFicheiro(player.iniciaisNome, player.getDataeHora()) + ".obj");
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }catch (IOException e) {
            System.out.println("Erro ao criar o ficheiro Jogadores.txt!");
        }
    }

    /**
     * Método utilizado para a leitura dos ficheiros
     * de objetos, que são criados para cada player.
     *
     * @param nomeFicheiro nome do ficheiro de objetos.
     * @return um objeto Player.
     */
    public Player lerFicheiroObjetos(String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Player player = (Player) ois.readObject();
            ois.close();
            return player;
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return null;
    }

    /**
     * Este método escreve o ficheiro de objetos de um player.
     *
     * @param nomeFicheiro nome do ficheiro de objetos.
     * @param player objeto Player que representa um dos jogadores.
     */
    public void escreverFicheiroObjetos(String nomeFicheiro, Player player){
        try {
            File f = new File(nomeFicheiro +".obj");
            if (f.createNewFile()) {
                System.out.println(nomeFicheiro + ".obj foi criado!");
            }
            try {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(player);
                oos.close();
            } catch (IOException ex) {
                System.out.println("Erro a escrever para o ficheiro.");
            }
        }catch (IOException e){
            System.out.println("Erro ao criar ficheiro.");
        }

    }

}
