/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas_formularios;
import Controlador.CRUD_Cliente;
import Modelo.Cliente;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;


import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10
 */
public class Vista_cliente extends javax.swing.JPanel {

    int datoSeleccionado = -1;
     
    public Vista_cliente() {
        initComponents();
        mostrar();
        
    }
    
public void guardarCliente() {
    CRUD_Cliente cc = new CRUD_Cliente();
    Object generoSeleccionado = comboGenero.getSelectedItem();
    char generoChar;

    if (generoSeleccionado != null && generoSeleccionado.toString().length() == 1) {
        generoChar = generoSeleccionado.toString().charAt(0);
    } else {
        // Manejo de caso cuando el valor seleccionado no es válido
        // por ejemplo, si está vacío o tiene más de un carácter
        generoChar = ' '; // Asignar un espacio en blanco como valor predeterminado
        // O mostrar un mensaje de error
        System.out.println("Error: el género seleccionado no es válido.");
    }

    Cliente cl = new Cliente(txtNombreClienteUno.getText(),
                             txtNombreClienteDos.getText(),
                             txtApellidoClienteUno.getText(),
                             txtApellidoClienteDos.getText(),
                             txtTelefonoCliente.getText(),
                             generoChar,
                             txtDireccionCliente.getText());

    cc.insertarCliente(cl);
}
    
    public void limpiar() {
        txtNombreClienteUno.setText("");
        txtNombreClienteDos.setText("");
        txtApellidoClienteUno.setText("");
        txtApellidoClienteDos.setText("");
        txtTelefonoCliente.setText("");
         txtDireccionCliente.setText("");
    }

    public void mostrar() { //Método mostrar
        try {
            DefaultTableModel modelo;
            CRUD_Cliente cli = new CRUD_Cliente(); //objeto de la clase CRUDCliente
            modelo = cli.mostrarDatos();
            tablaCliente.setModel(modelo);
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

        txtNombreClienteUno = new javax.swing.JTextField();
        txtApellidoClienteDos = new javax.swing.JTextField();
        txtNombreClienteDos = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtApellidoClienteUno = new javax.swing.JTextField();
        comboGenero = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        btnAgregarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        jSplitPane3 = new javax.swing.JSplitPane();
        btnLimpiarCamposCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        contenedorTablaCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        txtBuscarCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1280, 580));
        setMinimumSize(new java.awt.Dimension(1280, 580));
        setPreferredSize(new java.awt.Dimension(1280, 580));

