package org.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.bean.Country;
import org.example.bean.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@RequestMapping(value = "/countries")
	public List<Country> getCountries() {

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();
		return listOfCountries;
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Map<Integer, String>> getCountryById(/*
																 * @PathVariable
																 * int id,
																 * HttpRequest
																 * request
																 */) {
		/*
		 * List<Country> listOfCountries = new ArrayList<Country>();
		 * listOfCountries=createCountryList();
		 * 
		 * for (Country country: listOfCountries) { if(country.getId()==id)
		 * return new ResponseEntity(listOfCountries,HttpStatus.OK); }
		 */
		String first = "Pramod";
		String last = "Gautam";
		Map<Integer, String> list = new HashMap<Integer, String>();
		list.put(1, first);
		list.put(2, last);
		System.out.println("Hello");
		return new ResponseEntity<Map<Integer, String>>(list, HttpStatus.OK);

	}

	// Utiliy method to create country list.
	public List<Country> createCountryList() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);
		return listOfCountries;
	}

	@RequestMapping(value = "/countryPost", method = RequestMethod.POST/*
																		 * ,
																		 * headers
																		 * =
																		 * "Accept=application/json"
																		 */)
	public ResponseEntity<List<String>> postMethod(@RequestBody(required = false) Employee employee) {

		List<String> list = new ArrayList<String>();
		list.add(employee.getName());
		list.add(employee.getEmale());

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
