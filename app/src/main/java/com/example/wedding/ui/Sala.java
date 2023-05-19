package com.example.wedding.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.ImageAdapter;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentSalaBinding;

import java.util.ArrayList;
import java.util.List;

public class Sala extends Fragment {

    private FragmentSalaBinding binding;
    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private List<Integer> imageList;
    private int previousImageId = -1;
    private TextView cijena;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSalaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        cijena = root.findViewById(R.id.cena);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.s6);
        imageList.add(R.drawable.s7);
        imageList.add(R.drawable.s8);
        imageList.add(R.drawable.s9);
        imageList.add(R.drawable.s10);
        imageList.add(R.drawable.s11);
        imageList.add(R.drawable.s12);
        imageList.add(R.drawable.s13);
        imageList.add(R.drawable.s14);
        ImageAdapter.OnItemClickListener itemClickListener = new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int imageId) {
                if (previousImageId != imageId) {
                    switch (imageId) {
                        case R.drawable.s6:
                            cijena.setText("Cijena: 2000 KM");
                            break;
                        case R.drawable.s7:
                            cijena.setText("Cijena: 2100 KM");
                            break;
                        case R.drawable.s8:
                            cijena.setText("Cijena: 2200 KM");
                            break;
                        case R.drawable.s9:
                            cijena.setText("Cijena: 1900 KM");
                            break;
                        case R.drawable.s10:
                            cijena.setText("Cijena: 4000 KM");
                            break;
                        case R.drawable.s11:
                            cijena.setText("Cijena: 2150 KM");
                            break;
                        case R.drawable.s12:
                            cijena.setText("Cijena: 2300 KM");
                            break;
                        case R.drawable.s13:
                            cijena.setText("Cijena: 3000 KM");
                            break;
                    }
                    previousImageId = imageId;
                }
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