package org.zj.actions.longin;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping(value = "/login")
public class Login {

    static  Logger log = Logger.getLogger(Login.class.getName());

    @RequestMapping(value = "/dologin")
    public String dologin(Locale locale) {
        log.info(locale.getDisplayCountry());
        return "admin/index";
    }
}
