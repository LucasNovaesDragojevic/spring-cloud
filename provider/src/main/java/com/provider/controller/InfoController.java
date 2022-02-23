package com.provider.controller;

import com.provider.model.InfoProvider;
import com.provider.service.InfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InfoController 
{
    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @GetMapping("{state}")
    InfoProvider getProviderByState(@PathVariable String state)
    {
        LOG.info("Received request to providers in state {}", state);
        return infoService.getInfoByState(state);
    }
}
