/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas_formularios;

import Controlador.CRUD_Detalle_venta;
import Controlador.CRUD_Venta;
import Controlador.Conexion;
import Modelo.Detalle_venta;
import Modelo.ValidarCampos;
import Modelo.Venta;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Frame_venta extends javax.swing.JInternalFrame {

    ValidarCampos validar = new ValidarCampos();
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    CRUD_Venta func = new CRUD_Venta();
    DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form Frame_venta
     */
    public Frame_venta() {
        initComponents();
        txtFecha_venta.setVisible(false);
        txtHora_venta.setVisible(false);
        txtIDVenta.setVisible(false);
        mostrar();
        lbExito.setVisible(false);
        lbIconoVerificado.setVisible(false);
        separador.setVisible(false);
    }

    void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Venta func = new CRUD_Venta();
            modelo = func.mostrar();
            listarProductos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);

        }
    }

    public void guardarVenta() {
        //Ensertar Venta
        CRUD_Venta cv = new CRUD_Venta();
        Venta vt = new Venta(
                Date.valueOf(txtFecha_venta.getText()),
                Time.valueOf(txtHora_venta.getText()),
                Integer.parseInt(txtIDCliente.getText()));
        cv.insertarVenta(vt);

        //----------------------
        //Insertar Detalle_venta
        Detalle_venta dts = new Detalle_venta();
        CRUD_Detalle_venta cd = new CRUD_Detalle_venta();
        String IDVenta = cd.IdVentas();
        dts.setIDVenta(Integer.parseInt(IDVenta));
        for (int i = 0; i < listarProductos.getRowCount(); i++) {
            dts.setIDProducto(Integer.parseInt(listarProductos.getValueAt(i, 0).toString()));
            dts.setCantidad_venta(Integer.parseInt(listarProductos.getValueAt(i, 2).toString()));
            cd.insertarDetalle_venta(dts);
        }
    }

    void AgregarProducto() {

        double subtotal, totalpagar;

        modelo = (DefaultTableModel) listarProductos.getModel();

        int cant = Integer.parseInt(txtCantidadProducto.getText());
        double pre = Double.parseDouble(txtPrecioProducto.getText());

        subtotal = cant * pre;
        totalpagar = subtotal;
        ArrayList lista = new ArrayList();
        lista.add(txtIDProducto.getText());
        lista.add(txtProducto.getText());
        lista.add(txtCantidadProducto.getText());
        lista.add(txtPrecioProducto.getText());
        lista.add(subtotal);

        Object[] obj = new Object[5];
        obj[0] = lista.get(0);
        obj[1] = lista.get(1);
        obj[2] = lista.get(2);
        obj[3] = lista.get(3);
        obj[4] = lista.get(4);
        modelo.addRow(obj);
        listarProductos.setModel(modelo);
        calcularTotal();

    }

    void limpiardetalle() {
        txtIDProducto.setText("");
        txtCantidadProducto.setText("");
        txtPrecioProducto.setText("");
        txtProducto.setText("");
        txtCantidadDisponible.setText("");
    }

    void limpiarformulario() {
        txtIDCliente.setText("");
        txtNombreCliente.setText("");
        txtCambio.setText("");
        txtTotal.setText("");
        limpiardetalle();
        limpiartabla();
        limpiarCalculos();
    }

    void limpiarCalculos() {
        txtPagar.setText("");
        txtCambio.setText("");
        txtTotal.setText("");
    }

    void calcularTotal() {
        double subtotal = 0.0;
        double total = 0;

        for (int i = 0; i < listarProductos.getRowCount(); i++) {
            int cantidad = Integer.parseInt(listarProductos.getValueAt(i, 2).toString());
            Double precio = Double.valueOf(listarProductos.getValueAt(i, 3).toString());

            subtotal = subtotal + (cantidad * precio);
            total = subtotal;

        }
        txtTotal.setText(String.valueOf(total));

    }

    void limpiartabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    private void remover() {
        DefaultTableModel compras = (DefaultTableModel) listarProductos.getModel();
        int cantidadActual = 0;
        int item = listarProductos.getSelectedRow();
        if (item >= 0) {
            compras.removeRow(item);
            for (int i = 0; i < listarProductos.getRowCount(); i++) {

                int cantidad = Integer.parseInt(listarProductos.getValueAt(i, 2).toString());
                Double precio = Double.valueOf(listarProductos.getValueAt(i, 3).toString());
                Double subt = Double.valueOf(listarProductos.getValueAt(i, 4).toString());
                double act = Double.parseDouble(txtTotal.getText());
                double actCal = act - subt;
                txtTotal.setText(String.valueOf(actCal));
                calcularTotal();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Ventas", JOptionPane.WARNING_MESSAGE);
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listarProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtProducto = new javax.swing.JTextField();
        btnAgregarVProducto = new javax.swing.JButton();
        txtPrecioProducto = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        txtCantidadDisponible = new javax.swing.JTextField();
        txtIDProducto = new javax.swing.JTextField();
        txtPagar = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAgregarVCliente1 = new javax.swing.JButton();
        txtIDCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtFecha_venta = new javax.swing.JTextField();
        txtHora_venta = new javax.swing.JTextField();
        txtIDVenta = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lbExito = new javax.swing.JLabel();
        lbIconoVerificado = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 64, 98));
        jLabel2.setText("Geston de ventas");

        jSeparator2.setBackground(new java.awt.Color(4, 64, 98));
        jSeparator2.setForeground(new java.awt.Color(4, 64, 98));
        jSeparator2.setOpaque(true);

        jSeparator1.setBackground(new java.awt.Color(4, 64, 98));
        jSeparator1.setForeground(new java.awt.Color(4, 64, 98));
        jSeparator1.setOpaque(true);

        listarProductos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        listarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        listarProductos.setGridColor(new java.awt.Color(0, 204, 204));
        listarProductos.setRowHeight(25);
        listarProductos.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(listarProductos);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(4, 64, 98)), "Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Producto :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        btnAgregarVProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnAgregarVProducto.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btnAgregarVProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarVProducto.setText("+");
        btnAgregarVProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAgregarVProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarVProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVProductoActionPerformed(evt);
            }
        });
        btnAgregarVProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarVProductoKeyPressed(evt);
            }
        });

        txtPrecioProducto.setEditable(false);
        txtPrecioProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Precio :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });
        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        txtCantidadProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCantidadProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Cantidad :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        txtCantidadDisponible.setEditable(false);
        txtCantidadDisponible.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCantidadDisponible.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Stock :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtCantidadDisponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadDisponibleKeyTyped(evt);
            }
        });

        txtIDProducto.setEditable(false);
        txtIDProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIDProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "ID :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtIDProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDProductoKeyTyped(evt);
            }
        });

        txtPagar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtPagar.setForeground(new java.awt.Color(0, 0, 255));
        txtPagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPagar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Pago con :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagarActionPerformed(evt);
            }
        });
        txtPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagarKeyReleased(evt);
            }
        });

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtCambio.setForeground(new java.awt.Color(255, 0, 0));
        txtCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCambio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Cambio :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtCambio.setOpaque(true);
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 153, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Total :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtTotal.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtPrecioProducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCantidadDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarVProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTotal))))
                .addGap(0, 60, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarVProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(4, 64, 98));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(4, 64, 98));
        btnGuardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(4, 64, 98));
        btnImprimir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("Imprimir");
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(4, 64, 98)), "Datos del cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        btnAgregarVCliente1.setBackground(new java.awt.Color(4, 64, 98));
        btnAgregarVCliente1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btnAgregarVCliente1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarVCliente1.setText("+");
        btnAgregarVCliente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAgregarVCliente1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarVCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVCliente1ActionPerformed(evt);
            }
        });
        btnAgregarVCliente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarVCliente1KeyPressed(evt);
            }
        });

        txtIDCliente.setEditable(false);
        txtIDCliente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIDCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "ID :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtIDCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDClienteKeyTyped(evt);
            }
        });

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Cliente :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtNombreCliente.setOpaque(true);
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnAgregarVCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFecha_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtHora_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtIDCliente)
                    .addComponent(txtNombreCliente)
                    .addComponent(btnAgregarVCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnQuitar.setBackground(new java.awt.Color(255, 51, 51));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("-");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 204, 0));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lbExito.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lbExito.setForeground(new java.awt.Color(0, 204, 0));
        lbExito.setText("¡Venta realizada con exito!");

        lbIconoVerificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_iconos/ventaRealizada.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbExito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(separador))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbIconoVerificado))
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnQuitar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIconoVerificado)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbExito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void txtIDProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDProductoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtIDCliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un cliente");
            txtIDCliente.requestFocus();
            return;
        }
        if (txtTotal.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Agrege una venta");
            txtTotal.requestFocus();
            return;
        }
        guardarVenta();
        limpiarformulario();
        lbExito.setVisible(true);
        lbIconoVerificado.setVisible(true);
        separador.setVisible(true);
