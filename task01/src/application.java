package sdf.assessment.task01;

public class App {

    private String app;
    private String category;
    private Double rating;

    public App (String app, String category, Double rating) {
        this.app = app;
        this.category = category;
        this.rating = rating;
    }

    public String getApp() { return app; }

    public String getCategory() { return category; }
   
    public Double getRating() { return rating; }
    
}