        txtNombreClienteUno.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreClienteUno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreClienteUno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Primer Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtNombreClienteUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteUnoKeyTyped(evt);
            }
        });

        txtApellidoClienteDos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtApellidoClienteDos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoClienteDos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Segundo Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtApellidoClienteDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoClienteDosKeyTyped(evt);
            }
        });

        txtNombreClienteDos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreClienteDos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreClienteDos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Segundo Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtNombreClienteDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteDosKeyTyped(evt);
            }
        });

        txtDireccionCliente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDireccionCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccionCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        txtApellidoClienteUno.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtApellidoClienteUno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoClienteUno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Primer Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtApellidoClienteUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoClienteUnoKeyTyped(evt);
            }
        });

        comboGenero.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genero", "M", "F" }));
        comboGenero.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98))));
        comboGenero.setFocusable(false);

        jSeparator1.setBackground(new java.awt.Color(0, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 204, 204));
        jSeparator1.setOpaque(true);

        jSplitPane1.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane1.setOpaque(false);

        jSplitPane2.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane2.setOpaque(false);

        btnAgregarCliente.setBackground(new java.awt.Color(4, 64, 98));
        btnAgregarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jSplitPane2.setRightComponent(btnAgregarCliente);

        btnEditarCliente.setBackground(new java.awt.Color(4, 64, 98));
        btnEditarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setText("  Editar  ");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        jSplitPane2.setLeftComponent(btnEditarCliente);

        jSplitPane1.setRightComponent(jSplitPane2);

        btnActualizarCliente.setBackground(new java.awt.Color(4, 64, 98));
        btnActualizarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCliente.setText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(btnActualizarCliente);

        jSplitPane3.setBackground(new java.awt.Color(4, 64, 98));
        jSplitPane3.setOpaque(false);

        btnLimpiarCamposCliente.setBackground(new java.awt.Color(4, 64, 98));
        btnLimpiarCamposCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiarCamposCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCamposCliente.setText("Limpiar");
        jSplitPane3.setRightComponent(btnLimpiarCamposCliente);

        btnEliminarCliente.setBackground(new java.awt.Color(4, 64, 98));
        btnEliminarCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setText("Elimnar");
        jSplitPane3.setLeftComponent(btnEliminarCliente);

        contenedorTablaCliente.setLayout(new javax.swing.OverlayLayout(contenedorTablaCliente));

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID CLiente", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Genero", "Telefono", "Direccion"
            }
        ));
        tablaCliente.setGridColor(new java.awt.Color(0, 204, 204));
        tablaCliente.setRowHeight(25);
        tablaCliente.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaCliente.setShowHorizontalLines(true);
        tablaCliente.setSurrendersFocusOnKeystroke(true);
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        contenedorTablaCliente.add(jScrollPane1);

        txtBuscarCliente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtBuscarCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyTyped(evt);
            }
        });

        txtTelefonoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), "Telefono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        try {
            txtTelefonoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreClienteUno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreClienteDos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtApellidoClienteUno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellidoClienteDos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE)
                            .addComponent(contenedorTablaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApellidoClienteDos)
                    .addComponent(txtNombreClienteUno)
                    .addComponent(txtNombreClienteDos)
                    .addComponent(txtApellidoClienteUno, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(txtTelefonoCliente))
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarCliente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSplitPane3)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(contenedorTablaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // Llamando metodo KeyTipedTXT
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void txtNombreClienteUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteUnoKeyTyped
        // Llamando metodo KeyTipedTXT
        KeyTipedTXT(evt);
    }//GEN-LAST:event_txtNombreClienteUnoKeyTyped

    private void txtNombreClienteDosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteDosKeyTyped
        // Llamando metodo KeyTipedTXT
        KeyTipedTXT(evt);
    }//GEN-LAST:event_txtNombreClienteDosKeyTyped

    private void txtApellidoClienteUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoClienteUnoKeyTyped
        // Llamando metodo KeyTipedTXT
        KeyTipedTXT(evt);
    }//GEN-LAST:event_txtApellidoClienteUnoKeyTyped

    private void txtBuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyTyped
            try {
            DefaultTableModel modelo;
            CRUD_Cliente cli = new CRUD_Cliente();

            modelo = cli.buscarDatos(txtBuscarCliente.getText());

            if (txtBuscarCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Escriba el dato a buscar");
                mostrar();
            } else {
                tablaCliente.setModel(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
        KeyTipedTXT(evt);
    }//GEN-LAST:event_txtBuscarClienteKeyTyped

    private void txtApellidoClienteDosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoClienteDosKeyTyped
        // Llamando metodo KeyTipedTXT
        KeyTipedTXT(evt);
    }//GEN-LAST:event_txtApellidoClienteDosKeyTyped

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed


 CRUD_Cliente cc = new CRUD_Cliente();
try {
    if (txtNombreClienteUno.getText().equals("")
            || txtNombreClienteDos.getText().equals("")
            || txtApellidoClienteUno.getText().equals("")
            || txtApellidoClienteDos.getText().equals("")
            || txtTelefonoCliente.getText().equals("")
            || comboGenero.getSelectedItem().toString().equals("")
            || txtDireccionCliente.getText().equals("")) {

        JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
    } else {
        guardarCliente();
        limpiar();
        JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
    }
} catch (HeadlessException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e);
}







        
        
        
        
        
        
        
        
