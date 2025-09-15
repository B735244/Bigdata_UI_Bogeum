package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TxTestServiceTest {
    @Autowired
    private TxTestService txTestService;

    @Test
    public void t1() throws Exception{
//        txTestService.addMemo();
        txTestService.addMemoTx();
    }


    @Test
    public void t2() throws Exception{
        txTestService.addMemoWithMybatis(new MemoDto(958L,"a","a", LocalDateTime.now()));
    }

    @Test
    public void t3()throws Exception{
        txTestService.addMemoWithMybatisTx(new MemoDto(987L,"a","a",LocalDateTime.now()));

    }
}