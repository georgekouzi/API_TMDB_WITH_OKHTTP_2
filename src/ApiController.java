import networking.Api;
import networking.ResultApi;

public class ApiController {


    static public void ApiController(Api[] apis) {
        for (Api api :apis) {
            api.run(new ResultApi<String, Exception>() {
                @Override
                public void result(String getData, Exception getException) {
                    System.out.println(getData);
                }
            });

        }
    }
}
