package com.peake.webseed.utils;


import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

public class WechatUtils {

    // 静态实例变量
    private static WechatUtils instance;
    private WxMpService wxService;

    // 私有化构造函数
    private WechatUtils() {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxc4980c9f9cc9b7fe"); // 设置微信公众号的appid
        config.setSecret("8acbd001836c14af2bc75d0d617657c6"); // 设置微信公众号的app corpSecret
//        config.setToken("..."); // 设置微信公众号的token
//        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey

        wxService = new WxMpServiceImpl();// 实际项目中请注意要保持单例，不要在每次请求时构造实例，具体可以参考demo项目
        wxService.setWxMpConfigStorage(config);
    }

    // 静态public方法，向整个应用提供单例获取方式
    public static WechatUtils getInstance() {
        if (instance == null) {
            instance = new WechatUtils();
        }
        return instance;
    }

    public WxMpService getWxService() {
        return wxService;
    }
}
