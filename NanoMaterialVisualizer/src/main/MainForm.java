package main;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import main.geom.shapes.ShapeType;

/**
 * @author Алексей
 */
public class MainForm extends javax.swing.JFrame {

    private Render render;
    private int mouseX;
    private int mouseY;
    private Timer timer = new Timer(25, (ActionEvent e) -> {
        if (render != null) {
            render.rotate(Integer.MIN_VALUE, 0);
        }
    });

    public MainForm() {
        initComponents();
        listMaterials.setSelectedIndex(0);
        render = new Render(paneDraw.getGraphics(), paneDraw.getWidth(),
                paneDraw.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        listMaterials = new javax.swing.JList();
        bVisualize = new javax.swing.JButton();
        paneDraw = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bYDec = new javax.swing.JButton();
        bXDec = new javax.swing.JButton();
        bYInc = new javax.swing.JButton();
        bXInc = new javax.swing.JButton();
        bReset = new javax.swing.JButton();

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

        jPanel1.setPreferredSize(new java.awt.Dimension(140, 140));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        bYDec.setText("y-");
        bYDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bYDecActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel1.add(bYDec, gridBagConstraints);

        bXDec.setText("x-");
        bXDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXDecActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(bXDec, gridBagConstraints);

        bYInc.setText("y+");
        bYInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bYIncActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(bYInc, gridBagConstraints);

        bXInc.setText("x+");
        bXInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXIncActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel1.add(bXInc, gridBagConstraints);

        bReset.setText("0");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(bReset, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(bVisualize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(bVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVisualizeActionPerformed
        try {
            render.display(ShapeType.getBy(listMaterials.getSelectedIndex()));
            if (!timer.isRunning()) {
                timer.start();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }//GEN-LAST:event_bVisualizeActionPerformed

    private void paneDrawMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_paneDrawMouseWheelMoved
        render.scale(-evt.getWheelRotation());
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

    private void bYIncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bYIncActionPerformed
        render.translate(0, -20);
    }//GEN-LAST:event_bYIncActionPerformed

    private void bYDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bYDecActionPerformed
        render.translate(0, 20);
    }//GEN-LAST:event_bYDecActionPerformed

    private void bXIncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXIncActionPerformed
        render.translate(20, 0);
    }//GEN-LAST:event_bXIncActionPerformed

    private void bXDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXDecActionPerformed
        render.translate(-20, 0);
    }//GEN-LAST:event_bXDecActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        render.resetDisplayProperties();
    }//GEN-LAST:event_bResetActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReset;
    private javax.swing.JButton bVisualize;
    private javax.swing.JButton bXDec;
    private javax.swing.JButton bXInc;
    private javax.swing.JButton bYDec;
    private javax.swing.JButton bYInc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listMaterials;
    private javax.swing.JPanel paneDraw;
    // End of variables declaration//GEN-END:variables

}
