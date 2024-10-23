import {Field, InputType, Int} from "@nestjs/graphql";

@InputType()
export class CreateMinecraftInput {
    @Field(() => Int, {description: "Example field (placeholder)"})
    exampleField: number;
}
