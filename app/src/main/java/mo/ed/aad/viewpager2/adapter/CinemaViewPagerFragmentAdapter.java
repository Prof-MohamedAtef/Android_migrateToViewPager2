package mo.ed.aad.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import mo.ed.aad.viewpager2.fragments.EventsFragment;
import mo.ed.aad.viewpager2.fragments.MoviesFragment;
import mo.ed.aad.viewpager2.fragments.TicketsFragment;

public class CinemaViewPagerFragmentAdapter extends FragmentStateAdapter {
    public CinemaViewPagerFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new MoviesFragment();
            case 1: return new EventsFragment();
            case 2: return new TicketsFragment();
        }
        return new MoviesFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
