package com.example.demo.Controller;

import com.example.demo.Dto.PersonDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/param")
public class ParameterController {
    @RequestMapping(value = "/p01", method = RequestMethod.GET)
    public void paramHandler_1(@RequestParam(name = "username", required = false) String name) {
        log.info("GET /param/p01...." + name);
    }


    @GetMapping("/p02")
    public void paramHandler_2(@RequestParam(name = "username", required = true) String name) {
        log.info("GET /param/p02...." + name);
    }

    @PostMapping("/p03")
    public void paramHandler_3(@RequestParam(name = "username", required = true) String name) {
        log.info("POST /param/p03...." + name);
    }

    //@RequestParam :  동기요청 파라미터 처리/ html form,js form기반으로 전달되는 파라미터(json type은 못받음)
//    @RequestBody : 비동기요청 파라미터 처리/ json,file data 등 전달되는 파라미터 처리(html form도 처리가능)
    @PostMapping("/p04")
    public void paramHandler_4(@RequestBody String name) {
        log.info("POST /param/p04...." + name);
    }

    @PostMapping("/p05")
    public void paramHandler_5(@RequestParam(name = "username", required = false, defaultValue = "손보금") String name) {
        log.info("POST /param/p05...." + name);
    }

    @GetMapping("/p06")
    public void paramHandler_6(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String addr
    ) {
        log.info("GET /param/p06...." + name + " " + age + " " + addr);
    }

    //@ModelAttribute
    @GetMapping("/p07")
    public void paramHandler_7(@ModelAttribute PersonDto dto)//@ModelAttribute를 생략해도 동일함
    {

        log.info("GET /param/p07...." + dto);
    }


    //@PathVariable
    @GetMapping("/p08/{name}/{age}/{addr}")
    public void paramHandler_8(
            @PathVariable(value = "name") String username,
            @PathVariable int age,
            @PathVariable String addr
    ) {
        log.info("GET /param/p08...." + username + " " + age + " " + addr);
    }


    //@PathVariable
    @GetMapping("/p09/{name}/{age}/{addr}")
    public void paramHandler_9(PersonDto dto) {
        log.info("GET /param/p09...." + dto);
    }

    @GetMapping("/page1")
    public void page1(PersonDto dto, Model model) {
        //1. 파라미터 받기
        //2. 유효성 검즘
        //3. 서비스 실앻
        //4. 뷰로 이동 / Model을 이용하여 뷰로 전달한다.
        log.info("GET /param/page1...." + dto);
        model.addAttribute("dto", dto);
        model.addAttribute("isLogin", true);


    }

    @GetMapping("/page2/{name}/{age}/{addr}")
    public ModelAndView page2(PersonDto dto) {
        log.info("GET /param/page2..." + dto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dto", dto);
        modelAndView.setViewName("param/page2");
        return modelAndView;

    }

    @GetMapping("/page3")
    public void page3_handler(HttpServletRequest request, HttpServletResponse response) {
        //int형은 binder가 pasing해주지 않음
        //String으로 받으려하니 문제가 생김
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String addr = request.getParameter("addr");
        log.info("GET /param/page3..." + name + " " + age + " " + addr);

        PersonDto dto = new PersonDto(name, age, addr);

        //기본적으로 request는 유지해서 forwarding 방식을 제공하고 있다.
        request.setAttribute("dto", dto);


        //Model안쓰고 Session에다가 넣을 것임
//       HttpSession session= request.getSession();
//       session.setAttribute("dto",dto);
        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);

    }

    @GetMapping("/page4")
    public void page4_handler(@RequestParam Map<String, Object> params) {
        log.info("GET /parma/page4" + params);
    }
    //----------
    //Forwarding
    //----------
    @GetMapping("/forward/init")
    public String forward_init_handler(Model model){

        log.info("GET /param/forward/init...");
        model.addAttribute("init","init_value");
        return "forward:/param/forward/step1";
    }

    @GetMapping("/forward/step1")
    public String forward_step1_handler(Model model){
        log.info("GET /param/forward/step1...");
        model.addAttribute("step1","step1_value");
        return "forward:/param/forward/step2";

    }

    @GetMapping("/forward/step2")
    public void forward_step2_handler(Model model){
        log.info("GET /param/forward/step2...");
        model.addAttribute("step2","step2_value");

    }

    //------------
    //Redirect
    //------------
    //redirect한 경로로 새로 요청이 생겨서 URL을 보면 forward랑 다르다.
    //그 전에 있던 내용은 초기화 됨.
    @GetMapping("/redirect/init")
    public String redirect_init_handler(Model model, RedirectAttributes redirectAttributes){

        log.info("GET /param/redirect/init...");
        model.addAttribute("init","init_value");
        redirectAttributes.addAttribute("redirect_init","redirect_init_value");//Query String
        redirectAttributes.addFlashAttribute("redirect_init2","redirect_init2_value");//Session에 속성 추가
        return "redirect:/param/redirect/step1";


    }

    @GetMapping("/redirect/step1")
    public void redirect_step1_handler(Model model,@RequestParam String redirect_init){
        model.addAttribute("step1","step1_value");
        log.info("GET /param/redirect/step1..."+redirect_init);



    }

    @GetMapping("/redirect/step2")
    public void redirect_step2_handler(Model model){
        log.info("GET /param/redirect/step2...");


    }



//    @RequestMapping("")
//    public void paramHandler_1(){
//        log.info("");
//    }

}
