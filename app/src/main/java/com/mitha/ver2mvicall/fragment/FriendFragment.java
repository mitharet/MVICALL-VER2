package com.mitha.ver2mvicall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mitha.ver2mvicall.R;


public class FriendFragment extends Fragment {

    private View view;

    public static FriendFragment newInstance(){
        FriendFragment fragment = new FriendFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friend, container, false);

        return view;
    }
}
