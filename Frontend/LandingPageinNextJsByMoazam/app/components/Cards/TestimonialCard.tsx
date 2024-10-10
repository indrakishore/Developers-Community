import React from "react";
import PropTypes from "prop-types";
import Image from "next/image";
import Typography from "../../shared/Typography";
interface TestimonialCardProps {
  text: string;
  image: string;
  name: string;
  location: string;
}
const TestimonialCard: React.FC<TestimonialCardProps> = ({
  text,
  image,
  name,
  location,
}) => {
  return (
    <div className="flex flex-col gap-[20px] px-[30px] py-[40px] testimonial-box-bg ">
      <div className="flex justify-between ">
        <Image src="/google.svg" alt="google " width={150} height={75} />
        <Image
          src={"/inverted-commas.svg"}
          alt="Commas"
          width={95}
          height={80}
        />
      </div>
      <div>
        <Typography.PLarge styles="text-teal pl-[15px] border-l-[4px] border-solid border-teal font-normal">
          {text}
        </Typography.PLarge>
      </div>
      <div className="flex gap-[10px] items-center">
        <Image src={image} alt={name} width={50} height={50} />
        <div className="flex flex-col gap-[10px]">
          <Typography.PLarge>{name}</Typography.PLarge>
          <p className="text-[12px] text-teal font-medium">{location}</p>
        </div>
      </div>
    </div>
  );
};

TestimonialCard.propTypes = {
  text: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  location: PropTypes.string.isRequired,
};

export default TestimonialCard;
