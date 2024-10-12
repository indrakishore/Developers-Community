import Navbar from "./layout/Navbar";
import Contact from "./components/Home/Contact";

import Hero from "./components/Home/Hero";
import Offerings from "./components/Home/Offerings";
import Services from "./components/Home/Services";

import Footer from "./layout/Footer";
import React from "react";
import Features from "./components/Home/Features";

export default function Home() {
  return (
    <React.Fragment>
      <Navbar />
      <Hero />
      <Services />
      <Features />
      <Offerings />
      <Contact />
      <Footer />
    </React.Fragment>
  );
}
