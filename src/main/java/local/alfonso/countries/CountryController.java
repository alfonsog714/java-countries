package local.alfonso.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController {

    //    localhost:5000/names/all
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.countryList.countryList, HttpStatus.OK);
    }

    //    localhost:5000/names/start/{letter}
    @GetMapping(value = "/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountries(
            @PathVariable
                    char letter) {
        ArrayList<Country> rtnCnts = CountriesApplication.countryList.
                findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCnts, HttpStatus.OK);
    }
}
