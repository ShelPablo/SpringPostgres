package com.shelpablo.springpostgres.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class MainController {

    @GetMapping("/build/{filename}")
    public void script(@PathVariable("filename") String fileName,
                       HttpServletResponse response) throws IOException {
        InputStream is = getClass().getResourceAsStream("/build/" + fileName + ".js");   //"\\s";
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }
}
