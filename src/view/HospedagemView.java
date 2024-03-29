/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ClienteController;
import controller.HospedagemController;
import controller.SuiteController;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.bean.Cliente;
import model.bean.Hospedagem;
import model.bean.Suite;
import tableModel.HospedagemTableModel;

/**
 *
 * @author rodri
 */
public class HospedagemView extends javax.swing.JFrame {

    private int id_hospedagem = 0;
    public Cliente cliente;
    public Suite suite;
    public Hospedagem hospedagem;

    private boolean alterar = false;

    DefaultComboBoxModel ComboBoxCliente = new DefaultComboBoxModel();
    DefaultComboBoxModel comboBoxSuite = new DefaultComboBoxModel();

    SuiteController suiteController = new SuiteController();
    ClienteController clienteController = new ClienteController();

    HospedagemTableModel tableModelHospedagem = new HospedagemTableModel();
    HospedagemController hospedagemController = new HospedagemController();

    public HospedagemView() {
        initComponents();

        /*this.AdicionarComboBoxCliente();
        this.AdicionarComboBoxSuite();*/
        this.getListaCliente();
        this.getListaSuite();
        this.getHospedagem();

        jTableHospedagem.setModel(tableModelHospedagem);
    }

    public void getListaCliente() {
        ClienteController clienteController = new ClienteController();

        for (Cliente c : clienteController.read()) {
            //jComboBoxCliente.addItem(c);
            ComboBoxCliente.addElement(c);
        }

    }

    public void getListaSuite() {
        SuiteController suiteController = new SuiteController();

        for (Suite s : suiteController.read()) {
            jComboBoxSuite.addItem(s);
        }

    }

    private void AdicionarComboBoxCliente() {
        ComboBoxCliente.removeAllElements();
        for (int i = 0; i < clienteController.read().size(); i++) {
            ComboBoxCliente.addElement(clienteController.read().get(i));
        }
    }

    private void AdicionarComboBoxSuite() {
        comboBoxSuite.removeAllElements();
        for (int i = 0; i < suiteController.read().size(); i++) {
            comboBoxSuite.addElement(suiteController.read().get(i).getNome());
            jTextFieldValor.setText(String.valueOf(suiteController.read().get(i).getValor()));

        }

    }

    private void getHospedagem() {
        tableModelHospedagem = new HospedagemTableModel(hospedagemController.read());
        jTableHospedagem.setModel(tableModelHospedagem);
    }

    private void limpaCampos() {
        jFormattedTextFieldData.setText("");
        jFormattedTextFieldCartaoAcesso.setText("");
        jFormattedTextFieldCheckin.setText("");
        jFormattedTextFieldCheckout.setText("");
        jTextFieldInf_Pagamento.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelFuncionario = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldCartaoAcesso = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldCheckin = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCheckout = new javax.swing.JFormattedTextField();
        jTextFieldInf_Pagamento = new javax.swing.JTextField();
        jLabelPagamento = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSuite = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHospedagem = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonServicos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabelTitulo.setText("Hospedagem");

        jLabelFuncionario.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jLabelFuncionario.setText("Funcionário:");

        jLabelData.setText("Data da Reserva");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Cartão de acesso:");

        try {
            jFormattedTextFieldCartaoAcesso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Check-in");

        jLabel3.setText("Checkout");

        try {
            jFormattedTextFieldCheckin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldCheckout.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelPagamento.setText("Forma de pagamento:");

        jComboBoxCliente.setModel(ComboBoxCliente);
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Cliente:");

        jComboBoxSuite.setModel(comboBoxSuite);
        jComboBoxSuite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSuiteActionPerformed(evt);
            }
        });

        jLabel5.setText("Suite:");

        jTableHospedagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Data da Reserva", "Suíte", "Valor", "Cartão de acesso", "Check-in", "Checkout", "Forma de pagamento"
            }
        ));
        jTableHospedagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHospedagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHospedagem);

        jLabel6.setText("Valor:");

        jTextFieldValor.setEditable(false);

        jButtonIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/order.png"))); // NOI18N
        jButtonServicos.setText("Serviços");
        jButtonServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButtonIncluir)
                .addGap(32, 32, 32)
                .addComponent(jButtonSalvar)
                .addGap(27, 27, 27)
                .addComponent(jButtonExcluir)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonSair)
                .addGap(18, 18, 18)
                .addComponent(jButtonServicos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonServicos))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(467, 467, 467))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jLabelPagamento)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelData)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldInf_Pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCartaoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxSuite, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(642, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFuncionario)
                        .addGap(194, 194, 194))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxSuite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabelFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelData)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jFormattedTextFieldCartaoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextFieldCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldInf_Pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPagamento)))
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSuiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSuiteActionPerformed
        ArrayList<Suite> listaComboSuite = new ArrayList<>();
        listaComboSuite.addAll(suiteController.read());

        for (int i = 0; i < listaComboSuite.size(); i++) {
            if (comboBoxSuite.getSelectedItem().toString().equals(listaComboSuite.get(i).getNome())) {
                jTextFieldValor.setText(String.valueOf(listaComboSuite.get(i).getValor()));

            }

        }


    }//GEN-LAST:event_jComboBoxSuiteActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        Cliente cliente = (Cliente) jComboBoxCliente.getSelectedItem();
        Suite suite = (Suite) jComboBoxSuite.getSelectedItem();

        hospedagemController.create(cliente,
                suite,
                jFormattedTextFieldData.getText(),
                jTextFieldInf_Pagamento.getText(),
                Integer.parseInt(jFormattedTextFieldCartaoAcesso.getText()),
                jFormattedTextFieldCheckin.getText(),
                jFormattedTextFieldCheckout.getText());
        this.getHospedagem();
        this.limpaCampos();


    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jTableHospedagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHospedagemMouseClicked
        Suite suite = new Suite();

        tableModelHospedagem = (HospedagemTableModel) jTableHospedagem.getModel();

        Hospedagem hospedagem
                = tableModelHospedagem.getHospedagem(jTableHospedagem.getSelectedRow());
        jComboBoxCliente.getSelectedItem();
        jComboBoxSuite.getSelectedItem();
        jTextFieldValor.setText(String.valueOf(suite.getValor()));
        jFormattedTextFieldData.setText(hospedagem.getData_reserva());
        jFormattedTextFieldCartaoAcesso.setText(String.valueOf(hospedagem.getCartao_acesso()));
        jFormattedTextFieldCheckin.setText(hospedagem.getData_checkin());
        jFormattedTextFieldCheckout.setText(hospedagem.getData_checkout());
        jTextFieldInf_Pagamento.setText(hospedagem.getInf_pagamento());

        for (int i = 0; i < jComboBoxCliente.getItemCount(); i++) {
            Cliente c = (Cliente) jComboBoxCliente.getItemAt(i);
            if (c.getNome().equals(hospedagem.getCliente().getNome())) {

                jComboBoxCliente.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < jComboBoxSuite.getItemCount(); i++) {
            Suite s = (Suite) jComboBoxSuite.getItemAt(i);
            if (s.getNome().equals(hospedagem.getSuite()));
            {

                jComboBoxSuite.setSelectedIndex(i);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableHospedagemMouseClicked

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Hospedagem hospedagem = tableModelHospedagem.getHospedagem(jTableHospedagem.getSelectedRow());
        for (int i = 0; i < hospedagemController.read().size(); i++) {
            if (hospedagem.getId_hospedagem() == hospedagemController.read().get(i).getId_hospedagem()) {
                cliente = (Cliente) jComboBoxCliente.getSelectedItem();
                suite = (Suite) jComboBoxSuite.getSelectedItem();

                hospedagemController.update(
                        cliente,
                        suite,
                        jFormattedTextFieldData.getText(),
                        jTextFieldInf_Pagamento.getText(),
                        Integer.parseInt(jFormattedTextFieldCartaoAcesso.getText()),
                        jFormattedTextFieldCheckin.getText(),
                        jFormattedTextFieldCheckout.getText(),
                        hospedagem.getId_hospedagem());
            }
            this.limpaCampos();
        }

        this.getHospedagem();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        Hospedagem hospedagem = tableModelHospedagem.getHospedagem(jTableHospedagem.getSelectedRow());
        for (int i = 0; i < hospedagemController.read().size(); i++) {
            if (hospedagem.getId_hospedagem() == hospedagemController.read().get(i).getId_hospedagem()) {
                hospedagemController.delete(hospedagem);
            }
        }
        this.getHospedagem();
        this.limpaCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.limpaCampos();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicosActionPerformed
        RegistroServicoView registroServicoView = new RegistroServicoView();
        hospedagem = tableModelHospedagem.getHospedagem(jTableHospedagem.getSelectedRow());
        registroServicoView.idHospedagem = hospedagem.getId_hospedagem();
        registroServicoView.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonServicosActionPerformed

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
            java.util.logging.Logger.getLogger(HospedagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospedagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospedagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospedagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HospedagemView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonServicos;
    private javax.swing.JComboBox<Object> jComboBoxCliente;
    private javax.swing.JComboBox<Object> jComboBoxSuite;
    private javax.swing.JFormattedTextField jFormattedTextFieldCartaoAcesso;
    private javax.swing.JFormattedTextField jFormattedTextFieldCheckin;
    private javax.swing.JFormattedTextField jFormattedTextFieldCheckout;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelData;
    protected javax.swing.JLabel jLabelFuncionario;
    private javax.swing.JLabel jLabelPagamento;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHospedagem;
    private javax.swing.JTextField jTextFieldInf_Pagamento;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
