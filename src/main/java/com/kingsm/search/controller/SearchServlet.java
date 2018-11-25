package com.kingsm.search.controller;

import com.kingsm.search.domain.Keyword;
import com.kingsm.search.service.SearchService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setContentType("application/json;charset=utf-8");

        List<Map> resultList = new ArrayList<Map>();

        Keyword keyword = new Keyword();

        String value = request.getParameter("keyword");

        keyword.setKw(value);

        SearchService ss = new SearchService();

        ResultSet rs = ss.match(keyword);

        if (rs == null) {
            response.setStatus(502);
            response.getWriter().write("没有查询到数据");
        } else {

            try {


                while (rs.next()) {
                    try {
                        System.out.println(rs.getString(2));

                        Map<String, String> map = new HashMap<String, String>();
                        map.put("keyword", rs.getString(2));

                        resultList.add(map);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

//            response.getWriter().write("查询到了数据");

            JSONArray resule = JSONArray.fromObject(resultList);

            response.setStatus(200);

            response.getWriter().println(resule);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("hello world");
    }
}
