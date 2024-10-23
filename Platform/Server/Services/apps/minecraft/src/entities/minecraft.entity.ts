import {Field, Int, ObjectType} from "@nestjs/graphql";

@ObjectType()
export class Minecraft {
    @Field(() => Int, {description: "Example field (placeholder)"})
    exampleField: number;
}
