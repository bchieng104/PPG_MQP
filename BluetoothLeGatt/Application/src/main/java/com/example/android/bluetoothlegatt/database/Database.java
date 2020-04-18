package com.example.android.bluetoothlegatt.database;

import com.google.firebase.database.FirebaseDatabase;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Database {
    private static final Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
    }

    public double updateHeartRate(String message)
    {
        if (message.contains("b"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'b')
                {
                    started = true;
                }
                if (message.charAt(i) == 'c')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String HR = start.toString();
            try {
                double updatedHR = Double.parseDouble(HR);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("HeartRate")
                        .setValue(updatedHR);
                return updatedHR;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateHRV(String message)
    {
        if (message.contains("d"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'd')
                {
                    started = true;
                }
                if (message.charAt(i) == 'e')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String HRV = start.toString();
            try {
                double updatedHRV = Double.parseDouble(HRV);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("HRV")
                        .setValue(updatedHRV);
                return updatedHRV;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateRR(String message)
    {
        if (message.contains("c"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'c')
                {
                    started = true;
                }
                if (message.charAt(i) == 'd')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String RR = start.toString();
            try {
                double updatedRR = Double.parseDouble(RR);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("RespiratoryRate")
                        .setValue(updatedRR);
                return updatedRR;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateSP02(String message)
    {
        if (message.contains("a"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'a')
                {
                    started = true;
                }
                if (message.charAt(i) == 'b')
                {
                    started = false;
                }


                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String SP02 = start.toString();

            try {
//                int updatedSP02 = Integer.parseInt(SP02);
                double updatedSP02 = Double.parseDouble(SP02);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("SP02")
                        .setValue(updatedSP02);
                return updatedSP02;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public void addListEntries(String message)
    {
        double SP02 = updateSP02(message);
        double RR = updateRR(message);
        double HRV = updateHRV(message);
        double HR = updateHeartRate(message);

        if (message.contains("e"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'e')
                {
                    started = true;
                }
                if (message.charAt(i) == 'f')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String time = start.toString();
            long parsedTime = Long.valueOf(time);
            DateTime dateTime = new DateTime(parsedTime);
            int hourOfDay = dateTime.getHourOfDay();
            int minute = dateTime.getMinuteOfHour();

            /* HRV list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("HRVList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("HRVList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("HRVList")
                    .child(time)
                    .child("score")
                    .setValue(HRV);

            /* HeartRate list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("HeartRateList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("HeartRateList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("HeartRateList")
                    .child(time)
                    .child("bpm")
                    .setValue(HR);

            /* RespiratoryRate list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("RespiratoryRateList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("RespiratoryRateList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("RespiratoryRateList")
                    .child(time)
                    .child("breaths")
                    .setValue(RR);

            /* SP02 list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SP02List")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SP02List")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SP02List")
                    .child(time)
                    .child("ratio")
                    .setValue(SP02);
        }
    }
}
















//public class Database {
//    private static final Database ourInstance = new Database();
//
//    public static Database getInstance() {
//        return ourInstance;
//    }
//
//    private Database() {
//    }
//
//    public int updateHeartRate(String message)
//    {
//        if (message.contains("b"))
//        {
//            StringBuilder start = new StringBuilder();
//            boolean started = false;
//            for (int i=1;i<message.length();i++)
//            {
//                if (message.charAt(i-1) == 'b')
//                {
//                    started = true;
//                }
//                if (message.charAt(i) == 'c')
//                {
//                    started = false;
//                }
//                if (started)
//                {
//                    start.append(message.charAt(i));
//                }
//            }
//            String HR = start.toString();
//            try {
//                int updatedHR = Integer.parseInt(HR);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("HeartRate")
//                        .setValue(updatedHR);
//                return updatedHR;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return -1;
//    }
//
//    public int updateHRV(String message)
//    {
//        if (message.contains("d"))
//        {
//            StringBuilder start = new StringBuilder();
//            boolean started = false;
//            for (int i=1;i<message.length();i++)
//            {
//                if (message.charAt(i-1) == 'd')
//                {
//                    started = true;
//                }
//                if (message.charAt(i) == 'e')
//                {
//                    started = false;
//                }
//                if (started)
//                {
//                    start.append(message.charAt(i));
//                }
//            }
//            String HRV = start.toString();
//            try {
//                int updatedHRV = Integer.parseInt(HRV);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("HRV")
//                        .setValue(updatedHRV);
//                return updatedHRV;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return -1;
//    }
//
//    public int updateRR(String message)
//    {
//        if (message.contains("c"))
//        {
//            StringBuilder start = new StringBuilder();
//            boolean started = false;
//            for (int i=1;i<message.length();i++)
//            {
//                if (message.charAt(i-1) == 'c')
//                {
//                    started = true;
//                }
//                if (message.charAt(i) == 'd')
//                {
//                    started = false;
//                }
//                if (started)
//                {
//                    start.append(message.charAt(i));
//                }
//            }
//            String RR = start.toString();
//            try {
//                int updatedRR = Integer.parseInt(RR);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("RespiratoryRate")
//                        .setValue(updatedRR);
//                return updatedRR;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return -1;
//    }
//
//    public int updateSP02(String message)
//    {
//        if (message.contains("a"))
//        {
//            StringBuilder start = new StringBuilder();
//            boolean started = false;
//            for (int i=1;i<message.length();i++)
//            {
//                if (message.charAt(i-1) == 'a')
//                {
//                    started = true;
//                }
//                if (message.charAt(i) == 'b')
//                {
//                    started = false;
//                }
//                if (started)
//                {
//                    start.append(message.charAt(i));
//                }
//            }
//            String SP02 = start.toString();
//
//            try {
//                int updatedSP02 = Integer.parseInt(SP02);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("SP02")
//                        .setValue(updatedSP02);
//                return updatedSP02;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return -1;
//    }
//
//    public void addListEntries(String message)
//    {
//        int SP02 = updateSP02(message);
//        int RR = updateRR(message);
//        int HRV = updateHRV(message);
//        int HR = updateHeartRate(message);
//
//        if (message.contains("e"))
//        {
//            StringBuilder start = new StringBuilder();
//            boolean started = false;
//            for (int i=1;i<message.length();i++)
//            {
//                if (message.charAt(i-1) == 'e')
//                {
//                    started = true;
//                }
//                if (message.charAt(i) == 'f')
//                {
//                    started = false;
//                }
//                if (started)
//                {
//                    start.append(message.charAt(i));
//                }
//            }
//            String time = start.toString();
//            long parsedTime = Long.valueOf(time);
//            DateTime dateTime = new DateTime(parsedTime);
//            int hourOfDay = dateTime.getHourOfDay();
//            int minute = dateTime.getMinuteOfHour();
//
//            /* HRV list */
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("HRVList")
//                    .child(time)
//                    .child("hour")
//                    .setValue(hourOfDay);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("HRVList")
//                    .child(time)
//                    .child("minute")
//                    .setValue(minute);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("HRVList")
//                    .child(time)
//                    .child("ratio")
//                    .setValue(HRV);
//
//            /* HeartRate list */
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("HeartRateList")
//                    .child(time)
//                    .child("hour")
//                    .setValue(hourOfDay);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("HeartRateList")
//                    .child(time)
//                    .child("minute")
//                    .setValue(minute);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("HeartRateList")
//                    .child(time)
//                    .child("ratio")
//                    .setValue(HR);
//
//            /* RespiratoryRate list */
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("RespiratoryRateList")
//                    .child(time)
//                    .child("hour")
//                    .setValue(hourOfDay);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("RespiratoryRateList")
//                    .child(time)
//                    .child("minute")
//                    .setValue(minute);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("RespiratoryRateList")
//                    .child(time)
//                    .child("ratio")
//                    .setValue(RR);
//
//            /* SP02 list */
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("SP02List")
//                    .child(time)
//                    .child("hour")
//                    .setValue(hourOfDay);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("SP02List")
//                    .child(time)
//                    .child("minute")
//                    .setValue(minute);
//            FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("SP02List")
//                    .child(time)
//                    .child("ratio")
//                    .setValue(SP02);
//        }
//    }
//}