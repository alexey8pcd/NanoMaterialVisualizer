package main;

import javax.swing.JOptionPane;
import main.geom.shapes.ShapeType;

/**
 * @author Алексей
 */
public class MainForm extends javax.swing.JFrame {

    private final Render render;
    private int mouseX;
    private int mouseY;

    public MainForm() {
        initComponents();
        listMaterials.setSelectedIndex(0);
        render = new Render(paneDraw.getGraphics(), paneDraw.getWidth(),
                paneDraw.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listMaterials = new javax.swing.JList();
        bVisualize = new javax.swing.JButton();
        paneDraw = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listMaterials.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Углеродные нанотрубки", "Фуллерен", "Графен", "Нанокристаллы" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listMaterials);

        bVisualize.setText("Отобразить");
        bVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVisualizeActionPerformed(evt);
            }
        });

        paneDraw.setBackground(new java.awt.Color(0, 0, 0));
        paneDraw.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paneDrawMouseDragged(evt);
            }
        });
        paneDraw.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                paneDrawMouseWheelMoved(evt);
            }
        });
        paneDraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneDrawMousePressed(evt);
            }
        });

        javax.swing.GroupLayout paneDrawLayout = new javax.swing.GroupLayout(paneDraw);
        paneDraw.setLayout(paneDrawLayout);
        paneDrawLayout.setHorizontalGroup(
            paneDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        paneDrawLayout.setVerticalGroup(
            paneDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(bVisualize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVisualizeActionPerformed
        try {
            render.display(ShapeType.getBy(listMaterials.getSelectedIndex()));
            render.rotate(-400, 0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }//GEN-LAST:event_bVisualizeActionPerformed

    private void paneDrawMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_paneDrawMouseWheelMoved
        render.scale(evt.getWheelRotation());
    }//GEN-LAST:event_paneDrawMouseWheelMoved

    private void paneDrawMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneDrawMouseDragged
        int dx = evt.getX() - mouseX;
        int dy = evt.getY() - mouseY;
        render.rotate(dx, dy);
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_paneDrawMouseDragged

    private void paneDrawMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneDrawMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_paneDrawMousePressed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bVisualize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listMaterials;
    private javax.swing.JPanel paneDraw;
    // End of variables declaration//GEN-END:variables

}
