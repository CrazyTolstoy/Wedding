package com.example.wedding.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.example.wedding.FirstTimeOpen;
import com.example.wedding.MainActivity;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentHomeBinding;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SharedPreferences sharedPreferences;
    private TextView naslov;
    private Button zapocni;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        zapocni=root.findViewById(R.id.button);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        String mlada = sharedPreferences.getString("mlada", "");
        String mladozenja = sharedPreferences.getString("mladozenja", "");
        naslov=root.findViewById(R.id.text_home);
        naslov.setText("Dobrodošli dragi "+mlada+" i "+mladozenja);
        zapocni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).onBackPressed();
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