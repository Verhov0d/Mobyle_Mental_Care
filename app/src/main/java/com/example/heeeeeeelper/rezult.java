package com.example.heeeeeeelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.heeeeeeelper.ui.dbHelperTest;

import java.util.ArrayList;

public class rezult extends Fragment {

    public float rezHor;
    public float rezParan;
    public float rezShiz;
    public float rezIsterik;
    public float rezZav;
    public float rezAgr;


    public String txt = "Результат показал, что возможно у вас:\n ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rezult, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);

        dbHelperTest helperTest = new dbHelperTest(root.getContext());
        ArrayList<sqlTest> list = helperTest.getData();

            sqlTest test = (sqlTest) list.get(list.size() - 1);
            rezHor += test.getAllgood();
            rezParan += test.getParanoik();
            rezShiz += test.getShizik();
            rezIsterik += test.getIsterik();
            rezZav += test.getAstenik();
            rezAgr += test.getEmocloh();

        float mainrez = rezHor + rezParan + rezShiz + rezIsterik + rezZav + rezAgr;

        float finHor = (rezHor * 100) / mainrez;
        float finParan = (rezParan * 100) / mainrez;
        float finShiz = (rezShiz * 100) / mainrez;
        float finIsteric = (rezIsterik * 100) / mainrez;
        float finZav = (rezZav * 100) / mainrez;
        float finAgr = (rezAgr * 100) / mainrez;

        String finalRes = txt + "";

        TextView textView = root.findViewById(R.id.proverka);
        
        if (finHor > finParan && finHor > finShiz && finHor > finIsteric && finHor > finZav && finHor > finAgr) {
            textView.setText("У вас всё отлично!");
        }

        else {
            if (finParan >= finShiz && finParan >= finIsteric && finParan >= finZav && finParan >= finAgr) {

                String diagnP = "◉ Паранойальное расстройство личности \n";
                finalRes += diagnP;
                textView.setText(finalRes);
            }

            if (finShiz >= finParan && finShiz >= finIsteric && finShiz >= finZav && finShiz >= finAgr) {

                String diagnSh = "◉ Шизоидное расстройство личности \n";
                finalRes += diagnSh;
                textView.setText(finalRes);
            }

            if (finIsteric >= finParan && finIsteric >= finShiz && finIsteric >= finZav && finIsteric >= finAgr) {

                String diagnG = "◉ Гистрионическое расстройство личности \n";
                finalRes += diagnG;
                textView.setText(finalRes);
            }

            if (finZav >= finParan && finZav >= finShiz && finZav >= finIsteric && finZav >= finAgr) {

                textView.setText("У вас астеническое расстройство личности");
                String diagnA = "◉ Астеническое расстройство личности \n";
                finalRes += diagnA;
                textView.setText(finalRes);
            }

            if (finAgr >= finParan && finAgr >= finShiz && finAgr >= finIsteric && finAgr >= finZav) {

                textView.setText("У вас возбудимое расстройство личности");
                String diagnV = "◉ Возбудимое расстройство личности \n";
                finalRes += diagnV;
            }
            textView.setText(finalRes);
        }


        Button btn_ton = root.findViewById(R.id.tonach);
        btn_ton.setOnClickListener(view -> {
            navController.navigate(R.id.action_rezult_to_navigation_dashboard);
        });

        return root;
    }
}