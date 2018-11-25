package com.kingsm.search.controller;

import com.kingsm.search.domain.Keyword;
import com.kingsm.search.service.SearchService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        String value = request.getParameter("keyword");

        Keyword kw = new Keyword();

        kw.setKw(value);

        SearchService ss = new SearchService();

        boolean result = ss.insert(kw);

        Map<String, String> resultMap = new HashMap<String, String>();

        if (result) {

            resultMap.put("msg", "数据插入成功");
        } else {

            resultMap.put("msg", "数据插入失败");
        }


        JSONObject jo = JSONObject.fromObject(resultMap);
        response.getWriter().println(jo);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
