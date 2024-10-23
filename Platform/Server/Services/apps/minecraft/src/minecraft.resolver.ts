import {Query, Resolver} from "@nestjs/graphql";
import {MinecraftService} from "./minecraft.service";
import {Minecraft} from "./entities/minecraft.entity";

@Resolver(() => Minecraft)
export class MinecraftResolver {
    constructor(private readonly minecraftService: MinecraftService) {
    }

    @Query(() => String)
    callRcon() {
        return this.minecraftService.callRcon();
    }
}
