/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import data.ClienteDao;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizVagner
 */
public class TelaInicial extends javax.swing.JFrame {
ClienteDao cliente = new ClienteDao();
    /**
     * Creates new form TelaDeCadastro
     */
    public TelaInicial() {
        initComponents();
        rbFuncionario.setText("");
        rbCliente.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        painelTelaCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        rbFuncionario = new javax.swing.JRadioButton();
        rbCliente = new javax.swing.JRadioButton();
        btnProximo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo de cadastro");

        lblFuncionario.setText("Funcionario");

        lblCliente.setText("Cliente");

        buttonGroup2.add(rbFuncionario);
        rbFuncionario.setText("jRadioButton1");
        rbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFuncionarioActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbCliente);
        rbCliente.setText("jRadioButton2");
        rbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClienteActionPerformed(evt);
            }
        });

        btnProximo.setText("Próximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTelaCadastroLayout = new javax.swing.GroupLayout(painelTelaCadastro);
        painelTelaCadastro.setLayout(painelTelaCadastroLayout);
        painelTelaCadastroLayout.setHorizontalGroup(
            painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnProximo)
                            .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                    .addComponent(lblFuncionario)
                                    .addGap(29, 29, 29)
                                    .addComponent(rbFuncionario))
                                .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                                    .addComponent(lblCliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbCliente))))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        painelTelaCadastroLayout.setVerticalGroup(
            painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaCadastroLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionario)
                    .addComponent(rbFuncionario))
                .addGap(18, 18, 18)
                .addGroup(painelTelaCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(rbCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnProximo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTelaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFuncionarioActionPerformed

    }//GEN-LAST:event_rbFuncionarioActionPerformed

    private void rbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClienteActionPerformed
     
    }//GEN-LAST:event_rbClienteActionPerformed
    
    //
    
    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        
        if( rbCliente.isSelected()){
            TelaCliente cadastroCliente = new TelaCliente();
            cadastroCliente.setVisible(true);
        }
        else if(rbFuncionario.isSelected()){
            TelaFuncionario cadastroFuncionario = new TelaFuncionario();
            cadastroFuncionario.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Escolha qual cadastro deseja realizar.");
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProximo;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JPanel painelTelaCadastro;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbFuncionario;
    // End of variables declaration//GEN-END:variables

    
    
}
