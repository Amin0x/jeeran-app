package sd.jeeran.core;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JeeranApi {
    @GET("api/")
    public Call<String> getHome();
}
