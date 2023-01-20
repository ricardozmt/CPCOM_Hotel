package view;

import connection.ConnectionFactory;
import controller.SuiteController;
import controller.TipoSuiteController;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.bean.Suite;
import javax.swing.table.DefaultTableModel;
import model.bean.Funcionario;
import model.bean.Tipo_Suite;
import model.dao.SuiteDAO;
import model.dao.TipoSuiteDAO;
import tableModel.SuiteTableModel;
import model.bean.Suite;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SuiteView extends javax.swing.JFrame {

    public Suite suite;
    private int id_suite;

    SuiteController suiteController = new SuiteController();
    TipoSuiteController tipoSuiteController = new TipoSuiteController();
    SuiteTableModel tableModelSuite;

    public SuiteView() {
        initComponents();
        lerCombo();
        this.getSuite();
        jTable1.setModel(tableModelSuite);
    }

    private void getSuite() {
        tableModelSuite = new SuiteTableModel(suiteController.read());
        jTable1.setModel(tableModelSuite);
    }

    public void limpaCampos() {
        jTextFieldQuarto.setText("");
        jTextFieldValor.setText("");
        jTextFieldQuarto.requestFocus();
    }

    public void lerCombo() {
        ComboSuite.removeAllItems();
        for (Tipo_Suite t : tipoSuiteController.read()) {
            ComboSuite.addItem(t);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ComboSuite = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQuarto = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jRadioButtonDisponivel = new javax.swing.JRadioButton();
        jRadioButtonOcupado = new javax.swing.JRadioButton();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jButtonExcluir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        ComboSuite.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ComboSuiteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ComboSuite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSuiteActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipos de Suite");

        jLabel3.setText("Quarto:");

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/insert.png"))); // NOI18N
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonDisponivel);
        jRadioButtonDisponivel.setText("Disponível");

        buttonGroup1.add(jRadioButtonOcupado);
        jRadioButtonOcupado.setText("Ocupado");

        jLabelValor.setText("Valor:");

        jButtonExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        jButtonExcluir1.setText("Imprimir");
        jButtonExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(ComboSuite, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelValor)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jRadioButtonDisponivel)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonOcupado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAtualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcluir1)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboSuite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonDisponivel)
                    .addComponent(jRadioButtonOcupado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValor))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonExcluir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            jTextFieldQuarto.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));

            for (int i = 0; i < ComboSuite.getItemCount(); i++) {
                Tipo_Suite s = (Tipo_Suite) ComboSuite.getItemAt(i);
                if (s.getDescricao().equals(jTable1.getValueAt(jTable1.getSelectedRow(), 0))) {
                    ComboSuite.setSelectedIndex(i);
                }
            }

            jTextFieldValor.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2)));
            if (jTable1.getValueAt(jTable1.getSelectedRow(), 3).equals(true)) {
                jRadioButtonDisponivel.setSelected(true);
            } else {
                jRadioButtonOcupado.setSelected(true);
            }

        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void ComboSuiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSuiteActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_ComboSuiteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.lerCombo();
        this.getSuite();

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        boolean radio;
        if (jRadioButtonDisponivel.isSelected()) {
            radio = true;
        } else {
            radio = false;
        }

        if (ComboSuite.getSelectedItem() != null
                && !jTextFieldQuarto.getText().equals("")
                && !ComboSuite.getSelectedItem().equals("")
                && !jTextFieldValor.getText().equals("")
                && jRadioButtonDisponivel.isSelected()) {

            Tipo_Suite tips = (Tipo_Suite) ComboSuite.getSelectedItem();

            if (suiteController.create(jTextFieldQuarto.getText(), Double.parseDouble(jTextFieldValor.getText()), jRadioButtonDisponivel.isSelected(), tips)) {
                JOptionPane.showMessageDialog(this, "Suite salva com sucesso!");
                jTextFieldQuarto.setText("");
                jTextFieldValor.setText("");
                ComboSuite.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "nao foi possivel salvar a suite! VIEW", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            this.limpaCampos();
            this.getSuite();
        }

    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void ComboSuiteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ComboSuiteAncestorAdded

    }//GEN-LAST:event_ComboSuiteAncestorAdded

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        boolean radio;
        if (jRadioButtonDisponivel.isSelected()) {
            radio = true;
        } else {
            radio = false;
        }

        if (ComboSuite.getSelectedItem() != null
                && !jTextFieldQuarto.getText().equals("")
                && !ComboSuite.getSelectedItem().equals("")
                && !jTextFieldValor.getText().equals("")
                && jRadioButtonDisponivel.isSelected()) {

            Tipo_Suite tips = (Tipo_Suite) ComboSuite.getSelectedItem();
            suite = tableModelSuite.getSuite(jTable1.getSelectedRow());

            if (suiteController.update(suite.getId_suite(), jTextFieldQuarto.getText(), Double.parseDouble(jTextFieldValor.getText()), jRadioButtonDisponivel.isSelected(), tips)) {
                JOptionPane.showMessageDialog(this, "Suite salva com sucesso!");
                this.limpaCampos();
                this.getSuite();

            } else {
                JOptionPane.showMessageDialog(this, "nao foi possivel salvar a suite! VIEW", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        suite = tableModelSuite.getSuite(jTable1.getSelectedRow());
        if (suiteController.delete(suite.getId_suite())) {
            JOptionPane.showMessageDialog(this, "Cliente deletado com sucesso");
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possivel deletar a suite",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        this.getSuite();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     

// TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jButtonExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluir1ActionPerformed
 Connection con = ConnectionFactory.getConnection();

        String src = "src/reports/ListaSu.jasper";

        JasperPrint jasperPrint = null;
        Map parameters = new HashMap();

        for (int i = 0; i < suiteController.read().size(); i++) {
            parameters.put("id_suite", suiteController.read().get(i).getId_suite());
        }

        try {
            jasperPrint = JasperFillManager.fillReport(src, parameters, con);
        } catch (JRException ex) {
            System.out.println("Erro ao gerar relatórios: " + ex);
        }

        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluir1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuiteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuiteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuiteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuiteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuiteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> ComboSuite;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluir1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JRadioButton jRadioButtonDisponivel;
    private javax.swing.JRadioButton jRadioButtonOcupado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldQuarto;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
