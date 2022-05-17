package networking;

import exception.ApiException;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ApiManager implements Api {
    private final OkHttpClient client = new OkHttpClient();

    private Request request;
    private String url;

    public ApiManager(String url){
        this.url=url;
    }

    @Override
    public void run(ResultApi<String, Exception> callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.result(null, e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);

                    if (responseBody != null) {

                        callback.result(responseBody.string(), null);

                    }
                    else {
                        callback.result(null, new ApiException());
                    }
                }
            }
        });
    }


}

