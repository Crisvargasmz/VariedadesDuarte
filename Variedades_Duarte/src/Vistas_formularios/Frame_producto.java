/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas_formularios;

import Controlador.CRUD_Categoria;
import Controlador.CRUD_Presentacion;
import Controlador.CRUD_Cliente;
import Controlador.CRUD_Producto;
import Controlador.CRUD_Proveedor;
import Modelo.Categoria;
import Modelo.Desplazar_txtFields;
import Modelo.Presentacion;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.ValidarCampos;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Windows 10
 */
public class Frame_producto extends javax.swing.JInternalFrame {

    private ValidarCampos validar = new ValidarCampos();
    private Desplazar_txtFields des = new Desplazar_txtFields();
    int datoSeleccionado = -1;
    /**
     * Creates new form Frame_producto
     */
    public Frame_producto() {
        initComponents();
        Mostrar();
       llenarCategoria();
       llenarProveedor();
//        llenarcomboboxCategoria();//se va rellenar con combobox
        //en el formulario cuando inicie este
        llenarComboBoxPresentacion();
        txtIDProducto.setVisible(false);
        txtidppresentacion.setVisible(false);

    }
//
//    public void llenarcomboboxCategoria() {
//        CRUD_Categoria cate = new CRUD_Categoria();
//        DefaultComboBoxModel<Categoria> modelo = cate.Llenar();
//        comboCategoria.setModel(modelo);
//    }
//    
      public void llenarCategoria() {

          CRUD_Categoria cate = new CRUD_Categoria();
        ArrayList<Categoria> listaCategoria = cate.mostrarDatosCombo();
        comboCategoria.removeAllItems();
        for (int i = 0; i < listaCategoria.size(); i++) {
            comboCategoria.addItem(new Categoria(
                    listaCategoria.get(i).getIDCategoria(),
                    listaCategoria.get(i).getNombre_categoria()));
        }

    }
      
         public void llenarProveedor() {

          CRUD_Proveedor provee = new CRUD_Proveedor();
        ArrayList<Proveedor> listaproveedor = provee.mostrarDatosCombo();
        ComboBoxproveedor.removeAllItems();
        for (int i = 0; i < listaproveedor.size(); i++) {
            ComboBoxproveedor.addItem(new Proveedor(
                    listaproveedor.get(i).getID_proveedor(),
                    listaproveedor.get(i).getEmpresa_proveedor()));
        }

    }

    public void llenarComboBoxPresentacion() {
        CRUD_Presentacion Presen = new CRUD_Presentacion();
        DefaultComboBoxModel<Presentacion> modelo = Presen.Llenar();
        comboPresentacion.setModel(modelo);
    }

    //Metodo paa guardar un producto.
    public void GuardarProducto() {
        CRUD_Producto cp = new CRUD_Producto();

        // Obtener el ID de la categoría seleccionada del JComboBox
        Categoria categoriaSeleccionada = (Categoria) comboCategoria.getSelectedItem();
        int ID_Categoria = categoriaSeleccionada.getIDCategoria();

        Presentacion presenSeleccionada = (Presentacion) comboPresentacion.getSelectedItem();
        int ID_Presentacion = presenSeleccionada.getIDPresentacion();

        Producto p1;
        p1 = new Producto(txtNombreProducto.getText(),
                Integer.parseInt(txtCantidad.getText()),
                BigDecimal.valueOf(Double.parseDouble(txtPrecioCompra.getText())),
                BigDecimal.valueOf(Double.parseDouble(txtPrecioVenta.getText())),
                txtDescripcion.getText(),
                java.sql.Date.valueOf(txtFechaVencimiento.getText()),
                ID_Categoria,
                ID_Presentacion,
                BigDecimal.valueOf(Double.parseDouble(txtMedidaNumerica.getText())));

        cp.insertarProducto(p1);
    }

