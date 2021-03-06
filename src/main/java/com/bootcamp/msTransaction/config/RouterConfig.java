package com.bootcamp.msTransaction.config;

import com.bootcamp.msTransaction.Handler.TransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(TransactionHandler transactionHandler){

        return route(GET("/api/transaction"), transactionHandler::findAll)
                .andRoute(GET("/api/transaction/{identityNumber}"), transactionHandler::findTransactionsByIdentityNumber)
                .andRoute(POST("/api/transaction"), transactionHandler::newTransaction);
    }
}
