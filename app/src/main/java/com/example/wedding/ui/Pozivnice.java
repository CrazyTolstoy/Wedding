package com.example.wedding.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.ImageAdapter;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentPozivniceBinding;

import java.util.ArrayList;
import java.util.List;

public class Pozivnice extends Fragment {

    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private List<Integer> imageList;
    private FragmentPozivniceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPozivniceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        imageList = new ArrayList<>();
        imageList.add(getResources().getIdentifier("s15","drawable", "com.example.wedding.ui"));
        imageList.add(getResources().getIdentifier("16","drawable", "com.example.wedding.ui"));
        imageList.add(getResources().getIdentifier("17","drawable", "com.example.wedding.ui"));
        imageList.add(getResources().getIdentifier("18","drawable", "com.example.wedding.ui"));
        imageList.add(getResources().getIdentifier("19","drawable", "com.example.wedding.ui"));
        imageList.add(getResources().getIdentifier("20","drawable", "com.example.wedding.ui"));
        imageList.add(getResources().getIdentifier("21","drawable", "com.example.wedding.ui"));
        ImageAdapter.OnItemClickListener itemClickListener = new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int imageId) {
                Toast.makeText(getActivity(), "Neispravni podaci za polje 'Godina'!"+imageId, Toast.LENGTH_LONG).show();

            }
        };

// Create the ImageAdapter with the imageList and the itemClickListener
        adapter = new ImageAdapter(imageList, itemClickListener);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}