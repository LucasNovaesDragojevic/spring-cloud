package com.provider.service;

import com.provider.model.InfoProvider;
import com.provider.repository.InfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InfoService 
{
    @Autowired
    private InfoRepository infoRepository;

    public InfoProvider getInfoByState(String state) 
    {
        return infoRepository.findByState(state)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found provider in this state: " + state));
    }
    
}
