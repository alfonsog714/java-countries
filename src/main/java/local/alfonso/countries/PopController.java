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
@RequestMapping("/population")
public class PopController {

//    localhost:5000/population/size/{people}

    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> checkPop(@PathVariable int number)
    {
        ArrayList<Country> rtnCnts = CountriesApplication.countryList.findCountries(e -> (e.getPopulation() >= number));

        return new ResponseEntity<>(rtnCnts, HttpStatus.OK);
    }

    //    localhost:5000/population/min

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> minPop()
    {
        Country minCntry = Collections.min(CountriesApplication.countryList.countryList, new CountryComparePop());

        return new ResponseEntity<>(minCntry, HttpStatus.OK);
    }

    //    localhost:5000/population/max

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> maxPop()
    {
        Country maxCntry = Collections.max(CountriesApplication.countryList.countryList, new CountryComparePop());

        return new ResponseEntity<>(maxCntry, HttpStatus.OK);
    }
}
