package juegotictactoe;

public class Tablero {
    private Casilla[] casillas;

    public Tablero() {
        casillas = new Casilla[9];
        for (int i = 0; i < 9; i++) {
            casillas[i] = new Casilla(i);
        }
    }

    public Casilla getCasilla(int posicion) {
        return casillas[posicion];
    }

    public boolean isLleno() {
        for (Casilla casilla : casillas) {
            if (!casilla.isOcupada()) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarVictoria(char jugador) {
        int[][] combinacionesGanadoras = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Filas
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columnas
            {0, 4, 8}, {2, 4, 6}             // Diagonales
        };

        for (int[] combo : combinacionesGanadoras) {
            if (casillas[combo[0]].getSimbolo() == jugador &&
                casillas[combo[1]].getSimbolo() == jugador &&
                casillas[combo[2]].getSimbolo() == jugador) {
                return true;
            }
        }
        return false;
    }
}