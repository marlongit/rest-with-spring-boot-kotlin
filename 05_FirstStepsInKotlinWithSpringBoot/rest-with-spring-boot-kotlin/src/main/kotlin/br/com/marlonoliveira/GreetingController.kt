package br.com.marlonoliveira

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong();

    @RequestMapping("/greeting")
    fun greeting(): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello Kotlin");
    }

    @RequestMapping("/greetingWithParam")
    fun greetingWithParam(@RequestParam(value = "name", defaultValue ="Wolrd") name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello $name");
    }
}