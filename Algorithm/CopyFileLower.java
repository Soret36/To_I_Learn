import java.util.*;
import java.io.*;
public class CopyFileLower {
    public static void main(String[] args) {
        String stringTo, stringFrom;
        BufferedReader fileStreamFrom;
        BufferedWriter fileStreamTo;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Copy From: ");
        stringFrom = scanner.nextLine();
        System.out.println("Copy To: ");
        stringTo = scanner.nextLine();
        scanner.close();

        try {
            FileReader inputFile = new FileReader(stringFrom);
            File outputFile = new File(stringTo);

            fileStreamFrom = new BufferedReader(inputFile);  
            fileStreamTo = new BufferedWriter(new FileWriter(outputFile));

            String stringbuffer = "";

            while((stringbuffer = fileStreamFrom.readLine()) != null) {
                stringbuffer = stringbuffer.toLowerCase();
                fileStreamTo.write(stringbuffer);
                fileStreamTo.write("\n");
            }

            fileStreamFrom.close();
            fileStreamTo.close();
        }

        catch(FileNotFoundException e ) {
            System.out.println("File " + stringFrom + " not found");
        } 
        catch(IOException e) {
            System.out.println("Problem occured when try to writing file");
        }
    }
}