package com.mycompany.campominado;

import javax.swing.JButton;
import java.awt.*;
/* Classe com blocos que sao botoes clicaveis */
public class Blocos extends JButton {

    /* Classe de coordenadas */
    public class Coordenada {

        int x, y;

        Coordenada(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Coordenada coordenada;

    Blocos(int x, int y) {
        this.coordenada = new Coordenada(x, y);
        this.setFont(new Font("Arial", Font.PLAIN, 30));
        this.setText("x");
    }
}
