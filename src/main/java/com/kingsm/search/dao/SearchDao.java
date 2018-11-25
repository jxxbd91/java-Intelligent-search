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

        String sql = "INSERT INTO usr(`keywords`) VALUES ('" + value + "')";

        boolean flag = st.executeUpdate(sql) == 1;

//        st.close();

//        conn.close();

        return flag;
    }

    /**
     * 模糊查询数据
     */
    public ResultSet query(Keyword kw) throws SQLException {
        String value = kw.getKw();

        ResultSet rs = null;

        String sql = "SELECT * FROM usr WHERE keywords LIKE '%" + value + "%'";

        rs = st.executeQuery(sql);

//        st.close();

//        conn.close();

        return rs;
    }

    /**
     * 精确匹配数据
     */
    public ResultSet exactMatch (Keyword kw) throws SQLException {
        ResultSet rs = null;

        String value = kw.getKw();

        String sql = "SELECT * FROM usr WHERE `keywords` = '" + value +"'";

        rs = st.executeQuery(sql);

//        st.close();

//        conn.close();

        return rs;
    }

}
