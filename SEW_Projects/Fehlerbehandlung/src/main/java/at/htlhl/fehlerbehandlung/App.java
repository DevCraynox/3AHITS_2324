package at.htlhl.fehlerbehandlung;

import java.util.ArrayList;

/**
 * Fehlerbehandlung
 */

public class App {

    // Main *******************************************************************

    public static void main(String[] args) {
        try {
            // int wert = Integer.valueOf("Keine Zahl");    <- wirft eine NumberFormatException
            int wert = Integer.valueOf("12");
            ArrayList<String> nameList = null;           // <- wirft eine NullPointerException
            nameList.add("Marcel");
        } catch (NumberFormatException ex) {
            System.err.println("Can´t parse Integer: " + ex.getMessage());
        } catch (NullPointerException npe) {
            System.err.println("NullPointerException aufgetreten");
        }
    }
}
