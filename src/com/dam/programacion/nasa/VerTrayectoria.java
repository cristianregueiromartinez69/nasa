package com.dam.programacion.nasa;

import javax.swing.*;

public class VerTrayectoria extends JFrame {

    public VerTrayectoria(){

        setTitle("Trayectoria de la nave");
        setVisible(true);
        setBounds(600,600,600,600);
        DibujoTrayectoria miDibujo = new DibujoTrayectoria();
        add(miDibujo);
    }
}