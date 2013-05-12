package org.zj.citycontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.zj.citycontrol.model.Area;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class AreaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String QUERY_ALL_AREA = "select * from b_city where gngj = ";


    ParameterizedRowMapper<Area> areaMapper = new ParameterizedRowMapper<Area>() {
        @Override
        public Area mapRow(ResultSet rs, int i) throws SQLException {
            Area area = new Area();
//          area.setId(rs.getString("BH"));
            area.setName(rs.getString("MC"));
            area.setEnName(rs.getString("YWMC"));
            area.setShot(rs.getString("DLMCJP"));
//          area.setCountryId(rs.getString("SZGJ"));
            area.setCid(rs.getString("CSBH"));
            area.setAirName(rs.getString("JCMC"));
            area.setCode(rs.getString("NBBH"));

            return area;
        }
    };


    public List<Map<String,Object>> getAllArea(boolean international){
        String gngj = "'1'";
        if(international){
            gngj = "'0'";
        }

//        return jdbcTemplate.query(QUERY_ALL_AREA+gngj,areaMapper);
        return jdbcTemplate.queryForList(QUERY_ALL_AREA,gngj);
    }

    public List<Area> getArea(boolean international){
        String gngj = "'1'";
        if(international){
            gngj = "'0'";
        }

        return jdbcTemplate.query(QUERY_ALL_AREA+gngj,areaMapper);
    }

}
