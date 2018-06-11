import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaTest {

    @Test
    public void newSquareIsEmpty() {
        Casilla c = new Casilla();
        assertFalse(c.isOccupied());
    }

    @Test
    public void constructorWithChipSquareIsOccupied() {
        Casilla c = new Casilla('X');
        assertTrue(c.isOccupied());
    }

    @Test
    public void whenChipIsSetSquareIsOccupied() {
        Casilla c = new Casilla();
        c.setChip('X');
        assertTrue(c.isOccupied());
    }
}
