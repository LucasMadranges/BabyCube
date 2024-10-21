import {Field, InputType} from "@nestjs/graphql";

@InputType()
export class CreateUserInput {
    @Field()
    id: number;

    @Field()
    email: string;

    @Field()
    password: string;
}
