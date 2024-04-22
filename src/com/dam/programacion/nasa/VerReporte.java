package com.dam.programacion.nasa;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class VerReporte extends JFrame {

    private JPanel centerPanel;
    private JPanel selectAndInfoPanel;
    private JTable missionsTable;
    private DefaultTableModel modelTable;
    private JComboBox<String> missionNameBox;
    private JButton confirm;

    public VerReporte(){
        setTitle("Reportes de Misiones");
        setVisible(true);
        setBounds(600, 600, 600, 600);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);

        modelTable = new DefaultTableModel(
                new Object[][]{
                        {},

                },
                new Object[]{"Reportes"}
        );
        missionsTable = new JTable(modelTable);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(Color.CYAN);


        for (int i = 0; i < missionsTable.getColumnCount(); i++) {
            missionsTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }


        JScrollPane scrollPane = new JScrollPane(missionsTable);
        scrollPane.setBackground(Color.BLACK);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        selectAndInfoPanel = new JPanel();
        selectAndInfoPanel.setLayout(new BorderLayout());
        centerPanel.add(selectAndInfoPanel, BorderLayout.SOUTH);

        missionNameBox = new JComboBox<>();
        for (String element:GenerarReporte.getMissionsState().keySet()){

            missionNameBox.addItem(element);
        }
        selectAndInfoPanel.add(missionNameBox, BorderLayout.WEST);
        confirm = new JButton("confirmar");
        confirm.setBackground(Color.GREEN);
        confirm.setForeground(Color.WHITE);
        selectAndInfoPanel.add(confirm, BorderLayout.SOUTH);
        confirm.addActionListener(this::insertInformation);
    }

    public void insertInformation(ActionEvent e){

        if(checkEmptyContent()){
            confirm.setEnabled(true);
            String nameMission = (String) missionNameBox.getSelectedItem();
            for (Map.Entry<String, String> entry : GenerarReporte.getMissionsState().entrySet()) {
                String clave = entry.getKey();
                String valor = entry.getValue();
                Object[] row1 = {clave};
                modelTable.addRow(row1);
                Object[] row2 = {valor};
                modelTable.addRow(row2);


            }
        }

    }

    private boolean checkEmptyContent(){
        int selectIndex = missionNameBox.getSelectedIndex();
        return selectIndex != -1;
    }

}

