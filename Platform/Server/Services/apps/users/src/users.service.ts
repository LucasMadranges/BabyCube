import {Injectable} from "@nestjs/common";

@Injectable()
export class UsersService {
    getHello(): string {
        return "Users API started on 4001!";
    }
}
