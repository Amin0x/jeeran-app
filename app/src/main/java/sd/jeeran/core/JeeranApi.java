package sd.jeeran.core;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JeeranApi {


    @GET("api/")
    Call<String> getHome();


    @GET("api/posts")
    Call<httpApi.Post> getAllPost();

    @GET("api/posts/:id")
    Call<httpApi.Post> getPost(@Path("id") long id);


    @POST("api/posts")
    Call<httpApi.Post> createPost(@Body httpApi.Post post);
}
