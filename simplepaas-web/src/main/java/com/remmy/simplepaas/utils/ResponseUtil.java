package com.remmy.simplepaas.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remmy.simplepaas.common.IStatus;
import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.exception.BaseException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yejiaxin
 */
@Component
public class ResponseUtil {
    public void renderJson(HttpServletResponse response, BaseException e) throws IOException {
        write(response, e.getMessage());
    }

    public void renderJson(HttpServletResponse response, IStatus status) throws IOException {
        write(response, RespBean.error(status));
    }

    private void write(HttpServletResponse response, Object obj) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);

        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(obj));
        out.flush();
        out.close();
    }
}
