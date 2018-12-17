package top.plusy.myapp.animation;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.view.View;
import android.widget.TextView;

/**
 * Author: WangHui
 * Date: 2018/12/17.
 */
public class MyAnimation {
    public static void startColorGradientAnimation(final TextView view, int startColor, int endColor)
    {
        final ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view,"textColor", startColor, endColor);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    public static void startTranslater(View view) {
        Path path = new Path();
        path.addCircle(0, 0, 400, Path.Direction.CW);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationX", "translationY", path);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    public static void startTranslater2(View view) {
        Path path = new Path();
        path.addOval(-400, -800, 400, 800, Path.Direction.CW);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationX", "translationY", path);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    public static void startRotate(View view) {
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0, 360);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}
