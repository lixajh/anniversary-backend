package com.peake.webseed.feature.shortcut.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import com.peake.webseed.utils.PasswordUtils;
import com.peake.webseed.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by CodeGenerator on 2018/08/29.
 */
@Controller
@RequestMapping("/s")
public class ShortCutController extends AbstractController {

    @RequestMapping("/s/{id}")
    public String scan(@PathVariable(value="id") String id, HttpServletResponse response) throws IOException {
        if (id != null){
            ///mobile/member/toAuth
            response.sendRedirect("../../mobile/member/toAuth?deviceId=" + id);
//            return "redirect:/mobile/member/toAuth?deviceId=" + id;
            return null;
        }else{

            return "error id";
        }
    }
}
