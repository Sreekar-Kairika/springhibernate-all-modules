package com;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.event.RecordApplicationEvents;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    //controller to show initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //controller to process HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // new controller method to read form data
    //add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsAddData(HttpServletRequest request, Model model){

        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        // convert data to all caps
        theName = theName.toUpperCase();
        //create the message
        String res = "Yoo!!" + theName;
        // add message to model
        model.addAttribute("message",res);
        //name , value
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String letsAddDataA(@RequestParam("studentName")String theName, Model model){

        //read the request parameter from the HTML form

        // convert data to all caps
        theName = theName.toUpperCase();
        //create the message
        String res = "Heyy from V3!!" + theName;
        // add message to model
        model.addAttribute("message",res);
        //name , value
        return "helloworld";
    }
}
