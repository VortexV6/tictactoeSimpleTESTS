public class Tablero {
    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[3][3];
    }

    public Tablero(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public Casilla getCasilla(Posicion pos) {
        return casillas[pos.getX()][pos.getY()];
    }

    public void setCasilla(char chip, Posicion pos) {
        casillas[pos.getX()][pos.getY()].setChip(chip);
    }

    public void setCasilla(Casilla casilla, Posicion pos) {
        casillas[pos.getX()][pos.getY()] = casilla;
    }
}
