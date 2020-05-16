package mo.ed.aad.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import java.util.ArrayList;
import mo.ed.aad.viewpager2.adapter.ViewPagerFragmentAdapter;
import mo.ed.aad.viewpager2.fragments.FragmentOne;
import mo.ed.aad.viewpager2.fragments.FragmentThree;
import mo.ed.aad.viewpager2.fragments.FragmentTwo;

public class MenuActivity extends AppCompatActivity {

    private ViewPager2 myViewPager2;
    private ArrayList<Fragment> arrayList=new ArrayList<>();
    private ViewPagerFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager2=(ViewPager2) findViewById(R.id.view_pager);

        arrayList.add(new FragmentOne());
        arrayList.add(new FragmentTwo());
        arrayList.add(new FragmentThree());

        mAdapter=new ViewPagerFragmentAdapter(getSupportFragmentManager(),getLifecycle());

        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2.setAdapter(mAdapter);
        myViewPager2.setPageTransformer(new MarginPageTransformer(1500));
    }
}