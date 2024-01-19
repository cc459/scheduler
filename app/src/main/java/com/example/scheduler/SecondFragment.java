package com.example.scheduler;

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
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SecondFragment extends Fragment {

    private NewEventBinding binding;
    private String eventName;
    private Date eventDate;

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

                eventName = binding.eventLabel.getEditText().getText().toString();
                Log.v("EditText", eventName);

                if (eventName.isEmpty() || eventDate == null) {
                    if (eventName.isEmpty()) {
                        Log.v("Empty Label", "Event name is empty.");
                    }
                    if (eventDate == null) {
                        Log.v("Empty Label", "Event date is empty.");
                    }
                    Snackbar.make(view, "Please do not leave any fields empty!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show();
                } else {
                    Event event = new Event(eventName, eventDate);
                    FirstFragment.orderEvent(event.getEventDate(), event.getEventName());

                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_FirstFragment);
                }

            }
        });

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
                        // create calendar
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                        TimeZone timeZoneUTC = TimeZone.getDefault();
                        int offsetFromUTC = timeZoneUTC.getOffset(new Date().getTime()) * -1;
                        SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                        // set date with offset
                        calendar.setTimeInMillis(selection + offsetFromUTC);
                        eventDate = calendar.getTime();
                        Log.v("DatePickerWithOffset", eventDate.toString());
                        // show selection in edittext field
                        binding.selectDate.getEditText().setText(simpleFormat.format(eventDate));
                    }
                });



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}