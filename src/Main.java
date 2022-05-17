import networking.ApiManager;
import networking.tmdbCategories;

public class Main {
    public static void main(String [] args){
//        ApiController.ApiController(new Api[]{new RequestMovies(url)});
        tmdbCategories tmdbMovie= new tmdbCategories();

        ApiManager manager1 = new ApiManager(tmdbMovie.getTheTopMovie());
        manager1.run((getData, getException) -> {
            tmdbMovie.printData(getData);
        });





    }


}




