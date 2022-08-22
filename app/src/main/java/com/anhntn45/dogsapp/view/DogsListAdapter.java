package com.anhntn45.dogsapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhntn45.dogsapp.R;
import com.anhntn45.dogsapp.model.Dog;

import org.w3c.dom.Text;

import java.util.List;

public class DogsListAdapter extends RecyclerView.Adapter<DogsListAdapter.DogsListViewHolder> {
    private List<Dog> dogList;

    public DogsListAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    public void updateDogsList(List<Dog> newDogsList) {
        dogList.clear();
        dogList.addAll(newDogsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DogsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_dog, parent, false);
        return new DogsListViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsListViewHolder holder, int position) {
        holder.bind(dogList.get(position));
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    public class DogsListViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private ImageView dogImg;
        private TextView dogName, dogLifeSpan;
        public DogsListViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;

            dogImg = itemView.findViewById(R.id.dog_img);
            dogName = itemView.findViewById(R.id.dog_name);
            dogLifeSpan = itemView.findViewById(R.id.dog_lifespan);
        }

        public void bind(Dog dog) {
            dogName.setText(dog.dogBreed);
            dogLifeSpan.setText(dog.lifeSpan);
        }
    }
}
