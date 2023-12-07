package me.minkh.core.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.minkh.core.common.MyLogger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    public String logDemo(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestUrl(requestUrl);

        myLogger.log("Controller Test");
        logDemoService.logic("testId");
        return "OK";
    }
}
