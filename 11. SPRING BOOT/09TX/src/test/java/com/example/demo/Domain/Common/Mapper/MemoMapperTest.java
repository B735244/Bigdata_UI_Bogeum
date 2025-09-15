package com.example.demo.Domain.Common.Mapper;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MemoMapperTest {
    @Autowired
    private MemoMapper memoMapper;


    @Test
    public void post1000(){
        for(int i =0; i<1000; i++){
            memoMapper.insert(new MemoDto(null, "내용" +i, "작성자"+i, LocalDateTime.now()));
        }

    }
    @Test // Insert
    public void t1() {
        MemoDto dto = new MemoDto(1855L, "내용1", "작성자1", LocalDateTime.now());
        memoMapper.insert(dto);
    }

    @Test// Update
    public void t2() {
        MemoDto dto = new MemoDto(1L, "내용1-update", "작성자1-1", LocalDateTime.now());
        memoMapper.update(dto);
    }

    @Test //Delete
    public void t3() {
        memoMapper.delete(1L);
    }

    @Test
    public void t4(){
        MemoDto dto = new MemoDto(null, "내용1", "작성자1", LocalDateTime.now());
        memoMapper.insert(dto);

    }

    @Test
    public void t5(){
        // List<MemoDto> list = memoMapper.selectAll();
        List<MemoDto> list = memoMapper.selectAllContains("writer","2");
        list.forEach(System.out::println);
    }
    public void t6(){
        List<Map<String,Object>> list1 =
                memoMapper.selectAllWithResultMap();

        list1.forEach((map)->{
            System.out.println(map);

        });

    }

    @Test
    public void t7(){
        MemoDto dto = new MemoDto(2000L, "내용1", "작성자1", LocalDateTime.now());
        memoMapper.insertXML(dto);
    }



    @Test
    public void t8(){
        memoMapper.deleteXML(5L);

    }

    @Test
    public void t9(){
        MemoDto dto = new MemoDto(40L, "Hello", "손보금", LocalDateTime.now());
        memoMapper.updateXML(dto);
    }

    @Test
    public void t10(){

        MemoDto dto=  memoMapper.selectXML(7L);
        System.out.println(dto);
    }
    @Test
    public void t11(){
        List<MemoDto> dto= memoMapper.selectAllXML();
        dto.forEach(System.out::println);
    }

    @Test
    public void t12(){
        List<Map<String, Object>> list = memoMapper.selectAllMapXML();
        list.forEach(System.out::println);
    }

    @Test
    public void t13(){
        Map<String, Object> param = new HashMap();
        param.put("type", "text");
        param.put("keyword", "5");
        //param.put("keyword","5");
        List<Map<String, Object>> list = memoMapper.selectAllIfXML(param);
        System.out.println("TOTAL:" + list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void t14(){
        Map<String, Object> param = new HashMap();
        param.put("field", "1");
        param.put("type", "writer");
        param.put("keyword", "작성자");
        //param.put("keyword","5");
        List<Map<String, Object>> list = memoMapper.selectAllChooseXML(param);
        System.out.println("TOTAL:" + list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void t15(){
        Map<String, Object> param = new HashMap();
        param.put("field", "3");
        param.put("type", Arrays.asList("id","text","writer"));
        param.put("keyword", "5");
        //param.put("keyword","5");
        List<Map<String, Object>> list = memoMapper.selectAllIfAndXML(param);
        System.out.println("===========================TOTAL:" + list.size()+"=================================");
        list.forEach(System.out::println);
    }



}