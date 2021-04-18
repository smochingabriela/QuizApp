package com.example.quizapp.ViewHolder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quizapp.HomeActivity;
import com.example.quizapp.Interface.ItemClickListener;

import com.example.quizapp.Model.Category;
import com.example.quizapp.R;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



public class myadapter extends FirebaseRecyclerAdapter<Category,myadapter.myviewholder> {



    public myadapter(@NonNull FirebaseRecyclerOptions<Category> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder,final int position, @NonNull Category model) {
        holder.category_name.setText(model.getName());
        Picasso.with(holder.category_image.getContext())
                .load(model.getImage())
                .into(holder.category_image);



        holder.setItemClickListener(new ItemClickListener(){
            @Override
            public void onClick(View view,int position,boolean isLongClick){

                //Toast.makeText(myadapter.this.getClass(),"model.getName()",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout,parent,false);
        return new myviewholder(view);
    }

    public static class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView category_name;
        public ImageView category_image;

        private ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            category_image=(ImageView)itemView.findViewById(R.id.category_image);
            category_name=(TextView)itemView.findViewById(R.id.category_name);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            itemClickListener.onClick(view,getAdapterPosition(),false);

        }
    }
}
