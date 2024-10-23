import {Module} from "@nestjs/common";
import {MinecraftService} from "./minecraft.service";
import {MinecraftResolver} from "./minecraft.resolver";
import {GraphQLModule} from "@nestjs/graphql";
import {ApolloFederationDriver, ApolloFederationDriverConfig} from "@nestjs/apollo";

@Module({
    imports: [
        GraphQLModule.forRoot<ApolloFederationDriverConfig>({
            driver: ApolloFederationDriver,
            autoSchemaFile: {
                federation: 2,
            },
        }),
    ],
    providers: [MinecraftResolver, MinecraftService],
})
export class MinecraftModule {
}
