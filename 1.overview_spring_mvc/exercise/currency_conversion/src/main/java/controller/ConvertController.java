package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    @PostMapping(value = "/convert")
    public ModelAndView convert(@RequestParam String usd, String exchangeRate ) {
        try{
            int result = Integer.parseInt(usd)*Integer.parseInt(exchangeRate);
            return new ModelAndView("index","result",result);
        }catch (NumberFormatException e){
            return new ModelAndView("index","exception","Mời nhập chữ số");
        }
    }

    @RequestMapping(value = "")
    public String home(){
        return "index";
    }
}
