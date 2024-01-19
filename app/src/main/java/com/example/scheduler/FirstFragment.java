package com.example.scheduler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.scheduler.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    //Hashmap storing all events
    public static HashMap<Date, List<String>> schedule = new HashMap<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/*
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/
    }

    //orders and displays all events, including new entered ones from the user, in list form
    public static void orderEvent(Date date, String eventName) {
        //if list doesn't contain event with specified date
        if (!schedule.containsKey(date)){
            List<String> events = new ArrayList<String>();
            events.add(eventName);
            schedule.put(date, events);
        }
        //if list contains another event with same date
        else {
            List<String> events = schedule.get(date);
            events.add(eventName);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}