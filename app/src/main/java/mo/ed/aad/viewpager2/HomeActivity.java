package mo.ed.aad.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mo.ed.aad.viewpager2.adapter.ViewSliderAdapter;
import mo.ed.aad.viewpager2.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private int[] layouts;
    private ViewSliderAdapter mAdapter;
    private TextView[] dots;
    private ViewPager2.OnPageChangeCallback mPageChangeCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        mPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == layouts.length - 1) {
                    // last page. make button text to GOT IT
                    mBinding.btnNext.setText(getString(R.string.start));
                    mBinding.btnSkip.setVisibility(View.GONE);
                } else {
                    // still pages are left
                    mBinding.btnNext.setText(getString(R.string.next));
                    mBinding.btnSkip.setVisibility(View.VISIBLE);
                }
            }
        };

        init();
    }

    private void init() {
        layouts = new int[]{
                R.layout.slide_one,
                R.layout.slide_two,
                R.layout.slide_three,
                R.layout.slide_four
        };

        mAdapter = new ViewSliderAdapter(getApplicationContext(), layouts);
        mBinding.viewPager.setAdapter(mAdapter);
        mBinding.viewPager.registerOnPageChangeCallback(mPageChangeCallback);

        mBinding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        mBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    mBinding.viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });

        mBinding.iconMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

        addBottomDots(0);
    }

    private int getItem(int i) {
        return mBinding.viewPager.getCurrentItem() + i;
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        mBinding.layoutDots.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            mBinding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private void showMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.pager_transformers, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_orientation) {
                mBinding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
            } else {
                mBinding.viewPager.setPageTransformer(Utils.getTransformer(item.getItemId()));
                mBinding.viewPager.setCurrentItem(0);
                mBinding.viewPager.getAdapter().notifyDataSetChanged();
            }
            return false;
        });
        popup.show();
    }

    private void launchHomeScreen() {
        Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_LONG).show();
        finish();
    }
}