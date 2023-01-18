package exercise;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {

    @GetMapping(path = "/")
    public String getWelcomeToSpring() {
        return "Welcome to Spring";
    }

    @GetMapping(path = "/hello")
    public String getHelloName(@RequestParam(required = false) String name) {
        if (StringUtils.hasText(name)) {
            return "Hello, " + name + "!";
        }
        return "Hello, World!";
    }
}
// END
