# RoundedProgressBarModule [![](https://www.jitpack.io/v/lilingxi01/RoundedProgressBarModule.svg)](https://www.jitpack.io/#lilingxi01/RoundedProgressBarModule)

It's an Android library module that can help you to create an amazing rounded progress bar.

这是一个美妙的安卓圆角进度条插件，极端优雅，无与伦比。

<br><br>

![image](https://github.com/lilingxi01/RoundedProgressBarModule/blob/master/pics/sample_pic_2.png)

<br><br>

## 导入方法

1. 在根目录的build.gradle中添加以下依赖

    	allprojects {
    		repositories {
    			...
    			maven { url 'https://www.jitpack.io' }
    		}
    	}

2. 在app文件夹下的build.gradle中添加以下依赖

    	dependencies {
    		implementation 'com.github.lilingxi01:RoundedProgressBarModule:v0.1-alpha'
    	}

## XML调用
   	
    <cn.tacitech.roundedprogressbarmodule.RoundedProgressBar
            android:layout_width="75dp"
            android:layout_height="30dp"
            android:id="@+id/roundedProgressBar"
            app:drawingDirection="horizontal"
            app:progress="65"
            app:roundedRadius="15dp"
            app:barBackgroundColor="#fff3f3f3"
            app:barProgressColor="#ffafc7bf"/>
   	
XML预置变量如下：

| 变量名 | 变量内容 | 变量解释 |
| --- | --- | --- |
| drawingDirection | horizontal / Vertical | 进度条方向 —— 横向 / 纵向 |
| progress | 填写0-100的float值 | 进度 |
| roundedRadius | 填写有效长度值 | 圆角半径（不填写则默认为腰圆） |
| barBackgroundColor | 颜色 | 进度条背景层颜色 |
| barProgressColor | 颜色 | 进度条前景层颜色 |

## Java调用方法

1. 实例化RoundedProgressBar
        
        RoundedProgressBar roundedProgressBar = findViewById(R.id.roundedProgressBar);
        
2. 设置进度
        
        roundedProgressBar.setProgress(15f); // 设置进度
        
3. 设置圆角半径（若不设置，则默认为腰圆。该方法的值以像素为单位）
        
        roundedProgressBar.setRoundedRadius(16); // 设置半径（像素）
        
4. 设置圆角半径（该方法的值以dp为单位）
        
        roundedProgressBar.setRoundedRadiusByDip(16); // 设置半径（Dp）
        
5. 设置进度条方向
        
        roundedProgressBar.setDrawingDirection(RoundedProgressBar.DrawingDirection.VERTICAL); // 设置进度条方向
        
6. 设置进度条背景层颜色
        
        roundedProgressBar.setBarBackgroundColor(getColor(R.color.colorAccent)); // 设置进度条背景层颜色
        
7. 设置进度条前景层颜色
        
        roundedProgressBar.setBarProgressColor(getColor(R.color.colorPrimary)); // 设置进度条前景层颜色
        
<br>

****

<br>

**尽情享用这舒适而从容的圆角进度条插件吧～🉑️**
