package com.mycompany.campominado;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/* Os blocos usados sao JButtons com coordenadas */
public class Tabuleiro {

    /* Propriedades do Tabuleiro */
    int colunas = 9;
    int linhas = 9;
    int quantMinas;
    boolean ganhou;

    //Matriz de Blocos para o tabuleiro
    Blocos[][] matrizBlocos;
    ArrayList<Blocos> minas;
    ArrayList<Blocos> bandeiras;

    /* Verifica se coordenada aleatoria ja existe no vetor de minas */
    private boolean coordenadaJaExisteMina(int x, int y) {
        for (Blocos mina : minas) {
            if (mina.coordenada.x == x && mina.coordenada.y == y) {
                return true;
            }
        }
        return false;
    }


    /* Espalha as minas em posicoes aleatoria da matriz de blocos */
    private void espalhaMinas() {
        //Lista de posicoes para as minas

        minas = new ArrayList<>();
        Random random = new Random();
        int randX = random.nextInt(linhas);
        int randY = random.nextInt(colunas);

        /*Escolhe posicao random da matriz de blocos do tabuleiro */
        Blocos novaMina = matrizBlocos[randX][randY];
        minas.add(novaMina);
        System.out.printf("%d %d\n", novaMina.coordenada.x, novaMina.coordenada.y);
        for (int i = 1; i < quantMinas; i++) {
            while (coordenadaJaExisteMina(randX, randY)) {
                randX = random.nextInt(linhas);
                randY = random.nextInt(colunas);
            }
            novaMina = matrizBlocos[randX][randY];
            System.out.printf("%d %d\n", novaMina.coordenada.x, novaMina.coordenada.y);
            minas.add(novaMina);
        }
    }

    /*Verofica se clicou em uma mina */
    public boolean verificaClicouMina(Blocos blocoClicado) {
        if (blocoClicado.getText() == "x") {

            /* Verifica se o bloco clicado esta na lista de blocos de minas */
            if (minas.contains(blocoClicado)) {
                return true;
            }
        }
        return false;
    }

    /* Revela as minas no fim do jogo */
    public void revelaMinas() {
        /* Percorre Vetor das Minas e adiciona na matriz de blocos a bomba referente a coordenada */
        for (Blocos mina : minas) {
            matrizBlocos[mina.coordenada.x][mina.coordenada.y].setText("💣");
        }
    }

