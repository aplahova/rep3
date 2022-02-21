package ru.learnup.vtb.spring.opera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.spring.opera.services.OperaService;

@SpringBootApplication
public class OperaApplication {

    public static void main(String[] args) {

        //  SpringApplication.run(OperaApplication.class, args);
        final ConfigurableApplicationContext ctx = SpringApplication.run(OperaApplication.class, args);
        ctx.getBean(OperaApplication.class);
        ctx.getBean(OperaService.class).addOpera("Петя и волк", "С.Прокофьев", "для детей с 6 лет", 100);
        ctx.getBean(OperaService.class).addOpera("Риголетто", "Дж.Верди", "16+", 200);
        ctx.getBean(OperaService.class).addOpera("Севильский цирюльник", "Дж.Россини", "12+", 300);
        ctx.getBean(OperaService.class).printOperaList();

        //System.out.println(" ");
        System.out.println("Изменения в программе:");

        ctx.getBean(OperaService.class).changeOpera("Риголетто", "Травиата", "Дж.Верди", "16+", 3);
        ctx.getBean(OperaService.class).deleteOpera("Севильский цирюльник");

        ctx.getBean(OperaService.class).printOperaList();

        System.out.println(" ");
        System.out.println("Билеты");

        for (int i = 0; i < 3; i++) {
            ctx.getBean(OperaService.class).buyOperaTicket("Травиата");
        }
        for (int i = 0; i < 3; i++) {
            ctx.getBean(OperaService.class).returnOperaTicket("Травиата");
        }

    }

}
