/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n19;

import java.awt.EventQueue;
import java.beans.Beans;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DAW
 */
public class RebutsPannel extends JPanel {
    
    public RebutsPannel() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("n19PU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT r FROM Rebuts r");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        deleteButton1 = new javax.swing.JButton();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        idSociLabel = new javax.swing.JLabel();
        quantitatLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        concepteLabel = new javax.swing.JLabel();
        idSociField = new javax.swing.JTextField();
        quantitatField = new javax.swing.JTextField();
        dataField = new javax.swing.JTextField();
        concepteField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        deleteButton2 = new javax.swing.JButton();
        deleteButton3 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        deleteButton1.setText("Norma19");
        deleteButton1.addActionListener(formListener);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idSoci}"));
        columnBinding.setColumnName("Id Soci");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantitat}"));
        columnBinding.setColumnName("Quantitat");
        columnBinding.setColumnClass(Float.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${concepte}"));
        columnBinding.setColumnName("Concepte");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);

        masterScrollPane.setViewportView(masterTable);

        idSociLabel.setText("Id Soci:");

        quantitatLabel.setText("Quantitat:");

        dataLabel.setText("Data:");

        concepteLabel.setText("Concepte:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idSoci}"), idSociField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), idSociField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantitat}"), quantitatField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), quantitatField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.data}"), dataField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), dataField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.concepte}"), concepteField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), concepteField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Desa");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Refresca");
        refreshButton.addActionListener(formListener);

        newButton.setText("Nou");
        newButton.addActionListener(formListener);

        deleteButton.setText("Elimina");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        deleteButton2.setText("Editar Soci");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton2, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton2.addActionListener(formListener);

        deleteButton3.setText("Norma19");
        deleteButton3.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(deleteButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idSociLabel)
                            .addComponent(quantitatLabel)
                            .addComponent(dataLabel)
                            .addComponent(concepteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idSociField)
                            .addComponent(quantitatField)
                            .addComponent(dataField)
                            .addComponent(concepteField)))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idSociLabel)
                    .addComponent(idSociField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitatLabel)
                    .addComponent(quantitatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(dataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concepteLabel)
                    .addComponent(concepteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(deleteButton2)
                    .addComponent(deleteButton3))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                RebutsPannel.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                RebutsPannel.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                RebutsPannel.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                RebutsPannel.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton2) {
                RebutsPannel.this.deleteButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton3) {
                RebutsPannel.this.deleteButton3ActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton1) {
                RebutsPannel.this.deleteButton1ActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void loadForm(String title, JPanel formulari){
        JFrame f1 = new JFrame(title);
        f1.setSize(471, 500);
        f1.getContentPane().add(formulari);
        f1.setVisible(true);    
    }      

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<n19.Rebuts> toRemove = new ArrayList<n19.Rebuts>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            n19.Rebuts r = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(r);
            entityManager.remove(r);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        n19.Rebuts r = new n19.Rebuts();
        entityManager.persist(r);
        list.add(r);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<n19.Rebuts> merged = new ArrayList<n19.Rebuts>(list.size());
            for (n19.Rebuts r : list) {
                merged.add(entityManager.merge(r));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton2ActionPerformed
        int[] selected = masterTable.getSelectedRows();
        int soci = (int)masterTable.getValueAt(selected[0],0 );
        loadForm("Clients", new ClientsPannel(soci)); 
    }//GEN-LAST:event_deleteButton2ActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void deleteButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton3ActionPerformed
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(int i = 0; i<masterTable.getRowCount(); i++){
            values.add((Integer)masterTable.getValueAt(i,0));
        }        
        try {        
            new norma19(values);
        } catch (SQLException ex) {
            Logger.getLogger(RebutsPannel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RebutsPannel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RebutsPannel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField concepteField;
    private javax.swing.JLabel concepteLabel;
    private javax.swing.JTextField dataField;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JButton deleteButton2;
    private javax.swing.JButton deleteButton3;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField idSociField;
    private javax.swing.JLabel idSociLabel;
    private java.util.List<n19.Rebuts> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField quantitatField;
    private javax.swing.JLabel quantitatLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(RebutsPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RebutsPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RebutsPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RebutsPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new RebutsPannel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
