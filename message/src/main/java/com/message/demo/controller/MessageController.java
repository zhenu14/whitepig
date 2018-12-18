package com.message.demo.controller;

import com.message.demo.util.ChinaMobileMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    @Autowired
    ChinaMobileMessage chinaMobileMessage;

    @RequestMapping("/send")
    public String send(){
        try{
            String phone = "13502433942";

            String message = "hello?";

            String s = chinaMobileMessage.sendMassage(phone, message);

            log.info("message ==>{}" , s);

            return "success";
        }catch (Exception e){
            log.error("error :" ,e);
            return "fail";
        }

    }

}
