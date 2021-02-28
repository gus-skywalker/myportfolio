package com.example.sephirot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/*
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
*/


public class SephiraActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "sephiraID";

    private Button buttonOK;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sephira);

        int sephiraID = (Integer) getIntent().getExtras().get(EXTRA_ID);
        Sephira sephira = Sephira.sephiraLibrary[sephiraID];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(sephira.getName());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(sephira.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photoSephira);
        photo.setImageResource(sephira.getImageResourceId());
        photo.setContentDescription(sephira.getName());


        buttonOK = findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                finish();
            }
        });

       MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
       // Shows up Interstitial Ad
       mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(request);

        // Shows up Banner Ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


    }

}