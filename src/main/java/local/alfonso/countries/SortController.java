package local.alfonso.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class SortController {

//    localhost:5000/population/size/{people}

    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> checkPop(@PathVariable int number)
    {
        ArrayList<Country> rtnCnts = CountriesApplication.countryList.findCountries(e -> (e.getPopulation() >= number));

        return new ResponseEntity<>(rtnCnts, HttpStatus.OK);
    }
}
