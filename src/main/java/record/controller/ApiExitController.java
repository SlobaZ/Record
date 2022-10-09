package record.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping()
public class ApiExitController {
	
	@GetMapping(value={"/exit"})
    public String iskljuci(){
        System.exit(0);
        return null;
    }

}
