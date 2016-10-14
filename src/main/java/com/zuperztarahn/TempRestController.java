package com.zuperztarahn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ahn on 2016. 10. 15..
 */
@RestController
public class TempRestController {

    @Value("${enviroment}")
    private String env;

    @GetMapping
    public String index() {
        return env;
    }
}
