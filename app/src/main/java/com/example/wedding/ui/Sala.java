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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSalaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        imageList = new ArrayList<>();
        imageList.add(R.drawable.salon1);
        imageList.add(R.drawable.salon2);
        imageList.add(R.drawable.salon3);
        imageList.add(R.drawable.salon4);
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