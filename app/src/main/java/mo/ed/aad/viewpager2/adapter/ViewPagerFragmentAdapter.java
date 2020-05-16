package mo.ed.aad.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import mo.ed.aad.viewpager2.fragments.FragmentOne;
import mo.ed.aad.viewpager2.fragments.FragmentThree;
import mo.ed.aad.viewpager2.fragments.FragmentTwo;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> arrayList=new ArrayList<>();

    public ViewPagerFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new FragmentOne();
            case 1: return new FragmentTwo();
            case 2: return new FragmentThree();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}