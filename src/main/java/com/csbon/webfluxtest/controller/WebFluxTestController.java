package com.csbon.webfluxtest.controller;

//import com.csbon.webfluxtest.MyRepository;
import com.csbon.webfluxtest.MyRepository;
import com.csbon.webfluxtest.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WebFluxTestController {
    private final Logger logger = LoggerFactory.getLogger(WebFluxTestController.class);

    private final MyRepository myRepository;
    private final MovieService movieService;

/*
    @RequestMapping("/")
    public String indexMainView(final Model model) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(myRepository.findFixAll(), 1);
        model.addAttribute("movies", reactiveDataDrivenMode);

        return "index";
    }
*/
    @ModelAttribute
    @GetMapping("/mydata")
    public void getMyData(Model model) {
        model.addAttribute("data", myRepository.findFixFirst());
    }

    @ModelAttribute
    @GetMapping("/mydatas")
    public void getMyDatas(Model model) {
        model.addAttribute("dataList", myRepository.findFixAllbyMono());
    }

    @ModelAttribute
    @GetMapping("/mytest")
    public void getMyTest(@ModelAttribute("name") String name, Model model) {
        logger.info(name);
        model.addAttribute("name", "CSBON");
    }


}
