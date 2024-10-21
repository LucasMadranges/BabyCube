import {CreateUserInput} from "./create-user.input";
import {Field, InputType, PartialType} from "@nestjs/graphql";

@InputType()
export class UpdateUserInput extends PartialType(CreateUserInput) {
    @Field()
    id: number;

    @Field()
    email: string;

    @Field()
    password: string;
}
