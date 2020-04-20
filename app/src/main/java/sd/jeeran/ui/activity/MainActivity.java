package sd.jeeran.ui.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import java.io.IOException;

import androidx.appcompat.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sd.jeeran.R;
import sd.jeeran.core.JApplication;
import sd.jeeran.core.JeeranApi;
import sd.jeeran.ui.fragment.MainContentFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MainContentFragment mainContentFragment = new MainContentFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, MainContentFragment.newInstance(0))
                .commit();


        FloatingActionButton fab = findViewById(R.id.fab);
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void loadPage(){
        JeeranApi services = JApplication.getInstance().getServices();
       services.getHome().enqueue(new Callback<String>() {
           @Override
           public void onResponse(Call<String> call, Response<String> response) {

           }

           @Override
           public void onFailure(Call<String> call, Throwable t) {

           }
       });

    }
}