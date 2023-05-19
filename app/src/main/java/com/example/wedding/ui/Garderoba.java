package com.example.wedding.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.ImageAdapter;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentGarderobaBinding;

import java.util.ArrayList;
import java.util.List;

public class Garderoba extends Fragment {

    private FragmentGarderobaBinding binding;
    private RecyclerView recyclerView;
    private List<Integer> imageList;
    private int previousImageId = -1;
    private TextView cijena;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGarderobaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        cijena = root.findViewById(R.id.cena);

        recyclerView.setVisibility(root.INVISIBLE);
        Spinner spinner = root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.garderoba, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                ImageAdapter adapter;
                switch(position) {
                    case 0:
                        recyclerView.setVisibility(root.INVISIBLE);
                        break;
                    case 2:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.g14);
                        imageList.add(R.drawable.g15);
                        imageList.add(R.drawable.g16);
                        imageList.add(R.drawable.g17);
                        imageList.add(R.drawable.g18);
                        imageList.add(R.drawable.g19);
                        imageList.add(R.drawable.g20);
                        imageList.add(R.drawable.g21);
                        imageList.add(R.drawable.g22);
                        ImageAdapter.OnItemClickListener itemClickListener1 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                if (previousImageId != imageId) {
                                    switch (imageId) {
                                        case R.drawable.g14:
                                            cijena.setText("Cijena: 200 KM");
                                            break;
                                        case R.drawable.g15:
                                            cijena.setText("Cijena: 210 KM");
                                            break;
                                        case R.drawable.g16:
                                            cijena.setText("Cijena: 220 KM");
                                            break;
                                        case R.drawable.g17:
                                            cijena.setText("Cijena: 190 KM");
                                            break;
                                        case R.drawable.g18:
                                            cijena.setText("Cijena: 400 KM");
                                            break;
                                        case R.drawable.g19:
                                            cijena.setText("Cijena: 215 KM");
                                            break;
                                        case R.drawable.g20:
                                            cijena.setText("Cijena: 230 KM");
                                            break;
                                        case R.drawable.g21:
                                            cijena.setText("Cijena: 300 KM");
                                            break;
                                        case R.drawable.g22:
                                            cijena.setText("Cijena: 320 KM");
                                            break;
                                    }
                                    previousImageId = imageId;
                                }
                            }
                        };
                        adapter = new ImageAdapter(imageList, itemClickListener1);
                        recyclerView.setAdapter(adapter);
                        break;


                    case 1:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.g23);
                        imageList.add(R.drawable.g24);
                        imageList.add(R.drawable.g25);
                        imageList.add(R.drawable.g26);
                        imageList.add(R.drawable.g27);
                        imageList.add(R.drawable.g28);
                        imageList.add(R.drawable.g29);
                        imageList.add(R.drawable.g30);
                        imageList.add(R.drawable.g31);
                        ImageAdapter.OnItemClickListener itemClickListener3 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                if (previousImageId != imageId) {
                                    switch (imageId) {
                                        case R.drawable.g23:
                                            cijena.setText("Cijena: 200 KM");
                                            break;
                                        case R.drawable.g24:
                                            cijena.setText("Cijena: 210 KM");
                                            break;
                                        case R.drawable.g25:
                                            cijena.setText("Cijena: 220 KM");
                                            break;
                                        case R.drawable.g26:
                                            cijena.setText("Cijena: 190 KM");
                                            break;
                                        case R.drawable.g27:
                                            cijena.setText("Cijena: 400 KM");
                                            break;
                                        case R.drawable.g28:
                                            cijena.setText("Cijena: 215 KM");
                                            break;
                                        case R.drawable.g29:
                                            cijena.setText("Cijena: 230 KM");
                                            break;
                                        case R.drawable.g30:
                                            cijena.setText("Cijena: 300 KM");
                                            break;
                                        case R.drawable.g31:
                                            cijena.setText("Cijena: 390 KM");
                                            break;
                                    }
                                    previousImageId = imageId;
                                }
                            }
                        };
                        adapter = new ImageAdapter(imageList, itemClickListener3);
                        recyclerView.setAdapter(adapter);
                        break;

                    default:
                        // do something for other items
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}