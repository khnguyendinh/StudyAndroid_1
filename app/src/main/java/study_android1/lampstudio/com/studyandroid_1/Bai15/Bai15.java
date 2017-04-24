package study_android1.lampstudio.com.studyandroid_1.Bai15;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import study_android1.lampstudio.com.studyandroid_1.R;

public class Bai15 extends AppCompatActivity implements View.OnClickListener {
    Button btn_alpha,btn_scale,btn_rotation,btn_translate;
    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai15);
        btn_alpha = (Button) findViewById(R.id.btn_alpha);
        btn_scale = (Button) findViewById(R.id.btn_scale);
        btn_rotation = (Button) findViewById(R.id.btn_rotate);
        btn_translate = (Button) findViewById(R.id.btn_translate);
        imageView = (ImageView) findViewById(R.id.imgview);
        btn_alpha.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_rotation.setOnClickListener(this);
        btn_translate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_scale:
                Animation animation_scale = AnimationUtils.loadAnimation(Bai15.this,R.anim.scale_animation);
                btn_scale.startAnimation(animation_scale);
                imageView.setBackgroundResource(R.drawable.frame_animation);
                AnimationDrawable animation_frame = (AnimationDrawable) imageView.getBackground();

                animation_frame.start();
                break;
            case R.id.btn_alpha:
                Animation animationAlpha = AnimationUtils.loadAnimation(Bai15.this,R.anim.alpha_anim);
                btn_alpha.startAnimation(animationAlpha);
                break;
            case R.id.btn_rotate:
                Animation animationRotate= AnimationUtils.loadAnimation(Bai15.this,R.anim.rotate_animation);
                btn_rotation.startAnimation(animationRotate);
                break;
            case R.id.btn_translate:
                Animation animationTranslate= AnimationUtils.loadAnimation(Bai15.this,R.anim.translate_animation);
                btn_translate.startAnimation(animationTranslate);
                animationTranslate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                            //khi nào lặp lại thì  show ra
                    }
                });
                break;
        }

    }
}
