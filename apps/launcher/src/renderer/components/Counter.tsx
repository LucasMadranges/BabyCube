import {useState} from "react";
import {motion, AnimatePresence} from "framer-motion";

export default function Counter() {
    const [count, setCount] = useState(0);
    const [key, setKey] = useState(0); // pour forcer le changement de composant animé

    const increment = () => {
        setCount((prev) => prev + 1);
        setKey((prev) => prev + 1);
    };

    return (
        <div style={{textAlign: "center", marginTop: "2rem", overflowX: "hidden"}}>
            <h2>Compteur :</h2>
            <AnimatePresence mode="wait">
                <motion.div
                    key={key}
                    initial={{scale: 0.8, opacity: 0}}
                    animate={{scale: 1, opacity: 1}}
                    exit={{scale: 1.2, opacity: 0}}
                    transition={{duration: 0.2}}
                    style={{fontSize: "2rem", marginBottom: "1rem", position: "relative"}}
                >
                    {count}
                </motion.div>
            </AnimatePresence>
            <button onClick={increment}>Incrémenter</button>
        </div>
    );
}
