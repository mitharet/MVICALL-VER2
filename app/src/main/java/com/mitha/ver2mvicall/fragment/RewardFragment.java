package com.mitha.ver2mvicall.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mitha.ver2mvicall.R;


public class RewardFragment extends Fragment {

    private View view;

    public static RewardFragment newInstance(){
        RewardFragment fragment = new RewardFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward, container, false);

        return view;
    }
}
