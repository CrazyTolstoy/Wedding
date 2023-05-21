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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.ImageAdapter;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentFotoBinding;

import java.util.ArrayList;
import java.util.List;

public class Fotograf extends Fragment {

    private RecyclerView recyclerView;
    private List<Integer> imageList;
    private FragmentFotoBinding binding;
    private TextView cijena;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        cijena = root.findViewById(R.id.cena);

        recyclerView.setVisibility(root.INVISIBLE);
        Spinner spinner = root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.foto_radnje, android.R.layout.simple_spinner_item);
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
                    case 1:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.fs3);
                        imageList.add(R.drawable.fs2);
                        imageList.add(R.drawable.fs1);
                        ImageAdapter.OnItemClickListener itemClickListener1 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                switch (imageId) {
                                    case R.drawable.fs1:
                                        cijena.setText("Cijena: 330 KM");
                                        break;
                                    case R.drawable.fs2:
                                        cijena.setText("Cijena: 280 KM");
                                        break;
                                    case R.drawable.fs3:
                                        cijena.setText("Cijena: 220 KM");
                                        break;
                                } }
                        };
                         adapter = new ImageAdapter(imageList, itemClickListener1);
                        recyclerView.setAdapter(adapter);
                        break;

                    case 2:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.ft3);
                        imageList.add(R.drawable.ft2);
                        imageList.add(R.drawable.ft1);
                        ImageAdapter.OnItemClickListener itemClickListener2 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                switch (imageId) {
                                    case R.drawable.ft3:
                                        cijena.setText("Cijena: 230 KM");
                                        break;
                                    case R.drawable.ft2:
                                        cijena.setText("Cijena: 290 KM");
                                        break;
                                    case R.drawable.ft1:
                                        cijena.setText("Cijena: 340 KM");
                                        break;
                                }
                            }
                        };
                         adapter = new ImageAdapter(imageList, itemClickListener2);
                        recyclerView.setAdapter(adapter);
                        break;

                    case 3:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.ff1);
                        imageList.add(R.drawable.ff2);
                        imageList.add(R.drawable.ff3);
                        ImageAdapter.OnItemClickListener itemClickListener3 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                switch (imageId) {
                                    case R.drawable.ff1:
                                        cijena.setText("Cijena: 230 KM");
                                        break;
                                    case R.drawable.ff2:
                                        cijena.setText("Cijena: 290 KM");
                                        break;
                                    case R.drawable.ff3:
                                        cijena.setText("Cijena: 340 KM");
                                        break;
                                }  }
                        };
                         adapter = new ImageAdapter(imageList, itemClickListener3);
                        recyclerView.setAdapter(adapter);
                        break;
                    case 4:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.fsh1);
                        imageList.add(R.drawable.fsh2);
                        imageList.add(R.drawable.fsh3);
                        ImageAdapter.OnItemClickListener itemClickListener4 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                switch (imageId) {
                                    case R.drawable.fsh1:
                                        cijena.setText("Cijena: 270 KM");
                                        break;
                                    case R.drawable.fsh2:
                                        cijena.setText("Cijena: 290 KM");
                                        break;
                                    case R.drawable.fsh3:
                                        cijena.setText("Cijena: 350 KM");
                                        break;
                                }  }
                        };
                        adapter = new ImageAdapter(imageList, itemClickListener4);
                        recyclerView.setAdapter(adapter);
                        break;
                    default:
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