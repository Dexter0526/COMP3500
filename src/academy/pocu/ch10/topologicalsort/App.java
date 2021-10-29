package academy.pocu.ch10.topologicalsort;

import java.util.*;

public class App {
    public static void main(String[] args) {
        ArrayList<Course> courses = createCourseGraph();

        LinkedList<Course> sortedCourses = sortTopologically(courses);

        for (Course course : sortedCourses) {
            System.out.println(course.getTitle());
        }

        System.out.println("=======================================");

        Collections.shuffle(courses);

        sortedCourses = sortTopologically(courses);

        for (Course course : sortedCourses) {
            System.out.println(course.getTitle());
        }
    }

    private static LinkedList<Course> sortTopologically(ArrayList<Course> courses){
        Set<Course> discovered = new HashSet<>();
        LinkedList<Course> sortedList = new LinkedList<>();

        for(Course course : courses){
            if(discovered.contains(course)) continue;

            topologicalSortRecursive(course, discovered, sortedList);
        }

        return sortedList;
    }

    private static void topologicalSortRecursive(Course course, Set<Course> discovered, LinkedList<Course> list){
        discovered.add(course);

        for(Course nextCourse : course.getNextCourses()){
            if(discovered.contains(nextCourse)) continue;

            topologicalSortRecursive(nextCourse, discovered, list);
        }

        list.addFirst(course);
    }

//    그래프 생성
    private static ArrayList<Course> createCourseGraph() {
        final Course comp0000 = new Course("0000: Intro to Programming for Novices and Hobbyists (C#)");
        final Course comp1500 = new Course("1500: Intro to Professional Programming with C#");
        final Course comp1000 = new Course("1000: Math for Software Engineers");
        final Course comp1600 = new Course("1600: Visual Programming with C#");
        final Course comp2200 = new Course("2200: Unmanaged Programming with C");
        final Course comp2500 = new Course("2500: Object Oriented Programming and Design with Java");
        final Course comp4700 = new Course("4700: Database Programming with C#");
        final Course comp2300 = new Course("2300: Assembly");
        final Course comp3200 = new Course("3200: Unmanaged Programming with C++");
        final Course comp3500 = new Course("3500: Algorithm & Data Structure with Java");
        final Course comp3000 = new Course("3000: Computer Architecture (C or Assembly)");
        final Course comp4000 = new Course("4000: Operating Systems (C)");
        final Course comp4100 = new Course("4100: Data Comm (C or C++");

        comp0000.addNext(comp1500);

        comp1500.addNext(comp1000);
        comp1500.addNext(comp1600);
        comp1500.addNext(comp2200);
        comp1500.addNext(comp2500);

        comp1000.addNext(comp1600);
        comp1000.addNext(comp2200);
        comp1000.addNext(comp2500);

        comp1600.addNext(comp4700);

        comp2200.addNext(comp2300);
        comp2200.addNext(comp3200);
        comp2200.addNext(comp3000);

        comp2500.addNext(comp4700);
        comp2500.addNext(comp3200);
        comp2500.addNext(comp3500);

        comp2300.addNext(comp3000);

        comp3200.addNext(comp4000);
        comp3200.addNext(comp4100);

        comp3000.addNext(comp4000);

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(comp0000);
        courses.add(comp1000);
        courses.add(comp1500);
        courses.add(comp1600);
        courses.add(comp2200);
        courses.add(comp2300);
        courses.add(comp2500);
        courses.add(comp3000);
        courses.add(comp3200);
        courses.add(comp3500);
        courses.add(comp4000);
        courses.add(comp4100);
        courses.add(comp4700);

        return courses;
    }
}
