package com.example.inf01043_tp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inf01043_tp2.databinding.FragmentTarefa1Binding;
import com.example.inf01043_tp2.databinding.FragmentTarefa2Binding;

public class Tarefa2Fragment extends Fragment {

    private FragmentTarefa2Binding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTarefa2Binding.inflate(inflater, container, false);

        String toast = "Tarefa 1 Somar dois numeros";
        Toast.makeText(this.getContext(), toast, Toast.LENGTH_SHORT).show();

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Tarefa2Fragment.this)
                        .navigate(R.id.action_Tarefa2Fragment_to_FirstFragment);
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}