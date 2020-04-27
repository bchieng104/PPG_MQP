package com.example.android.bluetoothlegatt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.bluetoothlegatt.R;
import com.example.android.bluetoothlegatt.IResponse;
import com.example.android.bluetoothlegatt.graphs.COVGraphActivity;
import com.example.android.bluetoothlegatt.graphs.NN50GraphActivity;
import com.example.android.bluetoothlegatt.graphs.RMSSDGraphActivity;
import com.example.android.bluetoothlegatt.graphs.SDNNGraphActivity;
import com.example.android.bluetoothlegatt.graphs.SDSDGraphActivity;
import com.example.android.bluetoothlegatt.graphs.SP02GraphActivity;
import com.example.android.bluetoothlegatt.graphs.pNN50GraphActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class HRVGraphActivity extends AppCompatActivity {

    Button SDNN_button;
    Button COV_button;
    Button SDSD_button;
    Button RMSSD_button;
    Button NN50_button;
    Button pNN50_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_hrvgraph);

        final Intent intent = getIntent();

        SDNN_button = findViewById(R.id.SDNN);
        COV_button = findViewById(R.id.COV);
        SDSD_button = findViewById(R.id.SDSD);
        RMSSD_button = findViewById(R.id.RMSSD);
        NN50_button = findViewById(R.id.NN50);
        pNN50_button = findViewById(R.id.pNN50);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClick_SDNN(View view) {
        Intent intent = new Intent(HRVGraphActivity.this, SDNNGraphActivity.class);
        startActivity(intent);
    }

    public void onClick_SDSD(View view) {
        Intent intent = new Intent(HRVGraphActivity.this, SDSDGraphActivity.class);
        startActivity(intent);
    }

    public void onClick_COV(View view) {
        Intent intent = new Intent(HRVGraphActivity.this, COVGraphActivity.class);
        startActivity(intent);
    }

    public void onClick_RMSSD(View view) {
        Intent intent = new Intent(HRVGraphActivity.this, RMSSDGraphActivity.class);
        startActivity(intent);
    }

    public void onClick_NN50(View view) {
        Intent intent = new Intent(HRVGraphActivity.this, NN50GraphActivity.class);
        startActivity(intent);
    }

    public void onClick_pNN50(View view) {
        Intent intent = new Intent(HRVGraphActivity.this, pNN50GraphActivity.class);
        startActivity(intent);
    }
