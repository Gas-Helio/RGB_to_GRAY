/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.imageio.ImageIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author heliojunior
 */
public class Tela extends javax.swing.JFrame {

    private static String IP;
    private static int PORTA;

    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
    }
    
    private static File fileImg;
    private static BufferedImage image;
    private static String nameImg;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_Escolher = new javax.swing.JButton();
        button_Limpar = new javax.swing.JButton();
        button_Convert = new javax.swing.JButton();
        label_comF = new javax.swing.JLabel();
        label_semF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        button_Escolher.setText("Escolher");
        button_Escolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_EscolherActionPerformed(evt);
            }
        });

        button_Limpar.setText("Limpar");
        button_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_LimparActionPerformed(evt);
            }
        });

        button_Convert.setText("Converter");
        button_Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ConvertActionPerformed(evt);
            }
        });

        label_comF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Com filtro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        label_semF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sem filtro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(button_Escolher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_Limpar)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(label_semF, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_Convert)
                .addGap(18, 18, 18)
                .addComponent(label_comF, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(button_Convert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_comF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_semF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Escolher)
                    .addComponent(button_Limpar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_EscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_EscolherActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser(); 
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showSaveDialog(null);
        if (i == 1){
            System.out.println("");
        } else {
            File arquivo = file.getSelectedFile();
            nameImg = arquivo.getPath();
            ImageIcon ii = new ImageIcon(nameImg);
            Image image = ii.getImage();
            Image newimg = image.getScaledInstance(215, 175,  java.awt.Image.SCALE_SMOOTH);
            
            label_semF.setIcon(new ImageIcon(newimg));
        }
    }//GEN-LAST:event_button_EscolherActionPerformed

    private void button_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_LimparActionPerformed
        // TODO add your handling code here:
        label_comF.setIcon(null);
        label_semF.setIcon(null);
    }//GEN-LAST:event_button_LimparActionPerformed

    private void button_ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ConvertActionPerformed
        // TODO add your handling code here:
        try {
//            AplicaFiltroInterface afi = (AplicaFiltroInterface) Naming.lookup("rmi://192.168.0.108:12345/AplicaFiltro");
            
//            Registry rgty = LocateRegistry.getRegistry("192.168.0.108", 12345);

//            AplicaFiltroInterface afi = (AplicaFiltroInterface) rgty.lookup("AplicaFiltro");
            
            System.out.println("rmi://"+IP+":"+PORTA+"/AplicaFiltro");
            AplicaFiltroInterface afi = (AplicaFiltroInterface) Naming.lookup("rmi://"+IP+":"+PORTA+"/AplicaFiltro");

            fileImg = new File(nameImg);
            
            image = ImageIO.read(fileImg);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(image, "jpg", baos);
            System.out.println("Enviando imagem");
            image = javax.imageio.ImageIO.read(new ByteArrayInputStream(afi.aplicaFiltro(baos.toByteArray())));
            // image = afi.aplicaFiltro(ImageIO.read(fileImg));
            System.out.println("Imagem enviada");
            System.out.println("Imagem recebida");
            ImageIcon ii = new ImageIcon(image);
            Image image = ii.getImage();
            Image newimg = image.getScaledInstance(215, 175,  java.awt.Image.SCALE_SMOOTH);
            
            // label_semF.setIcon(null);
            label_comF.setIcon(new ImageIcon(newimg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_button_ConvertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        IP = args[0];
        PORTA = Integer.parseInt(args[1]);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela t = new Tela();
                t.setLocationRelativeTo(null);
                t.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Convert;
    private javax.swing.JButton button_Escolher;
    private javax.swing.JButton button_Limpar;
    private javax.swing.JLabel label_comF;
    private javax.swing.JLabel label_semF;
    // End of variables declaration//GEN-END:variables
}
