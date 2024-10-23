import {Injectable} from "@nestjs/common";

const Rcon = require("rcon");  // Utilisation de require pour importer le module

@Injectable()
export class MinecraftService {
    callRcon() {
        try {
            /*            const rcon = new Rcon("localhost", 50000, "/=a-59p-2K£N69okEtX;cg5FsZ'K^bwQWUXH3P<f=D(/(#4&!:");
            
                        rcon.on("auth", () => {
                            console.log(rcon.send("list"));
                            rcon.send("list");  // Exemple de commande pour lister les joueurs connectés
                        });*/

            return "Rcon connected";
        } catch (error) {
            throw new Error(error);
        }
    }
}
