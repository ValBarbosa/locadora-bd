/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Consultar;

import DAO.CategoriaDAO;
import DAO.ClassificacaoDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.FilmeDAO;
import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.Filme;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarFilme extends javax.swing.JFrame {

    public ConsultarFilme() {
        initComponents();
        AtualizaTable();
        setResizable(false);
         setResizable(false);
        setSize(1000,500);
          setLocationRelativeTo(this);
      
    }

   
    private  void AtualizaTable(){
    Connection con = Conexao.AbrirConexao();
    FilmeDAO bd = new FilmeDAO(con);
     
        List<Filme> lista = new ArrayList<>();
        lista = bd.ListarFilme();
        DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();
        
    
    while(tbm.getRowCount() > 0){
    tbm.removeRow(0);
    }
    int i = 0;
    for(Filme tab : lista){
    tbm.addRow(new String[i]);
   tabela.setValueAt(tab.getCodigo(), i,0);
    tabela.setValueAt(tab.getTitulo(), i,1);
    tabela.setValueAt(tab.getAno(), i,2);
    tabela.setValueAt(tab.getDuracao(), i,3);
    tabela.setValueAt(tab.getCod_categoria(), i,4);
    tabela.setValueAt(tab.getCod_classificacao(), i,5);
   
    i++;
    }
    Conexao.FecharConexao(con);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton7.setText("RG");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 30, 210, 30);

        jLabel1.setText("Pesquisa por código:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(500, 20, 160, 50);

        jLabel2.setText("Pesquisa por nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 20, 160, 50);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(640, 30, 96, 32);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 30, 40, 29);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(750, 30, 40, 30);

        jButton3.setText("VOLTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(820, 50, 100, 30);

        jButton4.setText("TODOS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(820, 10, 100, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1010, 90);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Filme", "Ano", "Duração", "Categoria", "Classificação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 960, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = jTextField1.getText();
        Connection con = Conexao.AbrirConexao();
        FilmeDAO bd = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        
        lista = bd.Pesquisar_Nome_Filme(nome);
        DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();

        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        // Limpar campos de pesquisa
        jTextField1.setText("");
        jTextField2.setText("");
        int i = 0;
        for(Filme tab : lista){
            tbm.addRow(new String[i]);
           tabela.setValueAt(tab.getCodigo(), i,0);
    tabela.setValueAt(tab.getTitulo(), i,1);
    tabela.setValueAt(tab.getAno(), i,2);
    tabela.setValueAt(tab.getDuracao(), i,3);
    tabela.setValueAt(tab.getCod_categoria(), i,4);
    tabela.setValueAt(tab.getCod_classificacao(), i,5);
            i++;
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String cod = jTextField2.getText();
        Connection con = Conexao.AbrirConexao();
        FilmeDAO bd = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        
        lista = bd.Pesquisar_Cod_Filme(cod);
        DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();

        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        // Limpar campos de pesquisa
        jTextField1.setText("");
        jTextField2.setText("");
        int i = 0;
        for(Filme tab : lista){
            tbm.addRow(new String[i]);
           tabela.setValueAt(tab.getCodigo(), i,0);
    tabela.setValueAt(tab.getTitulo(), i,1);
    tabela.setValueAt(tab.getAno(), i,2);
    tabela.setValueAt(tab.getDuracao(), i,3);
    tabela.setValueAt(tab.getCod_categoria(), i,4);
    tabela.setValueAt(tab.getCod_classificacao(), i,5);
            i++;
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         AtualizaTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       new Menu().setVisible(true);
   dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
