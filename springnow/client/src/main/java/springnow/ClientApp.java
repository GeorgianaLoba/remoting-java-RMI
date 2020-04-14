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

//        CommonClientService clientController = context.getBean(CommonClientService.class);
//        CommonMovieService movieController = context.getBean(CommonMovieService.class);
//        CommonRentalService rentalController = context.getBean(CommonRentalService.class);
//
//
//        Console console = new Console(movieController, rentalController, clientController);
        Console console=context.getBean(Console.class);
        console.runConsole();
    }
}
