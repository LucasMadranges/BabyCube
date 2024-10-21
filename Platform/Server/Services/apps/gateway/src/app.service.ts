import {Injectable} from "@nestjs/common";

@Injectable()
export class AppService {
    getHello(): string {
        return "Gateway API started on 4000!";
    }
}