//        FinalizarVenta dialog = new FinalizarVenta(null, true);
//        Frame_venta fv = new Frame_venta();
//        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        dialog.setResizable(false);
//        dialog.setLocationRelativeTo(fv);
//        dialog.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed

    private void txtPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarActionPerformed

    private void btnAgregarVCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVCliente1ActionPerformed
        // TODO add your handling code here:
        DialogVentaCliente dialog = new DialogVentaCliente(null, true);
        Vista_venta vv = new Vista_venta();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(vv);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAgregarVCliente1ActionPerformed

    private void txtIDClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDClienteKeyTyped

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void txtCantidadDisponibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadDisponibleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadDisponibleKeyTyped

    private void btnAgregarVProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVProductoActionPerformed
        // TODO add your handling code here:
        DialogVentaProducto dialog = new DialogVentaProducto(null, true);
        Vista_venta vv = new Vista_venta();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(vv);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAgregarVProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarformulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un producto");
            return;

        }
        if (txtCantidadProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese una cantidad a la venta");
            return;

        }

        int cant, stock;

        cant = Integer.parseInt(txtCantidadProducto.getText());
        stock = Integer.parseInt(txtCantidadDisponible.getText());

        if (stock >= cant) {
            int cantidadActual = stock - cant;
            AgregarProducto();
            try {
                double paga = Double.parseDouble(txtPagar.getText());
                double totalPagar = paga - Double.parseDouble(txtTotal.getText());
                txtCambio.setText(String.valueOf(totalPagar));
                txtCantidadDisponible.setText(String.valueOf(cantidadActual));
            } catch (NumberFormatException e) {

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay suficinete Stock", "Sistema ventas", JOptionPane.ERROR_MESSAGE);
        }
        limpiardetalle();
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked
        //Genrra comprobante venta
        String idv = func.IdVentas();
        JasperReport report;
        JasperPrint print;
        try {
            Map p = new HashMap();
            p.put("IDVenta", idv);
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/Vistas_reportes/comprobanteVenta.jrxml");
            print = JasperFillManager.fillReport(report, p, this.cn);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Comprobante Venta");
            view.setVisible(true);
            lbExito.setVisible(false);
            lbIconoVerificado.setVisible(false);
            separador.setVisible(false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImprimirMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed


    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        remover();
        try {

            double paga = Double.parseDouble(txtPagar.getText());
            double totalPagar = paga - Double.parseDouble(txtTotal.getText());
            txtCambio.setText(String.valueOf(totalPagar));
            if (listarProductos.getRowCount() == 0) {
                limpiarCalculos();
            }

        } catch (NumberFormatException e) {
        }

    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtPagarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagarKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPagar.getText().length() == 0) {
                txtCambio.setText("");
            } else {
                double paga = Double.parseDouble(txtPagar.getText());
                double totalPagar = paga - Double.parseDouble(txtTotal.getText());
                txtCambio.setText(String.valueOf(totalPagar));
            }
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txtPagarKeyReleased

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void btnAgregarVProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarVProductoKeyPressed
        // TODO add your handling code here:
        lbExito.setVisible(false);
        lbIconoVerificado.setVisible(false);
        separador.setVisible(false);
    }//GEN-LAST:event_btnAgregarVProductoKeyPressed

    private void btnAgregarVCliente1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarVCliente1KeyPressed
        // TODO add your handling code here:
        lbExito.setVisible(false);
        lbIconoVerificado.setVisible(false);
        separador.setVisible(false);
    }//GEN-LAST:event_btnAgregarVCliente1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarVCliente1;
    private javax.swing.JButton btnAgregarVProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbExito;
    private javax.swing.JLabel lbIconoVerificado;
    private javax.swing.JTable listarProductos;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtCambio;
    public static javax.swing.JTextField txtCantidadDisponible;
    public static javax.swing.JTextField txtCantidadProducto;
    public static javax.swing.JTextField txtFecha_venta;
    public static javax.swing.JTextField txtHora_venta;
    public static javax.swing.JTextField txtIDCliente;
    public static javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtIDVenta;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPagar;
    public static javax.swing.JTextField txtPrecioProducto;
    public static javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
