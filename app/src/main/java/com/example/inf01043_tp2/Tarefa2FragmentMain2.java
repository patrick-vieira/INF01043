package com.example.inf01043_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.inf01043_tp2.databinding.FragmentFirst2Binding;

public class Tarefa2FragmentMain2 extends Fragment {

private FragmentFirst2Binding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirst2Binding.inflate(inflater, container, false);
      binding.textviewFirst.setText(this.getActivity().getIntent().getStringExtra("message"));
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(binding.getRoot().getContext().getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}