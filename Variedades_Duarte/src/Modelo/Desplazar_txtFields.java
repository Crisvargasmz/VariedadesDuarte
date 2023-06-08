/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
public class Desplazar_txtFields {

    //Metodo para cambiar tipeo entre JTextFields.
    public void CambiarJTextField(JTextField JTexFieldUno, java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            JTexFieldUno.requestFocus();
        }
    }
    public void Desplazar (KeyEvent evt, JTextField siguiente, JTextField antes){
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            CambiarJTextField(siguiente, evt);
        }else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            CambiarJTextField(antes, evt);
        }
    }
}
