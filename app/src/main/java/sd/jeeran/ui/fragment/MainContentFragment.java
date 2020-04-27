package sd.jeeran.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sd.jeeran.R;
import sd.jeeran.core.JApplication;
import sd.jeeran.core.JeeranApi;
import sd.jeeran.ui.adapter.MainContentActivityAdapter;

/**
 *
 */
public class MainContentFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private List<DataListItem> dataSource = new ArrayList<DataListItem>();

    public class DataListItem {
        public int type;
        public String title;
        public String content;
        public String url;

        public DataListItem(int type) {
            this.type = type;
            this.title = "";
            this.content = "";
            this.url = "";
        }
        public DataListItem(int type, String title, String content, String url) {
            this.type = type;
            this.title = title;
            this.content = content;
            this.url = url;
        }
    }

    public static MainContentFragment newInstance(int index) {
        MainContentFragment fragment = new MainContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        dataSource.add(new DataListItem(0));
        dataSource.add(new DataListItem(1));
        dataSource.add(new DataListItem(2));
        dataSource.add(new DataListItem(0));
        dataSource.add(new DataListItem(2));
        dataSource.add(new DataListItem(1));
        dataSource.add(new DataListItem(0));

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.section_label);
        recyclerView.setAdapter(new MainContentActivityAdapter(dataSource));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }

    private void fetchData(List<DataListItem> data){

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