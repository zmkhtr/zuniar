package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<EventDay> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        events.add(new EventDay(calendar, R.drawable.ic_arrow_left));

        events.add(new EventDay(calendar, R.drawable.ic_arrow_left, Color.parseColor("#228B22")));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                List<Date> date = new ArrayList<>();
                try {
                    date.add(formatter.parse("07-07-2020"));
                    date.add(formatter.parse("10-07-2020"));
                    date.add(formatter.parse("12-07-2020"));
                    date.add(formatter.parse("14-07-2020"));
                    date.add(formatter.parse("15-07-2020"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                for (int i = 0 ; i < date.size(); i++){
                    events.add(new EventDay(DateToCalendar(date.get(i)), R.mipmap.ic_launcher_round, Color.parseColor("#228B22")));
                }

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setEvents(events);

        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                Log.d(TAG, "onDayClick: " + eventDay.getCalendar());



                events.add(new EventDay(eventDay.getCalendar(), R.mipmap.ic_launcher_round, Color.parseColor("#228B22")));
                calendarView.setEvents(events);


            }
        });


    }

    public static Calendar DateToCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}