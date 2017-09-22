# Android-BitherCompress
Android图片压缩目前最优解决方案。

------

## 介绍

Android图片压缩结合多种压缩方式，常用的有尺寸压缩、质量压缩以及通过JNI调用libjpeg库来进行压缩，三种方式结合使用实现指定图片内存大小，清晰度达到最优。

## 使用

* 导入lib-bither-compress

```java
	NativeUtil.compressBitmap(bitmap, savePath);

	NativeUtil.compressBitmap(bitmap, savePath, maxByte, quality);
```

* 图像建议尺寸

```Java
    public final static int QUALITY_320P = 320;//480, 320
    public final static int QUALITY_360P = 360;//640, 360
    public final static int QUALITY_480P = 480;//640, 480
    public final static int QUALITY_720P = 720;//1280, 720
    public final static int QUALITY_1080P = 1080;//1920, 1080
    public final static int QUALITY_2K = 1440;//2560, 1440
    public final static int QUALITY_4K = 2160;//3840, 2160
```

* 图像默认品质

```Java
    //见 NativeUtil 中 compressBitmap(bitmap, savePath, maxByte, quality) 方法
    int options = 80;//100不压缩品质
```

> 注意：默认将图像压缩到 1280*720 的尺寸，品质为 80 ，图像大小为 1 MB。其他配置可在 lib-bither-compress 中 NativeUtil 下自己配置。

## 对比

原图 5.5M  
<img src="https://github.com/freekite/Android-BitherCompress/blob/master/resources/20160815_141638_001.jpg" width="560px" height="315px" />

压缩后 784k  
<img src="https://github.com/freekite/Android-BitherCompress/blob/master/resources/compress_1471244287213.jpg" width="560px" height="315px" />

## 感谢

* [bither / bither-android-lib](https://github.com/bither/bither-android-lib)

## 关于我

如果对你有帮助，请 star 一下，然后 follow 我，给我增加一下分享动力，谢谢！

如果你有什么疑问或者问题，可以提交 issue 和 request，发邮件给我 jeanboy@foxmail.com 。

或者加入下面的 QQ 群来一起学习交流。

<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=bbbd62c0860ce7c1a6119030f51df102bb0d3ecc12cf66b4d8887941233c6e78"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="Android技术进阶：386463747" title="Android技术进阶：386463747"></a>

## License

    Copyright 2015 jeanboy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

