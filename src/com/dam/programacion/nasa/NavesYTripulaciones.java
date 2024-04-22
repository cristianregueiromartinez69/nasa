package com.dam.programacion.nasa;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NavesYTripulaciones extends JFrame {

    private JPanel centerPanel;
    private JLabel shipNameIndicator;
    private JTextField shipNameText;
    private JLabel crewMenbersIndicator;
    private JTextField crewMenbersText;
    private JTextArea shipAndCrewConfirmationAdded;
    private JButton confirm;
    private static HashMap<String, String> nave_tripulacion = new HashMap<>();


    public NavesYTripulaciones() {
        setTitle("Naves y tripulaciones");
        setBounds(500, 500, 500, 500);
        setVisible(true);
        centerPanel = new JPanel();
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 150);
        centerPanel.setBorder(borde);
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        add(centerPanel);
        shipNameIndicator = new JLabel("Nombre de la nave");
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(shipNameIndicator, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        shipNameText = new JTextField(9);
        shipNameText.setPreferredSize(new Dimension(20, 20));
        centerPanel.add(shipNameText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        crewMenbersIndicator = new JLabel("Nombre de la tripulacion");
        centerPanel.add(crewMenbersIndicator, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        crewMenbersText = new JTextField(9);
        crewMenbersText.setPreferredSize(new Dimension(300, 60));
        centerPanel.add(new JScrollPane(crewMenbersText), gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        shipAndCrewConfirmationAdded = new JTextArea();
        shipAndCrewConfirmationAdded.setPreferredSize(new Dimension(220, 60));
        shipAndCrewConfirmationAdded.setEditable(false);
        centerPanel.add(new JScrollPane(shipAndCrewConfirmationAdded), gbc);
        confirm = new JButton("confirmar");
        confirm.setBackground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(confirm, gbc);
        confirm.addActionListener(this::addShipCrewMission);

    }

    public void addShipCrewMission(ActionEvent e) {


        if (checkEmptyContent()) {
            String auxShipName = shipNameText.getText();
            String auxCrewMembers = crewMenbersText.getText();
            shipAndCrewConfirmationAdded.setText("Nave y tripulacion añadida correctamente");
            nave_tripulacion.put(auxShipName, auxCrewMembers);
            shipNameText.setText("");
            crewMenbersText.setText("");
        } else {
            shipAndCrewConfirmationAdded.setText("Rellene los campos que faltan");
        }
    }


    private boolean checkEmptyContent() {

        return !shipNameText.getText().isEmpty() && !crewMenbersText.getText().isEmpty();
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JLabel getShipNameIndicator() {
        return shipNameIndicator;
    }

    public void setShipNameIndicator(JLabel shipNameIndicator) {
        this.shipNameIndicator = shipNameIndicator;
    }

    public JTextField getShipNameText() {
        return shipNameText;
    }

    public void setShipNameText(JTextField shipNameText) {
        this.shipNameText = shipNameText;
    }

    public JLabel getCrewMenbersIndicator() {
        return crewMenbersIndicator;
    }

    public void setCrewMenbersIndicator(JLabel crewMenbersIndicator) {
        this.crewMenbersIndicator = crewMenbersIndicator;
    }

    public JTextField getCrewMenbersText() {
        return crewMenbersText;
    }

    public void setCrewMenbersText(JTextField crewMenbersText) {
        this.crewMenbersText = crewMenbersText;
    }

    public JTextArea getShipAndCrewConfirmationAdded() {
        return shipAndCrewConfirmationAdded;
    }

    public void setShipAndCrewConfirmationAdded(JTextArea shipAndCrewConfirmationAdded) {
        this.shipAndCrewConfirmationAdded = shipAndCrewConfirmationAdded;
    }

    public JButton getConfirm() {
        return confirm;
    }

    public void setConfirm(JButton confirm) {
        this.confirm = confirm;
    }

    public static HashMap<String, String> getNave_tripulacion() {
        return nave_tripulacion;
    }

    public void setNave_tripulacion(HashMap<String, String> nave_tripulacion) {
        this.nave_tripulacion = nave_tripulacion;
    }
}