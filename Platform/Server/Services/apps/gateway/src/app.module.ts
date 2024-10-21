import {Module} from "@nestjs/common";
import {AppController} from "./app.controller";
import {AppService} from "./app.service";
import {GraphQLModule} from "@nestjs/graphql";
import {ApolloGatewayDriver, ApolloGatewayDriverConfig} from "@nestjs/apollo";
import {IntrospectAndCompose} from "@apollo/gateway";
import * as process from "node:process";

@Module({
    imports: [
        GraphQLModule.forRoot<ApolloGatewayDriverConfig>({
            driver: ApolloGatewayDriver,
            server: {
                csrfPrevention: true,
                debug: process.env.NODE_ENV === "dev",
                nodeEnv: process.env.NODE_ENV,
            },
            gateway: {
                supergraphSdl: new IntrospectAndCompose({
                    subgraphs: [
                        {
                            name: "users",
                            url: `http://babycube-users:${process.env.PORT_USERS}/graphql`,
                        }, {
                            name: "posts",
                            url: `http://babycube-posts:${process.env.PORT_POSTS}/graphql`,
                        },
                    ],
                }),
            },
        }),
    ],
    controllers: [AppController],
    providers: [AppService],
})
export class AppModule {
}
