package rocks.zipcodewilmington.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author leon on 6/20/18.
 */
public class PlayerWinsColumn1Test {

    private Board board;

    @Before
    public void setup() {
        // Given
        this.board = new Board(new Character[][]{
                {'X', 'O', ' '},
                {'X', ' ', ' '},
                {'X', 'O', ' '}
        });
    }

    @Test
    public void getWinnerTest() {
        // Given
        String expectedWinner = "X";

        // When
        String actualWinner = board.getWinner();

        // Then
        Assert.assertEquals(expectedWinner, actualWinner);
    }



    @Test
    public void isInFavorOfPlayerOTest() {
        // Given
        Boolean expected = false;

        // When
        Boolean actual = board.isInFavorOfO();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void isInFavorOfPlayerXTest() {
        // Given
        Boolean expected = true;

        // When
        Boolean actual = board.isInFavorOfX();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTieTest() {
        // Given
        Boolean expected = false;

        // When
        Boolean actual = board.isTie();

        // Then
        Assert.assertEquals(expected, actual);

    }


}
