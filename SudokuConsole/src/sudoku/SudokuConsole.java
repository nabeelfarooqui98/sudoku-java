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
     */
   
    
    public static pos findNextEmpty(int[][] grid, int size)
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
            //checking if selected value is matched in same col
            //and if it is different row (otherwise it is same position match)
            if ( grid[i][p.get_j()] == grid[p.get_i()][p.get_j()] && i != p.get_i()){
                return false;
            }
        }        
        int myval = grid[p.get_i()][p.get_j()];
        int myi = p.get_i();
        int myj = p.get_j();
        if(myi%3 == 0 && myj%3 == 0) //3x3 ka top left
        {
            if(myval == grid[myi][myj+1]) return false;
            if(myval == grid[myi][myj+2]) return false;
            if(myval == grid[myi+1][myj]) return false;
            if(myval == grid[myi+1][myj+1]) return false;
            if(myval == grid[myi+1][myj+2]) return false;
            if(myval == grid[myi+2][myj]) return false;
            if(myval == grid[myi+2][myj+1]) return false;
            if(myval == grid[myi+2][myj+2]) return false;
            
        }
        else if(myi%3 == 0 && myj%3 == 1) //3x3 ka top mid
        {
            if(myval == grid[myi][myj-1]) return false;
            if(myval == grid[myi][myj+1]) return false;
            if(myval == grid[myi+1][myj-1]) return false;
            if(myval == grid[myi+1][myj]) return false;
            if(myval == grid[myi+1][myj+1]) return false;
            if(myval == grid[myi+2][myj-1]) return false;
            if(myval == grid[myi+2][myj]) return false;
            if(myval == grid[myi+2][myj+1]) return false;
            
        }
        else if(myi%3 == 0 && myj%3 == 2) //3x3 ka top right
        {
            if(myval == grid[myi][myj-1]) return false;
            if(myval == grid[myi][myj-2]) return false;
            if(myval == grid[myi+1][myj]) return false;
            if(myval == grid[myi+1][myj-1]) return false;
            if(myval == grid[myi+1][myj-2]) return false;
            if(myval == grid[myi+2][myj]) return false;
            if(myval == grid[myi+2][myj-1]) return false;
            if(myval == grid[myi+2][myj-2]) return false;
            
        }
        else if(myi%3 == 1 && myj%3 == 0) //3x3 ka mid left
        {
            if(myval == grid[myi-1][myj]) return false;
            if(myval == grid[myi-1][myj+1]) return false;
            if(myval == grid[myi-1][myj+2]) return false;
            if(myval == grid[myi][myj+1]) return false;
            if(myval == grid[myi][myj+2]) return false;
            if(myval == grid[myi+1][myj]) return false;
            if(myval == grid[myi+1][myj+1]) return false;
            if(myval == grid[myi+1][myj+2]) return false;
            
        }
        else if(myi%3 == 1 && myj%3 == 1) //3x3 ka mid mid
        {
            if(myval == grid[myi-1][myj-1]) return false;
            if(myval == grid[myi-1][myj]) return false;
            if(myval == grid[myi-1][myj+1]) return false;
            if(myval == grid[myi][myj-1]) return false;
            if(myval == grid[myi][myj+1]) return false;
            if(myval == grid[myi+1][myj-1]) return false;
            if(myval == grid[myi+1][myj]) return false;
            if(myval == grid[myi+1][myj+1]) return false;
            
        }
        else if(myi%3 == 1 && myj%3 == 2) //3x3 ka mid right
        {
            if(myval == grid[myi-1][myj-2]) return false;
            if(myval == grid[myi-1][myj-1]) return false;
            if(myval == grid[myi-1][myj]) return false;
            if(myval == grid[myi][myj-2]) return false;
            if(myval == grid[myi][myj-1]) return false;
            if(myval == grid[myi+1][myj]) return false;
            if(myval == grid[myi+1][myj-1]) return false;
            if(myval == grid[myi+1][myj-2]) return false;            
        }
        else if(myi%3 == 2 && myj%3 == 0) //3x3 ka bottom left
        {
            if(myval == grid[myi-2][myj]) return false;
            if(myval == grid[myi-2][myj+1]) return false;
            if(myval == grid[myi-2][myj+2]) return false;
            if(myval == grid[myi-1][myj]) return false;
            if(myval == grid[myi-1][myj+1]) return false;
            if(myval == grid[myi-1][myj+2]) return false;
            if(myval == grid[myi][myj+1]) return false;
            if(myval == grid[myi][myj+2]) return false;
            //done till here
        }
        else if(myi%3 == 2 && myj%3 == 1) //3x3 ka bottom mid
        {
            if(myval == grid[myi-2][myj-1]) return false;
            if(myval == grid[myi-2][myj]) return false;
            if(myval == grid[myi-2][myj+1]) return false;
            if(myval == grid[myi-1][myj]) return false;
            if(myval == grid[myi-1][myj-1]) return false;
            if(myval == grid[myi-1][myj+1]) return false;
            if(myval == grid[myi][myj-1]) return false;
            if(myval == grid[myi][myj+1]) return false;
            
        }
        else if(myi%3 == 2 && myj%3 == 2) //3x3 ka bottom right
        {
            if(myval == grid[myi-2][myj-2]) return false;
            if(myval == grid[myi-2][myj-1]) return false;
            if(myval == grid[myi-2][myj]) return false;
            if(myval == grid[myi-1][myj-2]) return false;
            if(myval == grid[myi-1][myj-1]) return false;
            if(myval == grid[myi-1][myj]) return false;
            if(myval == grid[myi][myj-1]) return false;
            if(myval == grid[myi][myj-2]) return false;            
        }
        
        return true;
    }
 
    public static void solve(int grid[][], int size)
    {
        while(findNextEmpty(grid, size).get_i() != -1 )
        {
            pos p = new pos(0, 0);
            p = findNextEmpty(grid, size);
//            if(p.get_i() == -1) break;
            //System.out.println("i and j: " + p.get_i() + " " + p.get_j());
            
            for (int x = 1; x <= 9; x++) {
                grid[p.get_i()][p.get_j()] = x;
                if (checkValidity(p, grid, size) == true)
                {
                    solve(grid, size);
                    pos o = new pos(0, 0);
                    o = findNextEmpty(grid, size);
                    if(o.get_i()==-1)
                        break;
            
                }
            }
        }
    }
    
    public static void main(String[] args)  {
 
        int size = 9;
        int[][] grid = new int[size][size];
        String s = new String();
        s = "003020600" +
            "900305001" +
            "001806400" +
            "008102900" +
            "700000008" +
            "006708200" +
            "002609500" +
            "800203009" +
            "005010300";
        char c;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
//                grid[i][j] = Integer.parseInt(s.charAt(i+j));
                c = s.charAt(i*size+j);
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

//        System.out.println(checkValidity(new pos(1,3),grid,size));
        
        solve(grid, size);
        
        System.out.println("");
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        
//      System.out.println(checkValidity(new pos(2,0),grid,size));
        

    }
    
}
