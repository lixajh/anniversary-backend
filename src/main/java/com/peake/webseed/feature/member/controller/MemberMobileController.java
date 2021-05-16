package com.peake.webseed.feature.member.controller;

import com.alipay.api.AlipayApiException;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.member.dto.WechatLoginDTO;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.model.MemberDetailDTO;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.utils.ShiroUtils;
import com.peake.webseed.utils.WechatUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by CodeGenerator on 2018/08/30.
 */
@RestController
@RequestMapping("/mobile/member")
public class MemberMobileController extends AbstractController {
    public static final String deviceIdKey = "deviceId";
    String host = "peake.mynatapp.cc";
    Logger logger = LoggerFactory.getLogger(MemberMobileController.class);

    @Value("${domain}")
    private String domain;
    @Value("${alipay.appid}")
    private String alipayAppid;
    @Value("${alipay.sandbox}")
    private boolean alipaySandbox;
    @Resource
    private MemberService memberService;

    @PostMapping("/add")
    public Result add(Member member) {
        memberService.save(member);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        memberService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Member member) {
        memberService.update(member);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail() {
        MemberDetailDTO member = memberService.detail(getMember().getPkId());
        return ResultGenerator.genSuccessResult(member);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Member member) {
        PageInfo pageInfo = memberService.findbyPage(page,size,"username",member);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     *
     * @param session
     * @param request
     * @param response
     * @param isNew 测试用，想看第一次登陆的效果使用isNew = 1
     * @param deviceId
     * @return
     * @throws IOException
     */
    @GetMapping("/toAuth")
    public String toAuth(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer isNew, String deviceId) throws IOException {
        if (StringUtils.isEmpty(deviceId)){
            session.removeAttribute(deviceIdKey);
        }else{
            session.setAttribute(deviceIdKey, deviceId);
        }
        String ua = ((HttpServletRequest) request).getHeader("user-agent").toLowerCase();
        if (ShiroUtils.getSubjct().isAuthenticated()){
            if(isNew != null){
                response.sendRedirect(domain + "mobilefront/#/index?result=0&isNew="+isNew + "&deviceId="+deviceId);
            }else{
                response.sendRedirect(domain + "mobilefront/#/index?result=0&isNew=0"+ "&deviceId="+deviceId);
            }

        }else{
            if(ua.indexOf("alipay") > 0){
                //支付宝
                String auth_code = request.getParameter("auth_code");

//                logger.info("alipay auth_code is null ,redirect open in alipay");
                String url = domain + "server/mobile/member/wechatLogin";
                String redirectUrl;
                if (alipaySandbox){
                    redirectUrl = "https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id="+alipayAppid+"&scope=auth_user&redirect_uri="+URLEncoder.encode(url,"UTF-8");

                }else{
                    redirectUrl = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+alipayAppid+"&scope=auth_user&redirect_uri="+URLEncoder.encode(url,"UTF-8");

                }
//                logger.info("redirect【" + redirectUrl + "】");

                response.sendRedirect(redirectUrl);
            }else if (ua.indexOf("micromessenger") > 0) {
                //微信
                WxMpService wxService = WechatUtils.getInstance().getWxService();
                String url = domain + "server/mobile/member/wechatLogin";
                String s = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
                response.sendRedirect(s);
            }else{
                //todo 提示请使用微信或支付宝扫描二维码
                return "请使用微信或支付宝扫描二维码";
            }

        }
        /*测试注销这一部分 end*/
//        response.sendRedirect("http://peake.mynatapp.cc/mobilefront/#/index?result=0&isNew=1");//todo for test
        return null;
    }

    @GetMapping("/wechatLogin")
//    @ResponseBody
    //https://www.jianshu.com/p/7882ee243298
    public String wechatLogin(HttpSession session, HttpServletResponse response, String code, String auth_code) throws WxErrorException, IOException, AlipayApiException {
        WechatLoginDTO memberDTO = null;
        if (StringUtils.isNotBlank(code)){
            memberDTO = memberService.getMemberByWechatCode(code);
        }else if(StringUtils.isNotBlank(auth_code)) {
            memberDTO = memberService.getMemberByAlipayCode(auth_code);
        }
        if (memberDTO == null){
            //todo 提示错误
            return null;
        }
        Member member = memberDTO.getMember();
        boolean isNew = memberDTO.isNew();
        String redirectUrl = domain + "mobilefront/#/index?result=";

        try {
            memberService.loginByOpenId(member.getOpenId());
            redirectUrl = redirectUrl + "0";
        } catch (AuthenticationException e) {
            redirectUrl = redirectUrl + "-1";
        } catch (AuthorizationException e) {
            redirectUrl = redirectUrl + "-1";
        }
        redirectUrl = redirectUrl +"&isNew="+(isNew?1:0) + "&deviceId=" + session.getAttribute(deviceIdKey);
        response.sendRedirect(redirectUrl);
        return null;
    }

    @RequestMapping("/logout")
    public Result logout() {
        ShiroUtils.logout();
        return ResultGenerator.genSuccessResult();
    }
}
