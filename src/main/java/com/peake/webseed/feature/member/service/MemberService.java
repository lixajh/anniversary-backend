package com.peake.webseed.feature.member.service;

import com.alipay.api.AlipayApiException;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.Service;
import com.peake.webseed.feature.member.dto.WechatLoginDTO;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.model.MemberDetailDTO;
import me.chanjar.weixin.common.error.WxErrorException;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
public interface MemberService extends Service<Member> {
    Result login(Member member);

    WechatLoginDTO getMemberByWechatCode(String code) throws WxErrorException;
    WechatLoginDTO getMemberByAlipayCode(String code) throws AlipayApiException;

    void loginByOpenId(String openId);

    Member findByOpenId(String openId);

    MemberDetailDTO detail(Long id);
}
