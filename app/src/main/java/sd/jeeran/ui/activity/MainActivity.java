package sd.jeeran.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sd.jeeran.R;
import sd.jeeran.core.JApplication;
import sd.jeeran.core.JeeranApi;
import sd.jeeran.ui.fragment.MainContentFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.activity_main_toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.drawer_menu_icon);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //getSupportActionBar().setIcon(0);

        //MainContentFragment mainContentFragment = new MainContentFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, MainContentFragment.newInstance(0))
                .commit();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                boolean result = false;

                if (itemId == R.id.profile) {
                    onProfile();
                    result = true;
                } else if (itemId == R.id.amin_omer) {
                    result = false;
                } else if (itemId == R.id.donate) {
                    onDonate();
                    result = true;
                } else if (itemId == R.id.update) {
                    onUpdate();
                    result = true;
                } else if (itemId == R.id.setting) {
                    onSetting();
                    result = true;
                } else if (itemId == R.id.contact_us) {
                    onContactUs();
                    result = true;
                } else if (itemId == R.id.about) {
                    onAbout();
                    result = true;
                }
                drawer.closeDrawer(GravityCompat.START);
                return result;
            }
        });
    }

    private void loadPage() {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_acitivty_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        boolean result = false;


        return result? result:super.onOptionsItemSelected(item);
    }

    private void onAbout() {

    }

    private void onContactUs() {

    }

    private void onSetting() {

    }

    private void onUpdate() {

    }

    private void onDonate() {

    }

    private void onProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}