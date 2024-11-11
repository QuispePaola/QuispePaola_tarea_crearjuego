package juegotictactoe;

import javax.swing.*;

public class Movimiento {
    public static void animarCasilla(JButton boton, char simbolo) {
        boton.setText(String.valueOf(simbolo));
        boton.setEnabled(false);
    }
}