package com.example.wedding.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
    private int previousImageId = -1;
    private TextView cijena;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPozivniceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        cijena = root.findViewById(R.id.cena);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.p15);
        imageList.add(R.drawable.p16);
        imageList.add(R.drawable.p17);
        imageList.add(R.drawable.p18);
        imageList.add(R.drawable.p19);
        imageList.add(R.drawable.p20);
        imageList.add(R.drawable.p21);
        ImageAdapter.OnItemClickListener itemClickListener = new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int imageId) {
                if (previousImageId != imageId) {
                    switch (imageId) {
                        case R.drawable.p15:
                            cijena.setText("Cijena: 20 KM");
                            break;
                        case R.drawable.p16:
                            cijena.setText("Cijena: 24 KM");
                            break;
                        case R.drawable.p17:
                            cijena.setText("Cijena: 22 KM");
                            break;
                        case R.drawable.p18:
                            cijena.setText("Cijena: 19 KM");
                            break;
                        case R.drawable.p19:
                            cijena.setText("Cijena: 40 KM");
                            break;
                        case R.drawable.p20:
                            cijena.setText("Cijena: 21 KM");
                            break;
                        case R.drawable.p21:
                            cijena.setText("Cijena: 23 KM");
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