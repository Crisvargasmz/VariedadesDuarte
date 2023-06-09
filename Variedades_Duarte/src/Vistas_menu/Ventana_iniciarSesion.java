/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas_menu;

import Controlador.Conexion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
public class Ventana_iniciarSesion extends javax.swing.JFrame {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    /**
     * Creates new form Ventana_iniciarSesion
     */
    public Ventana_iniciarSesion() {
        initComponents();
        pnlFormularioSesion.setSize(520, 450);
        DimencionesFields();
        setTitle("Iniciar Sesion");
        setLocationRelativeTo(null);
        btnOcultar.setVisible(false);
        txtPassword.setEchoChar('\u2022');

    }

    public void DimencionesFields() {

        txtUsuario.setSize(324, 60);
        txtPassword.setSize(324, 60);
    }

    public void nv() {
        String usuIngre = txtUsuario.getText();
        char[] MostrarPassword = txtPassword.getPassword();
        String password = new String(MostrarPassword);
        if (Autenticacion(usuIngre, password)) {
            Controlador_Principal principal = new Controlador_Principal();
            principal.setVisible(true);
            principal.setLocationRelativeTo(null);
            principal.setResizable(false);
            this.setVisible(false);
            lbAdvertencia.setForeground(new Color(0, 204, 0));
            lbAdvertencia.setText("Acceso correcto.");
        } else {
            lbAdvertencia.setForeground(new Color(255, 0, 0));
            lbAdvertencia.setText("Acceso incorrecto.");
            txtUsuario.setText("");
            txtPassword.setText("");
        }

    }

    //Metodo para autenticar usuarios en la base de datos.
    private boolean Autenticacion(String username, String password) {
        try {
            String sql = "SELECT * FROM IniciodeSesion WHERE usuario_sesion = ? AND contrasena_sesion = ?";
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String user = result.getString("usuario_sesion");
                String pass = result.getString("contrasena_sesion");
                return username.equals(user) && password.equals(pass);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

//Metodo para los botones Mostrar y Ocultar.
    private ActionEvent MostraPassword(java.awt.event.ActionEvent evt, JButton btnMostrar, JButton btnOcultar) {
        if (evt.getSource() == btnMostrar) {
            btnOcultar.setVisible(true);
            btnMostrar.setVisible(false);
            char[] MostrarPassword = txtPassword.getPassword();
            String password = new String(MostrarPassword);
            txtPassword.setEchoChar('\0');
            txtPassword.setSize(324, 60);

        } else if (evt.getSource() == btnOcultar) {
            btnOcultar.setVisible(false);
            btnMostrar.setVisible(true);
            char echoChar = txtPassword.getEchoChar();
            txtPassword.setEchoChar('\u2022');
            txtPassword.setSize(324, 60);

        }
        return evt;
    }

    private void LimpiarCampos() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }

    //Metodo para ingresar con la accion de boton.
    private void AccesoBoton(java.awt.event.ActionEvent evt) {
        String username = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());
        if (Autenticacion(username, password)) {
            Controlador_Principal principal = new Controlador_Principal();
            principal.setVisible(true);
            principal.setLocationRelativeTo(null);
            principal.setResizable(false);
            this.dispose();
            lbAdvertencia.setForeground(new Color(0, 204, 0));
            lbAdvertencia.setText("Acceso concedido.");
        } else {
            lbAdvertencia.setForeground(new Color(255, 0, 0));
            lbAdvertencia.setText("Acceso denegado.");
            LimpiarCampos();
            MostraPassword(evt, btnMostrar, btnOcultar);
        }
    }