//        CRUD_Cliente cc = new CRUD_Cliente();
//    try {
//        if (txtNombreClienteUno.getText().equals("")
//                || txtNombreClienteDos.getText().equals("")
//                || txtApellidoClienteUno.getText().equals("")
//                || txtApellidoClienteDos.getText().equals("")
//                || txtTelefonoCliente.getText().equals("")
//                || txtDireccionCliente.getText().equals("")) {
//
//            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
//        } else {
//            if (cc.verificarDatos(txtCedula.getText())) {
//                JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese número de Cédula");
//            } else {
//                guardarCliente();
//                limpiar();
//                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
//            }
//        }
//    } catch (HeadlessException e) {
//        JOptionPane.showMessageDialog(null, "Error: " + e);
//    }
















//   String nombreCliente1 = txtNombreClienteUno.getText();
//    String nombreCliente2 = txtNombreClienteDos.getText();
//    String apellidoCliente1 = txtApellidoClienteUno.getText();
//    String apellidoCliente2 = txtApellidoClienteDos.getText();
//    String telefonoCliente = txtTelefonoCliente.getText();
//    String generoCliente = comboGenero.getSelectedItem().toString();
//    String direccionCliente = txtDireccionCliente.getText();
//    
//    String url="jdbc:sqlserver://localhost:1433;databaseName=VariedadesDuarte;" + "integratedSecurity=true;" +
//                              "encrypt=true;trustServerCertificate=true; user=sa; password=2004";
//
//     try {
//        Connection conn = DriverManager.getConnection(url);
//
//        // Llama al procedimiento almacenado para insertar un cliente
//        String procedureCall = "{call InsertarCliente(?, ?, ?, ?, ?, ?, ?)}";
//        CallableStatement cstmt = conn.prepareCall(procedureCall);
//
//        // Define los parámetros de entrada
//        cstmt.setString(1, nombreCliente1);
//        cstmt.setString(2, nombreCliente2);
//        cstmt.setString(3, apellidoCliente1);
//        cstmt.setString(4, apellidoCliente2);
//        cstmt.setString(5, telefonoCliente);
//        cstmt.setString(6, generoCliente);
//        cstmt.setString(7, direccionCliente);
//
//        // Ejecuta el procedimiento almacenado
//        cstmt.execute();
//
//        // Cierra la conexión y el statement
//        cstmt.close();
//        conn.close();
//        limpiar();
//        // Realiza cualquier acción adicional después de guardar los datos
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        // Maneja la excepción si ocurre algún error al guardar los datos
//    }
 
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
  datoSeleccionado = tablaCliente.rowAtPoint(evt.getPoint());
  if (datoSeleccionado >= 0) {
          
                    String dato  = String.valueOf(tablaCliente.getValueAt(datoSeleccionado, 0));
            CRUD_Cliente cli = new CRUD_Cliente();
            if (JOptionPane.showConfirmDialog(this.getRootPane(),
                    "Se eliminará el registro, ¿desea continuar?",
                    "Eliminar Registro",
                    JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {

                cli.eliminar(dato);
                mostrar();
                JOptionPane.showMessageDialog(null,
                        "Dato eliminado correctamente");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar un registro de la tabla");
        }
  
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
 
//    try {
//        
//        if (txtNombreClienteUno.getText().equals("")
//                || txtNombreClienteDos.getText().equals("")
//                || txtApellidoClienteUno.getText().equals("")
//                || txtApellidoClienteDos.getText().equals("")
//                || comboGenero.getSelectedItem().toString().equals("")
//                ||   txtTelefonoCliente.getText().equals("")
//                || txtDireccionCliente.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
//        } else {
//            editarCliente();
//            JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
//            dispose();
//            tablaCliente.botonmostrar.doClick();
//        }
//    } catch (HeadlessException e) {
//        JOptionPane.showMessageDialog(null, "Error: " + e);
//    }


    }//GEN-LAST:event_btnActualizarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnLimpiarCamposCliente;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JPanel contenedorTablaCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTextField txtApellidoClienteDos;
    private javax.swing.JTextField txtApellidoClienteUno;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtNombreClienteDos;
    private javax.swing.JTextField txtNombreClienteUno;
    private javax.swing.JFormattedTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
