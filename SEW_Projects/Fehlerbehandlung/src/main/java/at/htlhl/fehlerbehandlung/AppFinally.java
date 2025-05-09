package at.htlhl.fehlerbehandlung;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Fehlerbehandlung mit finally
 */

public class AppFinally {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/temp/text.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException ioe) {
            System.err.println("IOException");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
