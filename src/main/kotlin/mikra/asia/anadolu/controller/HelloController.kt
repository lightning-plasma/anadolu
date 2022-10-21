package mikra.asia.anadolu.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @GetMapping("")
    fun hello(): String = "hello"
}