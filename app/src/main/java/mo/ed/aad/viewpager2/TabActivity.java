package mo.ed.aad.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayoutMediator;

import mo.ed.aad.viewpager2.adapter.CinemaViewPagerFragmentAdapter;
import mo.ed.aad.viewpager2.databinding.ActivityTabBinding;
import mo.ed.aad.viewpager2.transformers.HorizontalFlipTransformation;

public class TabActivity extends AppCompatActivity {

    // tab titles
    private String[] titles = new String[]{"Movies", "Events", "Tickets"};


    private ActivityTabBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mBinding= ActivityTabBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
    }

    private void init() {
        getSupportActionBar().setElevation(0);
        mBinding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        mBinding.viewPager.setAdapter(new CinemaViewPagerFragmentAdapter(getSupportFragmentManager(), getLifecycle()));
        mBinding.viewPager.setPageTransformer(new HorizontalFlipTransformation());

            new TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager,((tab, position) -> tab.setText(titles[position]))).attach();
    }
}