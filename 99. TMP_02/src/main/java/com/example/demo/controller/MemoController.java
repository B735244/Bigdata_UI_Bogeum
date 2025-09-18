package com.example.demo.controller;

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.service.MemoService;
import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.service.MemoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
    //MemoService와 연결해줍니다.
    @Autowired MemoService memoService;

    @GetMapping("/add")
    public void add_memo_get() throws Exception
    {//Get요청을 확인하고 memo/add.jsp로 찾아갑니다.
        log.info("GET /memo/add...");
    }
    //입력받은 데이터를 저장하는 요청처리를 합니다.
    @PostMapping("/add")
    //입력받은 데이터를 바인딩 및 유효성 검증을 함.
    //유효성 검증 결과 저장
    // Model을 사용하여 값을 저장하고 jsp로 보내줌.
    //리다이렉트를 하면 메시지 띄움.
    public String add_memo_post(
            @Valid MemoDto dto,
            BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) throws Exception
    {
        //요청한 파라미터 로그 출력함.
        log.info("POST /memo/add..." + dto);
        //유효성 검사 결과 출력
        log.info("유효성 오류 발생여부 : " + bindingResult.hasErrors());
        //만약에 오류가 있다면
        //모든 필드를 돌면서 로그 출력하고
        if(bindingResult.hasErrors()){
            for(FieldError error  : bindingResult.getFieldErrors()){
                log.info("Error Field : "+error.getField()+" Error Message : "+error.getDefaultMessage());
                //Model에 에러를 저장해 줌.
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }
// 다시 메모  add할 수 있도록 돌아감.
            return "memo/add";
        }

        //서비스 요청 -> Domain.Common.Service

        //add.MemoTx(dto)에서 넘어온 id값(primary key)를 받아서 isertedId에 초기화
        Long insertedId = memoService.addMemoTx(dto);
        //저장에 성공해서(Not null) 넘어오면 FlashAttribute에 메세지를 담아서
        if(insertedId!=null)
            redirectAttributes.addFlashAttribute("message","메모등록 완료 ID : " + insertedId );
        //뷰로 이동하고
        //만약 저장 실패(IsNull)라면 다시 메모작성을 하도록 add페이지를 띄어줌.
        return insertedId!=null ? "redirect:/":"memo/add";
    }

}
