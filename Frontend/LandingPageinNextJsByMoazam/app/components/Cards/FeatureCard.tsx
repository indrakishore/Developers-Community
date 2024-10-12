import React from "react";
import PropTypes from "prop-types";
import Image from "next/image";
import Typography from "../../shared/Typography";
interface FeatureCardProps {
  image: string;
  text: string;
  heading: string;
}

const FeatureCard: React.FC<FeatureCardProps> = ({ image, text, heading }) => {
  return (
    <div className="flex flex-col gap-[20px] items-center md:items-start">
      <div className="relative w-full  h-[300px]  xl:w-full  custom-md:h-[280px] custom-md:max-w-[450px] ">
        {" "}
        <Image
          src={image}
          alt={heading}
          fill
          priority
          className="w-full h-full object-cover rounded-[5px]"
        />
      </div>
      <Typography.H3 styles="justify-self-start self-start font-bold">
        {heading}
      </Typography.H3>
      <Typography.PSmall styles="text-gray">{text}</Typography.PSmall>
    </div>
  );
};

FeatureCard.propTypes = {
  image: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
  heading: PropTypes.string.isRequired,
};

export default FeatureCard;
