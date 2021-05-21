package com.example.airbnb.controller;


import com.example.airbnb.dto.AccommodationListDTO;
import com.example.airbnb.service.AccommodationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airbnb")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }



    @GetMapping
    public AccommodationListDTO getSample() {
        return AccommodationService.availableAccommodationsList();
    }


    /*
    @GetMapping
    public String getSample(){
        //System.out.println(accommodationService.countAccommodation());
        //System.out.println(accommodationService.findById(1L).getTitle());
        //System.out.println(accommodationService.findAll());
        //System.out.println(accommodationService.insert("샘플숙소3"));
        System.out.println(accommodationService.delete("샘플숙소3"));
        return "dd";
    }

     */

}
