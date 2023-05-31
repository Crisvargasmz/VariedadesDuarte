/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas_formularios;

import Controlador.CRUD_Categoria;
import Controlador.CRUD_Cliente;
import Controlador.CRUD_Presentacion;
import Controlador.CRUD_Producto;
import Vistas_menu.Controlador_Principal;
import Modelo.Categoria;
import Modelo.Producto;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10
 */
public class Vista_producto extends javax.swing.JPanel {

    int datoSeleccionado = -1;

    /**
     * Creates new form Vista_categoria
     */
    public Vista_producto() {
        initComponents();
        Mostrar();
        llenarcombobox();//se va rellenar con combobox
        //en el formulario cuando inicie este
        llenarcombobox2();

        txtIDProducto.setVisible(false);

    }

    public void llenarcombobox() {
        CRUD_Categoria cate = new CRUD_Categoria();
        comboCategoria.setModel(cate.Llenar());//Llenamos el combobox

    }
    
       public void llenarcombobox2() {
        CRUD_Presentacion cate = new CRUD_Presentacion();
        comboPresentacion.setModel(cate.Llenar());//Llenamos el combobox

    }
       
      
//         public void mostrar() { //Método mostrar
//        try {
//           DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
//            CRUD_Cliente cli = new CRUD_Cliente(); //objeto de la clase CRUDCliente
//            modelo = cli.mostrarDatos();
//            combocategoria.setModel(modelo);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//    }
    //Metodo paa guardar un producto.
    public void GuardarProducto() {
        //Aqui no entiendo lo del combo cris. Seleccion y eso xD
        CRUD_Producto cp = new CRUD_Producto();
        Object categoriaSeleccionada = comboCategoria.getSelectedItem();
        char categoriaChar;

        if (categoriaSeleccionada!= null && categoriaSeleccionada.toString().length() == 1) {
            categoriaChar = categoriaSeleccionada.toString().charAt(0);
        } else {
            /* Manejo de caso cuando el valor seleccionado no es válido
                por ejemplo, si está vacío o tiene más de un carácter */
            categoriaChar = ' '; // Asignar un espacio en blanco como valor predeterminado
            //O mostrar un mensaje de error
            System.out.println("Error: la categoria seleccionada no es válida.");
        }

        Producto p1;
        p1 = new Producto(
                Integer.parseInt(txtIDProducto.getText()),
                txtNombreProducto.getText(),
                txtCantidad.getText(),
                txtPrecioCompra.getText(),
                txtPrecioVenta.getText(),
                txtDescripcion.getText(),
                txtFechaVencimiento.getText(),
                Integer.parseInt(comboCategoria.getSelectedItem().toString()));

        cp.insertarProducto(p1);
    }

    //Metodo para limpiar campos
    public void LimpiarCampos() {
        txtIDProducto.setText("");
        txtNombreProducto.setText("");
        txtCantidad.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        comboCategoria.setSelectedItem("Categoria");
        comboPresentacion.setSelectedItem("Unidad de medida");
        txtDescripcion.setText("");
        txtFechaVencimiento.setText("");
    }

    //Metodo para editar un producto.
    public void EditarProducto() {

        CRUD_Producto cp = new CRUD_Producto();
        Object generoSeleccionado = comboCategoria.getSelectedItem();
        char categoriaChar;

        if (generoSeleccionado != null && generoSeleccionado.toString().length() == 1) {
            categoriaChar = generoSeleccionado.toString().charAt(0);
        } else {
            // Manejo de caso cuando el valor seleccionado no es válido
            // por ejemplo, si está vacío o tiene más de un carácter
            categoriaChar = ' '; // Asignar un espacio en blanco como valor predeterminado
            // O mostrar un mensaje de error
            System.out.println("Error: el género seleccionado no es válido.");
        }

        Producto p1 = new Producto(Integer.parseInt(txtIDProducto.getText()),
                txtNombreProducto.getText(),
                txtCantidad.getText(),
                txtPrecioCompra.getText(),
                txtPrecioVenta.getText(),
                txtDescripcion.getText(),
                txtFechaVencimiento.getText(),
                Integer.parseInt(comboCategoria.getSelectedItem().toString()));

        cp.ActualizarProducto(p1);

    }

