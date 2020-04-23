package sd.jeeran.core;

import android.app.Application;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import retrofit2.Retrofit;

public class JApplication extends Application {
    private static JApplication application = null;
    private static Lock lock = new ReentrantLock();

    private static final String BASE_URL = "";
    private Retrofit retrofit;
    private JeeranApi jeeranApi;

    public JApplication() {
        retrofit = null;
        jeeranApi = null;
    }

    public static JApplication getInstance() {

        lock.lock();
        if (application == null) {
            application = new JApplication();
        }
        lock.unlock();
        return application;
    }

    public JeeranApi getServices() {
        return jeeranApi;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        retrofit = builder.build();

        if (retrofit != null) {
            jeeranApi = retrofit.create(JeeranApi.class);
        }
    }
}
