package com.peake.webseed.feature.member.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.common.shiro.ThirdPartyLoginToken;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.member.dto.WechatLoginDTO;
import com.peake.webseed.feature.member.mapper.MemberMapper;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.model.MemberDetailDTO;
import com.peake.webseed.feature.member.model.MemberPlus;
import com.peake.webseed.feature.member.service.MemberPlusService;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.utils.JSONUtils;
import com.peake.webseed.utils.WechatUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class MemberServiceImpl extends AbstractService<Member> implements MemberService {

    Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Value("${alipay.appid}")
    private String alipayAppid;
    @Value("${alipay.sandbox}")
    private boolean alipaySandbox;
    @Value("${alipay.private_key}")
    private String alipayPrivateKey;
    @Value("${alipay.public_key}")
    private String alipayPublicKey;

    @Resource
    private MemberMapper MemberMapper;
    @Resource
    private MemberPlusService memberPlusService;

    @Override
    public Result login(Member member) {
        return null;
    }

    @Override
    public Member findByOpenId(String openId) {
        return findBy("openId", openId);
    }

    @Override
    public WechatLoginDTO getMemberByWechatCode(String code) throws WxErrorException {
        WxMpService wxMpService = WechatUtils.getInstance().getWxService();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        WxMpUser user = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        Member member = findByOpenId(user.getOpenId());
//        Member member = findByOpenId("ozqVc0VzImLHzu_NGlk_siyBH83U");
        boolean isNew = false;
        if (member == null){
            member = new Member();
            member.setNickname(user.getNickname());
            member.setOpenId(user.getOpenId());
            member.setCreateTime(now());
            member.setDataStatus(EnumDataStatus.normal.getValue());
            save(member);

            MemberPlus memberPlus = new MemberPlus();
            memberPlus.setFkMemberId(member.getPkId());
            memberPlus.setCity(user.getCity());
            memberPlus.setCountry(user.getCountry());
            memberPlus.setLanguage(user.getLanguage());
            memberPlus.setPrivilege(JSONUtils.beanToJson(user.getPrivileges()));
            memberPlus.setProvince(user.getProvince());
            memberPlus.setSex(user.getSex());
            memberPlus.setCreateTime(now());
            memberPlus.setUpdateTime(now());
            memberPlusService.save(memberPlus);
            isNew = true;
        }
        return new WechatLoginDTO(member,isNew);
    }

    @Override
    public WechatLoginDTO getMemberByAlipayCode(String code) throws AlipayApiException {
        //https://docs.open.alipay.com/284/106001/
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayAppid, alipayPrivateKey, "json", "UTF-8", alipayPublicKey, "RSA2");
        AlipaySystemOauthTokenRequest request1 = new AlipaySystemOauthTokenRequest();
        request1.setCode(code);
        request1.setGrantType("authorization_code");
        //获取用户id和token
        AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request1);
        System.out.println(oauthTokenResponse.getAccessToken());
        String alipayUserId = oauthTokenResponse.getUserId();

        Member member = findByOpenId(alipayUserId);
//        Member member = findByOpenId("ozqVc0VzImLHzu_NGlk_siyBH83U");
        boolean isNew = false;
        if (member == null){
            AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
            String auth_token = oauthTokenResponse.getAccessToken();
            AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(request, auth_token);
            member = new Member();
            member.setNickname(userinfoShareResponse.getNickName());
            member.setOpenId(alipayUserId);
            member.setCreateTime(now());
            member.setDataStatus(EnumDataStatus.normal.getValue());
            save(member);

            MemberPlus memberPlus = new MemberPlus();
            memberPlus.setFkMemberId(member.getPkId());
            memberPlus.setCity(userinfoShareResponse.getCity());
            memberPlus.setCountry(userinfoShareResponse.getCountryCode());
//            memberPlus.setLanguage(userinfoShareResponse.get());
//            memberPlus.setPrivilege(JSONUtils.beanToJson(user.getPrivileges()));
            memberPlus.setProvince(userinfoShareResponse.getProvince());
//            memberPlus.setSex(userinfoShareResponse.getGender());
            memberPlus.setCreateTime(now());
            memberPlus.setUpdateTime(now());
            memberPlusService.save(memberPlus);
            isNew = true;
        }
        return new WechatLoginDTO(member,isNew);
    }

    @Override
    public void loginByOpenId(String openId) {
        ThirdPartyLoginToken token = new ThirdPartyLoginToken(openId, 1);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        Member member = findByOpenId(openId);
        member.setLastLoginTime(now());
        member.setUpdateTime(now());
        update(member);
    }

    @Override
    public MemberDetailDTO detail(Long id) {
        Member member = findById(id);
        MemberPlus memberPlus = memberPlusService.findBy("fkMemberId", id);


        return new MemberDetailDTO(member,memberPlus);
    }
}
