package com.example.inf01043_tp2;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.inf01043_tp2.databinding.FragmentTarefa1Binding;

public class Tarefa1Fragment extends Fragment {

    private FragmentTarefa1Binding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTarefa1Binding.inflate(inflater, container, false);

        String toast = "Tarefa 1 Somar dois numeros";
        Toast.makeText(this.getContext(), toast, Toast.LENGTH_SHORT).show();

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Tarefa1Fragment.this)
                        .navigate(R.id.action_Tarefa1Fragment_to_FirstFragment);
            }
        });

        binding.buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v1 = Integer.parseInt(binding.editTextNumber1.getText().toString());
                int v2 = Integer.parseInt(binding.editTextNumber2.getText().toString());

                String result = "Resultado da soma: " + String.valueOf(v1 + v2);

                binding.textViewResult.setText(result);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}