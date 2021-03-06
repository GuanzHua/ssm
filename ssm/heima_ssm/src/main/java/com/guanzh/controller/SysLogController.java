package com.guanzh.controller;


import com.guanzh.domain.SysLog;
import com.guanzh.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<SysLog> sysLogList = sysLogService.findAll();
        model.addAttribute("sysLogs",sysLogList);
        return "syslog-list";
    }
}
