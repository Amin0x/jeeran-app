package sd.jeeran.ui.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import sd.jeeran.R;
import sd.jeeran.ui.fragment.MainContentFragment;


public class MainContentActivityAdapter extends RecyclerView.Adapter<MainContentActivityAdapter.ItemViewHolder> {

    private List<MainContentFragment.DataListItem> data;

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public View view;

        public ItemViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
        }
    }

    public MainContentActivityAdapter(List<MainContentFragment.DataListItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        int type =  -1;
        View view = null;

        if(data.size() > 0){
            type = data.get(viewType).type;
        }

        if(type == -1){
            view = inflater.inflate(R.layout.main_content_no_item, parent, false);
        }

        if (type == 0){
            view = inflater.inflate(R.layout.main_content_item_0, parent, false);
        }

        if (type == 1){
            view = inflater.inflate(R.layout.main_content_item_1, parent, false);
        }

        if (type == 2){
            view = inflater.inflate(R.layout.main_content_item_2, parent, false);
        }


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if (data.size() == 0){
            return;
        }

        MainContentFragment.DataListItem item = data.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.view.getContext(), "you clicked item" + position + "and item type" + item.type, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data.size() == 0){
            return 1;
        }

        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (data.size() == 0){
            return -1;
        }
        return data.get(position).type;
    }
}