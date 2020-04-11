package springnow.domain;

public class Movie extends BaseEntity<Long> {
    private String title, director;
    public Integer imdbRating;
    private Integer releaseYear;

    public Movie(){
    }

    public Movie(String title, String director, Integer imdbRating, Integer releaseYear) {
        this.title = title;
        this.director = director;
        this.imdbRating = imdbRating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Integer imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" + "title= " + this.title + ", director= " + this.director +
                 ", imdbRating= " + this.imdbRating + ", releaseYear=" + this.releaseYear
                + "} " + super.toString();

    }
}
