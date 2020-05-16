package mo.ed.aad.viewpager2;

import android.annotation.SuppressLint;

import androidx.viewpager2.widget.ViewPager2;

import mo.ed.aad.viewpager2.transformers.AntiClockSpinTransformation;
import mo.ed.aad.viewpager2.transformers.ClockSpinTransformation;
import mo.ed.aad.viewpager2.transformers.CubeInDepthTransformation;
import mo.ed.aad.viewpager2.transformers.CubeInRotationTransformation;
import mo.ed.aad.viewpager2.transformers.CubeOutDepthTransformation;
import mo.ed.aad.viewpager2.transformers.CubeOutRotationTransformation;
import mo.ed.aad.viewpager2.transformers.CubeOutScalingTransformation;
import mo.ed.aad.viewpager2.transformers.DepthPageTransformer;
import mo.ed.aad.viewpager2.transformers.DepthTransformation;
import mo.ed.aad.viewpager2.transformers.FadeOutTransformation;
import mo.ed.aad.viewpager2.transformers.FanTransformation;
import mo.ed.aad.viewpager2.transformers.GateTransformation;
import mo.ed.aad.viewpager2.transformers.HingeTransformation;
import mo.ed.aad.viewpager2.transformers.HorizontalFlipTransformation;
import mo.ed.aad.viewpager2.transformers.PopTransformation;
import mo.ed.aad.viewpager2.transformers.SimpleTransformation;
import mo.ed.aad.viewpager2.transformers.SpinnerTransformation;
import mo.ed.aad.viewpager2.transformers.TossTransformation;
import mo.ed.aad.viewpager2.transformers.VerticalFlipTransformation;
import mo.ed.aad.viewpager2.transformers.VerticalShutTransformation;
import mo.ed.aad.viewpager2.transformers.ZoomOutPageTransformer;

public class Utils {
    @SuppressLint("NewApi")
    public static ViewPager2.PageTransformer getTransformer(int id) {
        switch (id) {
            case R.id.action_anti_clock_spin:
                return new AntiClockSpinTransformation();
            case R.id.action_clock_spin:
                return new ClockSpinTransformation();
            case R.id.action_cube_in_depth:
                return new CubeInDepthTransformation();
            case R.id.action_cube_in_rotate:
                return new CubeInRotationTransformation();
            case R.id.action_cube_out_depth:
                return new CubeOutDepthTransformation();
            case R.id.action_cube_out_rotate:
                return new CubeOutRotationTransformation();
            case R.id.action_cube_out_scaling:
                return new CubeOutScalingTransformation();
            case R.id.action_depth_page:
                return new DepthPageTransformer();
            case R.id.action_depth:
                return new DepthTransformation();
            case R.id.action_fade_out:
                return new FadeOutTransformation();
            case R.id.action_fan:
                return new FanTransformation();
            case R.id.action_gate:
                return new GateTransformation();
            case R.id.action_hinge:
                return new HingeTransformation();
            case R.id.action_horizontal_flip:
                return new VerticalFlipTransformation();
            case R.id.action_pop:
                return new PopTransformation();
            case R.id.action_simple_transformation:
                return new SimpleTransformation();
            case R.id.action_spinner:
                return new SpinnerTransformation();
            case R.id.action_toss:
                return new TossTransformation();
            case R.id.action_vertical_flip:
                return new HorizontalFlipTransformation();
            case R.id.action_vertical_shut:
                return new VerticalShutTransformation();
            case R.id.action_zoom_out:
                return new ZoomOutPageTransformer();
        }

        return null;
    }
}
