package GameOfLife;
import GameOfLife.Cell.Cell;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    GameOfLife gol;

    @Test
    void getAliveNeighboursOfCornerCaseCell() {
        int[][] grid = new int[][]{
                {0,1,0,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0}
        };
        gol = new GameOfLife(grid);
        gol.startGame();
        Cell c = new Cell(0,0);
        assertEquals(3,gol.getAliveAmountOfNeighbours(c));

    }

    @Test
    void getAliveNeighborsOfCenterCaseCell(){
        int[][] grid = new int[][]{
                {0,1,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0}
        };
        gol = new GameOfLife(grid);
        Cell c = new Cell(1,1);
        assertEquals(5,gol.getAliveAmountOfNeighbours(c));
    }

    @Test
    void givenGridMaxSizeNotSquareGridWithGridConstructor_test() {
        int[][] grid = new int[][]{
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,0,0,0}
        };
        gol = new GameOfLife(grid);
        assertEquals(15, gol.getCurrentGenerationCells().size());
    }

    @Test
    void addAliveCellsToListWithCellsCheckIfAlive(){
        int[][] grid = new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };
        gol = new GameOfLife(grid);
        gol.startGame();
        gol.getCurrentGenerationCells().get(92).alive();
        gol.getCurrentGenerationCells().get(93).alive();
        gol.getCurrentGenerationCells().get(94).alive();
        gol.getCurrentGenerationCells().get(95).alive();
        Cell c1 = new Cell(5,8);
        Cell c2 = new Cell(9,4);
        gol.getAliveAmountOfNeighbours(c1);
        assertEquals(2, gol.getAliveAmountOfNeighbours(c2));
    }



    @Test
    void givenStartValueExpectLastPrintToConsole(){
        int[][] grid = new int[][]{
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        String arrayAsString =  "\n.,.,.,.,.,"+
                                "\n.,*,*,*,.," +
                                "\n.,.,.,.,.," +
                                "\n.,.,.,.,.," +
                                "\n.,.,.,.,.,";

        gol = new GameOfLife(grid);
        assertEquals(arrayAsString, gol.toString());
    }

    @Test
    void runGameUntilPatternRepeats(){
        int[][] grid = new int[][]{
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        gol = new GameOfLife(grid);
        gol.startGame();
        assertEquals(3, gol.getAllGenerationsAsStringList().size());

    }

    @Test
    void runGameUntilPatternRepeatsWithLargerGrid(){
        int[][] grid = new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0}
        };
        gol = new GameOfLife(grid);
        gol.startGame();
        assertEquals(7, gol.getAllGenerationsAsStringList().size());

    }

    @Test
    void testThroughWholeApp() {
        int[][] grid = new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };
        int[][] grid2 = new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

        gol = new GameOfLife(grid);
        gol.startGame();
        assertEquals(gol.convertListOfCellsToString(gol.convertGridToList(grid2)),
                gol.getAllGenerationsAsStringList().get(4));
    }

    @Test
    void testIfNeighborToTheLeftIsDeadReturn0(){
        int[][] grid1er =  new int[][]{{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        gol = new GameOfLife(grid1er);
        Cell cell = new Cell(1, 1);
        assertEquals(0, gol.getAliveAmountOfNeighbours(cell));
    }

    @Test
    void givenNeighborAboveLeftIsAliveThenAliveAmountOfNeighboursIs1(){
        int[][] grid1er =  new int[][]{{1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        gol = new GameOfLife(grid1er);
        Cell cell = new Cell(1, 1);
        assertEquals(1, gol.getAliveAmountOfNeighbours(cell));
    }

    @Test
    void givenNeighborAboveCenterAndAboveRightIsAliveThenAliveAmountOfNeighboursIs2(){
        int[][] grid1er =  new int[][]{{0, 1, 1},
                {0, 0, 0},
                {0, 0, 0}};
        gol = new GameOfLife(grid1er);
        Cell cell = new Cell(1, 1);
        assertEquals(2, gol.getAliveAmountOfNeighbours(cell));
    }

    @Test
    void givenNeighborToTheRightAndDownCenterIsAliveThenAliveAmountOfNeighboursIs2(){
        int[][] grid1er =  new int[][]{{0, 0, 0},
                {1, 0, 0},
                {0, 1, 0}};
        gol = new GameOfLife(grid1er);
        Cell cell = new Cell(1, 1);
        assertEquals(2, gol.getAliveAmountOfNeighbours(cell));
    }

}