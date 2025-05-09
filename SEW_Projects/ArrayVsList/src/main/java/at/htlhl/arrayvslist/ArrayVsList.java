package at.htlhl.arrayvslist;

import java.util.ArrayList;

/**
 * Dieses Beispiel zeigt die Unterschiede zwischen einem Array
 * und einer Liste.
 *
 * Das Arbeiten mit Listen bietet dem Programmierer viele Erleichterungen
 * gegenüber den Arbeiten direkt mit Arrays.
 *
 * z.B.:
 * einfaches Hinzufügen und Entfernen von Datenschützen
 * einfacher Zugriff auf Elemente (nicht nur über Index)
 * Elementsuche
 * u.v.m.
 */

public class ArrayVsList {
    // Fields *****************************************************************

    private String[] myArray;
    private ArrayList<String> myList;

    // Instance creation ******************************************************

    public ArrayVsList() {
        myArray = new String[4];
        myList = new ArrayList<String>();

        fill();
        showContents();
        removeValue("shit");
    }

    // Logic ******************************************************************

    private void fill() {
        // Fill array with values
        myArray[0] = "Heute";
        myArray[1] = "ist";
        myArray[2] = "es";
        myArray[3] = "shit";

        // Fill list with values
        myList.add("Heute");
        myList.add("ist");
        myList.add("es");
        myList.add("shit");
    }

    private void removeValue(String value) {
        System.out.println("Trying to remove value '" + value + "'");
        System.out.println("Lenght of array before removal: " + myArray.length);
        // Remove value from array:
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].equalsIgnoreCase(value)) {
                myArray[i] = null;
            }
        }
        System.out.println("Lenght of array after removal: " + myArray.length);

        System.out.println("Lenght of list before removal: " + myList.size());
        // Remove value from array:
        boolean success = myList.remove(value);
        System.out.println("List entry deleted: " + success);
        System.out.println("Lenght of list after removal: " + myList.size());

        System.out.println();
    }

    private void showContents() {
        System.out.println("Show array content: ");
        for (String value : myArray) {
            System.out.println(value);
        }

        System.out.println("Show list content: ");
        for (String value : myList) {
            System.out.println(value);
        }
    }

    // Main *******************************************************************

    public static void main(String[] args) {
        new ArrayVsList();
    }
}
