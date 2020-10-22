package GameOfLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    private List<int[][]> listOfGenerations;

    //private Grid grid;

    public GameOfLife(){

    }

    /*public GameOfLife(Grid newGrid) {
    grid = newGrid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void startNewGame(Grid newGrid) {
        grid = newGrid;
    }
*/

    public void startGame(int[][] grid){
        listOfGenerations = new ArrayList<>();
        listOfGenerations.add(grid);
    }

    public List<int[][]> getListOfGenerations(){
        return listOfGenerations;
    }


    public int[][] nextGeneration() {
        return listOfGenerations.get(listOfGenerations.size()-1);
    }

    public boolean lastGenerationSameAsNext() {
        return Arrays.equals(listOfGenerations.get(listOfGenerations.size() - 1), listOfGenerations.get(listOfGenerations.size() - 2));
    }

    public int getAliveNeighbours(int i) {
        return 2;
    }
}


