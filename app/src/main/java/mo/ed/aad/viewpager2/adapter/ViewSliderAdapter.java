package mo.ed.aad.viewpager2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewSliderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int[] mLayouts;
    private final Context mContext;

    public ViewSliderAdapter(Context context, int [] layouts){
        this.mContext=context;
        this.mLayouts=layouts;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return mLayouts[position];
    }

    @Override
    public int getItemCount() {
        return mLayouts.length;
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public SliderViewHolder(View view) {
            super(view);
        }
    }
}