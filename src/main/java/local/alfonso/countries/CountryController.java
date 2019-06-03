package local.alfonso.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CountryController {

//    localhost:5000/data/countries
    @GetMapping(value = "/countries", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList, HttpStatus.OK);
    }
}
