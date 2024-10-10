import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        "light-black": "#111414",
        "great-black": "#0E0E0E",
        teal: "#008080",
        "teal-hover": "#005050",
        "off-white": "#FAF9F6",
        coral: "#FF7F50",
        gray: "rgba(156, 163, 175, 1)",
      },
      screens: {
        "custom-md": "910px",
        xs: "570px",
      },
    },
  },
  plugins: [],
};
export default config;
