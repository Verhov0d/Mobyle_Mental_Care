package com.example.heeeeeeelper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.heeeeeeelper.ui.dbHelperTest;
import java.util.ArrayList;

public class story extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_story, container, false);
        dbHelperTest BD = new dbHelperTest(getContext());
        RecyclerView rcv = root.findViewById(R.id.recucler);
        ArrayList<sqlTest> test = BD.getData();
        recuclerAdapter adapter = new recuclerAdapter(inflater, test);
        rcv.setAdapter(adapter);
        return root;
    }

}