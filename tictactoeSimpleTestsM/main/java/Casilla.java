public class Casilla {
    private boolean occupied;
    private char chip;

    public Casilla() {
        occupied = false;
    }

    public Casilla(char chip) {
        this.setChip(chip);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public char getChip() {
        return chip;
    }

    public void setChip(char chip) {
        occupied = true;
        this.chip = chip;
    }
}
