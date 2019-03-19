/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author phutiM
 */
public class Assignment {
    
    public static void calculatePath(char[][] map) {
        int N = map.length;
        
        List<Cell> queue = new ArrayList<Cell>();
        queue.add(new Cell(4, 0));
        boolean pathExists = false;
        
        while(!queue.isEmpty()) {
            Cell current = queue.remove(0);
            if(map[current.x][current.y] == 'E') {
                pathExists = true;
                break;
            }
            
            map[current.x][current.y] = '"'; // mark as visited
            
            List<Cell> adjacents = getAdjacents(map, current);
            queue.addAll(adjacents);
        }
        printMap(map);
        
    }
    private static void printMap(char[][] map) {
            for (int rows = 0; rows < 10; rows++) {
                for (int columns = 0; columns < 20; columns++) {
                    System.out.print(map[rows][columns]);
                }
                System.out.println();
            }
    }
    
    public static List<Cell> getAdjacents(char[][] map, Cell cell) {
        List<Cell> adjacents = new ArrayList<Cell>();
        
        if(isValidMove(map, cell.x - 1, cell.y)) {
            adjacents.add(new Cell(cell.x - 1, cell.y));
        }
        
        if(isValidMove(map, cell.x + 1, cell.y)) {
            adjacents.add(new Cell(cell.x + 1, cell.y));
        }
        
        if(isValidMove(map, cell.x, cell.y - 1)) {
            adjacents.add(new Cell(cell.x, cell.y - 1));
        }
        
        if(isValidMove(map, cell.x, cell.y + 1)) {
            adjacents.add(new Cell(cell.x, cell.y + 1));
        }
        
        return adjacents;
    }
    
    public static boolean isValidMove(char[][] map, int x, int y) {
        return !(x < 0 || x >= map.length || y < 0 || y >= map.length) && (map[x][y] != 'W');
    }
    
    
    public static void main(String args[]) throws FileNotFoundException
    {
        int rows = 10;
        int columns = 20;
        char[][] map = new char[rows][columns];
        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Dev\\map.txt")));
        while (sc.hasNextLine()) {
            for (rows = 0; rows < 10; rows++) {
                String line = sc.nextLine().trim();
                char[] ch = line.toCharArray();
                for (columns = 0; columns < 20; columns++) {
                    map[rows][columns] = ch[columns];
                }
            }
        }
        System.out.print(Arrays.deepToString(map));
        calculatePath(map);
        
      
    }

    
    
    
}
