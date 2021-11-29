package com.example.gittry.FragmentsForMainAplicationPage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainAplicationPageFrameAdaptop extends FragmentStateAdapter{

    public MainAplicationPageFrameAdaptop(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new Task();
            case 2:
                return new Progress();

        }
        return new Home();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
