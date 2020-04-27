package com.example.android.bluetoothlegatt.graphs;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.bluetoothlegatt.IResponse;
import com.example.android.bluetoothlegatt.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class SDNNGraphActivity extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdnn);

        lineChart = findViewById(R.id.line_chart_sdnn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData(new IResponse<ArrayList<Map<String, Object>>>() {
            @Override
            public void success(ArrayList<Map<String, Object>> data) {
                ArrayList<Entry> values1 = new ArrayList<>();

                for (Map<String, Object> entry : data) {
                    long hour = (long) entry.get("hour");

                    String num = String.valueOf(entry.get("minute"));
                    double[] digits = new double[num.length()];
                    for (int k = 0 ; k < num.length() ; k++) {
                        digits[k] = Double.parseDouble(num.substring(k,k+1)) ;
                        if (k == 0) {
                            digits[k] = digits[k] * 0.15;
                        } else if (k == 1) {
                            digits[k] = digits[k] * 0.015;
                        }
                    }

                    double minute = 0;
                    for (int j = 0 ; j < digits.length ; j++) {
                        minute += digits[j];
                    }

                    double time = hour + minute;

                    double score = Double.parseDouble(String.valueOf(entry.get("score")));
                    Log.e(getClass().getName(), "TIME: " + time);

                    values1.add(new Entry((float) time, (float) score));
                }

                values1.sort(new Comparator<Entry>() {
                    @Override
                    public int compare(Entry entry, Entry t1) {
                        float change1 = entry.getX();
                        float change2 = t1.getX();
                        if (change1 < change2) return -1;
                        if (change1 > change2) return 1;
                        return 0;
                    }
                });

                LineDataSet d1 = new LineDataSet(values1, "SDNN " + data.size() + ", (1)");
                d1.setLineWidth(2.5f);
                d1.setCircleRadius(4.5f);
                d1.setHighLightColor(Color.rgb(244, 117, 117));
                d1.setDrawValues(false);

                ArrayList<ILineDataSet> sets = new ArrayList<>();
                sets.add(d1);

                lineChart.setData(new LineData(sets));
                lineChart.notifyDataSetChanged();
                lineChart.invalidate();
            }

            @Override
            public void fail() {

            }
        });
    }

    private void getData(final IResponse<ArrayList<Map<String, Object>>> SDNN_response) {
        DatabaseReference SDNNList_list = FirebaseDatabase.getInstance().getReference().child("SDNNList");
        SDNNList_list.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> SDNNList_children = dataSnapshot.getChildren();
                ArrayList<Map<String, Object>> mapList = new ArrayList<>();
                for (DataSnapshot child : SDNNList_children) {
                    Map<String, Object> map = (Map<String, Object>) child.getValue();
                    Log.e(getClass().getName(), map.toString());
                    long hour = (long) map.get("hour");
                    double score = Double.parseDouble(String.valueOf(map.get("score")));
                    Log.e(getClass().getName(), "hour: " + hour + ", score: " + score);
                    mapList.add(map);
                }

                SDNN_response.success(mapList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                SDNN_response.fail();
            }
        });
    }


}
