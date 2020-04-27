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

    public double updateSDNN(String message)
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
            String SDNN = start.toString();
            try {
                double updatedSDNN = Double.parseDouble(SDNN);
                // CAN COMMENT NEXT 4 LINES OF CODE SINCE WE HAVE ONLY LISTS
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("SDNN")
//                        .setValue(updatedSDNN);
                return updatedSDNN;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateCOV(String message)
    {
        if (message.contains("f"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'f')
                {
                    started = true;
                }
                if (message.charAt(i) == 'g')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String COV = start.toString();
            try {
                double updatedCOV = Double.parseDouble(COV);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("COV")
//                        .setValue(updatedCOV);
                return updatedCOV;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateSDSD(String message)
    {
        if (message.contains("g"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'g')
                {
                    started = true;
                }
                if (message.charAt(i) == 'h')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String SDSD = start.toString();
            try {
                double updatedSDSD = Double.parseDouble(SDSD);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("SDSD")
//                        .setValue(updatedSDSD);
                return updatedSDSD;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateRMSSD(String message)
    {
        if (message.contains("h"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'h')
                {
                    started = true;
                }
                if (message.charAt(i) == 'i')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String RMSSD = start.toString();
            try {
                double updatedRMSSD = Double.parseDouble(RMSSD);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("RMSSD")
//                        .setValue(updatedRMSSD);
                return updatedRMSSD;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public double updateNN50(String message)
    {
        if (message.contains("i"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'i')
                {
                    started = true;
                }
                if (message.charAt(i) == 'j')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String NN50 = start.toString();
            try {
                double updatedNN50 = Double.parseDouble(NN50);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("NN50")
//                        .setValue(updatedNN50);
                return updatedNN50;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }


    public double updatepNN50(String message)
    {
        if (message.contains("j"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'j')
                {
                    started = true;
                }
                if (message.charAt(i) == 'k')
                {
                    started = false;
                }
                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String pNN50 = start.toString();
            try {
                double updatedpNN50 = Double.parseDouble(pNN50);
//                FirebaseDatabase.getInstance()
//                        .getReference()
//                        .child("pNN50")
//                        .setValue(updatedpNN50);
                return updatedpNN50;
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


    public double updateLongHRV(String message)
    {
        if (message.contains("k"))
        {
            StringBuilder start = new StringBuilder();
            boolean started = false;
            for (int i=1;i<message.length();i++)
            {
                if (message.charAt(i-1) == 'k')
                {
                    started = true;
                }
                if (message.charAt(i) == 'l')
                {
                    started = false;
                }


                if (started)
                {
                    start.append(message.charAt(i));
                }
            }
            String LongHRV = start.toString();

            try {
//                int updatedSP02 = Integer.parseInt(SP02);
                double updatedLongHRV = Double.parseDouble(LongHRV);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("LongHRV")
                        .setValue(updatedLongHRV);
                return updatedLongHRV;
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
        double SDNN = updateSDNN(message);
        double COV = updateCOV(message);
        double SDSD = updateSDSD(message);
        double RMSSD = updateRMSSD(message);
        double NN50 = updateNN50(message);
        double pNN50 = updatepNN50(message);
        double HR = updateHeartRate(message);
        double LongHRV = updateLongHRV(message);

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

            /* SDNN list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SDNNList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SDNNList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SDNNList")
                    .child(time)
                    .child("score")
                    .setValue(SDNN);

            /* SDSD list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SDSDList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SDSDList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("SDSDList")
                    .child(time)
                    .child("score")
                    .setValue(SDSD);

            /* RMSSD list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("RMSSDList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("RMSSDList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("RMSSDList")
                    .child(time)
                    .child("score")
                    .setValue(RMSSD);

            /* NN50 list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("NN50List")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("NN50List")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("NN50List")
                    .child(time)
                    .child("score")
                    .setValue(NN50);

            /* pNN50 list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("pNN50List")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("pNN50List")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("pNN50List")
                    .child(time)
                    .child("score")
                    .setValue(pNN50);
            /* COV list */
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("COVList")
                    .child(time)
                    .child("hour")
                    .setValue(hourOfDay);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("COVList")
                    .child(time)
                    .child("minute")
                    .setValue(minute);
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("COVList")
                    .child(time)
                    .child("score")
                    .setValue(COV);

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

            if (message.contains("l")) {
                /* Long HRV list */
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("LongHRVList")
                        .child(time)
                        .child("hour")
                        .setValue(hourOfDay);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("LongHRVList")
                        .child(time)
                        .child("minute")
                        .setValue(minute);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("LongHRVList")
                        .child(time)
                        .child("ratio")
                        .setValue(LongHRV);
            }

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