/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Windows 10
 */
public class MenuBotones_color {

    //Metodo para jugar con los colores de los botones que muestran Positivo.
    public void Activo(JButton btnActivo) {

        btnActivo.setBackground(new Color(0, 151, 167));
        btnActivo.setForeground(new Color(255, 255, 255));
        btnActivo.setFont(new Font("Tahoma", 1, 18));
        btnActivo.setContentAreaFilled(true);
        btnActivo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent arg) {

                btnActivo.setBackground(new Color(0, 151, 167));
                btnActivo.setForeground(new Color(255, 255, 255));
                btnActivo.setFont(new Font("Tahoma", 1, 18));
                btnActivo.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnActivo.setBackground(new Color(29, 163, 83));
                btnActivo.setForeground(new Color(255, 255, 255));
                btnActivo.setFont(new Font("Tahoma", 1, 18));
                btnActivo.setContentAreaFilled(false);
            }

        });
    }

    public void SubMenu(JButton btnMenu, JPanel subMenu) {

        btnMenu.setBackground(new Color(0, 151, 167));
        btnMenu.setForeground(new Color(255, 255, 255));
        btnMenu.setFont(new Font("Tahoma", 1, 18));
        btnMenu.setContentAreaFilled(true);
        subMenu.setVisible(true);
        btnMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent arg) {

                btnMenu.setBackground(new Color(0, 151, 167));
                btnMenu.setForeground(new Color(255, 255, 255));
                btnMenu.setFont(new Font("Tahoma", 1, 18));
                btnMenu.setContentAreaFilled(true);
                subMenu.setVisible(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMenu.setBackground(new Color(29, 163, 83));
                btnMenu.setForeground(new Color(255, 255, 255));
                btnMenu.setFont(new Font("Tahoma", 1, 18));
                btnMenu.setContentAreaFilled(false);
                btnMenu.setVisible(false);
                subMenu.setVisible(false);
            }

        });
    }

    public void SubMenuInverso(JButton btnMenu, JPanel subMenu) {

        btnMenu.setBackground(new Color(29, 163, 83));
        btnMenu.setForeground(new Color(255, 255, 255));
        btnMenu.setFont(new Font("Tahoma", 1, 18));
        btnMenu.setContentAreaFilled(false);
        btnMenu.setVisible(false);
        subMenu.setVisible(false);
        btnMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent arg) {

                btnMenu.setBackground(new Color(29, 163, 83));
                btnMenu.setForeground(new Color(255, 255, 255));
                btnMenu.setFont(new Font("Tahoma", 1, 18));
                btnMenu.setContentAreaFilled(false);
                btnMenu.setVisible(false);
                subMenu.setVisible(false);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMenu.setBackground(new Color(0, 151, 167));
                btnMenu.setForeground(new Color(255, 255, 255));
                btnMenu.setFont(new Font("Tahoma", 1, 18));
                btnMenu.setContentAreaFilled(true);
                subMenu.setVisible(true);
            }

        });
        //Metodo para poner fondo blanco a los botones Agregar, Editar, Actualizar, Limpiar Campos, Borrar.
        //Este metodo se utiliza cuando se crean los botones agregar, editar, actualizar,eliminar.
//    public void inicioVerde(JButton btnUno, JButton btnDos, JButton btnTres, JButton btnCuatro, JButton btnCinco) {
//        Color myColor = new Color (29,163,83);
//         Font FL = new Font("Roboto" ,2, 28);
//        btnUno.setBackground(myColor);
//        btnUno.setFont(FL);
//        btnDos.setBackground(myColor);
//        btnDos.setFont(FL);
//        btnTres.setBackground(myColor);
//        btnTres.setFont(FL);
//        btnCuatro.setBackground(myColor);
//        btnCuatro.setFont(FL);
//        btnCinco.setBackground(myColor);
//        btnCinco.setFont(FL);
//    }
    }

    public void Ocultar(JButton boton1) {
        if (boton1.isVisible()) {
            boton1.setVisible(false);
        } else {
            boton1.setVisible(true);
        }
    }
}
