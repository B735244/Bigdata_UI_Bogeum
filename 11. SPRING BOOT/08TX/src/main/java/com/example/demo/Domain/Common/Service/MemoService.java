package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dto.MemoDto;
import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//Service 페이지는 개발자가 보기 편하게 변수나 함수명을 선언하는게 좋다.
//요청하는거 그때 그때 받아가지고 넘기고 추가하고 등등 그래서 Service부분이 가장 구현하기 힘들다.
//ctrl+shift+T 누르면 test파일이 자동으로 만들어집니다. test파일안에 들어가서 구현하고 돌려보기.
@Service
public class MemoService {
//    @Autowired
//    private MemoDao memoDao;
//

//    public boolean memoRegistration(MemoDto dto) throws SQLException {
//        int result = memoDao.insert(dto);
//        return result >0;

    @Autowired
    private MemoRepository memoRepository;

    public Long memoRegistration2(MemoDto dto) throws Exception {
        // dto ->Entity
        Memo memo = Memo.builder().id(null)
                .text(dto.getText())
                .writer(dto.getWriter())
                .createAt(LocalDateTime.now())
                .build();

        memoRepository.save(memo);
        return memo.getId();
    }

}




