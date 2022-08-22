package com.anhntn45.dogsapp.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhntn45.dogsapp.R;
import com.anhntn45.dogsapp.databinding.FragmentDetailBinding;
import com.anhntn45.dogsapp.model.Dog;
import com.anhntn45.dogsapp.viewmodel.DetailViewModel;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    private DetailViewModel detailViewModel;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(getLayoutInflater(), container, false);

        // pass data from list fragment through navigation
//        Bundle bundle = this.getArguments();
//        String name = DetailFragmentArgs.fromBundle(bundle).getData();
//        binding.textView.setText(name);
//        binding.textView.setTextColor(Color.WHITE);
//        binding.getRoot().setOnClickListener(view -> {
//            // navigate to list fragment
//            NavDirections action = DetailFragmentDirections.actionDetailFragmentToListFragment();
//            Navigation.findNavController(binding.getRoot()).navigate(action);
//        });

        init();
        observeViewModel();
        return binding.getRoot();
    }

    private void init() {
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        detailViewModel.fetch();
    }

    private void observeViewModel() {
        detailViewModel.dog.observe(getViewLifecycleOwner(), dog -> {
            binding.dogName.setText(dog.dogBreed);
            binding.dogPurpose.setText(dog.bredFor);
            binding.dogTemperament.setText(dog.temperament);
            binding.dogLifespan.setText(dog.lifeSpan);
        });
    }

}