    /*Calcula quantidade de minas ao Redor */
    public short numeroMinasProximas(Blocos blocoClicado) {
        short n = 0; //Numero de minas

        int lBloco = blocoClicado.coordenada.x; //Linha do Bloco
        int cBloco = blocoClicado.coordenada.y; //Coluna do Bloco

        /* Faz somatorio de coordenadas para X e Y */
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int linhaAdjacente = lBloco + i;
                int colunaAdjacente = cBloco + j;

                // Verifica se a posição é válida
                if (linhaAdjacente >= 0 && linhaAdjacente < linhas
                        && colunaAdjacente >= 0 && colunaAdjacente < colunas) {

                    Blocos blocoAoRedor = matrizBlocos[linhaAdjacente][colunaAdjacente];

                    // Verifica se o bloco adjacente contém uma mina
                    if (coordenadaJaExisteMina(blocoAoRedor.coordenada.x, blocoAoRedor.coordenada.y)) {
                        n++; //Soma quantidade de minas ao redor
                    }
                }
            }
        }
        return n;
    }

    /* Retorna bloco com coordenadas Somadas */
    public Blocos somaCoordenadasBloco(int acrescimoX, int acrescimoY, Blocos blocoAtual) {
        return new Blocos((blocoAtual.coordenada.x + acrescimoX), (blocoAtual.coordenada.y + acrescimoY));
    }

    /* Mostra blocos colocando valor neles recursivamente */
    public void mostraBlocosAoRedor(Blocos blocoClicado) {
        /* Caso base */
        if (blocoClicado.coordenada.x < 0 || blocoClicado.coordenada.x >= linhas
                || blocoClicado.coordenada.y < 0 || blocoClicado.coordenada.y >= colunas) {
            return;
        }
        /* Bloco Clicado recebe os botoes de matrizBlocos referente a coordenada */
        blocoClicado = matrizBlocos[blocoClicado.coordenada.x][blocoClicado.coordenada.y];

        /* Se o bloco clicado ja estiver desabilitado, nao precisa fazera verificacao */
        if (blocoClicado.isEnabled() == false) {
            return;
        }
        blocoClicado.setEnabled(false); //Desabilita botao
        //Recebe quantidade de minas ao redor
        short numMinasAoRedor = numeroMinasProximas(blocoClicado);
        // Atribui o numero ao bloco
        String textInBlock = (numMinasAoRedor > 0) ? String.valueOf(numMinasAoRedor) : "";
        blocoClicado.setText(textInBlock);

        /* Verifica minas ao redor recursivamente */
        if (numMinasAoRedor == 0) {
            /*Verificacao dos lados 
            /* Esquerda */
            mostraBlocosAoRedor(somaCoordenadasBloco(0, -1, blocoClicado));
            /* Direita */
            mostraBlocosAoRedor(somaCoordenadasBloco(0, 1, blocoClicado));

            /* Cima */
            mostraBlocosAoRedor(somaCoordenadasBloco(-1, 0, blocoClicado));

            /* Baixo */
            mostraBlocosAoRedor(somaCoordenadasBloco(1, 0, blocoClicado));

            /*Diagonais*/
 /* Baixo Direita */
            mostraBlocosAoRedor(somaCoordenadasBloco(1, 1, blocoClicado));

            /* Baixo Esquerda */
            mostraBlocosAoRedor(somaCoordenadasBloco(1, -1, blocoClicado));

            /* Cima Direita */
            mostraBlocosAoRedor(somaCoordenadasBloco(-1, 1, blocoClicado));

            /* Cima Esquerda */
            mostraBlocosAoRedor(somaCoordenadasBloco(-1, -1, blocoClicado));

        }
    }

    /* Procedimento de ganhar Perdeu */
    public void perdeuJogo(Janela janela) {
        janela.mudarRostoResetar(false);
        finalizaJogo();
        JOptionPane.showMessageDialog(null, "Opa! Você  perdeu o jogo 😞", "Perdeu", JOptionPane.INFORMATION_MESSAGE);
    }

    /* Procedimento de ganhar Jogo */
    public void ganhouJogo(Janela janela) {
        janela.mudarRostoResetar(true);
        finalizaJogo();
        JOptionPane.showMessageDialog(null, "Parabéns! Você venceu o jogo 😊", "Venceu", JOptionPane.INFORMATION_MESSAGE);
    }

    /* Verifica se todas posicoes marcadas estao na lista de posicoes minas */
    public boolean verificaSeGanhou() {
        for (Blocos blocoBandeira : bandeiras) {
            if (!minas.contains(blocoBandeira)) {
                return false;
            }
        }
        return true;
    }

    public void colocaBandeira(Blocos blocoSelecionado, Janela janela) {
        /* Coloca bloco marcado no vetor de bandeiras */
        bandeiras.add(matrizBlocos[blocoSelecionado.coordenada.x][blocoSelecionado.coordenada.y]);
        /* Decrementa quantMinas */
        quantMinas--;
        janela.quantMinas.setText(String.valueOf(quantMinas));
        if (quantMinas == 0) {
            if (verificaSeGanhou()) {
                ganhouJogo(janela);
            } else {
                perdeuJogo(janela);
            }
        }
    }

    /* Finaliza jogo */
    public void finalizaJogo() {
        /* Revela Blocos com os valores das minas */
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                mostraBlocosAoRedor(matrizBlocos[i][j]);
            }
        }
        /* Revela Minas */
        revelaMinas();
    }

    /* Construtor do tabuleiro */
    Tabuleiro(Janela janela) {
        /* Cria matriz de Blocos */
        matrizBlocos = new Blocos[linhas][colunas];
        /* Cria vetor de bandeiras */
        bandeiras = new ArrayList<>();
        /* Estabelece quantidade de minas */
        quantMinas = 10;
        janela.quantMinas.setText(String.valueOf(quantMinas));
        /*Preenche Tabuleiro */
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Blocos bloco = new Blocos(i, j);
                /* Adiciona Evento de clique de mouse */
                bloco.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        /*Botao 1 = Botao Esquerdo */
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            /* Verifica se clicou na mina (Perdeu) */
                            if (verificaClicouMina(bloco)) {
                                perdeuJogo(janela);
                            } else { //Caso nao tenha sido uma mina em que clicou
                                mostraBlocosAoRedor(bloco);
                            }
                        } /* Botao 3 = Botao Direito */ else if (e.getButton() == MouseEvent.BUTTON3) {
                            /* Adiciona marcacao */
                            if (bloco.isEnabled() && bloco.getText() != "🏴") {
                                bloco.setBackground(new Color(202, 62, 71));
                                bloco.setText("🏴");
                                colocaBandeira(bloco, janela);
                            } /* Retira marcacao */ else if (bloco.isEnabled() && bloco.getText() == "🏴") {
                                bloco.setBackground(new Color(41, 41, 41));
                                bloco.setText("x");
                                /* Incrementa quantMinas */
                                quantMinas++;
                                janela.quantMinas.setText(String.valueOf(quantMinas));
                            }
                        }
                    }

                });

                /* Crio blocos das minas e adiciono na matriz */
                matrizBlocos[i][j] = bloco;
                matrizBlocos[i][j].setSize(80, 80);
                matrizBlocos[i][j].setLocation(80 * j, 80 * i);
                matrizBlocos[i][j].setForeground(Color.WHITE);
                /*Estilizacao bloco*/
                matrizBlocos[i][j].setBackground(new Color(41, 41, 41));
                matrizBlocos[i][j].setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 1),
                        BorderFactory.createLineBorder(Color.BLACK, 1)
                ));
                /* Adiciona blocos no Painel Campo */
                janela.Campo.add(matrizBlocos[i][j]);
            }
        }
        /* Seta posicao randomica das minas */
        espalhaMinas();
    }
}
