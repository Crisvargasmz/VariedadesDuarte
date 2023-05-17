/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Controlador;

import Modelo.MenuBotones_color;
import Vista.Vista_categoria;
import Vista.Vista_cliente;
import Vista.Vista_compra;
import Vista.Vista_estadisticas;
import Vista.Vista_proveedor;
import Vista.Vista_venta;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Windows 10
 */
public class Controlador_Principal extends javax.swing.JFrame implements Runnable {

    String Hora, Minuto, Segundo, am_pm;
    Thread hilo;

    /**
     * Creates new form Controlador_Principal
     */
    public Controlador_Principal() {
        initComponents();
        setLocationRelativeTo(null);
        lbDate.setText(Fecha());

        hilo = new Thread(this);
        hilo.start();

        Vista_estadisticas vistaEstadistica = new Vista_estadisticas();
        vistaEstadistica.setSize(1290, 660);
        vistaEstadistica.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaEstadistica, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }

    //Metodo para mostrar la fecha
    public static String Fecha() {
        Date fecha = new Date();
        SimpleDateFormat Formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        return Formatofecha.format(fecha);
    }

    //Metodo para mostrar la hora
    public void Hora() {
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        am_pm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (am_pm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            Hora = h > 9 ? "" + h : "0" + h;

        } else {
            Hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        Minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        Segundo = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    //Este metodo corre la hora.
    public void run() {
        Thread current = Thread.currentThread();

        while (current == hilo) {
            Hora();
            lbTime.setText(Hora + ":" + Minuto + ":" + Segundo + "  " + am_pm);
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

        pnlMain = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bntCerrarSesion = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        pnlMostrarVentanas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        pnlTitulo.setBackground(new java.awt.Color(4, 64, 98));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N

        lbDate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        lbDate.setText("DD/MM/YYYY");
        lbDate.setMaximumSize(new java.awt.Dimension(174, 25));
        lbDate.setMinimumSize(new java.awt.Dimension(174, 25));
        lbDate.setPreferredSize(new java.awt.Dimension(174, 25));

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText("00:00:00");
        lbTime.setMaximumSize(new java.awt.Dimension(98, 25));
        lbTime.setMinimumSize(new java.awt.Dimension(98, 25));
        lbTime.setPreferredSize(new java.awt.Dimension(98, 25));

        lbUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lbUsuario.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("Usuario ( Nombre )");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);

        bntCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LoginSalir.png"))); // NOI18N
        bntCerrarSesion.setBorderPainted(false);
        bntCerrarSesion.setContentAreaFilled(false);
        bntCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbLogo)
                .addGap(146, 146, 146)
                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(bntCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTituloLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbLogo)))
                    .addGroup(pnlTituloLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnlMenu.setBackground(new java.awt.Color(29, 163, 83));
        pnlMenu.setLayout(new javax.swing.BoxLayout(pnlMenu, javax.swing.BoxLayout.LINE_AXIS));

        btnInicio.setBackground(new java.awt.Color(29, 163, 83));
        btnInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/HomeInicio.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setContentAreaFilled(false);
        btnInicio.setMaximumSize(new java.awt.Dimension(180, 60));
        btnInicio.setMinimumSize(new java.awt.Dimension(180, 60));
        btnInicio.setPreferredSize(new java.awt.Dimension(180, 60));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
        });
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        pnlMenu.add(btnInicio);

        btnCliente.setBackground(new java.awt.Color(29, 163, 83));
        btnCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add User MaleCliente.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setContentAreaFilled(false);
        btnCliente.setMaximumSize(new java.awt.Dimension(180, 60));
        btnCliente.setMinimumSize(new java.awt.Dimension(180, 60));
        btnCliente.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
        });
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCliente);

        btnVenta.setBackground(new java.awt.Color(29, 163, 83));
        btnVenta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add Shopping CartVenta.png"))); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.setContentAreaFilled(false);
        btnVenta.setMaximumSize(new java.awt.Dimension(180, 60));
        btnVenta.setMinimumSize(new java.awt.Dimension(180, 60));
        btnVenta.setPreferredSize(new java.awt.Dimension(180, 60));
        btnVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentaMouseEntered(evt);
            }
        });
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnVenta);

        btnCategoria.setBackground(new java.awt.Color(29, 163, 83));
        btnCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BoxCategoria.png"))); // NOI18N
        btnCategoria.setText("Categoria");
        btnCategoria.setContentAreaFilled(false);
        btnCategoria.setMaximumSize(new java.awt.Dimension(190, 60));
        btnCategoria.setMinimumSize(new java.awt.Dimension(190, 60));
        btnCategoria.setPreferredSize(new java.awt.Dimension(190, 60));
        btnCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseEntered(evt);
            }
        });
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCategoria);

        btnProveedor.setBackground(new java.awt.Color(29, 163, 83));
        btnProveedor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SupplierProveedor.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.setMaximumSize(new java.awt.Dimension(190, 60));
        btnProveedor.setMinimumSize(new java.awt.Dimension(190, 60));
        btnProveedor.setPreferredSize(new java.awt.Dimension(190, 60));
        btnProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProveedorMouseEntered(evt);
            }
        });
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        pnlMenu.add(btnProveedor);

        btnCompra.setBackground(new java.awt.Color(29, 163, 83));
        btnCompra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Full Shopping BasketComprar.png"))); // NOI18N
        btnCompra.setText("Compra");
        btnCompra.setContentAreaFilled(false);
        btnCompra.setMaximumSize(new java.awt.Dimension(180, 60));
        btnCompra.setMinimumSize(new java.awt.Dimension(180, 60));
        btnCompra.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCompraMouseEntered(evt);
            }
        });
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCompra);

        pnlMostrarVentanas.setBackground(new java.awt.Color(255, 255, 255));
        pnlMostrarVentanas.setLayout(new javax.swing.OverlayLayout(pnlMostrarVentanas));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlMostrarVentanas, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMostrarVentanas, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        // TODO add your handling code here:
        MenuBotones_color btn = new MenuBotones_color();
        btn.Activo(btnInicio);

    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
        Vista_estadisticas vistaEstadistica = new Vista_estadisticas();
        vistaEstadistica.setSize(1290, 660);
        vistaEstadistica.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaEstadistica, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        // TODO add your handling code here:
        MenuBotones_color btn = new MenuBotones_color();
        btn.Activo(btnCliente);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
        Vista_cliente vistaCliente = new Vista_cliente();
        vistaCliente.setSize(1290, 660);
        vistaCliente.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaCliente, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseEntered
        // TODO add your handling code here:
        MenuBotones_color btn = new MenuBotones_color();
        btn.Activo(btnVenta);
    }//GEN-LAST:event_btnVentaMouseEntered

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        // TODO add your handling code here:
        Vista_venta vistaVenta = new Vista_venta();
        vistaVenta.setSize(1290, 660);
        vistaVenta.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaVenta, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriaMouseEntered
        // TODO add your handling code here:
        MenuBotones_color btn = new MenuBotones_color();
        btn.Activo(btnCategoria);
    }//GEN-LAST:event_btnCategoriaMouseEntered

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
        Vista_categoria vistaCategoria = new Vista_categoria();
        vistaCategoria.setSize(1290, 660);
        vistaCategoria.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaCategoria, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorMouseEntered
        // TODO add your handling code here:
        MenuBotones_color btn = new MenuBotones_color();
        btn.Activo(btnProveedor);
    }//GEN-LAST:event_btnProveedorMouseEntered

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        Vista_proveedor vistaProveedor = new Vista_proveedor();
        vistaProveedor.setSize(1290, 660);
        vistaProveedor.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaProveedor, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnCompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraMouseEntered
        // TODO add your handling code here:
        MenuBotones_color btn = new MenuBotones_color();
        btn.Activo(btnCompra);
    }//GEN-LAST:event_btnCompraMouseEntered

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        // TODO add your handling code here:
        Vista_compra vistaCompra = new Vista_compra();
        vistaCompra.setSize(1290, 660);
        vistaCompra.setLocation(0, 0);
        pnlMostrarVentanas.removeAll();
        pnlMostrarVentanas.add(vistaCompra, BorderLayout.CENTER);
        pnlMostrarVentanas.revalidate();
        pnlMostrarVentanas.repaint();
    }//GEN-LAST:event_btnCompraActionPerformed

    private void bntCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCerrarSesionActionPerformed
        // TODO add your handling code here:
        Ventana_iniciarSesion iniciarSesion = new Ventana_iniciarSesion();
        iniciarSesion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bntCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Controlador_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controlador_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controlador_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controlador_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCerrarSesion;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnVenta;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMostrarVentanas;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
