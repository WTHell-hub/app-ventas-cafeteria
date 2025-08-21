package Segundo_Semestre.Diario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Interfas_Principal extends javax.swing.JFrame {

    public Interfas_Principal() {
        JLabel titulo = new JLabel();
        JButton btnNotaDelDia = new JButton();
        JButton btnMetas = new JButton();
        JButton btnResumen = new JButton();
        JLabel txtRecha = new JLabel();
        JScrollPane scroll = new JScrollPane();
        String[] columnas = {"txt","fecha","Dias"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(model);

        for (Entrada e: Controladora.OrdenarDiario()) {
            int fin = Math.min(10, e.getTxt().length());

            Object[] temp = {e.getTxt().substring(0,fin)+"...", e.getFecha(), ChronoUnit.DAYS.between(e.getFecha(), LocalDate.now())+" days ago"};
            model.addRow(temp);
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 24)); // NOI18N
        titulo.setText("Diario");

        btnNotaDelDia.setText("Nota del dia");
        btnNotaDelDia.addActionListener(_-> {
            SwingUtilities.getWindowAncestor(btnNotaDelDia).dispose();
            new Txt_Diario();
        });

        btnMetas.setText("Metas");
        btnMetas.addActionListener(_ -> {
            SwingUtilities.getWindowAncestor(btnMetas).dispose();
        });

        btnResumen.setText("Resumen");

        txtRecha.setText("Racha: "+Controladora.Contar_Racha());

        scroll.setViewportView(tabla);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnMetas)
                                                        .addComponent(btnNotaDelDia)
                                                        .addComponent(btnResumen))
                                                .addGap(26, 26, 26)
                                                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(titulo, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70)
                                                .addComponent(txtRecha)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(titulo))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(txtRecha)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(btnNotaDelDia)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnMetas)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnResumen))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
