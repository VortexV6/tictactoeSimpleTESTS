import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JuegoTest {

    @Test
    public void whenBoardIsFullGameIsOver () {
        Casilla[][] board = createFullBoard();
        Juego game = new Juego(new Tablero(board), new Player[0]);
        assertTrue(game.isOver());
    }
    
    @Test
    public void whoWonWhenXHasColumnReturnsX(){
        Casilla[][] board = new Casilla[3][3];

        Casilla cn = mock(Casilla.class);
        when(cn.getChip()).thenReturn(' ');
        when(cn.isOccupied()).thenReturn(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = cn;
            }
        }

        Casilla cx = mock(Casilla.class);
        when(cx.getChip()).thenReturn('x');
        when(cx.isOccupied()).thenReturn(true);
        for (int i = 0; i < 3; i++) {
            board[i][0] = cx;
        }

        Player[] players = createPlayers();

        Juego game = new Juego(new Tablero(board),players);
        assertEquals(game.whoWon(),players[0]);
    }
    
    @Test
    public void whoWonWhenXHasLineReturnsX(){
        Casilla[][] board = new Casilla[3][3];

        Casilla cn = mock(Casilla.class);
        when(cn.getChip()).thenReturn(' ');
        when(cn.isOccupied()).thenReturn(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = cn;
            }
        }

        Casilla cx = mock(Casilla.class);
        when(cx.getChip()).thenReturn('x');
        when(cx.isOccupied()).thenReturn(true);
        for (int i = 0; i < 3; i++) {
            board[0][i] = cx;
        }

        Player[] players = createPlayers();

        Juego game = new Juego(new Tablero(board),players);
        assertEquals(game.whoWon(),players[0]);
    }

    @Test
    public void whoWonWhenXDiagonalLineReturnsX(){
        Casilla[][] board = new Casilla[3][3];

        Casilla cn = mock(Casilla.class);
        when(cn.getChip()).thenReturn(' ');
        when(cn.isOccupied()).thenReturn(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = cn;
            }
        }

        Casilla cx = mock(Casilla.class);
        when(cx.getChip()).thenReturn('x');
        when(cx.isOccupied()).thenReturn(true);
        for (int i = 0; i < 3; i++) {
            board[i][i] = cx;
        }

        Player[] players = createPlayers();

        Juego game = new Juego(new Tablero(board),players);
        assertEquals(game.whoWon(),players[0]);
    }

    @Test
    public void whoWonWhenXHasInvertedDiagonalReturnsX(){
        Casilla[][] board = new Casilla[3][3];

        Casilla cn = mock(Casilla.class);
        when(cn.getChip()).thenReturn(' ');
        when(cn.isOccupied()).thenReturn(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = cn;
            }
        }

        Casilla cx = mock(Casilla.class);
        when(cx.getChip()).thenReturn('x');
        when(cx.isOccupied()).thenReturn(true);
        board[0][2] = cx;
        board[1][1] = cx;
        board[2][0] = cx;

        Player[] players = createPlayers();

        Juego game = new Juego(new Tablero(board),players);
        assertEquals(game.whoWon(),players[0]);
    }

    @Test
    public void whoWhonReturnsNullWhenNobodyWon(){
        Casilla[][] board = new Casilla[3][3];

        Casilla cn = mock(Casilla.class);
        when(cn.getChip()).thenReturn(' ');
        when(cn.isOccupied()).thenReturn(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = cn;
            }
        }

        Player[] players = createPlayers();

        Juego game = new Juego(new Tablero(board),players);
        assertEquals(game.whoWon(),null);
    }
    
    // metodos con mockito
    
    private Casilla[][] createFullBoard() {
        Casilla[][] board = new Casilla[3][3];
        Casilla occupiedSquare = mock(Casilla.class);
        when(occupiedSquare.isOccupied()).thenReturn(true);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = occupiedSquare;
            }
        }
        return board;
    }
    private Player[] createPlayers(){
        Player[] players = new Player[2];
        Player playerX = mock(Player.class);
        when(playerX.getChip()).thenReturn('x');
        Player o = mock(Player.class);
        when(o.getChip()).thenReturn('o');
        players[0] = playerX;
        players[1] = o;
        return players;
    }
}
