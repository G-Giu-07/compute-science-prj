import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Preprocessing {

  public static void main(String[] args) {
    if (args.length > 0) {
      File file = new File(args[0]);
    
      try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        File output = new File("output.txt");
        BufferedWriter writer = null;
        try {
         writer = new BufferedWriter(new FileWriter(output));
        } catch(Exception e) {}

        try {
          int i = 0;
          String str;

          while ((str = br.readLine()) != null) {
            String[] fields = str.split("\t", -1);

            // Contigue 1
            int s1    = Integer.parseInt(fields[5]);  // StartOverlap
            int e1    = Integer.parseInt(fields[6]);  // EndOverlap
            int size1 = Integer.parseInt(fields[7]);  // Size
            // Contigue 2
            int s2    = Integer.parseInt(fields[9]);  // StartOverlap
            int e2    = Integer.parseInt(fields[10]); // EndOverlap
            int size2 = Integer.parseInt(fields[11]); // Size

            if (e1-s1 != size1 && e2-s2 != size2) {
              writer.write(str + "\n");
            }

            i++;

            // if (i == 10) {
            //   break;
            // }
          }

          br.close();
          writer.close();
        } catch (IOException e) {
          System.out.println("IOException");
        }

      } catch(FileNotFoundException e) {
        System.out.println("File not found!");
      }
    }
  }

}
