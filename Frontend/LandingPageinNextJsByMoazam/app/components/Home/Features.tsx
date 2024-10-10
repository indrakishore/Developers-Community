import React from "react";
import Typography from "../../shared/Typography";
import Wrapper from "../../shared/Wrapper";
import FeatureCard from "../Cards/FeatureCard";
const features = [
  {
    heading: "Cleaning Workers",
    text: "Cleaning industry is extremely competitive and employees tend to be at the lower end of the pay scale. ",
  },
  {
    heading: "Cleaning Technique",
    text: " The scope of work may include all internal, general and routine cleaning - including floors, tiles, partition walls, internal walls, suspended ceilings",
  },
  {
    heading: "Cleaning Equipment",
    text: " Carpet cleaning though, even with regular vacuuming, needs hot water extraction applied every 18 to 24 months. External cleaning, litter picking, and removal of graffiti may also be incorporated. ",
  },
];

const Features = () => {
  return (
    <section>
      <Wrapper styles="md:px-16 ">
        <Typography.H2 styles="text-center text-great-black">
          Cleaning Services
        </Typography.H2>
        <div className="grid grid-cols-1 custom-md:grid-cols-2 xl:grid-cols-3 gap-x-[20px] gap-y-[30px] my-[30px]   ">
          {features.map((feature, index) => (
            <FeatureCard
              key={index}
              heading={feature.heading}
              text={feature.text}
              image={`/cleaning/clean${index + 1}.png`}
            />
          ))}
        </div>
      </Wrapper>
    </section>
  );
};

export default Features;
