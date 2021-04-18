package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp.Model.Category;
import com.example.quizapp.ViewHolder.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryFragment extends Fragment {

    View view;

    RecyclerView listCategory;
    //RecyclerView.LayoutManager layoutManager;
    //FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    myadapter adapter;

    //FirebaseDatabase database;
    DatabaseReference categories;


    public static CategoryFragment newInstance(){
        CategoryFragment categoryFragment=new CategoryFragment();
        return categoryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //database=FirebaseDatabase.getInstance();
        categories=FirebaseDatabase.getInstance().getReference("Category");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_category,container,false);

       /* listCategory=(RecyclerView)view.findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true);
        listCategory.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<Category> options=new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(categories,Category.class)
                .build();

        adapter=new myadapter(options);
        listCategory.setAdapter(adapter);
        //adapter.notifyDataSetChanged();*/

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listCategory = (RecyclerView) view.findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true);
        listCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerOptions<Category> options = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(categories, Category.class)
                .build();

        adapter = new myadapter(options);
        listCategory.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }


    @Override
    public void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    /*private void loadCategories(){
        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(
                Category.class,
                R.layout.category_layout,
                CategoryViewHolder.class,
                categories) {


            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder viewHolder,int position,@NonNull Category model) {
                viewHolder.category_name.setText(model.getName());
                Picasso.with(getActivity())
                        .load(model.getImage())
                        .into(viewHolder.category_image);

                viewHolder.setItemClickListener(new ItemClickListener(){
                    @Override
                    public void onClick(View view,int position,boolean isLongClick){
                        Toast.makeText(getActivity(),String.format("%s|%s",adapter.getRef(position).getKey(),model.getName()),Toast.LENGTH_SHORT).show();
                    }
                });
            }

        };

        adapter.notifyDataSetChanged();
        listCategory.setAdapter(adapter);
    }*/
}