    //Metodo para limpiar campos
    public void LimpiarCampos() {
        txtIDProducto.setText("");
        txtNombreProducto.setText("");
        txtCantidad.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        txtDescripcion.setText("");
        txtFechaVencimiento.setText("");
        txtMedidaNumerica.setText("");
        txtidppresentacion.setText("");
        
        // Establecer selección por defecto en los combo boxes
        comboCategoria.setSelectedIndex(0);  // Índice de la opción por defecto que hace referencia a un objeto por default
//        que hay en crud categoria que es con un valor 0,con un titulo que es categoria.
        comboPresentacion.setSelectedIndex(0);  // Índice de la opción por defecto
     
    }

//    Metodo para editar un producto.
    public void EditarProducto() {

        CRUD_Producto cp = new CRUD_Producto();

        // Obtener el ID de la categoría seleccionada del JComboBox
        Categoria categoriaSeleccionada = (Categoria) comboCategoria.getSelectedItem();
        int ID_Categoria = categoriaSeleccionada.getIDCategoria();

        Presentacion presenSeleccionada = (Presentacion) comboPresentacion.getSelectedItem();
        int ID_Presentacion = presenSeleccionada.getIDPresentacion();

        Producto p1 = new Producto(Integer.parseInt(txtIDProducto.getText()),
                txtNombreProducto.getText(),
                Integer.parseInt(txtCantidad.getText()),
                BigDecimal.valueOf(Double.parseDouble(txtPrecioCompra.getText())),
                BigDecimal.valueOf(Double.parseDouble(txtPrecioVenta.getText())),
                txtDescripcion.getText(),
                java.sql.Date.valueOf(txtFechaVencimiento.getText()),
                ID_Categoria,
                ID_Presentacion,
                BigDecimal.valueOf(Double.parseDouble(txtMedidaNumerica.getText())));

        cp.ActualizarProducto(p1);

    }
//    Integer.parseInt(comboCategoria.getSelectedItem().toString()));

    public void Mostrar() { //Método mostrar
        try {
            DefaultTableModel modelo;
            CRUD_Producto producto = new CRUD_Producto(); //objeto de la clase CRUD_Producto
            modelo = producto.mostrarDatos();
            tablaProducto.setModel(modelo);
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
        txtNombreProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
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
        botorefrescar = new javax.swing.JButton();
        comboCategoria = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        txtMedidaNumerica = new javax.swing.JTextField();
        comboPresentacion = new javax.swing.JComboBox<>();
        ComboBoxproveedor = new javax.swing.JComboBox<>();
        txtBuscarProducto = new javax.swing.JTextField();
        txtIDProducto = new javax.swing.JTextField();
        txtFechaVencimiento = new javax.swing.JFormattedTextField();
        txtidppresentacion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1280, 580));
        setMinimumSize(new java.awt.Dimension(1280, 580));
        setPreferredSize(new java.awt.Dimension(1280, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 580));

        txtNombreProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Cantidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtPrecioCompra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Precio compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        txtPrecioVenta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Precio venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });

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
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });
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
        btnLimpiarCamposProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposProductoActionPerformed(evt);
            }
        });
        jSplitPane3.setRightComponent(btnLimpiarCamposProducto);

        btnEliminarProducto.setBackground(new java.awt.Color(4, 64, 98));
        btnEliminarProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        jSplitPane3.setLeftComponent(btnEliminarProducto);

        jPanel2.setBackground(new java.awt.Color(4, 64, 98));

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

        botorefrescar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        botorefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_iconos/girar.png"))); // NOI18N
        botorefrescar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botorefrescar.setMaximumSize(new java.awt.Dimension(40, 40));
        botorefrescar.setMinimumSize(new java.awt.Dimension(40, 40));
        botorefrescar.setOpaque(true);
        botorefrescar.setPreferredSize(new java.awt.Dimension(45, 40));
        botorefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botorefrescarMouseClicked(evt);
            }
        });
        botorefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botorefrescarActionPerformed(evt);
            }
        });
        jPanel2.add(botorefrescar);

        comboCategoria.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboCategoria.setPreferredSize(new java.awt.Dimension(250, 40));
        comboCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCategoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboCategoriaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboCategoriaMousePressed(evt);
            }
        });
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(comboCategoria);

        jPanel3.setBackground(new java.awt.Color(4, 64, 98));

        txtMedidaNumerica.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtMedidaNumerica.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Numero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtMedidaNumerica.setPreferredSize(new java.awt.Dimension(90, 41));
        txtMedidaNumerica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedidaNumericaActionPerformed(evt);
            }
        });
        txtMedidaNumerica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMedidaNumericaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMedidaNumericaKeyTyped(evt);
            }
        });
        jPanel3.add(txtMedidaNumerica);

        comboPresentacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboPresentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(4, 64, 98))));
        comboPresentacion.setMinimumSize(new java.awt.Dimension(200, 40));
        comboPresentacion.setPreferredSize(new java.awt.Dimension(190, 40));
        comboPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPresentacionActionPerformed(evt);
            }
        });
        jPanel3.add(comboPresentacion);

        ComboBoxproveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ComboBoxproveedor.setPreferredSize(new java.awt.Dimension(190, 40));
        jPanel3.add(ComboBoxproveedor);

        txtBuscarProducto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        txtFechaVencimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Fecha vencimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        try {
            txtFechaVencimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaVencimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaVencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaVencimientoKeyPressed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(4, 64, 98));
        jSeparator2.setForeground(new java.awt.Color(4, 64, 98));
        jSeparator2.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 64, 98));
        jLabel2.setText("Gestion de Productos");

        jSeparator1.setBackground(new java.awt.Color(4, 64, 98));
        jSeparator1.setForeground(new java.awt.Color(4, 64, 98));
        jSeparator1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombreProducto)
                                    .addComponent(txtBuscarProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 33, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDescripcion))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidppresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidppresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(337, 337, 337))
        );

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
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyPressed
        des.Desplazar(evt, txtFechaVencimiento, txtNombreProducto);
    }//GEN-LAST:event_txtNombreProductoKeyPressed

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        validar.KeyTipedTXT(evt);
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        des.Desplazar(evt, txtPrecioCompra, txtFechaVencimiento);
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        validar.KeyTipedNUM(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed

    private void txtPrecioCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyPressed
        des.Desplazar(evt, txtPrecioVenta, txtCantidad);
    }//GEN-LAST:event_txtPrecioCompraKeyPressed

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        validar.KeyTipedNUMPUN(evt);
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyPressed
        des.Desplazar(evt, txtMedidaNumerica, txtPrecioCompra);
    }//GEN-LAST:event_txtPrecioVentaKeyPressed

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        validar.KeyTipedNUMPUN(evt);
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        des.Desplazar(evt,txtNombreProducto, txtMedidaNumerica);
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        datoSeleccionado = tablaProducto.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tablaProductoMouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        CRUD_Producto cp = new CRUD_Producto();
        try {
            if (txtNombreProducto.getText().equals("")
                || txtCantidad.getText().equals("")
                || txtPrecioCompra.getText().equals("")
                || txtPrecioVenta.getText().equals("")
                || txtDescripcion.getText().equals("")
                || comboCategoria.getSelectedItem().toString().equals("")
                || comboPresentacion.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                if (cp.verificarDatos(txtNombreProducto.getText())) {
                    JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
                } else {
                    GuardarProducto();
                    LimpiarCampos();
                    Mostrar();
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                }

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed

        int fila = this.tablaProducto.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla.");
        } else {
            try {
                int IDProducto = Integer.parseInt((String) this.tablaProducto.getValueAt(fila, 0));
                String nombreP = (String) this.tablaProducto.getValueAt(fila, 1).toString();
                int cantidadP = Integer.parseInt((String) this.tablaProducto.getValueAt(fila, 2));
                BigDecimal Ccompra = BigDecimal.valueOf(Double.parseDouble((String) this.tablaProducto.getValueAt(fila, 3).toString()));
                BigDecimal Cventa = BigDecimal.valueOf(Double.parseDouble((String) this.tablaProducto.getValueAt(fila, 4).toString()));
                Date fecha = java.sql.Date.valueOf(this.tablaProducto.getValueAt(fila, 6).toString());
                String descripcion = (String) this.tablaProducto.getValueAt(fila, 5).toString();
                int IDCategoria = Integer.parseInt((String) this.tablaProducto.getValueAt(fila, 7));
                BigDecimal Umedida = BigDecimal.valueOf(Double.parseDouble((String) this.tablaProducto.getValueAt(fila, 10).toString()));
                int ID_PPresentacion = Integer.parseInt((String) this.tablaProducto.getValueAt(fila, 9));
                int IDPresentacion = Integer.parseInt((String) this.tablaProducto.getValueAt(fila, 11));
                int IDProveedor = Integer.parseInt((String) this.tablaProducto.getValueAt(fila, 13));

                txtIDProducto.setText("" + IDProducto);
                txtNombreProducto.setText(nombreP);
                txtCantidad.setText("" + cantidadP);
                txtPrecioCompra.setText("" + Ccompra);
                txtPrecioVenta.setText("" + Cventa);
                txtFechaVencimiento.setText("" + fecha);
                txtDescripcion.setText(descripcion);
                txtMedidaNumerica.setText("" + Umedida);
                txtidppresentacion.setText("" + ID_PPresentacion);
                
                
                //Buscar y seleccionar la categoria correspondiente en el comboProveedor
                for (int i = 0; 1 < ComboBoxproveedor.getItemCount(); i++) {
                    Proveedor proveedor = (Proveedor) ComboBoxproveedor.getItemAt(i);
                    if(proveedor.getID_proveedor() == IDProveedor){
                        ComboBoxproveedor.setSelectedIndex(i);
                        break;
                    }
                }

                // Buscar y seleccionar la categoría correspondiente en el comboCategoria
                for (int i = 0; i < comboCategoria.getItemCount(); i++) {
                    Categoria categoria = (Categoria) comboCategoria.getItemAt(i);
                    if (categoria.getIDCategoria() == IDCategoria) {
                        comboCategoria.setSelectedIndex(i);
                        break;
                    }
                }

                // Buscar y seleccionar la presentación correspondiente en el comboPresentacion
                for (int i = 0; i < comboPresentacion.getItemCount(); i++) {
                    Presentacion presentacion = (Presentacion) comboPresentacion.getItemAt(i);
                    if (presentacion.getIDPresentacion() == IDPresentacion) {
                        comboPresentacion.setSelectedIndex(i);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        CRUD_Producto cp = new CRUD_Producto();
        try {
            if (txtNombreProducto.getText().equals("")
                || txtCantidad.getText().equals("")
                || txtPrecioCompra.getText().equals("")
                || txtPrecioVenta.getText().equals("")
                || txtDescripcion.getText().equals("")
                || txtFechaVencimiento.getText().equals("")) {
                //                    || comboCategoria.getSelectedItem().toString().equals("")
                //                    || comboPresentacion.getSelectedItem().toString().equals("")) {

                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                EditarProducto();
                LimpiarCampos();
                Mostrar();
                JOptionPane.showMessageDialog(null, "Datos Actualizados correctamente");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnLimpiarCamposProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposProductoActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_btnLimpiarCamposProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed

        if (datoSeleccionado >= 0) {

            String dato = String.valueOf(tablaProducto.getValueAt(datoSeleccionado, 0));
            CRUD_Producto cli = new CRUD_Producto();
            if (JOptionPane.showConfirmDialog(this.getRootPane(),
                "Se eliminará el registro, ¿desea continuar?",
                "Eliminar Registro",
                JOptionPane.WARNING_MESSAGE,
                JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION) {

            cli.eliminar(dato);
            Mostrar();
            JOptionPane.showMessageDialog(null,
                "Dato eliminado correctamente");
        }
        } else {
            JOptionPane.showMessageDialog(null,
                "Debe seleccionar un registro de la tabla");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnAgregarCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCateMouseClicked

    }//GEN-LAST:event_btnAgregarCateMouseClicked

    private void btnAgregarCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCateActionPerformed

        DialogCategoria dialog = new DialogCategoria(null, true);
        Frame_producto vv = new Frame_producto();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(vv);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAgregarCateActionPerformed

    private void botorefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botorefrescarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botorefrescarMouseClicked

    private void botorefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botorefrescarActionPerformed
  llenarCategoria();
    }//GEN-LAST:event_botorefrescarActionPerformed

    private void comboCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaMouseClicked

    private void comboCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMouseEntered
        // TODO add your handling code here:
        //        llenarcombobox();
    }//GEN-LAST:event_comboCategoriaMouseEntered

    private void comboCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaMousePressed

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo;
            CRUD_Producto cli = new CRUD_Producto();

            modelo = cli.buscarDatos(txtBuscarProducto.getText());
            Mostrar();

            tablaProducto.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void txtFechaVencimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaVencimientoKeyPressed
        des.Desplazar(evt, txtCantidad, txtNombreProducto);
    }//GEN-LAST:event_txtFechaVencimientoKeyPressed

    private void comboPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPresentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPresentacionActionPerformed

    private void txtMedidaNumericaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedidaNumericaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaNumericaKeyTyped

    private void txtMedidaNumericaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedidaNumericaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaNumericaKeyPressed

    private void txtMedidaNumericaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedidaNumericaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaNumericaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Proveedor> ComboBoxproveedor;
    public static javax.swing.JButton botorefrescar;
    private javax.swing.JButton btnActualizarProducto;
    public static javax.swing.JButton btnAgregarCate;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnLimpiarCamposProducto;
    public static javax.swing.JComboBox<Categoria> comboCategoria;
    private javax.swing.JComboBox<Presentacion> comboPresentacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtFechaVencimiento;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtMedidaNumerica;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtidppresentacion;
    // End of variables declaration//GEN-END:variables
}
