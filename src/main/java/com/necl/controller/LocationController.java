package com.necl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.necl.model.ReportLocation;
import com.necl.service.ReportLocationService;

@Controller
public class LocationController {
	
	@Autowired 
	ReportLocationService reportLocationService;
	
	 @RequestMapping(value = "/location", method = RequestMethod.GET)
	 public String reportLocation(ModelMap modelMap) throws Exception {
		 	List<ReportLocation> reportLocationList = reportLocationService.findAll();
		 	modelMap.addAttribute("reportLocationList", reportLocationList);
			return "admin/location";
	    }
	 
	 @RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
	 @ResponseBody 
	 public void saveLocation(ModelMap modelMap, HttpServletResponse response,
				HttpServletRequest request,
				@RequestParam(value = "locationId") String locationId,
				@RequestParam(value = "locationDescription") String locationDescription) {
		 
		
		 try {
			
			ReportLocation reportLocation = new ReportLocation();
			reportLocation.setLocationId(locationId);
			reportLocation.setLocationDescription(locationDescription);
			reportLocationService.save(reportLocation);
			System.out.println("Success To save Report Location");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    }
	 
}
