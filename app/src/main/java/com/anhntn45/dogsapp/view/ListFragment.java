package com.anhntn45.dogsapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhntn45.dogsapp.R;
import com.anhntn45.dogsapp.databinding.FragmentListBinding;
import com.anhntn45.dogsapp.model.Dog;
import com.anhntn45.dogsapp.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private FragmentListBinding binding;
    private DogsListAdapter dogsListAdapter;
    private ListViewModel listViewModel;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(getLayoutInflater(), container, false);

        // pass argument from list fragment to detail fragment
//        binding.getRoot().setOnClickListener(view -> {
//            // navigate to detail fragment
//            NavDirections action = ListFragmentDirections.actionListFragmentToDetailFragment("Rain");
//            Navigation.findNavController(binding.getRoot()).navigate(action);
//        });
//        binding.getRoot().setOnClickListener(view -> {
//            NavDirections action = ListFragmentDirections.actionListFragmentToDetailFragment();
//            Navigation.findNavController(getView()).navigate(action);
//        });

        init();
        observeViewModel();
        return binding.getRoot();
    }

    private void init() {
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        dogsListAdapter = new DogsListAdapter(new ArrayList<>());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(dogsListAdapter);
        listViewModel.refresh();
    }

    private void observeViewModel() {
        listViewModel.dogsList.observe(getViewLifecycleOwner(), dogs -> {
            binding.recyclerView.setVisibility(View.VISIBLE);
            dogsListAdapter.updateDogsList(dogs);
        });

        listViewModel.dogLoadError.observe(getViewLifecycleOwner(), isError -> {
            binding.tvError.setVisibility(isError ? View.VISIBLE : View.GONE);
        });

        listViewModel.loading.observe(getViewLifecycleOwner(), isLoading -> {
            binding.progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            if (isLoading) {
                binding.recyclerView.setVisibility(View.GONE);
                binding.tvError.setVisibility(View.GONE);
            }
        });
    }


//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        NavDirections action = ListFragmentDirections.actionListFragmentToDetailFragment();
//        Navigation.findNavController(view).navigate(action);
//    }
}
