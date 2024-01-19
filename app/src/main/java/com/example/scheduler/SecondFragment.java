package com.example.scheduler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.scheduler.databinding.NewEventBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SecondFragment extends Fragment {

    private NewEventBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = NewEventBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override // current action: navigate from new_event to fragment_first
            public void onClick(View view) {
                String eventName = binding.eventLabel.getEditText().getText().toString();
                Log.v("EditText", eventName);

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

//        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
//        materialDateBuilder.setTitleText("SELECT A DATE");
//        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
        MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        binding.selectDate.setStartIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show(getActivity().getSupportFragmentManager(), "icon_date_picker");
            }
        });

        datePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
//                        calendar.setTimeInMillis(selection);
//                        Date date = calendar.getTime();
//                        Log.v("DatePicker", DateFormat.format("dd/MM/yyyy", new Date(selection)).toString());
//                        Log.v("TimeInMillis", calendar.getTime().toString());

                        TimeZone timeZoneUTC = TimeZone.getDefault();
                        int offsetFromUTC = timeZoneUTC.getOffset(new Date().getTime()) * -1;
                        SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
//                        Date offset_date = new Date(selection + offsetFromUTC);
                        calendar.setTimeInMillis(selection + offsetFromUTC);
                        Date date = calendar.getTime();
                        Log.v("DatePickerWithOffset", date.toString());
                        binding.selectDate.getEditText().setText(simpleFormat.format(date));
                    }
                });



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}