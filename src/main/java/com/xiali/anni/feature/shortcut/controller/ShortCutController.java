package com.xiali.anni.feature.shortcut.controller;

import com.xiali.anni.core.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
