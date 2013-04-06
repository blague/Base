package org.zj.poi;

import com.google.common.base.Strings;
import  org.jsoup.nodes.Document;
import  org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReadWord {


    /**
     * 查询地区表中是否存在该地区.
     */
    public static final String QUERY_COUNT_AREA = "select count(*) from AREA where name = ?";
    /**
     * 插入地区数据
     */
    public static final String INSERT_AREA = "insert into area values (null,?,?)";

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String url = "http://www.51ticket.net/ziliao/aozhou1.htm";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("#table1 tr");
            for (int i = 1,length = element.size(); i < length; i++) {
                final String name = element.get(i).child(3).text();
                if(!Strings.isNullOrEmpty(name) && jdbcTemplate.queryForInt(QUERY_COUNT_AREA,name) < 1){
                    jdbcTemplate.execute(INSERT_AREA,new PreparedStatementCallback<Boolean>() {
                        @Override
                        public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                            ps.setString(1,name);
                            ps.setInt(2,5);
                            return ps.execute();
                        }
                    });
                }

            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
