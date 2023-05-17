package com.example.wedding.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.ImageAdapter;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentDekoracijaBinding;

import java.util.ArrayList;
import java.util.List;

public class Dekoracija extends Fragment {

    private FragmentDekoracijaBinding binding;
    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private List<Integer> imageList;
    private TextView cijena;
    private int previousImageId = -1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDekoracijaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        cijena = root.findViewById(R.id.cena);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.d22);
        imageList.add(R.drawable.d23);
        imageList.add(R.drawable.d24);
        imageList.add(R.drawable.d25);
        imageList.add(R.drawable.d26);
        imageList.add(R.drawable.d27);
        imageList.add(R.drawable.d28);
        imageList.add(R.drawable.d29);
        ImageAdapter.OnItemClickListener itemClickListener = new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int imageId) {
                if (previousImageId != imageId) {
                    switch (imageId) {
                        case R.drawable.d22:
                            cijena.setText("Cijena: 200 KM");
                            break;
                        case R.drawable.d23:
                            cijena.setText("Cijena: 210 KM");
                            break;
                        case R.drawable.d24:
                            cijena.setText("Cijena: 220 KM");
                            break;
                        case R.drawable.d25:
                            cijena.setText("Cijena: 190 KM");
                            break;
                        case R.drawable.d26:
                            cijena.setText("Cijena: 200 KM");
                            break;
                        case R.drawable.d27:
                            cijena.setText("Cijena: 215 KM");
                            break;
                        case R.drawable.d28:
                            cijena.setText("Cijena: 230 KM");
                            break;
                        case R.drawable.d29:
                            cijena.setText("Cijena: 200 KM");
                            break;
                    }
                    previousImageId = imageId;
                }
            }
        };

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
