package com.mitha.ver2mvicall.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mitha.ver2mvicall.fragment.HomeFragment;
import com.mitha.ver2mvicall.R;
import com.mitha.ver2mvicall.fragment.FriendFragment;
import com.mitha.ver2mvicall.fragment.MarketPlaceFragment;
import com.mitha.ver2mvicall.fragment.RewardFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.nav_view)
    BottomNavigationView bottomNavigationView;
    @Nullable
    @BindView(R.id.imageMarket)
    ImageView imageMarket;
    @Nullable
    @BindView(R.id.imageMessage)
    ImageView imageMessage;
    @Nullable
    @BindView(R.id.imageFriends)
    ImageView imageAddFriend;


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Menu menu = bottomNavigationView.getMenu();

            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home);
                    loadFragment(HomeFragment.newInstance());
                    imageMarket.setVisibility(View.VISIBLE);
                    imageMessage.setVisibility(View.VISIBLE);
                    imageAddFriend.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_marketplace:
                    menu.findItem(R.id.navigation_marketplace).setIcon(R.drawable.ic_market);
                    loadFragment(MarketPlaceFragment.newInstance());
//                    imageMarket.setVisibility(View.GONE);
//                    imageAddFriend.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_teman:
                    loadFragment(FriendFragment.newInstance());
                    imageAddFriend.setVisibility(View.VISIBLE);
//                    imageMarket.setVisibility(View.GONE);
//                    imageMessage.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_reward:
                    loadFragment(RewardFragment.newInstance());
//                    imageAddFriend.setVisibility(View.GONE);
                    imageMarket.setVisibility(View.VISIBLE);
//                    imageMessage.setVisibility(View.GONE);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        loadFragment(HomeFragment.newInstance());

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        action();
    }


    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                .replace(R.id.frame_home, fragment)
                .commit();
    }

    private void action(){

    }

}
