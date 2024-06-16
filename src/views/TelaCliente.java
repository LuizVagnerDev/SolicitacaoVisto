/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

//import java.util.Scanner;
//import java.time.LocalDate;
import javax.swing.JOptionPane;
import data.Cliente;
import data.ClienteDao;
import data.Funcionario;
import data.FuncionarioDao;
//import data.ListaDeCadastroClientes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LuizVagner
 */
public class TelaCliente extends javax.swing.JFrame {
    
    Cliente cliente = new Cliente();
    ClienteDao  cDao = new ClienteDao();
    boolean status;
    int resposta;
    
    
    public TelaCliente() {
        initComponents();
        popularTabela("");
        txtMatricula.setEnabled(false);
        preencherComboFuncionario();
    }
    
      public String dataFormatada(String data) {
        String dia = data.substring(8);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);

        return dia + "/" + mes + "/" + ano;
    }
        
     public int posicao() {
        String linhaSelecionada = String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0));
        return Integer.parseInt(linhaSelecionada);
    }
     
       private void limpaTela(){
           txtMatricula.setText("");
           txtNome.setText("");
           fmtCpf.setText("");
           formatData.setText("");
           txtEndereco.setText("");
           txtEmail.setText("");
         
    }
       Funcionario f = new Funcionario();
       private void popularTabela(String filtrar){
        
        status = cDao.conectar();
         
          if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            List<Cliente> listaClientes = cDao.listagem(filtrar);
            
            DefaultTableModel tabelaClientes = (DefaultTableModel) tblClientes.getModel();
            tblClientes.setRowSorter(new TableRowSorter(tabelaClientes));
            tabelaClientes.setNumRows(0);
            
            for(Cliente c: listaClientes){
                Object[] obj = new Object[]{
                    c.getMatricula(),
                    c.getNome(),
                    c.getCpf(),
                    dataFormatada(String.valueOf(c.getData_nasc())),
                    c.getEndereco(),
                    c.getEmail(),
                    c.getId_funcionario().getNomeFuncionario()
                   
                };
                 tabelaClientes.addRow(obj);
            }
           
            cDao.desconectar();
          }
    }
       
        private void consultarCliente(){
          
         Cliente encontrarCliente = cDao.consulta(posicao());
         
                 txtMatricula.setText(String.valueOf(encontrarCliente.getMatricula()));
                 txtNome.setText(encontrarCliente.getNome());
                 fmtCpf.setText(encontrarCliente.getCpf());
                 formatData.setText(dataFormatada(String.valueOf(encontrarCliente.getData_nasc())));
                 txtEndereco.setText(encontrarCliente.getEndereco());
                 txtEmail.setText(encontrarCliente.getEmail());      
                 cbFuncionarios.setSelectedItem(encontrarCliente.getId_funcionario());
    }
        
        private void preencherComboFuncionario(){
            FuncionarioDao fDao = new FuncionarioDao();
            boolean status = fDao.conectar();
             if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        
        else{
                  List<Funcionario> lista = fDao.getFuncionario();
                  
                  for(Funcionario f : lista){
                      cbFuncionarios.addItem(f);
                  }
             }
           
            
            fDao.desconectar();
        }

 
    @SuppressWarnings("unchecked")
     
     
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTituloCadastroClientes = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        formatData = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        fmtCpf = new javax.swing.JFormattedTextField();
        lblFuncionario = new javax.swing.JLabel();
        cbFuncionarios = new javax.swing.JComboBox();
        filtrarNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloCadastroClientes.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTituloCadastroClientes.setText("Cadastro de Clientes");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setText("Nome do cliente:");

        lblDataNasc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDataNasc.setText("Data de nascimento:");

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setText("E-mail:");

        try {
            formatData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCpf.setText("CPF:");

        lblMatricula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMatricula.setText("Matrícula:");

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        try {
            fmtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFuncionario.setText("Funcionario responsável:");

        filtrarNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                filtrarNomeCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisar Cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFuncionario)
                                    .addComponent(lblEmail)
                                    .addComponent(lblDataNasc))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formatData, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMatricula, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filtrarNome, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtEndereco)
                            .addComponent(fmtCpf)
                            .addComponent(txtMatricula))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(lblTituloCadastroClientes))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(421, 421, 421))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTituloCadastroClientes)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCpf)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNasc)
                    .addComponent(formatData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricula)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filtrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFuncionario)
                        .addComponent(cbFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar)
                    .addComponent(btnCadastrar))
                .addGap(26, 26, 26))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRÍCULA", "NOME", "CPF", "DATA NASC", "ENDEREÇO", "E-MAIL", "RESPONSÁVEL"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
      TelaInicial voltarTela = new TelaInicial();
      voltarTela.setVisible(true);
      dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

      cliente.setNome(txtNome.getText());
      cliente.setCpf(fmtCpf.getText());
       
        String data = formatData.getText();
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataConvertida = conversor.parse(data);
            java.sql.Date dataEmSql = new java.sql.Date(dataConvertida.getTime());
            cliente.setData_nasc(dataEmSql);
        } catch (ParseException pe) {

        }
        cliente.setEndereco(txtEndereco.getText());
        cliente.setEmail(txtEmail.getText());
        Funcionario funcionarioId = (Funcionario)  cbFuncionarios.getSelectedItem();
        cliente.setId_funcionario(funcionarioId);
        
        String nome = txtNome.getText();
       
        boolean validaNome = nome.matches("^[a-zA-ZÀ-ÖØ-öø-ÿ\\s]+$");
        String cpf = fmtCpf.getText();
        boolean validaCpf = cpf.matches("\\d{11}");

        String email = txtEmail.getText();
        boolean validaEmail = email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        
        if(nome.isEmpty() || cpf.isEmpty() || formatData.getText().isEmpty() || txtEndereco.getText().isEmpty() ||email.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco.");
            return;
        }
        
        if(!validaNome && !nome.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não é permitido números no campo nome");
            return;
        }
        
        if(!validaCpf){
            JOptionPane.showMessageDialog(null, "O campo CPF deve conter 11 digitos e apenas números");
            return;
        }
        
        if(!validaEmail){
            JOptionPane.showMessageDialog(null, "Formato de e-mail inválido");
            return;
        }
        if(cbFuncionarios.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos um funcionário");
            return;
        }
        
        status = cDao.conectar();
        
        if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        
        else{
            resposta = cDao.salvar(cliente);
            
            if(resposta == 1){
                limpaTela();
                popularTabela("");
            }
            
            else if(resposta == 1062){
               JOptionPane.showMessageDialog(null, "O CPF que está tentando cadastrar já está sendo utilizado");
                fmtCpf.setText("");
                 return;
                
            }
        }
        
        cDao.desconectar();
      
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        status = cDao.conectar();
        int posicao  = tblClientes.getSelectedRow();
        
        if(posicao ==-1){
             JOptionPane.showMessageDialog(null," A lista está vazia ou nenhuma linha foi selecionada");
        return;
        }
        if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            int opcao = JOptionPane.showConfirmDialog(null, "Cliente " + tblClientes.getValueAt(tblClientes.getSelectedRow(), 1) + " será excluído da lista, deseja continuar?");
            if(opcao == JOptionPane.YES_OPTION){
            cDao.excluir(posicao());
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
        
        cDao.desconectar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:

        int posicao  = tblClientes.getSelectedRow();
        
        if(posicao ==-1){
             JOptionPane.showMessageDialog(null," A lista está vazia ou nenhuma linha foi selecionada");
        return;
        }
        
        String data = formatData.getText();
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Date dataConvertida = conversor.parse(data);
            java.sql.Date dataEmSql = new java.sql.Date(dataConvertida.getTime());
            cliente.setData_nasc(dataEmSql);
        }
        catch (ParseException pe) {
            JOptionPane.showMessageDialog(null, "Erro na conversão da data " + pe.getMessage());
        }
        
        cliente.setMatricula(Integer.valueOf(txtMatricula.getText()));
        cliente.setNome(txtNome.getText());
        cliente.setCpf(fmtCpf.getText());
        cliente.setEndereco(txtEndereco.getText());
        cliente.setEmail(txtEmail.getText());
        
          Funcionario funcionarioId = (Funcionario) cbFuncionarios.getSelectedItem();
          cliente.setId_funcionario(funcionarioId);
        
        
        status = cDao.conectar();
        
        if(status == false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            
            cDao.atualizar(cliente, posicao());
            limpaTela();
            popularTabela("");
            btnAtualizar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnCadastrar.setEnabled(true);
           
          }
        cDao.desconectar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // TODO add your handling code here:
        
        cDao.conectar();
        if(status ==false){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        else{
            consultarCliente();
            btnCadastrar.setEnabled(false);
            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
        }
        cDao.desconectar();
      
    }//GEN-LAST:event_tblClientesMouseClicked

    private void filtrarNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_filtrarNomeCaretUpdate
        // TODO add your handling code here:
        popularTabela(filtrarNome.getText());
    }//GEN-LAST:event_filtrarNomeCaretUpdate

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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbFuncionarios;
    private javax.swing.JTextField filtrarNome;
    private javax.swing.JFormattedTextField fmtCpf;
    private javax.swing.JFormattedTextField formatData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTituloCadastroClientes;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
