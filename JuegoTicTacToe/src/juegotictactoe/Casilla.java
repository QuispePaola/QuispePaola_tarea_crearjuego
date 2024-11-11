package juegotictactoe;

public class Casilla {
    private int posicion; // Posición en el tablero (0-8)
    private char simbolo; // 'X' o 'O'
    private boolean ocupada; // Estado de ocupación

    public Casilla(int posicion) {
        this.posicion = posicion;
        this.simbolo = ' ';
        this.ocupada = false;
    }

    public int getPosicion() {
        return posicion;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void colocar(char simbolo) {
        this.simbolo = simbolo;
        this.ocupada = true;
    }
}