package fr.MEGEMONT_Thibault.exam.controller;
import fr.MEGEMONT_Thibault.exam.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomeController {

    private ListingService listingService;


    @GetMapping(name = "index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("allListing", listingService.findAll());
        return mav;
    }
}
