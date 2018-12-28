/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Nabeel
 */

class pos{
    int i;
    int j;

    public pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    public int get_i(){
        return i;
    }
    
    public int get_j(){
        return j;
    }
    
    
}



public class SudokuConsole {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
   
    
    public pos findNextEmpty(int[][] grid, int size)
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(grid[i][j]==0)
                {
                    return new pos(i,j);
                }

            }
        }
        return new pos(-1,-1); // no empty
    }
    
    public static boolean checkValidity(pos p,int[][] grid, int size)
    {
        for (int j = 0; j < size; j++) {
            //checking if selected value is matched in same row
            //and if it is different col (otherwise it is same position match)
            if ( grid[p.get_i()][j] == grid[p.get_i()][p.get_j()] && j != p.get_j()){
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            //checking if selected value is matched in same row
            //and if it is different col (otherwise it is same position match)
            if ( grid[i][p.get_j()] == grid[p.get_i()][p.get_j()] && i != p.get_i()){
                return false;
            }
        }        
        
        
        
        return true;
    }
    
    public static void main(String[] args)  {
 
        int size = 5;
        int[][] grid = new int[size][size];
        String s = new String();
        s = "003020600\n" +
            "900305001\n" +
            "001806400\n" +
            "008102900\n" +
            "700000008\n" +
            "006708200\n" +
            "002609500\n" +
            "800203009\n" +
            "005010300";
        char c;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
//                grid[i][j] = Integer.parseInt(s.charAt(i+j));
                c = s.charAt(i+j);
//                System.out.println(c);
                grid[i][j] = Integer.parseInt(String.valueOf(c));
//                System.out.println(s.charAt(i+j));
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        System.out.println(checkValidity(new pos(1,1),grid,size));
        
        
    }
    
}
