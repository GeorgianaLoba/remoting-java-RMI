package springnow.domain;

import java.io.Serializable;

public class Rental extends BaseEntity<Long> implements Serializable {
    private Long movieId, clientId;

    public Rental(){}

    public Rental(Long movieId, Long clientId) {
        this.movieId = movieId;
        this.clientId = clientId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "movieId=" + movieId +
                ", clientId=" + clientId +
                "} " + super.toString();
    }

}
