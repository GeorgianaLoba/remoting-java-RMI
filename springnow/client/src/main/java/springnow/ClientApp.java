package springnow;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springnow.service.CommonClientService;
import springnow.service.CommonMovieService;
import springnow.service.CommonRentalService;
import springnow.ui.Console;

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "springnow.configuration"
                );

        Console console=context.getBean(Console.class);
        console.runConsole();
    }
}
