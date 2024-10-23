import {CreateMinecraftInput} from "./create-minecraft.input";
import {Field, InputType, Int, PartialType} from "@nestjs/graphql";

@InputType()
export class UpdateMinecraftInput extends PartialType(CreateMinecraftInput) {
    @Field(() => Int)
    id: number;
}
