export {};

declare global {
  interface Window {
    minecraft: {
      launch: () => Promise<void>;
    };
  }
}
