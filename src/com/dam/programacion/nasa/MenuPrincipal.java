package com.dam.programacion.nasa;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPrincipal extends JFrame{
    private JPanel centerPanel;
    private JPanel buttonsPanel;
    private JButton createMisionButton;
    private JButton assignShipsAndCrewButton;
    private JButton viewMissionStatus;
    private JButton reportsTrayectoryButton;
    private Image mainPanelBackground;
    private ImageIcon iconImage;
    private String sourceImage;
    private JLabel putVideoImage;


    public MenuPrincipal(){
        setTitle("NASA");
        setVisible(true);
        setBounds(600,600,600,600);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        add(centerPanel);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 2);
        buttonsPanel.setBorder(borde);
        buttonsPanel.setBackground(Color.BLACK);
        centerPanel.add(buttonsPanel, BorderLayout.SOUTH);
        sourceImage = "menuFondoPrincipal.jpg";
        iconImage = new ImageIcon(sourceImage);
        mainPanelBackground = iconImage.getImage();
        putVideoImage = new JLabel();
        putVideoImage.setBorder(new EmptyBorder(0, 150, 100, 0));
        iconImage = new ImageIcon(sourceImage);
        mainPanelBackground = iconImage.getImage();
        Image scaledImage = mainPanelBackground.getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        putVideoImage.setIcon(scaledIcon);
        buttonsPanel.add(putVideoImage, BorderLayout.CENTER);
        createMisionButton = new JButton("Crear Mision");
        createMisionButton.setPreferredSize(new Dimension(200,60));
        createMisionButton.setBackground(Color.BLUE);
        createMisionButton.setForeground(Color.WHITE);
        buttonsPanel.add(createMisionButton, BorderLayout.SOUTH);
        assignShipsAndCrewButton = new JButton("Asignar naves y tripulaciones");
        assignShipsAndCrewButton.setBackground(Color.CYAN);
        assignShipsAndCrewButton.setForeground(Color.WHITE);
        buttonsPanel.add(assignShipsAndCrewButton, BorderLayout.SOUTH);
        viewMissionStatus = new JButton("Visualizar  mision");
        viewMissionStatus.setBackground(Color.ORANGE);
        viewMissionStatus.setForeground(Color.WHITE);
        buttonsPanel.add(viewMissionStatus, BorderLayout.SOUTH);
        reportsTrayectoryButton = new JButton("Reportes y Trayectorias de las naves");
        reportsTrayectoryButton.setBackground(Color.MAGENTA);
        reportsTrayectoryButton.setForeground(Color.WHITE);
        buttonsPanel.add(reportsTrayectoryButton, BorderLayout.SOUTH);
        createMisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearMision();
            }
        });
        assignShipsAndCrewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NavesYTripulaciones();
            }
        });
        viewMissionStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VisualizarMisiones();
            }
        });
        reportsTrayectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ReportesYTrayectoriaNave();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }




}