package com.agussuhardi.i18n;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.agussuhardi.i18n.config.i18n.translate;


/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :20.15
 * @project i18n
 */

@RestController
@RequestMapping("welcome")
public class SampleController {


    @GetMapping
    public String guest() {
        return translate("welcome.guest");
    }

    @GetMapping("{name}")
    public String get(@PathVariable String name) {
        return translate("welcome", name);
    }

}
