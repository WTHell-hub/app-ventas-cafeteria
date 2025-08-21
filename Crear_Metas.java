package Segundo_Semestre.Diario;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class Crear_Metas extends javax.swing.JFrame {

    public Crear_Metas() {
        JScrollPane scroll = new javax.swing.JScrollPane();
        String[] columnas = {"Metas"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable lista = new javax.swing.JTable(model);
        JLabel titulo = new javax.swing.JLabel();
        JTextField entrada = new javax.swing.JTextField();
        JButton aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
//        setUndecorated(true);

        scroll.setViewportView(lista);

        titulo.setFont(new java.awt.Font("Segoe UI Historic", 3, 24)); // NOI18N
        titulo.setText("Objetivos a cumplir:");

        ActionListener agg = (_ -> {
            String txt = entrada.getText().trim();

            if (!txt.isEmpty()) {
                System.out.println(Controladora.getMetas().size());
                Controladora.addMetas(txt);
                Object[] temp = {txt};
                model.addRow(temp);

                Controladora.Guardar();

                if (Controladora.getMetas().size() == 10) {
                    System.out.println("hasta aquid");
                    dispose();
                    new Interfas_Principal();
                }
            }

            entrada.setText("");
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(agg);
        entrada.addActionListener(agg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(aceptar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(titulo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(aceptar)
                                                .addGap(0, 187, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
        setVisible(true);
    }
}