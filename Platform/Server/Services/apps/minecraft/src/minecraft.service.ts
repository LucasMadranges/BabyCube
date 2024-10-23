import {Injectable} from "@nestjs/common";

const Rcon = require("rcon");  // Utilisation de require pour importer le module

@Injectable()
export class MinecraftService {
    callRcon() {
        try {
            const rcon = new Rcon("babycube-minecraft", 50000, process.env.RCON_PASSWORD);

            rcon.on("auth", () => {
                console.log("Authenticated");
                rcon.send("list");  // Exemple de commande pour lister les joueurs connectés
            });

            rcon.on("response", (response) => {
                console.log("Server response:", response);
            });

            rcon.connect();  // Important de démarrer la connexion
            return "Rcon connected";
        } catch (error) {
            throw new Error(error.message);
        }
    }
}
