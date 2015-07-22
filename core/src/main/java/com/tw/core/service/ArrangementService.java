package com.tw.core.service;

import com.tw.core.dao.ArrangementDao;
import com.tw.core.entity.Arrangement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangementService {

    @Autowired
    ArrangementDao arrangementDao;

    public List<Arrangement> getAllArrangement() {

        return arrangementDao.getAllArrangement();
    }
}
