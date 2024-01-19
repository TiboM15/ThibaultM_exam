package fr.MEGEMONT_Thibault.exam.controller;

import fr.MEGEMONT_Thibault.exam.entity.Listing;
import fr.MEGEMONT_Thibault.exam.mapping.UrlRoute;
import fr.MEGEMONT_Thibault.exam.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(name = "AppListing")
@AllArgsConstructor
public class ListingController {

    private ListingService listingService;


    @GetMapping(path = UrlRoute.URL_LISTING + "/{id}", name = "show")
    public ModelAndView show(
            @PathVariable Long id,
            ModelAndView mav) {
        Optional<Listing> listing = listingService.findById(id);
        mav.setViewName("listing/show");
        mav.addObject("allListing", listingService.findTop12ByOrderByCreatedAtDesc());
        return mav;
    }

//    @GetMapping(path = UrlRoute.URL_LISTING_SHOW + "/{id}", name = "show")
//    public ModelAndView show(
//            @PathVariable Long id,
//            ModelAndView mav
//    ) {
//        Optional<Listing> listing = listingService.findById(id);
//        mav.setViewName("listing/show");
//        mav.addObject("listing", listing);
//        return mav;
//    }
}
