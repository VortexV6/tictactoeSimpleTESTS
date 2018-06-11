public class Juego {
    private Tablero tablero;
    private Player[] players;

    public Juego(Tablero tablero, Player[] players) {
        this.tablero = tablero;
        this.players = players;
    }

    public boolean isOver() {
        if (isFull()) {
            return true;
        }
        if (whoWon() != null) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        boolean isFull = true;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Posicion pos = new Posicion(x, y);
                if (!tablero.getCasilla(pos).isOccupied()) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public Player whoWon() {
        for (Player player: players) {
            if (hasWon(player)) {
                return player;
            }
        }
        return null;
    }

    private boolean hasWon(Player player) {
        if (hasRow(player)) {
            return true;
        }
        if (hasColumn(player)) {
            return true;
        }
        if (hasDiagonal(player)) {
            return true;
        }
        return false;
    }

    private boolean hasRow(Player player) {
        boolean fullLine;
        for (int x = 0; x < 3; x++) {
            fullLine = true;
            for (int y = 0; y < 3; y++) {
                Posicion pos = new Posicion(x, y);
                if(tablero.getCasilla(pos).getChip() != player.getChip()) {
                    fullLine = false;
                }
            }
            if (fullLine) {
                return true;
            }
        }
        return false;
    }

    private boolean hasColumn(Player player) {
        boolean fullColumn;
        for (int y = 0; y < 3; y++) {
            fullColumn = true;
            for (int x = 0; x < 3; x++) {
                Posicion pos = new Posicion(x, y);
                if(tablero.getCasilla(pos).getChip() != player.getChip()) {
                    fullColumn = false;
                }
            }
            if (fullColumn) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDiagonal(Player player) {
        if (hasRightDiagonal(player)) {
            return true;
        }
        if (hasLeftDiagonal(player)) {
            return true;
        }
        return false;
    }

    private boolean hasRightDiagonal(Player player) {
        Posicion pos1 = new Posicion(0, 0);
        Posicion pos2 = new Posicion(1, 1);
        Posicion pos3 = new Posicion(2, 2);
        if (tablero.getCasilla(pos1).getChip() == tablero.getCasilla(pos2).getChip() && tablero.getCasilla(pos2).getChip() ==
                tablero.getCasilla(pos3).getChip() && tablero.getCasilla(pos3).getChip() == player.getChip()) {
            return true;
        }
        return false;
    }

    private boolean hasLeftDiagonal(Player player) {
        Posicion pos1 = new Posicion(0, 2);
        Posicion pos2 = new Posicion(1, 1);
        Posicion pos3 = new Posicion(2, 0);
        if (tablero.getCasilla(pos1).getChip() == tablero.getCasilla(pos2).getChip() && tablero.getCasilla(pos2).getChip() ==
                tablero.getCasilla(pos3).getChip() && tablero.getCasilla(pos3).getChip() == player.getChip()) {
            return true;
        }
        return false;
    }
}
