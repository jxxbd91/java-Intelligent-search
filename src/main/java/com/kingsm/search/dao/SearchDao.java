package com.kingsm.search.dao;

import com.kingsm.search.common.DBUtils;
import com.kingsm.search.domain.Keyword;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchDao {
    private Statement st = DBUtils.getSt();
    private Connection conn = DBUtils.getConn();


    /*
    *  插入数据
    * */

    public boolean insert(Keyword kw) throws SQLException {
        String value = kw.getKw();

        String sql = "INSERT INTO usr(`keywords`) VALUES '" + value + "''";

        boolean flag = st.execute(sql);

        return flag;
    }

    /**
     * 查询数据
     */
    public ResultSet query(Keyword kw) throws SQLException {
        String value = kw.getKw();

        ResultSet rs = null;

        String sql = "SELECT * FROM usr WHERE keywords LIKE '%" + value + "'%";

        rs = st.executeQuery(sql);

        return rs;
    }

}
