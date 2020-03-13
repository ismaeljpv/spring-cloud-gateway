package edu.urbe.springcloudgateway.config;

import edu.urbe.springcloudgateway.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Ismael Peña
 */
@Component
public class GlobalFilterConfiguration implements GlobalFilter {
    
    final Logger logger = LoggerFactory.getLogger(GlobalFilterConfiguration.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();
        if(path.contains("/actuator")){
            logger.info("Actuator Request Filtered");
            throw new NotFoundException("Not Found");
        }
        return chain.filter(exchange);
    } 
}