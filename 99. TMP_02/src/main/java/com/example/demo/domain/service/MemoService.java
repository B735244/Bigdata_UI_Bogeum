package com.example.demo.domain.service;

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.entity.Memo;
import com.example.demo.domain.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface MemoService {

    Long addMemoTx(MemoDto dto) throws Exception;



}








