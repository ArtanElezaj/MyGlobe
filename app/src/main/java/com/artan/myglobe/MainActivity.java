package com.artan.myglobe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.artan.myglobe.adapters.CountriesAdapter;
import com.artan.myglobe.models.Countries;
import com.artan.myglobe.network.CountriesResponse;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvInfo;
    private CountriesAdapter mSchoolsAdapter;
    private Retrofit mRetrofit;
    private final String BASEURL = "https://restcountries.eu/";
    private String mCountriesName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvInfo = (RecyclerView) findViewById(R.id.rv_info);

        setUpAdapter();
        setUpRetrofit();
        initBackgroundImage();

    }

    public void setUpAdapter() {

        mSchoolsAdapter = new CountriesAdapter();

        mRvInfo.setAdapter(mSchoolsAdapter);
        mRvInfo.setHasFixedSize(true);
        mRvInfo.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));
    }

    public void setUpRetrofit() {

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountriesResponse schoolsResponse = mRetrofit.create(CountriesResponse.class);
        Call<List<Countries>> listCall = schoolsResponse.schoolsData();

        listCall.enqueue(new Callback<List<Countries>>() {

            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                if (response.isSuccessful()) {
                    List<Countries> schools = response.body();

                        mSchoolsAdapter.setCountriesList(schools);
                    }
                }

                @Override
                public void onFailure (Call < List <Countries>> call, Throwable t){
                    Toast.makeText(getBaseContext(), "Not Working!", Toast.LENGTH_LONG).show();
                }
            }

            );
        }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this)
                .load(R.drawable.myglobe)
                .centerCrop()
                .into(background);
    }
    }
