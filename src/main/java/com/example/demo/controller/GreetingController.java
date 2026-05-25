package com.example.demo.controller;

import com.example.demo.chat.Greeting;
import com.example.demo.chat.HelloMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        Thread.sleep(1000);

        return new Greeting(
            HtmlUtils.htmlEscape(message.getName())
            + " : "
            + HtmlUtils.htmlEscape(message.getMessage())
        );
    }
}