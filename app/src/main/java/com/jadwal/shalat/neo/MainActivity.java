package com.jadwal.shalat.neo;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker alarmTimePicker;
    PendingIntent pendingIntentImsak,pendingIntentSubuh,pendingIntentDjuhur,pendingIntentAshar,pendingIntentMaghrib,pendingIntentIsya;
    AlarmManager alarmManager;
    ToggleButton imageImsak,imageSubuh,imageDjuhur,imageAshar,imageMaghrib,imageIsya;
    private TextView displayTimeImsak,displayTimeSubuh,displayTimeDjuhur,displayTimeAshar,displayTimeMaghrib,displayTimeIsya;
    private int pHour;
    private int pMinute;
    int pJamImsak,pJamSubuh,pJamDjuhur,pJamAshar,pJamMaghrib,pJamIsya ;
    int pMenitImsak,pMenitSubuh,pMenitDjuhur,pMenitAshar,pMenitMaghrib,pMenitIsya;
    private Calendar calendar;

    String jam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        displayTimeImsak = (TextView) findViewById(R.id.txtImsakTime);
        displayTimeSubuh = (TextView) findViewById(R.id.txtSubuhTime);
        displayTimeDjuhur = (TextView) findViewById(R.id.txtDjuhurTime);
        displayTimeAshar = (TextView) findViewById(R.id.txtAsharTime);
        displayTimeMaghrib = (TextView) findViewById(R.id.txtMaghribTime);
        displayTimeIsya = (TextView) findViewById(R.id.txtIsyaTime);
        imageImsak = (ToggleButton) findViewById(R.id.imageImsak);
        imageSubuh = (ToggleButton) findViewById(R.id.imageSubuh);
        imageDjuhur = (ToggleButton) findViewById(R.id.imageDjuhur);
        imageAshar = (ToggleButton) findViewById(R.id.imageAshar);
        imageMaghrib = (ToggleButton) findViewById(R.id.imageMaghrib);
        imageIsya = (ToggleButton) findViewById(R.id.imageIsya);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        calendar = Calendar.getInstance();
        pHour = calendar.get(Calendar.HOUR_OF_DAY);
        pMinute = calendar.get(Calendar.MINUTE);

    }

    public void setTimeImsak(View view) {
        showDialog(444);
        updateDisplayImsak();
    }
    public void setTimeSubuh(View view) {
        showDialog(445);
        updateDisplaySubuh();
    }
    public void setTimeDjuhur(View view) {
        showDialog(446);
        updateDisplayDjuhur();
    }
    public void setTimeAshar(View view) {
        showDialog(447);
        updateDisplayAshar();
    }
    public void setTimeMaghrib(View view) {
        showDialog(448);
        updateDisplayMaghrib();
    }
    public void setTimeIsya(View view) {
        showDialog(449);
        updateDisplayIsya();
    }

    private void updateDisplayImsak() {
        displayTimeImsak.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
        pJamImsak = pHour;
        pMenitImsak = pMinute;

    }

    private void updateDisplaySubuh() {
        displayTimeSubuh.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
        pJamSubuh = pHour;
        pMenitSubuh = pMinute;

    }

    private void updateDisplayDjuhur() {
        displayTimeDjuhur.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
        pJamDjuhur = pHour;
        pMenitDjuhur = pMinute;

    }

    private void updateDisplayAshar() {
        displayTimeAshar.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
        pJamAshar = pHour;
        pMenitAshar = pMinute;

    }

    private void updateDisplayMaghrib() {
        displayTimeMaghrib.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
        pJamMaghrib = pHour;
        pMenitMaghrib = pMinute;

    }

    private void updateDisplayIsya() {
        displayTimeIsya.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
        pJamIsya = pHour;
        pMenitIsya = pMinute;

    }

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerImsak =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
                    updateDisplayImsak();
                    jam = pHour + ":" + pMinute;
                    displayToast();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerSubuh =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
                    updateDisplaySubuh();
                    jam = pHour + ":" + pMinute;
                    displayToast();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerDjuhur =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
                    updateDisplayDjuhur();
                    jam = pHour + ":" + pMinute;
                    displayToast();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerAshar =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
                    updateDisplayAshar();
                    jam = pHour + ":" + pMinute;
                    displayToast();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerMaghrib =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
                    updateDisplayMaghrib();
                    jam = pHour + ":" + pMinute;
                    displayToast();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerIsya =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
                    updateDisplayIsya();
                    jam = pHour + ":" + pMinute;
                    displayToast();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 444) {
            return new TimePickerDialog(this,
                    mTimeSetListenerImsak, pHour, pMinute, false);
        }else if (id == 445) {
            return new TimePickerDialog(this,
                    mTimeSetListenerSubuh, pHour, pMinute, false);
        }else if (id == 446) {
            return new TimePickerDialog(this,
                    mTimeSetListenerDjuhur, pHour, pMinute, false);
        }else if (id == 447) {
            return new TimePickerDialog(this,
                    mTimeSetListenerAshar, pHour, pMinute, false);
        }else if (id == 448) {
            return new TimePickerDialog(this,
                    mTimeSetListenerMaghrib, pHour, pMinute, false);
        }else if (id == 449) {
            return new TimePickerDialog(this,
                    mTimeSetListenerIsya, pHour, pMinute, false);
        }
        return null;
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }


    private void displayToast() {
        Toast.makeText(this, jam, Toast.LENGTH_SHORT).show();
    }


    public void OnToggleClickedImsak(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(MainActivity.this, "ALARM IMSAK ON", Toast.LENGTH_SHORT).show();
            imageImsak.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, pJamImsak);
            calendar.set(Calendar.MINUTE, pMenitImsak);
            Intent intentImsak = new Intent(this, AlarmReceiverImsak.class);
            pendingIntentImsak = PendingIntent.getBroadcast(this, 0, intentImsak, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntentImsak);
        } else {
            alarmManager.cancel(pendingIntentImsak);
            Toast.makeText(MainActivity.this, "ALARM IMSAK OFF", Toast.LENGTH_SHORT).show();
            imageImsak.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
        }
    }

    public void OnToggleClickedSubuh(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(MainActivity.this, "ALARM SUBUH ON", Toast.LENGTH_SHORT).show();
            imageSubuh.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, pJamSubuh);
            calendar.set(Calendar.MINUTE, pMenitSubuh);
            Intent intentSubuh = new Intent(this, AlarmReceiverSubuh.class);
            pendingIntentSubuh = PendingIntent.getBroadcast(this, 0, intentSubuh, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntentSubuh);
        } else {
            alarmManager.cancel(pendingIntentSubuh);
            Toast.makeText(MainActivity.this, "ALARM SUBUH OFF", Toast.LENGTH_SHORT).show();
            imageSubuh.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
        }
    }

    public void OnToggleClickedDjuhur(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(MainActivity.this, "ALARM DJUHUR ON", Toast.LENGTH_SHORT).show();
            imageDjuhur.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, pJamDjuhur);
            calendar.set(Calendar.MINUTE, pMenitDjuhur);
            Intent intentDjuhur = new Intent(this, AlarmReceiverDjuhur.class);
            pendingIntentDjuhur = PendingIntent.getBroadcast(this, 0, intentDjuhur, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntentDjuhur);
        } else {
            alarmManager.cancel(pendingIntentDjuhur);
            Toast.makeText(MainActivity.this, "ALARM DJUHUR OFF", Toast.LENGTH_SHORT).show();
            imageDjuhur.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
        }
    }

    public void OnToggleClickedAshar(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(MainActivity.this, "ALARM ASHAR ON", Toast.LENGTH_SHORT).show();
            imageAshar.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, pJamAshar);
            calendar.set(Calendar.MINUTE, pMenitAshar);
            Intent intentAshar = new Intent(this, AlarmReceiverAshar.class);
            pendingIntentAshar = PendingIntent.getBroadcast(this, 0, intentAshar, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntentAshar);
        } else {
            alarmManager.cancel(pendingIntentAshar);
            Toast.makeText(MainActivity.this, "ALARM ASHAR OFF", Toast.LENGTH_SHORT).show();
            imageAshar.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
        }
    }

    public void OnToggleClickedMaghrib(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(MainActivity.this, "ALARM MAGHRIB ON", Toast.LENGTH_SHORT).show();
            imageMaghrib.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, pJamMaghrib);
            calendar.set(Calendar.MINUTE, pMenitMaghrib);
            Intent intentMaghrib = new Intent(this, AlarmReceiverMaghrib.class);
            pendingIntentMaghrib = PendingIntent.getBroadcast(this, 0, intentMaghrib, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntentMaghrib);
        } else {
            alarmManager.cancel(pendingIntentMaghrib);
            Toast.makeText(MainActivity.this, "ALARM MAGHRIB OFF", Toast.LENGTH_SHORT).show();
            imageMaghrib.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
        }
    }

    public void OnToggleClickedIsya(View view) {
        long time;
        if (((ToggleButton) view).isChecked()) {
            Toast.makeText(MainActivity.this, "ALARM ISYA ON", Toast.LENGTH_SHORT).show();
            imageIsya.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, pJamIsya);
            calendar.set(Calendar.MINUTE, pMenitIsya);
            Intent intentIsya = new Intent(this, AlarmReceiverIsya.class);
            pendingIntentIsya = PendingIntent.getBroadcast(this, 0, intentIsya, 0);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntentIsya);
        } else {
            alarmManager.cancel(pendingIntentIsya);
            Toast.makeText(MainActivity.this, "ALARM ISYA OFF", Toast.LENGTH_SHORT).show();
            imageIsya.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
        }
    }

}
