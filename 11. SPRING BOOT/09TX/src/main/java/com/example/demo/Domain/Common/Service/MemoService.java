package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dao.MemoDao;
import com.example.demo.Domain.Common.Dto.MemoDto;
import com.example.demo.Domain.Common.Dto.PageDto;
import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
public class MemoService {
    @Autowired
    private MemoDao memoDao;

    @Autowired
    private MemoRepository memoRepository;


    public boolean memoRegistration(MemoDto dto) throws Exception {
        int result = memoDao.insert(dto);
        return result>0;
    }

    @Transactional(rollbackFor = SQLException.class,transactionManager = "jpaTransactionManager")
    public Long memoRegistration2(MemoDto dto) throws Exception {
        //dto -> entity
        Memo memo = Memo.builder()
                .id(null)
                .text(dto.getText())
                .writer(dto.getWriter())
                .createAt(LocalDateTime.now())
                .build();
        memoRepository.save(memo);
        return memo.getId();
    }
    //Param : PageNo,PageBlock:15개


    @Transactional(rollbackFor =Exception.class, transactionManager = "jpaTransactionManager")
public Page<Memo> listMemo(PageDto pageDto){


        int pageNo = pageDto.getPageNo() != null ? pageDto.getPageNo() : 0;
        int amount = pageDto.getAmount() != null ? pageDto.getAmount() : 10;


Pageable pageable = PageRequest.of(pageNo,amount, Sort.by("id").descending());


        Page<Memo> page =  memoRepository.findAll(pageable);

        System.out.println("현재 페이지 번호: " +page.getNumber());
        System.out.println("한 페이지에 표시 할 건수: "+page.getSize());
        System.out.println("총 게시물 갯수: "+page.getTotalElements());
        System.out.println("총 페이지 갯수: "+page.getTotalPages());
        System.out.println("첫번째 페이지인지의 여부: "+ page.isFirst());
        System.out.println("다음 페이지가 있는지의 여부: "+page.hasNext());
        System.out.println("이전 페이지가 있는지의 여부: "+page.hasPrevious());
        return page;
}

}

