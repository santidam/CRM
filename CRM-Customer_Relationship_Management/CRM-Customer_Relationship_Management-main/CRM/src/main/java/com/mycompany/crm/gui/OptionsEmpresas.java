/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.crm.gui;

import com.mycompany.crm.entity.Empresa;
import com.mycompany.crm.exceptions.ComandaException;
import com.mycompany.crm.validator.Validations;
import java.awt.Dialog;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class OptionsEmpresas extends javax.swing.JPanel {

    private DefaultTableModel model ;
    private Map<String,Empresa> lista;
    
    public OptionsEmpresas() {
        initComponents();
        model = (DefaultTableModel) tabla.getModel();
        loadData(loadListaEmpresas());
        
        
    }
    public Map<String,Empresa> loadListaEmpresas(){
        Map<String,Empresa> listaEmpresas = new LinkedHashMap<>();
        try {
            listaEmpresas = Validations.getInstance().valClientesList();
           
            
        } catch (ComandaException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex ,"ERROR",javax.swing.JOptionPane.ERROR_MESSAGE);

        }
        lista = listaEmpresas;
        return listaEmpresas;
    }
    public void loadData(Map<String,Empresa> listas){
        for (Empresa e: listas.values()) {
                model.addRow(new Object[]{e.getCodigo(),e.getNombre(), e.getRepresentante(),e.getPhoneNumber(), e.getEmail()});
        }
    }
    public void addData(){
        model.addRow(new Object[]{codigo.getText(),empresa.getText(),contacto.getText(),telefono.getText(),email.getText()});
    }
    public void eliminar(){
        int fila = tabla.getSelectedRow();
        if (fila!=-1) {
            model.removeRow(fila);
        }
    }
    public void update(){
        int fila = tabla.getSelectedRow();
        if (fila!=-1) {
            model.setValueAt(codigo.getText(), fila, 0);
            model.setValueAt(empresa.getText(), fila, 1);
            model.setValueAt(contacto.getText(), fila, 2);
            model.setValueAt(telefono.getText(), fila, 3);
            model.setValueAt(email.getText(), fila, 4);
        }
        
        
    }
    public void clear(){
        int filas = model.getRowCount();
        for (int i = 0; i < filas; i++) {
            model.removeRow(0);
        }
    }
    public void cambiarDialog(Dialog a){
        a.setSize(650, 473);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }
    public void clearText(){
        codigo.setText("");
        empresa.setText("");
        contacto.setText("");
        email.setText("");
        telefono.setText("");
        direccion.setText("");
        cp.setText("");
        ciudad.setText("");
        comunidad.setText("");
        web.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        empresa = new javax.swing.JTextField();
        contacto = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        cp = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comunidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        web = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        agregar1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(630, 460));

        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Empresas");

        jLabel2.setText("Código");

        jLabel3.setText("Empresa *");

        jLabel4.setText("Contacto*");

        jLabel5.setText("Email*");

        jLabel6.setText("Dirección*");

        jLabel7.setText("Télefono *");

        jLabel8.setText("CP*");

        jLabel9.setText("Ciudad*");

        codigo.setEditable(false);
        codigo.setEnabled(false);

        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });

        jLabel10.setText("Comunidad*");

        jLabel11.setText("WEB");

        agregar.setText("AGREGAR");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Empresa", "Contacto", "Telefono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        agregar1.setText("BUSCAR");
        agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(contacto)
                                    .addComponent(cp)
                                    .addComponent(comunidad)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42)
                                .addComponent(codigo)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(188, 188, 188)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregar)
                                .addGap(27, 27, 27)
                                .addComponent(agregar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modificar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpiar))
                    .addComponent(web, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(ciudad)
                    .addComponent(direccion)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(empresa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(eliminar)
                    .addComponent(limpiar)
                    .addComponent(agregar)
                    .addComponent(agregar1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        try {
            Validations.getInstance().valBajaEmpresa(telefono.getText());
            clear();
            loadData(loadListaEmpresas());
            clearText();
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente dado de baja correctamente","Baja Cliente",javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (ComandaException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex,"ERROR",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
//        clear();
        clearText();
    }//GEN-LAST:event_limpiarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed


            if (empresa.getText().isEmpty() || contacto.getText().isEmpty() || email.getText().isEmpty() || telefono.getText().isEmpty() || direccion.getText().isEmpty() || cp.getText().isEmpty() || ciudad.getText().isEmpty() || comunidad.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "ERROR: TODOS LOS CAMPOS OBLIGATORIOS DEBEN ESTAR COMPLETOS (*)", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);

            } else {
                try {
                    Validations.getInstance().valAltaCliente(empresa.getText(), email.getText(), telefono.getText(), contacto.getText(), direccion.getText(), cp.getText(), ciudad.getText(), comunidad.getText(), web.getText());
                    clear();
                    loadData(loadListaEmpresas());
                    clearText();
                    javax.swing.JOptionPane.showMessageDialog(this, "Cliente registrado correctamente", "Alta Cliente", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                } catch (ComandaException ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, ex, "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        
    }//GEN-LAST:event_agregarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed


            if (this.empresa.getText().isEmpty() || contacto.getText().isEmpty() || email.getText().isEmpty() || telefono.getText().isEmpty() || direccion.getText().isEmpty() || cp.getText().isEmpty() || ciudad.getText().isEmpty() || comunidad.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "ERROR: TODOS LOS CAMPOS OBLIGATORIOS DEBEN ESTAR COMPLETOS (*)","ERROR",javax.swing.JOptionPane.ERROR_MESSAGE);

            }else{
                try{
                    Validations.getInstance().valModificarEmpresa(email.getText(), contacto.getText(), direccion.getText(), cp.getText(), ciudad.getText(), comunidad.getText(), web.getText(), codigo.getText());
                    clear();
                    loadData(loadListaEmpresas());
                    javax.swing.JOptionPane.showMessageDialog(this, "Cliente modificado correctamente","Modificar Cliente",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    clearText();
                }catch(ComandaException e){
                    javax.swing.JOptionPane.showMessageDialog(this, e, "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                }

        }

        

    }//GEN-LAST:event_modificarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int linea = tabla.getSelectedRow();
        if (linea!=-1) {
            String codigo = (String)model.getValueAt(linea, 0);
            Empresa e = lista.get(codigo);
            if (e!=null) {
                this.codigo.setText(e.getCodigo());
                this.empresa.setText(e.getNombre());
                this.contacto.setText(e.getRepresentante());
                this.email.setText(e.getEmail());
                this.telefono.setText(e.getPhoneNumber());
                this.direccion.setText(e.getDireccion());
                this.cp.setText(""+e.getCp());
                this.ciudad.setText(e.getCiudad());
                this.comunidad.setText(e.getComunidad_autonoma());
                this.web.setText(e.getPagina_web());
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar1ActionPerformed
      try {
            Map<String,Empresa> newlist =  Validations.getInstance().valBusquedaEmpresa(telefono.getText(),empresa.getText(), email.getText(),contacto.getText(), direccion.getText(), cp.getText(), ciudad.getText(), comunidad.getText(), web.getText());
            clear();
            loadData(newlist);
            clearText();
            javax.swing.JOptionPane.showMessageDialog(this, "Buscando clientes","Clientes",javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (ComandaException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex,"ERROR",javax.swing.JOptionPane.ERROR_MESSAGE);

        }  
    }//GEN-LAST:event_agregar1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton agregar1;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField comunidad;
    private javax.swing.JTextField contacto;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField email;
    private javax.swing.JTextField empresa;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField web;
    // End of variables declaration//GEN-END:variables
}

