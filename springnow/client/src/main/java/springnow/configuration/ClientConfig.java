package springnow.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import springnow.service.CommonClientService;
import springnow.service.CommonMovieService;
import springnow.service.CommonRentalService;

@Configuration
public class ClientConfig {


    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBeanClient() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(CommonClientService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/ClientService");
        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBeanMovie() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(CommonMovieService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/MovieService");
        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBeanRental() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(CommonRentalService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/RentalService");
        return rmiProxyFactoryBean;
    }

}
