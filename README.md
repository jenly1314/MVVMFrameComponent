# MVVMFrameComponent

![Image](app/src/main/ic_launcher-playstore.png)

[![Download](https://img.shields.io/badge/download-APK-brightgreen?logo=github)](https://raw.githubusercontent.com/jenly1314/MVVMFrameComponent/master/app/release/app-release.apk)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen?logo=android)](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)
[![License](https://img.shields.io/github/license/jenly1314/MVVMFrameComponent?logo=open-source-initiative)](https://opensource.org/licenses/mit)


MVVMFrameComponent 一个基于 [MVVMFrame](https://github.com/jenly1314/MVVMFrame) 框架为核心基础库构建的组件化方案


## 主要使用的核心技术

* JetPack(Lifecycle，LiveData，ViewModel，Room，Hilt)
* Dagger
* DataBinding
* Retrofit
* OkHttp
* Glide
* Kotlin coroutines
* ARouter

## 架构

**MVVMFrameComponent** 组件化架构图分层如下：

![Architecture](art/MVVMFrameComponent_architecture.jpg)

因为组件化的核心基础库是基于 **MVVMFrame**，这里贴出 **MVVMFrame** 的架构图如下：

![Architecture](art/mvvm_architecture.jpg)

## 浅谈组件化

1. 什么是组件化？
> 组件化简单概括就是把一个功能完整的 **App** 或 **模块** 拆分成多个子模块, 让每个子模块可以独立编译和运行, 也可以作为 **library** 合并到宿主App组成一个完整的 **App**进行编译和运行。每个模块即可以不相互依赖，又可以相互交互。

2. 为什么要组件化？
> 当一个项目随着时间的推移，需求不断的变更与迭代。各个模块也会变的相对复杂。维护难度也会随之增加，时间久了，可能会引起一些新的问题。这时我们就需要组件化。

3. 组件化的优势是什么？
> 当一个App使用组件化开发方案时，主要的优势有：组件化拆分各个模块后，每个子模块都可以独立编译和运行，这样在开发调测某个模块时，可以大大提高编译速度和开发效率。多人开发时，每个人负责独立的模块，更有利于多人团队协作开发。并且各个模块之间的代码边界相对清晰，更易于后期维护。

## MVVMFrameComponent 组件化方案

**MVVMFrameComponent** = **MVVMFrame** + **Component**。即 **MVVMFrameComponent** 采用 **MVVM** 模式架构的组件化方案。


## 工程各个 Module 相关说明

### app
宿主App：当各个子 **Module** 作为 **library** 时，则可将所有组件集成到 **宿主App** 中。此时 **宿主App** 则是一个拥有所有组件功能集合的完整的App。

### common-base
组件化公共基础库：主要包含 **MVVMFrame** 快速开发框架，和作为组件化的一些公共的核心基础库，方便快速构建组件化 **Project**。

### common-res
组件化公共资源库：主要方便统一管理各个 **Module** 中的一些公共资源相关。

### module-joke
一个简单的笑话功能模块：主要用来展示基于 **MVVMFrame** 来实现组件化开发，作为组件化开发的 **Module** 实现示例之一。

### module-news
一个简单的新闻功能模块：主要用来展示基于 **MVVMFrame** 来实现组件化开发，作为组件化开发的 **Module** 实现示例之一。

## 其他

### 特别说明
**Project** -> **build.gradle** 内的自定义变量 **isBuildModule**
> 自定义变量 **isBuildModule** 来统一管理各个子 module 方便在 **application** 与 **library** 之间进行切换
>> 当 **isBuildModule = true** 时，表示 各个子 **module** 为 **application** ，即 **module** 可独立运行
>> 当 **isBuildModule = false** 时，表示 各个子 **module** 为 **library** ，即 **module** 作为 **library** 合并到 **宿主App**

**Project** -> **module-build.gradle**
> 组件化子 **module** 通用 **build.gradle** ，方便统一管理
>> 根据 **isBuildModule** 来统一管理各个子 **module** 在 **application** 与 **library** 之间切换


### 关于 **MVVMFrame**
因为 **MVVMFrameComponent** 的核心基础库是基于 **MVVMFrame** 的，所以需要对 **MVVMFrame** 有一定的了解，才能在使用 **MVVMFrameComponent** 时更加得心应手，
这里不再特意介绍 **MVVMFrame** 相关的使用，具体介绍你可以直接查看 [MVVMFrame](https://github.com/jenly1314/MVVMFrame)

## 示例

### 关于各组件/模块共用 **Application** 初始化

 对于模块公用的可以尽量写在 **BaseApp** 中，对于模块相对独立使用的，可以写在模块对应 **IComponentApp** 的实现实现类中。
 
 特别说明：对于**IComponentApp** 的实现只是为你提供对应需求的一种解决方式，是可选的。根据需要使用。
 
 这里贴出各模块的 **IComponentApp** 实现类示例供参考：
 
 [**module-joke**](module-joke) 中 **IComponentApp** 的实现类是 [**JokeComponentApp**](module-joke/src/main/java/com/king/mvvm/joke/JokeComponentApp.kt)
 
 [**module-news**](module-news) 中 **IComponentApp** 的实现类是 [**NewsComponentApp**](module-news/src/main/java/com/king/mvvm/news/NewsComponentApp.kt)

下面是 [**module-joke**](module-joke) 中的代码示例
```kotlin
class JokeComponentApp : IComponentApp{

    override fun onCreate(app: BaseApp) {

    }

}
```

在 **Manifest** 中配置 **meta-data** 对应的**IComponentApp**实现类，示例如下 ：
```xml
        <!-- name为：IComponentApp的实现类，value固定为: ComponentApp -->
        <meta-data android:name="com.king.mvvm.joke.JokeComponentApp"
            android:value="ComponentApp"/>
```

当想要获取各模块的 **IComponentApp** 实现类时，可通过 **BaseApp** 的 **getComponentApp** 方法获取。

更多使用详情，请查看[app](app)中的源码使用示例

## 相关推荐
- [MVVMFrame](https://github.com/jenly1314/MVVMFrame) 一个基于Google官方推出的JetPack构建的MVVM快速开发框架。
- [AppTemplate](https://github.com/jenly1314/AppTemplate) 一款基于 MVVMFrame 构建的App模板。
- [AppUpdater](http://github.com/jenly1314/AppUpdater) 一个专注于App更新，一键傻瓜式集成App版本升级的轻量开源库。
- [RetrofitHelper](http://github.com/jenly1314/RetrofitHelper) 一个支持动态改变BaseUrl，动态配置超时时长的Retrofit帮助类。
- [BaseUrlManager](http://github.com/jenly1314/BaseUrlManager) 一个BaseUrl管理器，主要用于打测试包时，一个App可动态切换到不同的开发环境或测试环境。
- [SuperTextView](http://github.com/jenly1314/SuperTextView) 一个在TextView的基础上扩展了几种动画效果的控件。
- [ImageViewer](http://github.com/AndroidKTX/ImageViewer) 一个图片查看器，一般用来查看图片详情或查看大图时使用。
- [GuidePage](http://github.com/AndroidKTX/GuidePage) 一个App欢迎引导页。一般用于首次打开App时场景，通过引导页指南，概述App特色等相关信息。
- [LogX](http://github.com/jenly1314/LogX) 一个轻量而强大的日志框架；好用不解释。
- [KVCache](http://github.com/jenly1314/KVCache) 一个便于统一管理的键值缓存库；支持无缝切换缓存实现。
- [AndroidKTX](http://github.com/AndroidKTX/AndroidKTX) 一个简化 Android 开发的 Kotlin 工具类集合。
- [AndroidUtil](http://github.com/AndroidUtil/AndroidUtil) 一个整理了Android常用工具类集合，平时在开发的过程中可能会经常用到。


## 更新日志 

#### 2021-1-15
*  使用Hilt简化Dagger依赖注入用法
*  更新gradle至v4.1.1
*  更新MVVMFrame至v2.0.0
*  更新其它第三方依赖库版本

#### 2020-6-23
*  MVVMFrameComponent初始版本

---

![footer](https://jenly1314.github.io/page/footer.svg)

