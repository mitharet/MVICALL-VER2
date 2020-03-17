package com.mitha.ver2mvicall.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mitha.ver2mvicall.R;
import com.mitha.ver2mvicall.adapter.ExploreAdapter;
import com.mitha.ver2mvicall.model.Explore;
import com.mitha.ver2mvicall.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
public class HomeFragment<videoView> extends Fragment {


    //Explore
    private ExploreAdapter exploreAdapter;
    private List<Explore> exploreList = new ArrayList<>();

    //    @BindView(R.id.recyclerview_user)
//    RecyclerView recyclerView;
//    @BindView(R.id.recyclerview_banner)
//    RecyclerView recyclerViewBanner;
    @BindView(R.id.recycler_video_home)
    RecyclerView recyclerViewVideoHome;
    @BindView(R.id.all_bottom)
    ConstraintLayout bottomSheetHome;
//    @BindView(R.id.relative_top)
//    RelativeLayout relativeLayout;

    private StaggeredGridLayoutManager layoutManagerExplore;

    private BottomSheetBehavior sheetBehavior;
    private int sheetHome, deviceHeight;
    public View rootView;

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        setPixels();

        int[] size =  Utils.getScreenSize(Objects.requireNonNull(getActivity()));
        Log.e("SIZE", Arrays.toString(size)); // [1080, 2107]

        setBottomSheetHome();
        load_data();

        return rootView;
    }

    private void setPixels(){

    }

    private void load_data(){
//        //User
//        users.add(new User("Your Status", "https://oov.life/wp-content/uploads/2018/08/532969250-612x612.jpg"));
//        users.add(new User("Username", "http://www.pngplay.com/wp-content/uploads/1/Businessman-PNG-Photos.png"));
//        users.add(new User("Username", "https://image.freepik.com/free-photo/group-people-smiling_1139-528.jpg"));
//        users.add(new User("Username", "https://purepng.com/public/uploads/large/businessman-bow.png"));
//        users.add(new User("Username", "https://toppng.com/public/uploads/preview/sunglasses-businessman-11549009026w2ugfrwgoo.png"));
//        users.add(new User("Username", "https://jooinn.com/images/people-9.jpg"));
//        users.add(new User("Username", "http://assetplanningpros.com/wp-content/uploads/2017/01/business-people2.jpg"));
//        users.add(new User("Username", "https://image.freepik.com/free-photo/corporate-portrait-three-members-successful-business-team_1262-14904.jpg"));
//
//        userAdapter = new UserAdapter(getActivity(), users, user -> {
//            Toast.makeText(getActivity(), "Test User", Toast.LENGTH_SHORT).show();
//        });
//
////        //Banner
////        banners.add(new Banner("https://lendcreative.com/wp-content/uploads/2018/11/promo-hari-pahlawan-web-lendcreative.png"));
////        banners.add(new Banner("https://www.ardetamedia.com/images/slider/november/promo30/banner.jpg"));
////        banners.add(new Banner("https://www.oketheme.com/wp-content/uploads/2016/11/Diskon-Hari-Pahlawan-Iklan.png"));
////        banners.add(new Banner("https://dana.id/uploads/promo/promothumb-1565234809Campaign---BPJS-Direct-Discount-50P-max-20K---Web-Banner---1440x575px.png"));
////        banners.add(new Banner("https://digiads.co.id/wp-content/uploads/2019/07/PAKET-PROMO-MYADS-AGUSTUS-01-01.jpg"));
//
////        bannerAdapter = new BannerAdapter(getActivity(), banners, banner -> {
////            Toast.makeText(getActivity(), "Test Banner", Toast.LENGTH_SHORT).show();
////        });
//
        //Explore
        for (int i=0; i<10; i++){
            exploreList.add(new Explore("Video " + i, "", "https://musicgallery.org/wp-content/uploads/2017/03/music-gallery-about.jpg"));
        }

        exploreAdapter = new ExploreAdapter(getActivity(), exploreList, explore -> {
            Toast.makeText(getActivity(), explore.getName(), Toast.LENGTH_SHORT).show();
        });

        init_adapter();
    }

    private void init_adapter(){
//        //User
//        recyclerView.setHasFixedSize(false);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(userAdapter);
//
//        //Banner
//        recyclerViewBanner.setHasFixedSize(false);
//        recyclerViewBanner.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerViewBanner.setAdapter(bannerAdapter);
//
        //Explore
        layoutManagerExplore = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewVideoHome.setLayoutManager(layoutManagerExplore);
        recyclerViewVideoHome.setAdapter(exploreAdapter);
    }

    private void setBottomSheetHome(){
        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();

        // dapatkan tinggi layar pada satuan pixel dan rubah ke satuan dp
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;

        int mapHeightDp = getResources().getDimensionPixelSize(R.dimen.dummy);

        // pengurangan dalam satuan dp
        sheetHome = Math.round(dpHeight) - mapHeightDp;
        /*
            pengurangan dilakukan untuk menentukan tinggi bottom sheet
            agar hanya bagian tulisan "Live Explore" dan Profile yang terlihat.
            Namun masih terdapat kendala dikarenakan dengan nilai mapHeightDp
            yang sama dapat menghasilkan tamplian yang berbeda di beda perangkat.
         */

        sheetBehavior = BottomSheetBehavior.from(bottomSheetHome);
        sheetBehavior.setHideable(false);

        // atur ketinggian awal bottom sheet, nilai input tinggi dikonversikan kembali ke pixel
        sheetBehavior.setPeekHeight(Math.round(sheetHome * displayMetrics.density));
    }



}

