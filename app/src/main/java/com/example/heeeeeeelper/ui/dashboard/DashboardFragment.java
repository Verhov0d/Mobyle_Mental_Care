package com.example.heeeeeeelper.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.heeeeeeelper.R;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class DashboardFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);

        Button btn = root.findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            navController.navigate(R.id.action_navigation_dashboard_to_test);
        });

        return root;
    }
}