package com.example.robacobres_androidclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.robacobres_androidclient.R;
import com.example.robacobres_androidclient.models.Item;
import com.example.robacobres_androidclient.services.ServiceBBDD;

import java.util.List;

public class MyItemsAdapter extends RecyclerView.Adapter<MyItemsAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;
    private ServiceBBDD service;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtIdObj;
        public TextView txtNameItem;
        public TextView txtPriceItem;
        public ImageView icon;


        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtIdObj = (TextView) v.findViewById(R.id.itemId);
            txtNameItem = (TextView) v.findViewById(R.id.userName);
            txtPriceItem = (TextView) v.findViewById(R.id.comentario);
            icon=(ImageView) v.findViewById(R.id.icon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyItemsAdapter(Context context, List<Item> myDataset) {
        this.context = context;
        this.service = ServiceBBDD.getInstance(context);
        items = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_myitems_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyItemsAdapter.ViewHolder vh = new MyItemsAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyItemsAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Item i = items.get(position);
        holder.txtIdObj.setText(i.getId());
        holder.txtNameItem.setText(i.getName());
        holder.txtPriceItem.setText(String.valueOf(i.getCost()));

        Glide.with(holder.icon.getContext())
                .load(i.getItem_url())
                .into(holder.icon);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}
