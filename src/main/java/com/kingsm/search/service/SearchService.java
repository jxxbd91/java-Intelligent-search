package com.kingsm.search.service;

import com.kingsm.search.dao.SearchDao;
import com.kingsm.search.domain.Keyword;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchService {
    private SearchDao sd = new SearchDao();

    /**
     * 输入框输入内容进行匹配
     */
    public ResultSet match (Keyword kw) {

        ResultSet rs = null;

        try {
            rs = sd.query(kw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }


    /**
     * 进行数据插入
     *  首先进行精准匹配，如果存在就不进行插入，如果不存在插入新数据
     */
    public boolean insert (Keyword kw) {

        boolean flag = false;

        ResultSet rs = null;

        try {
            rs = sd.exactMatch(kw);

            if (!rs.next()) {

                flag = sd.insert(kw);

            } else {
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
