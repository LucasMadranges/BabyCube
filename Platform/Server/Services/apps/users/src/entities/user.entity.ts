import {Field, ID, ObjectType} from "@nestjs/graphql";

@ObjectType()
export class User {
    @Field(() => ID)
    id: number;

    @Field()
    email: string;

    @Field()
    password: string;
}
