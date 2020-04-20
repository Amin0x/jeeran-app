package sd.jeeran.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import sd.jeeran.R;
import sd.jeeran.ui.main.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainContentFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


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
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final RecyclerView textView = root.findViewById(R.id.section_label);

        return root;
    }
}