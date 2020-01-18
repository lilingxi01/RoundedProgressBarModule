# RoundedProgressBarModule [![](https://www.jitpack.io/v/lilingxi01/RoundedProgressBarModule.svg)](https://www.jitpack.io/#lilingxi01/RoundedProgressBarModule)
 
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

## 使用方法

### 1. XML文件调用
   	
   	<cn.tacitech.roundedprogressbarmodule.RoundedProgressBar
        android:layout_width="75dp"
        android:layout_height="30dp"
        app:drawingDirection="horizontal"
        app:progress="65"
        app:roundedRadius="15dp"
        app:barBackgroundColor="#fff3f3f3"
        app:barProgressColor="#ffafc7bf"/>
   	
XML预置变量如下：
| 变量名 | 变量 | 解释 |
| --- | --- | --- |
| drawingDirection | horizontal / Vertical | 进度条方向 —— 横向 / 纵向 |
| progress | 填写0-100的float值 | 进度 |
| roundedRadius | 填写有效长度值 | 圆角半径（不填写则默认为腰圆） |
| barBackgroundColor | 颜色 | 进度条背景层颜色 |
| barProgressColor | 颜色 | 进度条进度层颜色 |
