package academy.pocu.ch10.topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private final String title;
    private final ArrayList<Course> nextCourses = new ArrayList<>();

    public Course(final String title){
        this.title = title;
    }

    public List<Course> getNextCourses() {
        return Collections.unmodifiableList(this.nextCourses);
    }

    public void addNext(final Course course){
        this.nextCourses.add(course);
    }

    public String getTitle() {
        return title;
    }
}
