package com.example.demo.Domain.Common.Dao;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class MemoDao {

    //**중요**
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSession sqlSession;
    String NAMESPACE = "com.example.demo.Domain.Common.Mapper.MemoMapper.";
    //MyBatis 사용
    public Long insert(MemoDto dto) throws SQLException {

        sqlSession.insert(NAMESPACE +"insert",dto);
        System.out.println(dto);
        return dto.getId();

    }


}
