package com.example.heeeeeeelper.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.heeeeeeelper.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.heeeeeeelper.databinding.FragmentNotificationsBinding;
import com.example.heeeeeeelper.sqlTest;
import com.example.heeeeeeelper.ui.dbHelperTest;
import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public float noProb;
    public float tiParan;
    public float tiShiz;
    public float tiIsterik;
    public float tiAstenik;
    public float tiToxik;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dbHelperTest helperTest = new dbHelperTest(root.getContext());
        ArrayList list = helperTest.getData();

        for (int i = 0; i < list.size(); i++) {
            sqlTest test = (sqlTest) list.get(i);
            noProb += test.getAllgood();
            tiParan += test.getParanoik();
            tiShiz += test.getShizik();
            tiIsterik += test.getIsterik();
            tiAstenik += test.getAstenik();
            tiToxik += test.getEmocloh();
        }

        float prcNoProb = 0;
        float prcTiParan = 0;
        float prcTiShiz = 0;
        float prcTiIsterik = 0;
        float prcTiAstenik = 0;
        float prcTiToxik = 0;

        float diagrHelper = noProb + tiParan + tiShiz + tiIsterik + tiAstenik + tiToxik;

        prcNoProb = (noProb * 100) / diagrHelper;
        prcTiParan = (tiParan * 100) / diagrHelper;
        prcTiShiz = (tiShiz * 100) / diagrHelper;
        prcTiIsterik = (tiIsterik * 100) / diagrHelper;
        prcTiAstenik = (tiAstenik * 100) / diagrHelper;
        prcTiToxik = (tiToxik * 100) / diagrHelper;

        float lastPrcNoProb = 0;
        float lastPrcTiParan = 0;
        float lastPrcTiShiz = 0;
        float lastPrcTiIsterik = 0;
        float lastPrcTiAstenik = 0;
        float lastPrcTiToxik = 0;

        CardView crd_sh = root.findViewById(R.id.palkaScha);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) crd_sh.getLayoutParams();
        layoutParams.height = Math.round(350.f * prcNoProb / 100.f * root.getResources().getDisplayMetrics().density);
        crd_sh.setLayoutParams(layoutParams);

        CardView crd_par = root.findViewById(R.id.palkaPar);
        LinearLayout.LayoutParams layoutPar = (LinearLayout.LayoutParams) crd_par.getLayoutParams();
        layoutPar.height = Math.round(350.f * prcTiParan / 100.f * root.getResources().getDisplayMetrics().density);
        crd_par.setLayoutParams(layoutPar);

        CardView crd_shiz = root.findViewById(R.id.palkaShiz);
        LinearLayout.LayoutParams layoutShiz = (LinearLayout.LayoutParams) crd_shiz.getLayoutParams();
        layoutShiz.height = Math.round(350.f * prcTiShiz / 100.f * root.getResources().getDisplayMetrics().density);
        crd_shiz.setLayoutParams(layoutShiz);

        CardView crd_ister = root.findViewById(R.id.palkaIster);
        LinearLayout.LayoutParams layoutIster = (LinearLayout.LayoutParams) crd_ister.getLayoutParams();
        layoutIster.height = Math.round(350.f * prcTiIsterik / 100.f * root.getResources().getDisplayMetrics().density);
        crd_ister.setLayoutParams(layoutIster);

        CardView crd_zavis = root.findViewById(R.id.palkaZavis);
        LinearLayout.LayoutParams layoutZavis = (LinearLayout.LayoutParams) crd_zavis.getLayoutParams();
        layoutZavis.height = Math.round(350.f * prcTiAstenik / 100.f * root.getResources().getDisplayMetrics().density);
        crd_zavis.setLayoutParams(layoutZavis);

        CardView crd_agr = root.findViewById(R.id.palkaAgr);
        LinearLayout.LayoutParams layoutAgr = (LinearLayout.LayoutParams) crd_agr.getLayoutParams();
        layoutAgr.height = Math.round(350.f * prcTiToxik / 100.f * root.getResources().getDisplayMetrics().density);
        crd_agr.setLayoutParams(layoutAgr);

        if (list.size() > 0) {
        sqlTest lastTest = (sqlTest) list.get(list.size() - 1);
        float lastNoProb = 0;
        lastNoProb += lastTest.getAllgood();
        float lastTiParan = 0;
        lastTiParan += lastTest.getParanoik();
        float lastTiShiz = 0;
        lastTiShiz += lastTest.getShizik();
        float lastTiIsterik = 0;
        lastTiIsterik += lastTest.getIsterik();
        float lastTiAstenik = 0;
        lastTiAstenik += lastTest.getAstenik();
        float lastTiToxik = 0;
        lastTiToxik += lastTest.getEmocloh();

        float lastDiagrHelper = lastNoProb + lastTiParan + lastTiShiz + lastTiIsterik + lastTiAstenik + lastTiToxik;

        lastPrcNoProb = (lastNoProb * 100) / lastDiagrHelper;
        lastPrcTiParan = (lastTiParan * 100) / lastDiagrHelper;
        lastPrcTiShiz = (lastTiShiz * 100) / lastDiagrHelper;
        lastPrcTiIsterik = (lastTiIsterik * 100) / lastDiagrHelper;
        lastPrcTiAstenik = (lastTiAstenik * 100) / lastDiagrHelper;
        lastPrcTiToxik = (lastTiToxik * 100) / lastDiagrHelper;

    }
        else {
            lastPrcNoProb = 0;
            lastPrcTiParan = 0;
            lastPrcTiShiz = 0;
            lastPrcTiIsterik = 0;
            lastPrcTiAstenik = 0;
            lastPrcTiToxik = 0;
        }

        CardView crd_sh2 = root.findViewById(R.id.palkaScha2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) crd_sh2.getLayoutParams();
        layoutParams2.height = Math.round(350.f * lastPrcNoProb / 100.f * root.getResources().getDisplayMetrics().density);
        crd_sh2.setLayoutParams(layoutParams2);

        CardView crd_par2 = root.findViewById(R.id.palkaPar2);
        LinearLayout.LayoutParams layoutPar2 = (LinearLayout.LayoutParams) crd_par2.getLayoutParams();
        layoutPar2.height = Math.round(350.f * lastPrcTiParan / 100.f * root.getResources().getDisplayMetrics().density);
        crd_par2.setLayoutParams(layoutPar2);

        CardView crd_shiz2 = root.findViewById(R.id.palkaShiz2);
        LinearLayout.LayoutParams layoutShiz2 = (LinearLayout.LayoutParams) crd_shiz2.getLayoutParams();
        layoutShiz2.height = Math.round(350.f * lastPrcTiShiz / 100.f * root.getResources().getDisplayMetrics().density);
        crd_shiz2.setLayoutParams(layoutShiz2);

        CardView crd_ister2 = root.findViewById(R.id.palkaIster2);
        LinearLayout.LayoutParams layoutIster2 = (LinearLayout.LayoutParams) crd_ister2.getLayoutParams();
        layoutIster2.height = Math.round(350.f * lastPrcTiIsterik / 100.f * root.getResources().getDisplayMetrics().density);
        crd_ister2.setLayoutParams(layoutIster2);

        CardView crd_zavis2 = root.findViewById(R.id.palkaZavis2);
        LinearLayout.LayoutParams layoutZavis2 = (LinearLayout.LayoutParams) crd_zavis2.getLayoutParams();
        layoutZavis2.height = Math.round(350.f * lastPrcTiAstenik / 100.f * root.getResources().getDisplayMetrics().density);
        crd_zavis2.setLayoutParams(layoutZavis2);

        CardView crd_agr2 = root.findViewById(R.id.palkaAgr2);
        LinearLayout.LayoutParams layoutAgr2 = (LinearLayout.LayoutParams) crd_agr2.getLayoutParams();
        layoutAgr2.height = Math.round(350.f * lastPrcTiToxik / 100.f * root.getResources().getDisplayMetrics().density);
        crd_agr2.setLayoutParams(layoutAgr2);

        Button btn_tos = root.findViewById(R.id.tostory);
        btn_tos.setOnClickListener(view -> {
            navController.navigate(R.id.action_navigation_notifications_to_story);
        });

        return root;
    }
}
