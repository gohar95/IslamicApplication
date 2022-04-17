
package com.invotech.mrsmofficial.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;/*
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;*/
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.navigation.NavigationView;
import com.invotech.mrsmofficial.Activities.ActivityAboutUs;
import com.invotech.mrsmofficial.Activities.ActivityDonation;
import com.invotech.mrsmofficial.Activities.ActivityMembership;
import com.invotech.mrsmofficial.Activities.ActivityMureed;
import com.invotech.mrsmofficial.Activities.ActivityQazaNamaz;
import com.invotech.mrsmofficial.Activities.CompassActivity;
import com.invotech.mrsmofficial.Activities.MainActivity;
import com.invotech.mrsmofficial.Activities.NamazActivity;
import com.invotech.mrsmofficial.Activities.YoutubeActivity;
import com.invotech.mrsmofficial.R;
import com.invotech.mrsmofficial.YoutubeAPI.PlaylistActivity;


public class MenuListFragment extends Fragment {


    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container,
                false);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentHome fragmentHome = new FragmentHome();
        fragmentTransaction.replace(R.id.content, fragmentHome);
        fragmentTransaction.commit();


        NavigationView sNavigation = (NavigationView) view.findViewById(R.id.vNavigation);

        sNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();


                switch (item.getItemId()) {


                    case R.id.menu_playlist:

                        startActivity(new Intent(getActivity(), PlaylistActivity.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();

                        break;
                    case R.id.menu_membership:

                        startActivity(new Intent(getActivity(), ActivityMembership.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();


                        break;
                    case R.id.menu_donate:
                        startActivity(new Intent(getActivity(), ActivityDonation.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();

                        break;
                    case R.id.menu_share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "AssalamOAlikum, Please Download Our Application from link https://drive.google.com/drive/u/0/folders/1p47h424ONjcOL12yiHT-IvAUQwGjh-z9");
                        sendIntent.setType("text/plain");
                        startActivity(Intent.createChooser(sendIntent, "Share"));
                        /*((MainActivity)getActivity()).closeDrawer();*/
                        break;
                    case R.id.menu_mureed:

                       startActivity(new Intent(getActivity(), ActivityMureed.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();
                        break;
                    case R.id.menu_about_us:
                        startActivity(new Intent(getActivity(), ActivityAboutUs.class));

                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();

                        break;
                    case R.id.menu_namaz_calculation:
                        startActivity(new Intent(getActivity(), NamazActivity.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();
                        break;
                    case R.id.menu_qibla:
                        startActivity(new Intent(getActivity(), CompassActivity.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();

                        break;
                    case R.id.menu_home:
                        FragmentHome fragmentHome = new FragmentHome();
                        ft.replace(R.id.content, fragmentHome);
                        ft.commit();
                        ((MainActivity) getActivity()).closeDrawer();
                        break;
                    case R.id.menu_qaza_namaz:
                        startActivity(new Intent(getActivity(),ActivityQazaNamaz.class));
                        ((MainActivity) getActivity()).closeDrawer();
                        ((MainActivity) getActivity()).finish();
                        break;

                }
                return true;
            }
        });

        return view;
    }
}
