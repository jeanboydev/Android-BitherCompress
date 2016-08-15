# Android-BitherCompress
Android图片压缩目前最优解决方案。

------

##介绍

Android图片压缩结合多种压缩方式，常用的有尺寸压缩、质量压缩以及通过JNI调用libjpeg库来进行压缩，三种方式结合使用实现指定图片内存大小，清晰度达到最优。

##使用

* 导入lib-bither-compress
```java
	NativeUtil.compressBitmap(bitmap, savePath);
```

## 对比

原图 5.5M  
<img src="https://github.com/freekite/Android-BitherCompress/blob/master/resources/20160815_141638_001.jpg" width="560px" height="315px" />

压缩后 784k  
<img src="https://github.com/freekite/Android-BitherCompress/blob/master/resources/compress_1471244287213.jpg" width="560px" height="315px" />

## 感谢

* [bither / bither-android-lib](https://github.com/bither/bither-android-lib)

## 关于我

* Mail: jeanboy@foxmail.com

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

