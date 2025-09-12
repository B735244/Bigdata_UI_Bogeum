package com.example.demo.Domain.Common.Dao;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class MemoDao {

    //**중요**
    @Autowired
    private DataSource dataSource3;

    public int insert(MemoDto dto) throws SQLException {
        Connection conn = dataSource3.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(1,now(),?,?)"); //4개 인자 던진다
       // pstmt.setLong(1, null);
        pstmt.setString(3, dto.getText());
        pstmt.setString(4, dto.getWriter());
        //pstmt.setString(4, dto.getCreateAt().toString());
        int result = pstmt.executeUpdate();
        return result;

    }


}
