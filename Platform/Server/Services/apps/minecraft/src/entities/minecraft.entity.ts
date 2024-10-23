import {Field, ObjectType} from "@nestjs/graphql";

@ObjectType()
export class Minecraft {
    @Field()
    response: string;
}