    //Metodo pata ingresar ccn laccion del ENTER con JTextField
    private void AccesoENTER(java.awt.event.KeyEvent evt) {
        String username = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Autenticacion(username, password)) {
                Controlador_Principal principal = new Controlador_Principal();
                principal.setVisible(true);
                principal.setLocationRelativeTo(null);
                principal.setResizable(false);
                this.dispose();
                lbAdvertencia.setForeground(new Color(0, 204, 0));
                lbAdvertencia.setText("Acceso concedido.");
            } else {
                lbAdvertencia.setForeground(new Color(255, 0, 0));
                lbAdvertencia.setText("Acceso denegado.");
                LimpiarCampos();

            }
        }
    }

    //Metodo para cambiar tipeo entre JTextFields.
    private void CambiarJTextField(JTextField JTexFields, java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            JTexFields.requestFocus();
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

        pnlPanelContenedor = new javax.swing.JPanel();
        cuadroEstilo_Uno = new javax.swing.JPanel();
        cuadroEstilo_Dos = new javax.swing.JPanel();
        cuadroEstilo_Tres = new javax.swing.JPanel();
        pnlFormularioSesion = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        separadorEstilo_Dos = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        separadorEstilo_Uno = new javax.swing.JSeparator();
        lbAdvertencia = new javax.swing.JLabel();
        pnlBotonesMV = new javax.swing.JPanel();
        btnMostrar = new javax.swing.JButton();
        btnOcultar = new javax.swing.JButton();
        cuadroEstilo_Cuatro = new javax.swing.JPanel();
        cuadroEstilo_Cinco = new javax.swing.JPanel();
        cuadroEstilo_Seis = new javax.swing.JPanel();
        cuadroEstilo_Siete = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1095, 660));
        setMinimumSize(new java.awt.Dimension(1095, 660));
        setPreferredSize(new java.awt.Dimension(1095, 660));
        setResizable(false);

        pnlPanelContenedor.setBackground(new java.awt.Color(59, 156, 210));
        pnlPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cuadroEstilo_Uno.setBackground(new java.awt.Color(29, 163, 83));

        javax.swing.GroupLayout cuadroEstilo_UnoLayout = new javax.swing.GroupLayout(cuadroEstilo_Uno);
        cuadroEstilo_Uno.setLayout(cuadroEstilo_UnoLayout);
        cuadroEstilo_UnoLayout.setHorizontalGroup(
            cuadroEstilo_UnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        cuadroEstilo_UnoLayout.setVerticalGroup(
            cuadroEstilo_UnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        cuadroEstilo_Dos.setBackground(new java.awt.Color(250, 15, 15));

        javax.swing.GroupLayout cuadroEstilo_DosLayout = new javax.swing.GroupLayout(cuadroEstilo_Dos);
        cuadroEstilo_Dos.setLayout(cuadroEstilo_DosLayout);
        cuadroEstilo_DosLayout.setHorizontalGroup(
            cuadroEstilo_DosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        cuadroEstilo_DosLayout.setVerticalGroup(
            cuadroEstilo_DosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 220));

        cuadroEstilo_Tres.setBackground(new java.awt.Color(255, 35, 5));

        javax.swing.GroupLayout cuadroEstilo_TresLayout = new javax.swing.GroupLayout(cuadroEstilo_Tres);
        cuadroEstilo_Tres.setLayout(cuadroEstilo_TresLayout);
        cuadroEstilo_TresLayout.setHorizontalGroup(
            cuadroEstilo_TresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        cuadroEstilo_TresLayout.setVerticalGroup(
            cuadroEstilo_TresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 450, 300, 160));

        pnlFormularioSesion.setBackground(new java.awt.Color(255, 255, 255));

        btnIniciarSesion.setBackground(new java.awt.Color(4, 64, 98));
        btnIniciarSesion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar sesion");
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        separadorEstilo_Dos.setBackground(new java.awt.Color(4, 64, 98));
        separadorEstilo_Dos.setForeground(new java.awt.Color(4, 64, 98));
        separadorEstilo_Dos.setOpaque(true);

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 14))); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 64, 98)), "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Verdana", 1, 14))); // NOI18N
        txtPassword.setCaretColor(new java.awt.Color(4, 64, 98));
        txtPassword.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        separadorEstilo_Uno.setBackground(new java.awt.Color(4, 64, 98));
        separadorEstilo_Uno.setForeground(new java.awt.Color(4, 64, 98));
        separadorEstilo_Uno.setOpaque(true);

        lbAdvertencia.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbAdvertencia.setForeground(new java.awt.Color(255, 0, 0));
        lbAdvertencia.setToolTipText("");
        lbAdvertencia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        pnlBotonesMV.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotonesMV.setOpaque(false);

        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_iconos/ver.png"))); // NOI18N
        btnMostrar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        btnMostrar.setBorderPainted(false);
        btnMostrar.setContentAreaFilled(false);
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        pnlBotonesMV.add(btnMostrar);

        btnOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas_iconos/ocultar.png"))); // NOI18N
        btnOcultar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 102)));
        btnOcultar.setBorderPainted(false);
        btnOcultar.setContentAreaFilled(false);
        btnOcultar.setMinimumSize(new java.awt.Dimension(22, 22));
        btnOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcultarActionPerformed(evt);
            }
        });
        pnlBotonesMV.add(btnOcultar);

        javax.swing.GroupLayout pnlFormularioSesionLayout = new javax.swing.GroupLayout(pnlFormularioSesion);
        pnlFormularioSesion.setLayout(pnlFormularioSesionLayout);
        pnlFormularioSesionLayout.setHorizontalGroup(
            pnlFormularioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separadorEstilo_Dos, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(separadorEstilo_Uno, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlFormularioSesionLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(pnlFormularioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioSesionLayout.createSequentialGroup()
                        .addGroup(pnlFormularioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlBotonesMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(pnlFormularioSesionLayout.createSequentialGroup()
                        .addComponent(btnIniciarSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        pnlFormularioSesionLayout.setVerticalGroup(
            pnlFormularioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioSesionLayout.createSequentialGroup()
                .addGroup(pnlFormularioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFormularioSesionLayout.createSequentialGroup()
                        .addComponent(separadorEstilo_Dos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlBotonesMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addComponent(separadorEstilo_Uno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlPanelContenedor.add(pnlFormularioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 520, -1));

        cuadroEstilo_Cuatro.setBackground(new java.awt.Color(250, 15, 15));

        javax.swing.GroupLayout cuadroEstilo_CuatroLayout = new javax.swing.GroupLayout(cuadroEstilo_Cuatro);
        cuadroEstilo_Cuatro.setLayout(cuadroEstilo_CuatroLayout);
        cuadroEstilo_CuatroLayout.setHorizontalGroup(
            cuadroEstilo_CuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        cuadroEstilo_CuatroLayout.setVerticalGroup(
            cuadroEstilo_CuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, 70));

        cuadroEstilo_Cinco.setBackground(new java.awt.Color(29, 163, 83));

        javax.swing.GroupLayout cuadroEstilo_CincoLayout = new javax.swing.GroupLayout(cuadroEstilo_Cinco);
        cuadroEstilo_Cinco.setLayout(cuadroEstilo_CincoLayout);
        cuadroEstilo_CincoLayout.setHorizontalGroup(
            cuadroEstilo_CincoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        cuadroEstilo_CincoLayout.setVerticalGroup(
            cuadroEstilo_CincoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        cuadroEstilo_Seis.setBackground(new java.awt.Color(224, 203, 8));

        javax.swing.GroupLayout cuadroEstilo_SeisLayout = new javax.swing.GroupLayout(cuadroEstilo_Seis);
        cuadroEstilo_Seis.setLayout(cuadroEstilo_SeisLayout);
        cuadroEstilo_SeisLayout.setHorizontalGroup(
            cuadroEstilo_SeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        cuadroEstilo_SeisLayout.setVerticalGroup(
            cuadroEstilo_SeisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Seis, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, 60));

        cuadroEstilo_Siete.setBackground(new java.awt.Color(224, 203, 8));

        javax.swing.GroupLayout cuadroEstilo_SieteLayout = new javax.swing.GroupLayout(cuadroEstilo_Siete);
        cuadroEstilo_Siete.setLayout(cuadroEstilo_SieteLayout);
        cuadroEstilo_SieteLayout.setHorizontalGroup(
            cuadroEstilo_SieteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        cuadroEstilo_SieteLayout.setVerticalGroup(
            cuadroEstilo_SieteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        pnlPanelContenedor.add(cuadroEstilo_Siete, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 410, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
        AccesoBoton(evt);
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        MostraPassword(evt, btnMostrar, btnOcultar);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcultarActionPerformed
        // TODO add your handling code here:
        MostraPassword(evt, btnMostrar, btnOcultar);
    }//GEN-LAST:event_btnOcultarActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        lbAdvertencia.setText("");
        CambiarJTextField(txtPassword, evt);
        AccesoENTER(evt);
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        lbAdvertencia.setText("");
        CambiarJTextField(txtUsuario, evt);
        AccesoENTER(evt);
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Ventana_iniciarSesion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_iniciarSesion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_iniciarSesion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_iniciarSesion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_iniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnOcultar;
    private javax.swing.JPanel cuadroEstilo_Cinco;
    private javax.swing.JPanel cuadroEstilo_Cuatro;
    private javax.swing.JPanel cuadroEstilo_Dos;
    private javax.swing.JPanel cuadroEstilo_Seis;
    private javax.swing.JPanel cuadroEstilo_Siete;
    private javax.swing.JPanel cuadroEstilo_Tres;
    private javax.swing.JPanel cuadroEstilo_Uno;
    private javax.swing.JLabel lbAdvertencia;
    private javax.swing.JPanel pnlBotonesMV;
    private javax.swing.JPanel pnlFormularioSesion;
    private javax.swing.JPanel pnlPanelContenedor;
    private javax.swing.JSeparator separadorEstilo_Dos;
    private javax.swing.JSeparator separadorEstilo_Uno;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
