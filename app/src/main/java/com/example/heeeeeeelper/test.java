package com.example.heeeeeeelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.heeeeeeelper.ui.dbHelperTest;

public class test extends Fragment {


    public float good;
    public float paran;
    public float shiz;
    public float gistra;
    public float asteich;
    public float vozb;

    public CheckBox chk_1;
    public CheckBox chk_2;
    public CheckBox chk_3;
    public CheckBox chk_4;
    public CheckBox chk_5;
    public CheckBox chk_6;
    public CheckBox chk_7;
    public CheckBox chk_8;
    public CheckBox chk_9;
    public CheckBox chk_10;
    public CheckBox chk_11;
    public CheckBox chk_12;
    public CheckBox chk_13;
    public CheckBox chk_14;
    public CheckBox chk_15;
    public CheckBox chk_16;
    public CheckBox chk_17;
    public CheckBox chk_18;
    public CheckBox chk_19;
    public CheckBox chk_20;
    public CheckBox chk_21;
    public CheckBox chk_22;
    public CheckBox chk_23;
    public CheckBox chk_24;
    public CheckBox chk_25;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);

        dbHelperTest helperBD = new dbHelperTest(root.getContext());

        chk_1 = root.findViewById(R.id.cht1);
        chk_2 = root.findViewById(R.id.cht2);
        chk_3 = root.findViewById(R.id.cht3);
        chk_4 = root.findViewById(R.id.cht4);
        chk_5 = root.findViewById(R.id.cht5);
        chk_6 = root.findViewById(R.id.cht6);
        chk_7 = root.findViewById(R.id.cht7);
        chk_8 = root.findViewById(R.id.cht8);
        chk_9 = root.findViewById(R.id.cht9);
        chk_10 = root.findViewById(R.id.cht10);
        chk_11 = root.findViewById(R.id.cht11);
        chk_12 = root.findViewById(R.id.cht12);
        chk_13 = root.findViewById(R.id.cht13);
        chk_14 = root.findViewById(R.id.cht14);
        chk_15 = root.findViewById(R.id.cht15);
        chk_16 = root.findViewById(R.id.cht16);
        chk_17 = root.findViewById(R.id.cht17);
        chk_18 = root.findViewById(R.id.cht18);
        chk_19 = root.findViewById(R.id.cht19);
        chk_20 = root.findViewById(R.id.cht20);
        chk_21 = root.findViewById(R.id.cht21);
        chk_22 = root.findViewById(R.id.cht22);
        chk_23 = root.findViewById(R.id.cht23);
        chk_24 = root.findViewById(R.id.cht24);
        chk_25 = root.findViewById(R.id.cht25);


        Button btn_tob = root.findViewById(R.id.tobad);
        btn_tob.setOnClickListener(view -> {

            if (chk_1.isChecked())
                good += 1;
            if (chk_17.isChecked())
                good += 1;
            if (chk_18.isChecked())
                good += 1;
            if (chk_19.isChecked())
                good += 1;
            if (chk_20.isChecked())
                good += 1;
            if (chk_21.isChecked())
                good += 1;
            if (chk_22.isChecked())
                good += 1;
            if (chk_23.isChecked())
                good += 1;
            if (chk_24.isChecked())
                good += 1;
            if (chk_25.isChecked())
                good += 1;
            if (chk_2.isChecked())
                paran += 1;
            if (chk_3.isChecked())
                paran += 1;
            if (chk_4.isChecked())
                paran += 1;
            if (chk_5.isChecked())
                shiz += 1;
            if (chk_6.isChecked())
                shiz += 1;
            if (chk_7.isChecked())
                shiz += 1;
            if (chk_8.isChecked())
                gistra += 1;
            if (chk_9.isChecked())
                gistra += 1;
            if (chk_10.isChecked())
                gistra += 1;
            if (chk_11.isChecked())
                asteich += 1;
            if (chk_12.isChecked())
                asteich += 1;
            if (chk_13.isChecked())
                asteich += 1;
            if (chk_14.isChecked())
                vozb += 1;
            if (chk_15.isChecked())
                vozb += 1;
            if (chk_16.isChecked())
                vozb += 1;

            if (good == 0 && paran == 0 && shiz == 0 && gistra == 0 && asteich == 0 && vozb == 0){
                Toast.makeText(root.getContext(), "Вы ничего не выбрали", Toast.LENGTH_SHORT).show();
            }

            else {
                helperBD.insert(Math.round(good), Math.round(paran),
                        Math.round(shiz), Math.round(gistra), Math.round(asteich), Math.round(vozb));

                navController.navigate(R.id.action_test_to_rezult);
            }
        });

        return root;
    }
}