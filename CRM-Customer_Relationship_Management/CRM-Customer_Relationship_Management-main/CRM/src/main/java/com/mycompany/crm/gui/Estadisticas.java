/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.crm.gui;

import com.mycompany.crm.entity.*;
import com.mycompany.crm.exceptions.ComandaException;
import com.mycompany.crm.validator.Validations;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author admin
 */
public class Estadisticas extends javax.swing.JPanel {

    private DefaultTableModel model ;
    private Map<String,RankingTO> lista;
    private JFreeChart chart;
    private JFreeChart chart2;
    private Timer timer;
    private double rotationAngle = 0.0;
    
    public Estadisticas() {
        initComponents();
        model = (DefaultTableModel) tabla.getModel();
        loadData(loadEstadisticasComercial());
        
        
    }
    public Map<String,RankingTO> loadEstadisticasComercial(){
        Map<String, RankingTO> listaComerciales = new LinkedHashMap();
        try {
            listaComerciales = Validations.getInstance().ranking();
            
        } catch (ComandaException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex ,"ERROR",javax.swing.JOptionPane.ERROR_MESSAGE);

        }
        lista = listaComerciales;
        return listaComerciales;
    }
    public void loadData(Map<String,RankingTO> listas){
        int n = 1;
        int visitas = 0;
        int llamada = 0;
        int email = 0;
        for (RankingTO e: listas.values()) {
            model.addRow(new Object[]{n,""+e.getComercial().getDni(), e.getComercial().getNombre(),e.getAccionVisita(), e.getAccionLlamada(),e.getAccionEmail(),e.getAccionesTotales()});
            visitas += e.getAccionVisita();
            llamada += e.getAccionLlamada();
            email += e.getAccionEmail();
//            loadGraphicComercial(e);
            n++;
        }
        RankingTO r = new RankingTO(llamada,email,visitas);
        loadGraphicGeneral(r);
    }
    
     public void loadGraphicComercial(RankingTO t){
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Visitas", t.getAccionVisita());
        datos.setValue("Llamadas", t.getAccionLlamada());
        datos.setValue("Email", t.getAccionEmail());
        
        JFreeChart graphic = ChartFactory.createRingChart(
        "Estadisticas de acciones de "+t.getComercial().getNombre(),
         datos,
         true,
         true,
         false
        );
        this.chart = graphic;
        
        graphic.setBackgroundPaint(Color.WHITE);
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(300,250));
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
         
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(panel,BorderLayout.NORTH);
        
       
        
        
        jPanel2.removeAll(); 
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(panel, BorderLayout.NORTH);
        jPanel2.revalidate(); 
        jPanel2.repaint();
        
         girar(plot);
//        plot.setStartAngle(rotationAngle);
    }
     public void loadGraphicGeneral(RankingTO t){
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Visitas", t.getAccionVisita());
        datos.setValue("Llamadas", t.getAccionLlamada());
        datos.setValue("Email", t.getAccionEmail());
        
        JFreeChart graphic = ChartFactory.createPieChart(
        "Estadisticas de acciones Globales",
         datos,
         true,
         true,
         false
        );
        this.chart2 = graphic;
        
        graphic.setBackgroundPaint(Color.WHITE);
        
        ChartPanel panel = new ChartPanel(chart2);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(300,250));
        
        PiePlot plot = (PiePlot) chart2.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        
//        RingPlot plot = (RingPlot) chart2.getPlot();
//        plot.setBackgroundPaint(Color.WHITE);
         
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel,BorderLayout.NORTH);
        
        
        jPanel1.removeAll(); 
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel, BorderLayout.NORTH);
        jPanel1.revalidate(); 
        jPanel1.repaint();  
        
         girar(plot);
        
    }
     public void girar(PiePlot p ){
         if (timer!=null) {
             timer.stop();
         }
         timer = new Timer (100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               rotationAngle += 2.5;
               p.setStartAngle(rotationAngle);
                if (chart2!=null) {
                    PiePlot plot2 = (PiePlot) chart2.getPlot();
                    plot2.setStartAngle(rotationAngle);
                }
               
            }
         });
         timer.start();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Estadisticas");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puesto", "DNI", "Nombre", "Visitas", "Llamadas", "Email", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 250));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 250));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 250));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(287, 287, 287))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int linea = tabla.getSelectedRow();
        if (linea!=-1) {
            String dni = (String)model.getValueAt(linea, 1);
            RankingTO e = lista.get(dni);
            if (e!=null) {
                loadGraphicComercial(e);
                chart.fireChartChanged();

            }
            
            
            
        }
    }//GEN-LAST:event_tablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
