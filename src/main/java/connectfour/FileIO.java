package connectfour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * This class is a Template for the FileIO Object
 *
 * This class is responsible for handling: 
 * File input for matrices using CSV file format
 * File output for matrices using CSV file format
 * </p>
 * @author Wali Temuri - 1183379
 */
public class FileIO {
    
    /**
     * Reads line by line from CSV file
     * Splits comma delimited integers and parses them into matrix
     * Returns int matrix
     * 
     * @param String containing the file name 
     * @return int[][]
     */
    public int[][] fileReader(String fileName) {
        String filePath = "/course/coursework/A2/assets/";
        filePath = filePath.concat(fileName);

        int j= 0;
        int i = 0;
        int[][] matrix = new int[6][7];

        try(BufferedReader myReader = new BufferedReader(new FileReader(filePath))){
            String oneLine = myReader.readLine();
            while(oneLine != null) {
                System.out.println(oneLine);
                String[] arrOfStr = oneLine.split(",", 7);

                for (j = 0; j < 7; j++) {
                    matrix[i][j] = Integer.parseInt(arrOfStr[j]);
                }
                i++;
                oneLine = myReader.readLine();
            }
        }catch (IOException e) {
            System.out.println("File Error");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return matrix;
    }
    /**
     * Reads writes line by line in desired CSV file
     * Takes entries in integer matrix and constructs a line to print
     * 
     * @param Int[][]
     * @return void
     */
    public void fileWriter(int[][] matrix) {

        String filePath = "/course/coursework/A2/assets/saveFile.csv";
        String line = "";
        int i = 0;

        for (i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                line = line + Integer.toString(matrix[i][j]) + ",";
            }

            line = line.substring(0, line.length() - 1);

            if(i < 5) {
                line = line.concat("\n");
            } 

            try(PrintWriter myWriter = new PrintWriter(new FileWriter(filePath, false))) {
                myWriter.print(line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}