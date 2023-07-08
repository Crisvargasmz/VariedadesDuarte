package Vistas_formularios;
import Controlador.CRUD_Proveedor;
import Modelo.Desplazar_txtFields;
import Modelo.Proveedor;
import Modelo.ValidarCampos;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Frame_proveedor extends javax.swing.JInternalFrame {
    private ValidarCampos validar = new ValidarCampos();
    private Desplazar_txtFields des = new Desplazar_txtFields();
    int datoSeleccionado = -1;
    
    public Frame_proveedor() {
        initComponents();
        mostrar();
        ocultartabla();
        txtidproveedor.setVisible(false);
        txtidpersona.setVisible(false);
    }
     public void guardarProveedor() {
        CRUD_Proveedor cp = new CRUD_Proveedor();

        Proveedor p1 = new Proveedor(
                txtNombreProveedorUno.getText(),
                txtNombreProveedorDos.getText(),
                txtApellidoProveedorUno.getText(),
                txtApellidoProveedorDos.getText(),
                txtEmpresaProveedor.getText(),
                txtTelefonoProveedor.getText(),
                txtDireccionProveedor.getText());
        cp.insertarProveedor(p1);
    }

    public void limpiar() {
        txtEmpresaProveedor.setText("");
        txtNombreProveedorUno.setText("");
        txtNombreProveedorDos.setText("");
        txtApellidoProveedorUno.setText("");
        txtApellidoProveedorDos.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");

    }

    public void editarProveedor() {

        CRUD_Proveedor cp = new CRUD_Proveedor();

        Proveedor p1 = new Proveedor(Integer.parseInt(txtidproveedor.getText()),
                Integer.parseInt(txtidpersona.getText()),
                txtNombreProveedorUno.getText(),
                txtNombreProveedorDos.getText(),
                txtApellidoProveedorUno.getText(),
                txtApellidoProveedorDos.getText(),
                txtEmpresaProveedor.getText(),
                txtTelefonoProveedor.getText(),
                txtDireccionProveedor.getText());

        cp.ActualizarProveedor(p1);

    }

    public void mostrar() {
        try {
            DefaultTableModel modelo;
            CRUD_Proveedor pro = new CRUD_Proveedor();
            modelo = pro.mostrarDatos();
            tablaProveedor.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
             public void ocultartabla() {
    int columnIndex = 0; // Aquí pones el índice de la columna que deseas ocultar
    int columnIdex1 = 1;

    TableColumnModel columnModel = tablaProveedor.getColumnModel();
    columnModel.getColumn(columnIndex).setWidth(0);
    columnModel.getColumn(columnIndex).setMinWidth(0);
    columnModel.getColumn(columnIndex).setMaxWidth(0);
    columnModel.getColumn(columnIndex).setPreferredWidth(0);
    columnModel.getColumn(columnIdex1).setWidth(0);
    columnModel.getColumn(columnIdex1).setMinWidth(0);
    columnModel.getColumn(columnIdex1).setMaxWidth(0);
    columnModel.getColumn(columnIdex1).setPreferredWidth(0);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        txtNombreProveedorUno = new javax.swing.JTextField();
        txtNombreProveedorDos = new javax.swing.JTextField();
        txtEmpresaProveedor = new javax.swing.JTextField();
        txtApellidoProveedorDos = new javax.swing.JTextField();
        txtApellidoProveedorUno = new javax.swing.JTextField();
        jSplitPane3 = new javax.swing.JSplitPane();
        btnLimpiarCamposProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        btnAgregarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        txtDireccionProveedor = new javax.swing.JTextField();
        txtBuscarProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JFormattedTextField();
        txtidproveedor = new javax.swing.JTextField();
        txtidpersona = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(1280, 580));
        setMinimumSize(new java.awt.Dimension(1280, 580));
        setPreferredSize(new java.awt.Dimension(1280, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 580));

        tablaProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Empresa", "Telefono", "Direccion"
            }
        ));
        tablaProveedor.setGridColor(new java.awt.Color(0, 204, 204));
        tablaProveedor.setRowHeight(25);
        tablaProveedor.setShowHorizontalLines(true);
        tablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedor);

        txtNombreProveedorUno.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreProveedorUno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreProveedorUno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Primer Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtNombreProveedorUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreProveedorUnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorUnoKeyTyped(evt);
            }
        });

        txtNombreProveedorDos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreProveedorDos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreProveedorDos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Segundo Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtNombreProveedorDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreProveedorDosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorDosKeyTyped(evt);
            }
        });

        txtEmpresaProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtEmpresaProveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmpresaProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtEmpresaProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmpresaProveedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpresaProveedorKeyTyped(evt);
            }
        });

        txtApellidoProveedorDos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtApellidoProveedorDos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoProveedorDos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Segundo Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtApellidoProveedorDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoProveedorDosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoProveedorDosKeyTyped(evt);
            }
        });

        txtApellidoProveedorUno.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtApellidoProveedorUno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoProveedorUno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Primer Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtApellidoProveedorUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoProveedorUnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoProveedorUnoKeyTyped(evt);
            }
        });

        jSplitPane3.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane3.setOpaque(false);

        btnLimpiarCamposProveedor.setBackground(new java.awt.Color(4, 64, 98));
        btnLimpiarCamposProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiarCamposProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCamposProveedor.setText("Limpiar");
        btnLimpiarCamposProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposProveedorActionPerformed(evt);
            }
        });
        jSplitPane3.setRightComponent(btnLimpiarCamposProveedor);

        btnEliminarProveedor.setBackground(new java.awt.Color(4, 64, 98));
        btnEliminarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });
        jSplitPane3.setLeftComponent(btnEliminarProveedor);

        jSplitPane1.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane1.setOpaque(false);

        jSplitPane2.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane2.setOpaque(false);

        btnAgregarProveedor.setBackground(new java.awt.Color(4, 64, 98));
        btnAgregarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });
        jSplitPane2.setRightComponent(btnAgregarProveedor);

        btnEditarProveedor.setBackground(new java.awt.Color(4, 64, 98));
        btnEditarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEditarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor.setText("  Editar  ");
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });
        jSplitPane2.setLeftComponent(btnEditarProveedor);

        jSplitPane1.setRightComponent(jSplitPane2);

        btnActualizarProveedor.setBackground(new java.awt.Color(4, 64, 98));
        btnActualizarProveedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnActualizarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProveedor.setText("Actualizar");
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(btnActualizarProveedor);

        txtDireccionProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDireccionProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccionProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtDireccionProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionProveedorKeyPressed(evt);
            }
        });

        txtBuscarProveedor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBuscarProveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscarProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorKeyReleased(evt);
            }
        });

        txtTelefonoProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        try {
            txtTelefonoProveedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefonoProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefonoProveedor.setMinimumSize(new java.awt.Dimension(64, 41));
        txtTelefonoProveedor.setPreferredSize(new java.awt.Dimension(64, 41));
        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyPressed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(4, 64, 98));
        jSeparator2.setForeground(new java.awt.Color(4, 64, 98));
        jSeparator2.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 64, 98));
        jLabel2.setText("Gestion de Proveedores");

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
                        .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(txtEmpresaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombreProveedorUno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreProveedorDos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellidoProveedorUno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellidoProveedorDos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombreProveedorDos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreProveedorUno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtApellidoProveedorUno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidoProveedorDos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpresaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedorMouseClicked
        datoSeleccionado = tablaProveedor.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tablaProveedorMouseClicked

    private void txtNombreProveedorUnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorUnoKeyPressed
        des.Desplazar(evt, txtNombreProveedorDos, txtNombreProveedorUno);
    }//GEN-LAST:event_txtNombreProveedorUnoKeyPressed

    private void txtNombreProveedorUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorUnoKeyTyped
        // Llamando metodo KeyTipedTXT
        validar.KeyTipedTXT(evt);
    }//GEN-LAST:event_txtNombreProveedorUnoKeyTyped

    private void txtNombreProveedorDosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorDosKeyPressed
        des.Desplazar(evt, txtApellidoProveedorUno, txtNombreProveedorUno);
    }//GEN-LAST:event_txtNombreProveedorDosKeyPressed

    private void txtNombreProveedorDosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorDosKeyTyped
        // Llamando metodo KeyTipedTXT
        validar.KeyTipedTXT(evt);
    }//GEN-LAST:event_txtNombreProveedorDosKeyTyped

    private void txtEmpresaProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaProveedorKeyPressed
        des.Desplazar(evt, txtTelefonoProveedor, txtApellidoProveedorDos);
    }//GEN-LAST:event_txtEmpresaProveedorKeyPressed

    private void txtEmpresaProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaProveedorKeyTyped
        // Llamando metodo KeyTipedTXT
        validar.KeyTipedTXT(evt);
    }//GEN-LAST:event_txtEmpresaProveedorKeyTyped

    private void txtApellidoProveedorDosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoProveedorDosKeyPressed
        des.Desplazar(evt, txtEmpresaProveedor, txtApellidoProveedorUno);
    }//GEN-LAST:event_txtApellidoProveedorDosKeyPressed

    private void txtApellidoProveedorDosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoProveedorDosKeyTyped
        // Llamando metodo KeyTipedTXT
        validar.KeyTipedTXT(evt);
    }//GEN-LAST:event_txtApellidoProveedorDosKeyTyped

    private void txtApellidoProveedorUnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoProveedorUnoKeyPressed
        des.Desplazar(evt, txtApellidoProveedorDos, txtNombreProveedorDos);
    }//GEN-LAST:event_txtApellidoProveedorUnoKeyPressed

    private void txtApellidoProveedorUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoProveedorUnoKeyTyped
        // Llamando metodo KeyTipedTXT
        validar.KeyTipedTXT(evt);
    }//GEN-LAST:event_txtApellidoProveedorUnoKeyTyped

    private void btnLimpiarCamposProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposProveedorActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarCamposProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed

   if (datoSeleccionado >= 0) {
    int pr = Integer.parseInt((String) tablaProveedor.getValueAt(datoSeleccionado, 1));
    int perso = Integer.parseInt((String) tablaProveedor.getValueAt(datoSeleccionado, 0));

    CRUD_Proveedor provee = new CRUD_Proveedor();
    
       try {
           // Verificar si existen productos asociados al proveedor
           if (provee.tieneProductosAsociados(pr)) {
               JOptionPane.showMessageDialog(null, "No se puede eliminar el proveedor. Tiene productos asociados.");
           } else {
               if (JOptionPane.showConfirmDialog(this.getRootPane(),
                       "Se eliminará el registro, ¿desea continuar?",
                       "Eliminar Registro",
                       JOptionPane.WARNING_MESSAGE,
                       JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                   
                   provee.eliminar(pr, perso);
                   mostrar();
                   ocultartabla();
                   JOptionPane.showMessageDialog(null, "Dato eliminado correctamente");
               }
           }  } catch (SQLException e) {
              e.printStackTrace();
       }
} else {
    JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
}

    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed

        CRUD_Proveedor cc = new CRUD_Proveedor();
        try {
            if (txtNombreProveedorUno.getText().equals("")
                || txtNombreProveedorDos.getText().equals("")
                || txtApellidoProveedorUno.getText().equals("")
                || txtApellidoProveedorDos.getText().equals("")
                || txtTelefonoProveedor.getText().equals("")
                || txtEmpresaProveedor.getText().equals("")
                || txtDireccionProveedor.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                if (cc.verificarTelefonoProveedor(txtTelefonoProveedor.getText())) {
                    JOptionPane.showMessageDialog(null, "El numero de telefono que ingreso ya existe.");
                } else {
                    guardarProveedor();
                    limpiar();
                    mostrar();
                    ocultartabla();
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed

        int fila = this.tablaProveedor.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor de la tabla.");
        } else {
            try {
                int IDPersona = Integer.parseInt((String) this.tablaProveedor.getValueAt(fila, 0));
                int IDProveedor = Integer.parseInt((String) this.tablaProveedor.getValueAt(fila, 1));
                String nombre1 = (String) this.tablaProveedor.getValueAt(fila, 2);
                String nombre2 = (String) this.tablaProveedor.getValueAt(fila, 3);
                String apell1ido1 = (String) this.tablaProveedor.getValueAt(fila, 4).toString();
                String apellido2 = (String) this.tablaProveedor.getValueAt(fila, 5).toString();
                String telefono = (String) this.tablaProveedor.getValueAt(fila, 6).toString();
                String empresa = (String) this.tablaProveedor.getValueAt(fila, 7).toString();
                String direccion = (String) this.tablaProveedor.getValueAt(fila, 8).toString();
                //                System.out.println(telefono);
                txtidpersona.setText("" + IDPersona);
                txtidproveedor.setText("" + IDProveedor);
                txtNombreProveedorUno.setText(nombre1);
                txtNombreProveedorDos.setText(nombre2);
                txtApellidoProveedorUno.setText(apell1ido1);
                txtApellidoProveedorDos.setText(apellido2);
                txtTelefonoProveedor.setText(telefono);
                txtEmpresaProveedor.setText(empresa);
                txtDireccionProveedor.setText(direccion);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
        try {
            CRUD_Proveedor cp = new CRUD_Proveedor();
            if (txtNombreProveedorUno.getText().equals("")
                || txtNombreProveedorDos.getText().equals("")
                || txtApellidoProveedorUno.getText().equals("")
                || txtApellidoProveedorDos.getText().equals("")
                || txtEmpresaProveedor.getText().equals("")
                || txtTelefonoProveedor.getText().equals("")
                || txtDireccionProveedor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                if (cp.verificarTelefonoProveedorActualizado(Integer.parseInt(txtidpersona.getText()),txtTelefonoProveedor.getText())) {
                    JOptionPane.showMessageDialog(null, "El numero de telefono que ingreso ya existe.");
                } else {
                    editarProveedor();
                    limpiar();
                    mostrar();
                    ocultartabla();

                    JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");

                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed

    private void txtDireccionProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionProveedorKeyPressed
        des.Desplazar(evt, txtNombreProveedorUno, txtTelefonoProveedor);
    }//GEN-LAST:event_txtDireccionProveedorKeyPressed

    private void txtTelefonoProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyPressed
        des.Desplazar(evt, txtDireccionProveedor, txtEmpresaProveedor);
    }//GEN-LAST:event_txtTelefonoProveedorKeyPressed

    private void txtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorKeyReleased
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo;
            CRUD_Proveedor cli = new CRUD_Proveedor();

            modelo = cli.buscarDatos(txtBuscarProveedor.getText());
            mostrar();
            
            tablaProveedor.setModel(modelo);
            ocultartabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        validar.KeyTipedTXT(evt);      
    }//GEN-LAST:event_txtBuscarProveedorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnLimpiarCamposProveedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JTextField txtApellidoProveedorDos;
    private javax.swing.JTextField txtApellidoProveedorUno;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtEmpresaProveedor;
    private javax.swing.JTextField txtNombreProveedorDos;
    private javax.swing.JTextField txtNombreProveedorUno;
    private javax.swing.JFormattedTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtidproveedor;
    // End of variables declaration//GEN-END:variables
}
