package anhnd.ph30384.asm2;

import anhnd.ph30384.asm2.controller.IndexCtrl;
import anhnd.ph30384.asm2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Asm2Application  {

    public static void main(String[] args) {
        SpringApplication.run(Asm2Application.class, args);
        System.out.println("If you see this, be happy");
        IndexCtrl.showHomepage();
    }

}
