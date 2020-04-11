package springnow;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rpc.service.CommonClientService;
import rpc.service.CommonMovieService;
import rpc.service.CommonRentalService;
import springnow.ui.Console;

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "springnow.configuration"
                );

        CommonClientService clientController = context.getBean(CommonClientService.class);
        CommonMovieService movieController = context.getBean(CommonMovieService.class);
        CommonRentalService rentalController = context.getBean(CommonRentalService.class);


        Console console = new Console(movieController, rentalController, clientController);
        console.runConsole();
    }
}
