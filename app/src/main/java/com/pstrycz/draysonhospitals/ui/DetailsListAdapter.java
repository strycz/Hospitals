package com.pstrycz.draysonhospitals.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pstrycz.draysonhospitals.R;
import com.pstrycz.draysonhospitals.ui.DetailsActivity.DetailEntry;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


class DetailsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<DetailEntry> data;

    DetailsListAdapter(List<DetailEntry> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_item, parent, false);

        DetailsViewHolder viewHolder = new DetailsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        detailsViewHolder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DetailsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.header)
        TextView header;
        @BindView(R.id.value)
        TextView value;

        DetailsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(DetailEntry detailEntry) {
            header.setText(detailEntry.header);
            value.setText(detailEntry.value);
        }
    }
}
