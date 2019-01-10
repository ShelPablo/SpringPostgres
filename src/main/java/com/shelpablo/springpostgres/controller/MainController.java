package com.shelpablo.springpostgres.controller;

import com.shelpablo.springpostgres.services.WeatherService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

//@Grab("thymeleaf-spring4")
@Controller
public class MainController {
    @Autowired
    private WeatherService service;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/js/{filename}")
    public void script(@PathVariable("filename") String fileName,
            HttpServletResponse response) throws IOException {
        InputStream is = getClass().getResourceAsStream("/js/"+fileName+".js");   //"\\s";
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }

  /*  @RequestMapping(value = "/files/{fileID}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("fileID") String fileName,
            HttpServletResponse response) throws IOException {
        String src= "\\("\\"+fileName);
        InputStream is = new FileInputStream(src);
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }
*/

//    @GetMapping
//    public List<Weather> index(){
//        return services.getCurrentWeather();
//    }
}
