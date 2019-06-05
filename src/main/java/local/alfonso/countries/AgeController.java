package local.alfonso.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/age")
public class AgeController {

//    localhost:5000/age/age/{age}

    @GetMapping(value = "/age/{number}", produces = {"application/json"})
    public ResponseEntity<?> getByAge(@PathVariable int number)
    {
        ArrayList<Country> rtnCnts = CountriesApplication.countryList.findCountries(c -> (c.getMedAge() >= number));

        rtnCnts.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCnts, HttpStatus.OK);
    }

//    localhost:5000/age/min

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> minAge()
    {
        Country minCntry = Collections.min(CountriesApplication.countryList.countryList, new CountryCompareAge());

        return new ResponseEntity<>(minCntry, HttpStatus.OK);
    }

    //    localhost:5000/age/max

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> maxAge()
    {
        Country maxCntry = Collections.max(CountriesApplication.countryList.countryList, new CountryCompareAge());

        return new ResponseEntity<>(maxCntry, HttpStatus.OK);
    }
}
