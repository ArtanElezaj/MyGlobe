package com.artan.myglobe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailsActivity extends AppCompatActivity {

    TextView mName, mAlpha3Code, mRegion, mCapital, mPopulation, mArea, mLanguages, mCurrencies, mTimezones, mCallingCodes, mBorders , mSubRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        mName = (TextView)findViewById(R.id.name);
        mAlpha3Code = (TextView)findViewById(R.id.alpha3Code);
        mRegion = (TextView)findViewById(R.id.region);
        mSubRegion = (TextView)findViewById(R.id.subRegion);
        mCapital = (TextView)findViewById(R.id.capital);
        mPopulation = (TextView)findViewById(R.id.population);
        mArea = (TextView)findViewById(R.id.area);
        mLanguages = (TextView)findViewById(R.id.languages);
        mCurrencies = (TextView)findViewById(R.id.currencies);
        mTimezones = (TextView)findViewById(R.id.timezones);
        mCallingCodes = (TextView)findViewById(R.id.callingCodes);
        mBorders = (TextView)findViewById(R.id.borders);

        Bundle bundle = getIntent().getExtras();
        mName.setText (bundle.getString("name"));
        mAlpha3Code.setText (bundle.getString("alpha3Code"));
        mRegion.setText (bundle.getString("region"));
        mSubRegion.setText (bundle.getString("subregion"));
        mCapital.setText (bundle.getString("capital"));
        mPopulation.setText (bundle.getString("population"));
        mArea.setText (bundle.getString("area") + " (sq km)");
        mLanguages.setText (printArray(bundle.getStringArray("languages")));
        mCurrencies.setText (printArray(bundle.getStringArray("currencies")));
        mTimezones.setText (printArray(bundle.getStringArray("timezones")));
        mCallingCodes.setText (printArray(bundle.getStringArray("callingCodes")));
        mBorders.setText (printArray(bundle.getStringArray("borders")));

        initBackgroundImage();

    }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.myglobe)
                .centerCrop()
                .into(background);
    }

    private String printArray(String[] myArray ){
        String tempString = "";

        for(int i = 0; i< myArray.length; i++){

            if(i != myArray.length - 1){
                tempString = tempString + myArray[i] + " / ";
            }else{
                tempString = tempString + myArray[i];
            }
        }

        if (tempString.equals("")){
            tempString = "0";
        }

        return tempString;
    }

    public void onClick(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.co.in/maps?q=" + mName.getText()));

        this.startActivity(intent);
    }
}
