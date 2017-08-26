package com.willbank.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.willbank.R;
import com.willbank.activity.HomeActivity;
import com.willbank.dialog.AwardDialog;

public class HomeFragment extends Fragment {
    ImageView calendar;
    Handler handler;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        handler = new Handler();
        //progress bar
        RoundCornerProgressBar progress = (RoundCornerProgressBar) view.findViewById(R.id.progress);
        progress.setMax(100);
        progress.setProgress(72);
        calendar = (ImageView) view.findViewById(R.id.calendar);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                calendar.setImageResource(R.drawable.img_cal_today2);
                Glide.with(getContext())
                        .load(R.drawable.img_cal_today2)
                        .animate(android.R.anim.fade_in)
                        .into(calendar);



                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                AwardDialog awardDialog = new AwardDialog(getContext());
                                awardDialog.show();

                                Vibrator vibe = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
                                vibe.vibrate(1000);

                                Intent intent = new Intent(getActivity(), HomeActivity.class);
                                //        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                                NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(getContext())
                                        .setSmallIcon(R.drawable.logo)
                                        .setContentTitle("9/23 13:35 927103-**-***174 (주)윌뱅크 체크카드입금")
                                        .setContentText("60,000 잔액 12,560,000")
                                        .setAutoCancel(true)
                                        .setSound(defaultSoundUri)
                                        .setTicker("NotificationCompat.Builder")
                                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                                        .setContentIntent(pendingIntent)
                                        .setPriority(Notification.PRIORITY_HIGH);
                                NotificationManager notificationManager =
                                        (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);

                                notificationManager.notify(0, notificationBuilder.build());
                            }
                        });
                    }
                }).start();

            }
        });


//        int progressColor1 = progress.getProgressColor();
//        int backgroundColor1 = progress.getProgressBackgroundColor();
//        int max1 = (int) progress.getMax();
//        int progress1 = (int) progress.getProgress();

        return view;
    }


}
