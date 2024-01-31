package com.mycompany.campominado;

import javax.swing.JButton;
import java.awt.Font;

/* Classe representando blocos que são botões clicáveis no campo minado */
public class Blocos extends JButton {

    private Coordenada coordenada;
    private String redFlag;

    public Blocos(int x, int y) {
        this.redFlag="";
        initializeBlock(x, y);
    }

    public String getRedFlag() {
        return redFlag;
    }

    public void setRedFlag(String redFlag) {
        this.redFlag = redFlag;
    }
    
    private void initializeBlock(int x, int y) {
        this.coordenada = new Coordenada(x, y);
        configureButtonAppearance();
    }
    

    private void configureButtonAppearance() {
        this.setFont(new Font("Arial", Font.PLAIN, 30));
        this.setText("X"); // Adicione lógica para exibir o conteúdo desejado
        // Exemplo: this.setText(coordenada.toString());
    }
    
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
}
