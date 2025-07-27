import Counter from './components/Counter';
import LauncherButton from './components/LauncherButton';

export default function App() {
  return (
    <div style={{ fontFamily: 'sans-serif', textAlign: 'center', padding: '2rem' }}>
      <h1>🚀 Launcher React + Electron</h1>
      <p>Bienvenue dans ton app React embarquée dans Electron !</p>
      <Counter />
      <p>------------------------</p>
      <LauncherButton />
    </div>
  );
}
