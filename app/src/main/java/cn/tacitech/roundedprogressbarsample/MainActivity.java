package cn.tacitech.roundedprogressbarsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.tacitech.roundedprogressbarmodule.RoundedProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoundedProgressBar roundedProgressBar = findViewById(R.id.roundedProgressBar);
        roundedProgressBar.setProgress(15f); // 设置进度
        roundedProgressBar.setRoundedRadius(16); // 设置半径（像素）
        roundedProgressBar.setRoundedRadiusByDip(16); // 设置半径（Dp）
        roundedProgressBar.setDrawingDirection(RoundedProgressBar.DrawingDirection.VERTICAL); // 设置进度条方向
        roundedProgressBar.setBarBackgroundColor(getColor(R.color.colorAccent)); // 设置进度条背景层颜色
        roundedProgressBar.setBarProgressColor(getColor(R.color.colorPrimary)); // 设置进度条进度层颜色
    }
}
