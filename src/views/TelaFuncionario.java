/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import data.Funcionario;
import data.FuncionarioDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LuizVagner
 */
public class TelaFuncionario extends javax.swing.JFrame {
    
    Funcionario funcionario = new Funcionario();
    FuncionarioDao  fDao = new FuncionarioDao();
    boolean status;
    int resposta;

    /**
     * Creates new form TelaFuncionario
     */
    public TelaFuncionario() {
        initComponents();
         popularTabela("");
         txtMatricula.setEnabled(false);
    }

    public int posicao() {
        String linhaSelecionada = String.valueOf(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 0));
        return Integer.parseInt(linhaSelecionada);
    }
    
     private void limpaTela(){
           txtNome.setText("");
           txtMatricula.setText("");
     }
     
     private void popularTabela(String filtrar){
        
        status = fDao.conectar();
         
          if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            List<Funcionario> listaFuncionarios = fDao.listagem(filtrar);
            
            DefaultTableModel tabelaModelo = (DefaultTableModel) tblFuncionarios.getModel();
            tblFuncionarios.setRowSorter(new TableRowSorter(tabelaModelo));
            tabelaModelo.setNumRows(0);
            
            for(Funcionario f: listaFuncionarios){
                Object[] obj = new Object[]{
                    f.getId(),
                    f.getNomeFuncionario(),
                    f.getCargo(),
                   
                };
                 tabelaModelo.addRow(obj);
            }
           
            fDao.desconectar();
          }
    }
     
     private void consultarFuncionario(){
         Funcionario encontrarFuncionario = fDao.consulta(posicao());
         txtNome.setText(encontrarFuncionario.getNomeFuncionario());
         cbCargo.setSelectedItem(encontrarFuncionario.getCargo());
         txtMatricula.setText(String.valueOf(encontrarFuncionario.getId()));
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        cbCargo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Funcionários");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setText("Nome:");

        lblCargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCargo.setText("Cargo:");

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Matrícula:");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Analista de processo Júnior", "Analista de processo Pleno", "Gerente Geral", "Supervisor de atendimento" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblCargo)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMatricula)
                            .addComponent(cbCargo, 0, 215, Short.MAX_VALUE)
                            .addComponent(txtNome))
                        .addGap(131, 131, 131))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar)
                    .addComponent(btnVoltar))
                .addGap(16, 16, 16))
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRÍCULA", "NOME", "CARGO"
            }
        ));
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    
     

    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
       TelaInicial voltarTela = new  TelaInicial();
       voltarTela.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        funcionario.setNomeFuncionario(txtNome.getText());
        funcionario.setCargo(String.valueOf(cbCargo.getSelectedItem()));
         
        String nome = txtNome.getText();
        boolean validaNome = nome.matches("^[a-zA-ZÀ-ÖØ-öø-ÿ\\s]+$");
        
        if(nome.isEmpty() ||cbCargo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco.");
            return;
        }
        
        if(!validaNome && !nome.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não é permitido números no campo nome");
            return;
        }
        
        status = fDao.conectar();
        
        if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        
        else{
            resposta = fDao.salvar(funcionario);
            
            if(resposta == 1){
                limpaTela();
                popularTabela("");
            }
            
            else {
              JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
                 return;
                
            }
        }
        
        fDao.desconectar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        status = fDao.conectar();
        int posicao  = tblFuncionarios.getSelectedRow();
        
        if(posicao ==-1){
             JOptionPane.showMessageDialog(null," A lista está vazia ou nenhuma linha foi selecionada");
        return;
        }
        if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            int opcao = JOptionPane.showConfirmDialog(null, "O(a) Funcuinário(a)  " + tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 1) + " será excluído da lista, deseja continuar?");
            if(opcao == JOptionPane.YES_OPTION){
            fDao.excluir(posicao());
            }
            else{
                return;
             }
            
            limpaTela();
            popularTabela("");
            btnExcluir.setEnabled(false);
            btnAtualizar.setEnabled(false);
            btnCadastrar.setEnabled(true);
        }
        fDao.desconectar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        int posicao  = tblFuncionarios.getSelectedRow();
        
        if(posicao ==-1){
             JOptionPane.showMessageDialog(null," A lista está vazia ou nenhuma linha foi selecionada");
        return;
        }
        
        
        
        funcionario.setNomeFuncionario(txtNome.getText());
        funcionario.setCargo(String.valueOf(cbCargo.getSelectedItem()));
         
        status = fDao.conectar();
        
        if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            
            fDao.atualizar(funcionario, posicao());
            limpaTela();
            popularTabela("");
            btnAtualizar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnCadastrar.setEnabled(true);
           
          }
        fDao.desconectar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        // TODO add your handling code here:
          fDao.conectar();
        if(status ==false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            consultarFuncionario();
            btnCadastrar.setEnabled(false);
            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
            
        }
        fDao.desconectar();
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
