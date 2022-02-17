package io.promova.killer.mathmaid;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MathMaidApplication
{

    public static void main(String[] args) throws JsonProcessingException
    {
        SpringApplication.run(MathMaidApplication.class, args);
    }

}
