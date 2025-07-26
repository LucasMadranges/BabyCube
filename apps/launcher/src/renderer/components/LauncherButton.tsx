export default function LauncherButton() {
    const launch = async () => {
        try {
            await window.minecraft.launch();
            console.log("Minecraft lancé !");
        } catch (err) {
            console.error("Erreur de lancement :", err);
        }
    };

    return (
        <button onClick={launch}>
            Lancer Minecraft (serveur localhost)
        </button>
    );
}