    public void Mostrar() { //Método mostrar
        try {
            DefaultTableModel modelo;
            CRUD_Producto producto = new CRUD_Producto(); //objeto de la clase CRUDCliente
            modelo = producto.mostrarDatos();
            tablaProducto.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Metodo para tipar solo letras.
    private void KeyTipedTXT(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á'
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á'
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ü'
                && car != 'ü'
                && car != 'Ñ'
                && car != 'ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
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

        jSeparator2 = new javax.swing.JSeparator();
        txtNombreProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        jSplitPane3 = new javax.swing.JSplitPane();
        btnLimpiarCamposProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarCate = new javax.swing.JButton();
        comboCategoria = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtMedidaNumerica = new javax.swing.JTextField();
        comboPresentacion = new javax.swing.JComboBox<>();
        txtxBuscarProducto = new javax.swing.JTextField();
        txtIDProducto = new javax.swing.JTextField();
        txtPresentacion = new javax.swing.JTextField();
        txtFechaVencimiento = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1280, 580));
        setMinimumSize(new java.awt.Dimension(1280, 580));
        setPreferredSize(new java.awt.Dimension(1280, 580));

        jSeparator2.setBackground(new java.awt.Color(0, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(0, 204, 204));
        jSeparator2.setOpaque(true);

        txtNombreProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        txtCantidad.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Cantidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        txtPrecioCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Precio compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });

        txtPrecioVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Precio venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        tablaProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Cantidad", "Precio compra", "Precio venta", "Descripcion", "Fecha vencimiento"
            }
        ));
        tablaProducto.setGridColor(new java.awt.Color(0, 204, 204));
        tablaProducto.setRowHeight(25);
        tablaProducto.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tablaProducto);

        jSplitPane1.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane1.setOpaque(false);

        jSplitPane2.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane2.setOpaque(false);

        btnAgregarProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnAgregarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jSplitPane2.setRightComponent(btnAgregarProducto);

        btnEditarProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnEditarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEditarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setText("  Editar  ");
        jSplitPane2.setLeftComponent(btnEditarProducto);

        jSplitPane1.setRightComponent(jSplitPane2);

        btnActualizarProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnActualizarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnActualizarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProducto.setText("Actualizar");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(btnActualizarProducto);

        jSplitPane3.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane3.setOpaque(false);

        btnLimpiarCamposProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnLimpiarCamposProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiarCamposProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCamposProducto.setText("Limpiar");
        jSplitPane3.setRightComponent(btnLimpiarCamposProducto);

        btnEliminarProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnEliminarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Elimnar");
        jSplitPane3.setLeftComponent(btnEliminarProducto);

        btnAgregarCate.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnAgregarCate.setText("+");
        btnAgregarCate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarCate.setMaximumSize(new java.awt.Dimension(40, 40));
        btnAgregarCate.setMinimumSize(new java.awt.Dimension(40, 40));
        btnAgregarCate.setOpaque(true);
        btnAgregarCate.setPreferredSize(new java.awt.Dimension(45, 40));
        btnAgregarCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarCateMouseClicked(evt);
            }
        });
        btnAgregarCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCateActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarCate);

        comboCategoria.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboCategoria.setPreferredSize(new java.awt.Dimension(250, 40));
        comboCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboCategoriaMouseEntered(evt);
            }
        });
        jPanel2.add(comboCategoria);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMedidaNumerica.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtMedidaNumerica.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMedidaNumerica.setPreferredSize(new java.awt.Dimension(80, 40));
        jPanel1.add(txtMedidaNumerica);

        comboPresentacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboPresentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(4, 64, 98))));
        comboPresentacion.setMinimumSize(new java.awt.Dimension(200, 40));
        comboPresentacion.setPreferredSize(new java.awt.Dimension(190, 40));
        jPanel1.add(comboPresentacion);

        txtxBuscarProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtxBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        txtFechaVencimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Fecha vencimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        try {
            txtFechaVencimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaVencimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombreProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDescripcion)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtxBuscarProducto)
                                .addGap(18, 18, 18)
                                .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSplitPane3)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtxBuscarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed

    private void btnAgregarCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCateActionPerformed

        DialogCategoria dialog = new DialogCategoria(null, true);
        Vista_producto vv = new Vista_producto();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(vv);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAgregarCateActionPerformed

    private void btnAgregarCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCateMouseClicked


    }//GEN-LAST:event_btnAgregarCateMouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        CRUD_Producto cp = new CRUD_Producto();
        try {
            if (txtNombreProducto.getText().equals("")
                    || txtCantidad.getText().equals("")
                    || txtPrecioCompra.getText().equals("")
                    || txtPrecioVenta.getText().equals("")
                    || txtDescripcion.getText().equals("")
                    || txtFechaVencimiento.getText().equals("")
                    || comboCategoria.getSelectedItem().toString().equals("")
                    || comboPresentacion.getSelectedItem().toString().equals("")) {

                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                GuardarProducto();
                LimpiarCampos();
                Mostrar();
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
   LimpiarCampos();
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void comboCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMouseEntered
        // TODO add your handling code here:
        llenarcombobox();
    }//GEN-LAST:event_comboCategoriaMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarProducto;
    public static javax.swing.JButton btnAgregarCate;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnLimpiarCamposProducto;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboPresentacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtFechaVencimiento;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtMedidaNumerica;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtxBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
