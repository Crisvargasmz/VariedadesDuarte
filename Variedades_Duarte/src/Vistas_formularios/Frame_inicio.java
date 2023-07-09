package Vistas_formularios;

import Controlador.CRUD_Venta;
import Controlador.Conexion;
import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Windows 10
 */
public final class Frame_inicio extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    Connection cn = (Connection) con.conectar();

    CRUD_Venta cv = new CRUD_Venta();

    /**
     * Creates new form Frame_inicio
     */
    public Frame_inicio() {
        initComponents();
        mostrarventasdia();
        int sumaVentas = cv.obtenerSumaVentasPorDia();
        double sumaTotales = cv.ObtenerTotalProductosPorDia();
        lbTotalVentas.setText(String.valueOf(sumaVentas));
        lbTotalGanancias.setText("C$ " + String.valueOf(sumaTotales));
    }

    public void mostrarventasdia() {
        try {
            DefaultTableModel modelo;
            CRUD_Venta vt = new CRUD_Venta(); //objeto de la clase CRUD_Producto
            modelo = vt.mostrarventadia();
            tablaventasdia.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnReporteClientes = new javax.swing.JButton();
        btnReporteProveedores = new javax.swing.JButton();
        btnReporteProductos = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventasdia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbTotalVentas = new javax.swing.JLabel();
        lbTotalGanancias = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnReporteVentas = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)), "Reportes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Verdana", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setOpaque(false);

        btnReporteClientes.setBackground(new java.awt.Color(4, 64, 98));
        btnReporteClientes.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnReporteClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteClientes.setText("Clientes");
        btnReporteClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReporteClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteClientesMouseClicked(evt);
            }
        });

        btnReporteProveedores.setBackground(new java.awt.Color(4, 64, 98));
        btnReporteProveedores.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnReporteProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteProveedores.setText("Proveedores");
        btnReporteProveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReporteProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteProveedoresMouseClicked(evt);
            }
        });
        btnReporteProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteProveedoresActionPerformed(evt);
            }
        });

        btnReporteProductos.setBackground(new java.awt.Color(4, 64, 98));
        btnReporteProductos.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnReporteProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteProductos.setText("Productos");
        btnReporteProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReporteProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteProductosMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("© 2023 Variedades Duarte");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReporteProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReporteClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReporteProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(101, 101, 101))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnReporteClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)), "Bienvenido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Verdana", 0, 36), new java.awt.Color(51, 51, 51))); // NOI18N

        tablaventasdia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaventasdia);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Total ventas :");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Total Ganancias :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbTotalVentas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTotalVentas.setForeground(new java.awt.Color(51, 51, 51));
        lbTotalVentas.setText("0");

        lbTotalGanancias.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTotalGanancias.setForeground(new java.awt.Color(51, 51, 51));
        lbTotalGanancias.setText("0.0");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("Ventas Realizadas en el dia");

        btnReporteVentas.setBackground(new java.awt.Color(4, 64, 98));
        btnReporteVentas.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnReporteVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteVentas.setText("Ventas realizadas por semana");
        btnReporteVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteVentasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(53, 53, 53)
                                .addComponent(lbTotalVentas)
                                .addGap(66, 66, 66)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel2)
                                .addGap(59, 59, 59)
                                .addComponent(lbTotalGanancias))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(jLabel5))
                            .addComponent(btnReporteVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalVentas)
                    .addComponent(lbTotalGanancias))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteProveedoresActionPerformed

    private void btnReporteClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteClientesMouseClicked
        // Generar reporte de los clientes.
        String path = "/src/Vistas_reportes/reporteClientes.jrxml";
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath() + path);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jr, null, this.cn);
            JasperViewer view = new JasperViewer(mostrarReporte,false);
            view.setTitle("Reporte Clientes");
            view.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnReporteClientesMouseClicked

    private void btnReporteProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteProveedoresMouseClicked
        // Generar reporte de los proveedores.
        String path = "/src/Vistas_reportes/reporteProveedores.jrxml";
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath() + path);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jr, null, cn);
            JasperViewer view = new JasperViewer(mostrarReporte,false);
            view.setTitle("Reporte Proveedores");
            view.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnReporteProveedoresMouseClicked

    private void btnReporteProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteProductosMouseClicked
        // Generar reporte de los productos.
        String path = "/src/Vistas_reportes/reporteProductos.jrxml";
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath() + path);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jr, null, cn);
            JasperViewer view = new JasperViewer(mostrarReporte,false);
            view.setTitle("Reporte Productos");
            view.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnReporteProductosMouseClicked

    private void btnReporteVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteVentasMouseClicked
        // TODO add your handling code here:
        // Generar reporte de los clientes.
        String path = "/src/Vistas_reportes/reporteVentaSemanal.jrxml";
        JasperReport jr;
        try {
            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath() + path);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(jr, null, this.cn);
            JasperViewer view = new JasperViewer(mostrarReporte,false);
            view.setTitle("Reporte Clientes");
            view.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnReporteVentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporteClientes;
    private javax.swing.JButton btnReporteProductos;
    private javax.swing.JButton btnReporteProveedores;
    private javax.swing.JButton btnReporteVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbTotalGanancias;
    private javax.swing.JLabel lbTotalVentas;
    private javax.swing.JTable tablaventasdia;
    // End of variables declaration//GEN-END:variables
}
