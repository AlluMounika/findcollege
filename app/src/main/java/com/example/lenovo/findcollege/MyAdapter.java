package com.example.lenovo.findcollege;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context c;
    ArrayList<collegepojo> dataarray=new ArrayList<>();

    public MyAdapter(Context c, ArrayList<collegepojo> dataarray) {
        this.c = c;
        this.dataarray = dataarray;
        Log.i("name3",dataarray.get(1).getName()+"hiii");

    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        Picasso.with(c).load(dataarray.get(position).getImage()).into(holder.iv);
        holder.accrediatatedto.setText(dataarray.get(position).getAccrediatatedto());
//        Log.i("name",dataarray.get(position).getAccrediatatedto());
        holder.name.setText(dataarray.get(position).getName());
        holder.userrating.setText(Double.toString(dataarray.get(position).getUserrating()));
        holder.location.setText(dataarray.get(position).getLocation());
        holder.district.setText(dataarray.get(position).getDistrict());
        holder.ownertype.setText(dataarray.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return dataarray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView accrediatatedto,userrating,location,district,ownertype,name;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv=(ImageView) itemView.findViewById(R.id.college_image);
            accrediatatedto=(TextView) itemView.findViewById(R.id.accrediatatedto);
            userrating=(TextView) itemView.findViewById(R.id.userrating);
            location=(TextView) itemView.findViewById(R.id.location);
            district=(TextView) itemView.findViewById(R.id.district);
            ownertype=(TextView) itemView.findViewById(R.id.ownership);
            name=(TextView) itemView.findViewById(R.id.collegename);
        }
    }
}
