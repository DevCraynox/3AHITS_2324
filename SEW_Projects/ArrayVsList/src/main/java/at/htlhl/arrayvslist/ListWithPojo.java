package at.htlhl.arrayvslist;

import java.util.ArrayList;

public class ListWithPojo {

    ArrayList<Subject> subjectList;

    public ListWithPojo() {
        subjectList = new ArrayList<Subject>();
        fillList();

        // Check weekly hours
        int totalWeeklyHours = 0;
        for (Subject subject : subjectList) {
            totalWeeklyHours += subject.getWeeklyHours();
        }
        System.out.println("Total weekly hours: " + totalWeeklyHours);
    }

    private void fillList() {
        subjectList.add(new Subject("Softwareentwicklung", "Geischläger", 2));
        subjectList.add(new Subject("Softwareentwicklung1", "Geischläger", 2));
        subjectList.add(new Subject("Englisch", "Schwach", 2));
        subjectList.add(new Subject("Mathematik", "Kreuch", 3));
        subjectList.add(new Subject("Deutsch", "Wenzina", 2));
        subjectList.add(new Subject("Systemtechnik-BS", "Höfermeyer", 3));
        subjectList.add(new Subject("Systemtechnik-EL", "Zottl", 2));
    }

    public static void main(String[] args) {
        new ListWithPojo();
    }
}