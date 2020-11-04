package pl.deska.ksb2.model;

public class Movie {

    private String title;
    private String productionDate;
    private String director;

    public Movie(String title, String productionDate, String director) {
        this.title = title;
        this.productionDate = productionDate;
        this.director = director;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