//    LineChart lineChart;
//    final int[] red = new int[]{244, 255, 0, 0, 0, 117};
//    final int[] green = new int[]{117, 0, 0, 255, 0, 117};
//    final int[] blue = new int[]{117, 0, 0, 0, 255, 244};;
//    final String[] datasets = new String[]{"SDNN","COV","SDSD","RMSSD","NN50","pNN50"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hrvgraph);
//
//        lineChart = findViewById(R.id.line_chart_hrv);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//            getData(red[0], green[0], blue[0], datasets[0], new IResponse<ArrayList<Map<String, Object>>>() {
//                @Override
//                public void success(ArrayList<Map<String, Object>> data) {
//                    ArrayList<Entry> values1 = new ArrayList<>();
//
//                    for (Map<String, Object> entry : data) {
//                        long hour = (long) entry.get("hour");
//                        double score = Double.parseDouble(String.valueOf(entry.get("score")));
//
//                        // double score = (double) entry.get("score");
//                        Log.e(getClass().getName(), "HOUR: " + hour);
//
//                        values1.add(new Entry((int) hour, (float) score));
//                    }
//
//                    values1.sort(new Comparator<Entry>() {
//                        @Override
//                        public int compare(Entry entry, Entry t1) {
//                            float change1 = entry.getX();
//                            float change2 = t1.getX();
//                            if (change1 < change2) return -1;
//                            if (change1 > change2) return 1;
//                            return 0;
//                        }
//                    });
//
//                    LineDataSet d1 = new LineDataSet(values1, datasets[0] + " " + data.size() + ", (1)");
//                    d1.setLineWidth(2.5f);
//                    d1.setCircleRadius(4.5f);
//                    d1.setHighLightColor(Color.rgb(red[0], green[0], blue[0]));
//                    d1.setDrawValues(false);
//
//                    ArrayList<ILineDataSet> sets = new ArrayList<>();
//                    sets.add(d1);
//
//                    lineChart.setData(new LineData(sets));
//                    lineChart.notifyDataSetChanged();
//                    lineChart.invalidate();
//                }
//
//                @Override
//                public void fail() {
//
//                }
//            });
//
//        getData(red[1], green[1], blue[1], datasets[1], new IResponse<ArrayList<Map<String, Object>>>() {
//            @Override
//            public void success(ArrayList<Map<String, Object>> data) {
//                ArrayList<Entry> values1 = new ArrayList<>();
//
//                for (Map<String, Object> entry : data) {
//                    long hour = (long) entry.get("hour");
//                    double score = Double.parseDouble(String.valueOf(entry.get("score")));
//
//                    // double score = (double) entry.get("score");
//                    Log.e(getClass().getName(), "HOUR: " + hour);
//
//                    values1.add(new Entry((int) hour, (float) score));
//                }
//
//                values1.sort(new Comparator<Entry>() {
//                    @Override
//                    public int compare(Entry entry, Entry t1) {
//                        float change1 = entry.getX();
//                        float change2 = t1.getX();
//                        if (change1 < change2) return -1;
//                        if (change1 > change2) return 1;
//                        return 0;
//                    }
//                });
//
//                LineDataSet d1 = new LineDataSet(values1, datasets[1] + " " + data.size() + ", (1)");
//                d1.setLineWidth(2.5f);
//                d1.setCircleRadius(4.5f);
//                d1.setHighLightColor(Color.rgb(red[1], green[1], blue[1]));
//                d1.setDrawValues(false);
//
//                ArrayList<ILineDataSet> sets = new ArrayList<>();
//                sets.add(d1);
//
//                lineChart.setData(new LineData(sets));
//                lineChart.notifyDataSetChanged();
//                lineChart.invalidate();
//            }
//
//            @Override
//            public void fail() {
//
//            }
//        });
//
//        getData(red[2], green[2], blue[2], datasets[2], new IResponse<ArrayList<Map<String, Object>>>() {
//            @Override
//            public void success(ArrayList<Map<String, Object>> data) {
//                ArrayList<Entry> values1 = new ArrayList<>();
//
//                for (Map<String, Object> entry : data) {
//                    long hour = (long) entry.get("hour");
//                    double score = Double.parseDouble(String.valueOf(entry.get("score")));
//
//                    // double score = (double) entry.get("score");
//                    Log.e(getClass().getName(), "HOUR: " + hour);
//
//                    values1.add(new Entry((int) hour, (float) score));
//                }
//
//                values1.sort(new Comparator<Entry>() {
//                    @Override
//                    public int compare(Entry entry, Entry t1) {
//                        float change1 = entry.getX();
//                        float change2 = t1.getX();
//                        if (change1 < change2) return -1;
//                        if (change1 > change2) return 1;
//                        return 0;
//                    }
//                });
//
//                LineDataSet d1 = new LineDataSet(values1, datasets[2] + " " + data.size() + ", (1)");
//                d1.setLineWidth(2.5f);
//                d1.setCircleRadius(4.5f);
//                d1.setHighLightColor(Color.rgb(red[2], green[2], blue[2]));
//                d1.setDrawValues(false);
//
//                ArrayList<ILineDataSet> sets = new ArrayList<>();
//                sets.add(d1);
//
//                lineChart.setData(new LineData(sets));
//                lineChart.notifyDataSetChanged();
//                lineChart.invalidate();
//            }
//
//            @Override
//            public void fail() {
//
//            }
//        });
//
//        getData(red[3], green[3], blue[3], datasets[3], new IResponse<ArrayList<Map<String, Object>>>() {
//            @Override
//            public void success(ArrayList<Map<String, Object>> data) {
//                ArrayList<Entry> values1 = new ArrayList<>();
//
//                for (Map<String, Object> entry : data) {
//                    long hour = (long) entry.get("hour");
//                    double score = Double.parseDouble(String.valueOf(entry.get("score")));
//
//                    // double score = (double) entry.get("score");
//                    Log.e(getClass().getName(), "HOUR: " + hour);
//
//                    values1.add(new Entry((int) hour, (float) score));
//                }
//
//                values1.sort(new Comparator<Entry>() {
//                    @Override
//                    public int compare(Entry entry, Entry t1) {
//                        float change1 = entry.getX();
//                        float change2 = t1.getX();
//                        if (change1 < change2) return -1;
//                        if (change1 > change2) return 1;
//                        return 0;
//                    }
//                });
//
//                LineDataSet d1 = new LineDataSet(values1, datasets[3] + " " + data.size() + ", (1)");
//                d1.setLineWidth(2.5f);
//                d1.setCircleRadius(4.5f);
//                d1.setHighLightColor(Color.rgb(red[3], green[3], blue[3]));
//                d1.setDrawValues(false);
//
//                ArrayList<ILineDataSet> sets = new ArrayList<>();
//                sets.add(d1);
//
//                lineChart.setData(new LineData(sets));
//                lineChart.notifyDataSetChanged();
//                lineChart.invalidate();
//            }
//
//            @Override
//            public void fail() {
//
//            }
//        });
//
//        getData(red[4], green[4], blue[4], datasets[4], new IResponse<ArrayList<Map<String, Object>>>() {
//            @Override
//            public void success(ArrayList<Map<String, Object>> data) {
//                ArrayList<Entry> values1 = new ArrayList<>();
//
//                for (Map<String, Object> entry : data) {
//                    long hour = (long) entry.get("hour");
//                    double score = Double.parseDouble(String.valueOf(entry.get("score")));
//
//                    // double score = (double) entry.get("score");
//                    Log.e(getClass().getName(), "HOUR: " + hour);
//
//                    values1.add(new Entry((int) hour, (float) score));
//                }
//
//                values1.sort(new Comparator<Entry>() {
//                    @Override
//                    public int compare(Entry entry, Entry t1) {
//                        float change1 = entry.getX();
//                        float change2 = t1.getX();
//                        if (change1 < change2) return -1;
//                        if (change1 > change2) return 1;
//                        return 0;
//                    }
//                });
//
//                LineDataSet d1 = new LineDataSet(values1, datasets[4] + " " + data.size() + ", (1)");
//                d1.setLineWidth(2.5f);
//                d1.setCircleRadius(4.5f);
//                d1.setHighLightColor(Color.rgb(red[4], green[4], blue[4]));
//                d1.setDrawValues(false);
//
//                ArrayList<ILineDataSet> sets = new ArrayList<>();
//                sets.add(d1);
//
//                lineChart.setData(new LineData(sets));
//                lineChart.notifyDataSetChanged();
//                lineChart.invalidate();
//            }
//
//            @Override
//            public void fail() {
//
//            }
//        });
//
//        getData(red[5], green[5], blue[5], datasets[5], new IResponse<ArrayList<Map<String, Object>>>() {
//            @Override
//            public void success(ArrayList<Map<String, Object>> data) {
//                ArrayList<Entry> values1 = new ArrayList<>();
//
//                for (Map<String, Object> entry : data) {
//                    long hour = (long) entry.get("hour");
//                    double score = Double.parseDouble(String.valueOf(entry.get("score")));
//
//                    // double score = (double) entry.get("score");
//                    Log.e(getClass().getName(), "HOUR: " + hour);
//
//                    values1.add(new Entry((int) hour, (float) score));
//                }
//
//                values1.sort(new Comparator<Entry>() {
//                    @Override
//                    public int compare(Entry entry, Entry t1) {
//                        float change1 = entry.getX();
//                        float change2 = t1.getX();
//                        if (change1 < change2) return -1;
//                        if (change1 > change2) return 1;
//                        return 0;
//                    }
//                });
//
//                LineDataSet d1 = new LineDataSet(values1, datasets[5] + " " + data.size() + ", (1)");
//                d1.setLineWidth(2.5f);
//                d1.setCircleRadius(4.5f);
//                d1.setHighLightColor(Color.rgb(red[5], green[5], blue[5]));
//                d1.setDrawValues(false);
//
//                ArrayList<ILineDataSet> sets = new ArrayList<>();
//                sets.add(d1);
//
//                lineChart.setData(new LineData(sets));
//                lineChart.notifyDataSetChanged();
//                lineChart.invalidate();
//            }
//
//            @Override
//            public void fail() {
//
//            }
//        });
//
//    }
//
//    private void getData( final int red, final int green, final int blue, final String dataset, final IResponse<ArrayList<Map<String, Object>>> HRV_response) {
//        String databaseList = dataset + "List";
//        DatabaseReference list = FirebaseDatabase.getInstance().getReference().child(databaseList);
//
//        list.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Iterable<DataSnapshot> list_children = dataSnapshot.getChildren();
//                ArrayList<Map<String, Object>> mapList = new ArrayList<>();
//                for (DataSnapshot child : list_children) {
//                    Map<String, Object> map = (Map<String, Object>) child.getValue();
//                    Log.e(getClass().getName(), map.toString());
//                    long hour = (long) map.get("hour");
//                    double score = Double.parseDouble(String.valueOf(map.get("score")));
////                    double score = (double) map.get("score");
//                    Log.e(getClass().getName(), "hour: " + hour + ", score: " + score);
//                    mapList.add(map);
//                }
//
//                HRV_response.success(mapList); // TODO: make success function have arguments for rgb and title of legend
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                HRV_response.fail();
//            }
//        });
//    }
}
