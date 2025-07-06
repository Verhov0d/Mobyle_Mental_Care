package com.example.heeeeeeelper.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.heeeeeeelper.R;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.heeeeeeelper.ui.dbHelperTest;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn_sbros = root.findViewById(R.id.sbros);
        btn_sbros.setOnClickListener(view -> {
            Toast.makeText(root.getContext(), "Готово", Toast.LENGTH_SHORT).show();

            dbHelperTest dbHelperTest = new dbHelperTest(root.getContext());

            dbHelperTest.delete();

        });

        return root;
    }
}