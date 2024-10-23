import {NestFactory} from "@nestjs/core";
import {MinecraftModule} from "./minecraft.module";

async function bootstrap() {
    const app = await NestFactory.create(MinecraftModule);
    await app.listen(process.env.PORT_MINECRAFT);
}

bootstrap();
