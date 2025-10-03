package com.example.burgerloginapi.burgerdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.burgerloginapi.Login.MainActivity;
import com.example.burgerloginapi.R;


public class Profilefragment extends Fragment {

    Button btnlogout;
    SharedPreferences sharedPreferences;
    private static final String Prefname = "MyPrefFile";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profilefragment, container, false);

        sharedPreferences = getActivity().getSharedPreferences(Prefname, Context.MODE_PRIVATE);

        // Initialize the logout button
        btnlogout = view.findViewById(R.id.btnlogout);

        // Set the onClickListener for the logout button
        btnlogout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                // Finish the activity
                getActivity().finish();

                // Start the MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

                // Show logout success message
                // Show logout success message
                Toast.makeText(getActivity(), "Logout sukses cuy", Toast.LENGTH_SHORT).show(); }
        });
        return view;
    }
}
