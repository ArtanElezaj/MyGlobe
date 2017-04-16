package com.artan.myglobe.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artan.myglobe.DetailsActivity;
import com.artan.myglobe.R;
import com.artan.myglobe.models.Countries;

import java.util.ArrayList;
import java.util.List;


public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesVHolder> {


    List<Countries> countriesList;

    public CountriesAdapter() {
        countriesList = new ArrayList<>();
    }


    public void setCountriesList(List<Countries> mCountriesList) {
        this.countriesList = mCountriesList;
        notifyDataSetChanged();
    }

    @Override
    public CountriesVHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_country_item, parent, false);

        return new CountriesVHolder(view);
    }

    @Override
    public void onBindViewHolder(CountriesVHolder holder, int position) {
        Countries schools = countriesList.get(position);
        holder.bind(schools);
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    public class CountriesVHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mName;
        Countries mCountries;


        public CountriesVHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.countries_name);
            itemView.setOnClickListener(this);
        }

        public void bind(Countries countries) {

            mCountries = countries;

            mName.setText(getAdapterPosition() + 1 + ". " + countries.getName());
        }


        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), DetailsActivity.class);

            Bundle bundle = new Bundle();

            bundle.putString("name", mCountries.getName());
            bundle.putString("alpha3Code", mCountries.getAlpha3Code());
            bundle.putString("region", mCountries.getRegion());
            bundle.putString("subregion", mCountries.getSubregion());
            bundle.putString("capital", mCountries.getCapital());
            bundle.putString("population", mCountries.getPopulation());
            bundle.putString("area", mCountries.getArea());
            bundle.putStringArray("languages", mCountries.getLanguages());
            bundle.putStringArray("currencies", mCountries.getCurrencies());
            bundle.putStringArray("timezones", mCountries.getTimezones());
            bundle.putStringArray("callingCodes", mCountries.getCallingCodes());
            bundle.putStringArray("borders", mCountries.getBorders());

            intent.putExtras(bundle);
            view.getContext().startActivity(intent);

        }
    }
}
