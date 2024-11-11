package juegotictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class JuegoTicTacToe extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L; // Agregar serialVersionUID
    private Tablero tablero;
    private char jugadorActual;
    private JButton[] botones;

    public JuegoTicTacToe() {
        tablero = new Tablero();
        jugadorActual = 'X';
        botones = new JButton[9];

        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));
        inicializarBotones();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    private void inicializarBotones() {
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton();
            final int index = i;
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!tablero.getCasilla(index).isOcupada()) {
                        tablero.getCasilla(index).colocar(jugadorActual);
                        Movimiento.animarCasilla(botones[index], jugadorActual);
                        if (tablero.verificarVictoria(jugadorActual)) {
                            JOptionPane.showMessageDialog(null, "¡Jugador " + jugadorActual + " gana!");
                            reiniciarJuego();
                        } else if (tablero.isLleno()) {
                            JOptionPane.showMessageDialog(null, "¡Es un empate!");
                            reiniciarJuego();
                        }
                        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X'; // Cambiar de jugador
                    }
                }
            });
            add(botones[i]);
        }
    }

    private void reiniciarJuego() {
        tablero = new Tablero();
        for (JButton boton : botones) {
            boton.setText("");
            boton.setEnabled(true);
        }
        jugadorActual = 'X'; // Reiniciar al jugador X
    }

    public static void main(String[] args) {
        new JuegoTicTacToe();
    }
}