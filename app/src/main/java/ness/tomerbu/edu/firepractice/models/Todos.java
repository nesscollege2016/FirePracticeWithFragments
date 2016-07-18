package ness.tomerbu.edu.firepractice.models;

/**
 * Created by android on 18/07/2016.
 */
public class Todos {
    private String title;
    private String description;


    public Todos(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public Todos() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
