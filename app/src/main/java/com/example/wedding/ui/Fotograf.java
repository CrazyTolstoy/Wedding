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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


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
                        imageList.add(R.drawable.salon4);
                        imageList.add(R.drawable.salon1);
                        imageList.add(R.drawable.salon2);
                        imageList.add(R.drawable.salon3);
                        imageList.add(R.drawable.salon4);
                        ImageAdapter.OnItemClickListener itemClickListener1 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                Toast.makeText(getActivity(), "Neispravni podaci za polje 'Godina'!"+imageId, Toast.LENGTH_LONG).show();
                            }
                        };
                         adapter = new ImageAdapter(imageList, itemClickListener1);
                        recyclerView.setAdapter(adapter);
                        break;

                    case 2:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.salon3);
                        imageList.add(R.drawable.salon1);
                        imageList.add(R.drawable.salon2);
                        imageList.add(R.drawable.salon3);
                        imageList.add(R.drawable.salon4);
                        ImageAdapter.OnItemClickListener itemClickListener2 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                Toast.makeText(getActivity(), "Neispravni podaci za polje 'Godina'!"+imageId, Toast.LENGTH_LONG).show();
                            }
                        };
                         adapter = new ImageAdapter(imageList, itemClickListener2);
                        recyclerView.setAdapter(adapter);
                        break;

                    case 3:
                        recyclerView.setVisibility(root.VISIBLE);
                        imageList = new ArrayList<>();
                        imageList.add(R.drawable.salon2);
                        imageList.add(R.drawable.salon1);
                        imageList.add(R.drawable.salon2);
                        imageList.add(R.drawable.salon3);
                        imageList.add(R.drawable.salon4);
                        ImageAdapter.OnItemClickListener itemClickListener3 = new ImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int imageId) {
                                Toast.makeText(getActivity(), "Neispravni podaci za polje 'Godina'!"+imageId, Toast.LENGTH_LONG).show();
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