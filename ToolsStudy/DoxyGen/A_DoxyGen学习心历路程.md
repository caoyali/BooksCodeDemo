最近没少学新工具，之前记到备忘录上， 但是后来因为备忘录不能是树的结构，搞的记录的位置一直很乱。加上这次写doxygen，碰到了很多问题，更乱了。 那可不行我受不了。就决定把一些工具的学习都提到git里去吧。

这个别调研了，王老板推荐用  doxygen   搞明白这个出的文档更好
先用这个 命令
 doxygen -g <config-file> 生成一个配置文件
这个配置文件可以配置一些东西
我目前碰到的问题是
1 我的排版特别丑
2 我注释的链接似乎不奏效
下面我将着重调研来找这两个问题的答案

排版问题：
https://www.doxygen.nl/manual/commands.html#cmdarg

将配置中   JAVADOC_AUTOBRIEF  改为true 
￼
这里会加很多说明， 会把你在函数上面的说明都加上
对于参数解析的第二种写法，也可以
public void init(InitConfig initConfig /**<初始化信息， 详见{@link InitConfig}*/, InitSDKCallback initSDKCallback/**<回调句柄，初始化结果会通过这个参数回调出去*/)
就是在方法参数后面加  /** < */

JAVADOC_BANNER = YES
RECURSIVE = YES  递归

我决定放弃链接了！！！，打不了看参数中的文档

sa   see also 的简写，不知道java好不好用
@see  java是这， 这个可能是方法内连接， 或者？？？方法外也行吗
注意提示；
/*! 
 *  \brief     Pretty nice class.
 *  \details   This class is used to demonstrate a number of section commands.
 *  \author    John Doe
 *  \author    Jan Doe
 *  \version   4.1a
 *  \date      1990-2011
 *  \pre       First initialize the system.
 *  \bug       Not all memory is freed when deleting an object of this class.
 *  \warning   Improper use can crash your application   这个是我们需要注意的项目
* \note
 *  \copyright GNU Public License.
 */

换行，官方提供的\b 都比不上HTML <br> 我的天！！！！

链接问题
用  \sa 命令  会在下面多一个
￼
但是你看看后面的，压根就不是链接。哎,即使我按照说明加了井号啥的，都不是链接。可能这个根本就不是链接
基本
链接到构造方法 ： #Autolink_Test and Autolink_Test()  
链接到此类的方法  member()     member(int)   member(int,int)  重载
连接到变量   #var
链接到全局   ::B
连接到全局枚举   #GlobEnum
连接到其他的变量并给予说明  \link #var using another text\endlink as a link     这个是 \link    \endlink 经典用法

\link Autolink_Test::Val1 Val1 \endlink and ::GVal1.     第一个就是想办法能凑成链接的点， 第二个是自己的说明！  这个是经典用法
链接到一个文件  直接写文件名    autolink.cpp


关于格式，这家伙竟然支持markdown我的天哪，但是你得在注释里面写，有些尴尬，也没有自动提示！HTMl也支持
关于链接位置不对的问题， 原因是，文件的相对位置要对？？？

# 使用前配置修改
## 生成配置文件
**doxygen -g <config-file>** 生成一个配置文件，这个很简单

# 格式相关常用
### group
```java
/**@name 业务场景常量*/     这个是声明的组名
    ///@{           这个确定组的边界， 从这里往下都是正常的注释
    /**
     * 支持720P、1080P高清画质，单个房间最多支持300人同时在线，最高支持50人同时发言,
     * <br> 适用于[1对1视频通话]、[300人视频会议]、[在线问诊]、[视频聊天]、[远程面试]等
     */
    public static final int ZPRTC_APP_SCENE_VIDEOCALL = 0;
    /**
    *支持平滑上下麦，切换过程无需等待，主播延时小于300ms；支持十万级别观众同时播放，播放延时低至1000ms
    *<br> 适用于[视频低延时直播]、[十万人互动课堂]、[视频直播 PK]、[视频相亲房]、[互动课堂]、[远程培训]、[超大型会议]
    */
    public static final int ZPRTC_APP_SCENE_LIVE = 1;
    /**
    *支持 48kHz，支持双声道。单个房间最多支持300人同时在线，最高支持50人同时发言
    *<br> 适用于[视频低延时直播]、[十万人互动课堂]、[视频直播 PK]、[视频相亲房]、[互动课堂]、[远程培训]、[超大型会议]
    */
    public static final int ZPRTC_APP_SCENE_AUDIOCALL = 2;
    /**
    *语音互动直播，支持平滑上下麦，切换过程无需等待，主播延时小于300ms；支持十万级别观众同时播放，播放延时低至1000ms
    *<br> 适用于[语聊房]、[语音直播连麦]、[K 歌房]、[FM 电台]等
    */
    public static final int ZPRTC_APP_SCENE_VOICE_CHATROOM = 3;
    ///@}   这个是组边界结束
```

![Snipaste_2022-02-23_14-42-29](/assets/Snipaste_2022-02-23_14-42-29.png)
### 换行