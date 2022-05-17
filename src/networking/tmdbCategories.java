package networking;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import models.Movie;
import models.Movies;


import java.io.IOException;

public class tmdbCategories {

    private  Movies movieName;

    public String getTheNewMovie(){
        return "https://api.themoviedb.org/3/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1";
    }
    public String getTheTrendingMovie(){
        return "https://api.themoviedb.org/3/trending/all/week?api_key=96624ea86553cd7a4caed4ecbdc35ec1";
    }
    public String getMovieSortByPopularity(){
        return "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc?api_key=96624ea86553cd7a4caed4ecbdc35ec1";
    }
    public String getTheTopMovie(){
        return "https://api.themoviedb.org/3/movie/top_rated?api_key=96624ea86553cd7a4caed4ecbdc35ec1";
    }
    public String getTheTopRatedMovie(){
        return "https://api.themoviedb.org/3/tv/top_rated?api_key=96624ea86553cd7a4caed4ecbdc35ec1";
    }


    public void printData(String getData) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Movies> gistJsonAdapter = moshi.adapter(Movies.class);
        try {
            movieName = gistJsonAdapter.fromJson(getData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(movieName !=null){
            for (Movie movie : movieName.getMovies()){
                System.out.println(movie.getOriginal_title());
            }
        }

    }


}
