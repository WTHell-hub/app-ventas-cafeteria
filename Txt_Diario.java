package Segundo_Semestre.Diario;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Txt_Diario extends javax.swing.JFrame {

    public Txt_Diario() {
        JButton atras = new javax.swing.JButton();
        JScrollPane scroll = new javax.swing.JScrollPane();
        JTextArea txt = new javax.swing.JTextArea();
        JButton guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        atras.setText("<-");
        atras.addActionListener(_ -> {
            SwingUtilities.getWindowAncestor(atras).dispose();
            new Interfas_Principal();
        });

        ActionListener save = (_ -> {
            Entrada tmp = new Entrada(txt.getText().trim(), LocalDate.now());
            Controladora.addDiario(tmp);
            Controladora.Guardar();
            txt.setText("");
        });

        txt.setColumns(20);
        txt.setRows(5);
        scroll.setViewportView(txt);

        guardar.setText("Save");
        guardar.addActionListener(save);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guardar)
                                .addGap(23, 23, 23))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(atras)
                                        .addComponent(guardar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

