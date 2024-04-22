package com.dam.programacion.nasa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GenerarReporte extends JFrame implements ActionListener {

    private JPanel centerPanel;
    private JScrollPane reportPanel;
    private JPanel jComboBoxPanel;
    private JComboBox<String> missionNameBox;
    private JLabel crewInformationIndicator;
    private JTextField crewInformationText;
    private JLabel shipStatusIndicator;
    private JTextField shipStatusText;
    private JLabel progressBarIndicator;
    private JTextField progressBarNumber;
    private JProgressBar missionProgressBar;
    private JButton confirmBoxButton;
    private JTextArea confirmReport;
    private static HashMap<String, String> missionsState = new HashMap<>();

    public GenerarReporte() {
        setTitle("Generar Reporte");

        setBounds(50, 50, 600, 400);
        setVisible(true);

        centerPanel = new JPanel(new BorderLayout());
        add(centerPanel);

        jComboBoxPanel = new JPanel(new BorderLayout());
        centerPanel.add(jComboBoxPanel, BorderLayout.WEST);

        missionNameBox = new JComboBox<>();
        for (String element : CrearMision.getMissionName()) {
            missionNameBox.addItem(element);
        }
        jComboBoxPanel.add(missionNameBox);

        confirmBoxButton = new JButton("Confirmar selección");
        jComboBoxPanel.add(confirmBoxButton, BorderLayout.SOUTH);
        confirmBoxButton.addActionListener(this);

        reportPanel = new JScrollPane();
        centerPanel.add(reportPanel, BorderLayout.CENTER);

        JPanel reportContentPanel = new JPanel(new GridLayout(4, 2));
        reportPanel.setViewportView(reportContentPanel);

        crewInformationIndicator = new JLabel("Información de la tripulación");
        crewInformationText = new JTextField();
        shipStatusIndicator = new JLabel("Estado de la nave");
        shipStatusText = new JTextField();
        progressBarIndicator = new JLabel("Porcentaje progreso de la nave");
        progressBarNumber = new JTextField();
        missionProgressBar = new JProgressBar();

        reportContentPanel.add(crewInformationIndicator);
        reportContentPanel.add(crewInformationText);
        reportContentPanel.add(shipStatusIndicator);
        reportContentPanel.add(shipStatusText);
        reportContentPanel.add(progressBarIndicator);
        reportContentPanel.add(progressBarNumber);
        reportContentPanel.add(missionProgressBar);

        confirmReport = new JTextArea();
        reportContentPanel.add(confirmReport);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkIndexEmpty()) {
            confirmReport.setText("reporte creado correctamente");
            String missionName = (String) missionNameBox.getSelectedItem();
            String informationMissionName = "Informacion de la tripulacion: " + crewInformationText.getText() +
                    "Estado de la mision: " + shipStatusText.getText() +
                    "Progreso de la mision: " + progressBarNumber.getText() + "%";
            missionsState.put(missionName, informationMissionName);
        } else {
            confirmReport.setText("Seleccione una misión para el reporte");
        }
    }

    private boolean checkIndexEmpty() {
        int index = missionNameBox.getSelectedIndex();
        return index != -1;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JScrollPane getReportPanel() {
        return reportPanel;
    }

    public void setReportPanel(JScrollPane reportPanel) {
        this.reportPanel = reportPanel;
    }

    public JPanel getjComboBoxPanel() {
        return jComboBoxPanel;
    }

    public void setjComboBoxPanel(JPanel jComboBoxPanel) {
        this.jComboBoxPanel = jComboBoxPanel;
    }

    public JComboBox<String> getMissionNameBox() {
        return missionNameBox;
    }

    public void setMissionNameBox(JComboBox<String> missionNameBox) {
        this.missionNameBox = missionNameBox;
    }

    public JLabel getCrewInformationIndicator() {
        return crewInformationIndicator;
    }

    public void setCrewInformationIndicator(JLabel crewInformationIndicator) {
        this.crewInformationIndicator = crewInformationIndicator;
    }

    public JTextField getCrewInformationText() {
        return crewInformationText;
    }

    public void setCrewInformationText(JTextField crewInformationText) {
        this.crewInformationText = crewInformationText;
    }

    public JLabel getShipStatusIndicator() {
        return shipStatusIndicator;
    }

    public void setShipStatusIndicator(JLabel shipStatusIndicator) {
        this.shipStatusIndicator = shipStatusIndicator;
    }

    public JTextField getShipStatusText() {
        return shipStatusText;
    }

    public void setShipStatusText(JTextField shipStatusText) {
        this.shipStatusText = shipStatusText;
    }

    public JLabel getProgressBarIndicator() {
        return progressBarIndicator;
    }

    public void setProgressBarIndicator(JLabel progressBarIndicator) {
        this.progressBarIndicator = progressBarIndicator;
    }

    public JTextField getProgressBarNumber() {
        return progressBarNumber;
    }

    public void setProgressBarNumber(JTextField progressBarNumber) {
        this.progressBarNumber = progressBarNumber;
    }

    public JProgressBar getMissionProgressBar() {
        return missionProgressBar;
    }

    public void setMissionProgressBar(JProgressBar missionProgressBar) {
        this.missionProgressBar = missionProgressBar;
    }

    public JButton getConfirmBoxButton() {
        return confirmBoxButton;
    }

    public void setConfirmBoxButton(JButton confirmBoxButton) {
        this.confirmBoxButton = confirmBoxButton;
    }

    public JTextArea getConfirmReport() {
        return confirmReport;
    }

    public void setConfirmReport(JTextArea confirmReport) {
        this.confirmReport = confirmReport;
    }

    public static HashMap<String, String> getMissionsState() {
        return missionsState;
    }

    public static void setMissionsState(HashMap<String, String> missionsState) {
        GenerarReporte.missionsState = missionsState;
    }
}