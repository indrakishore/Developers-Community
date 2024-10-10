import React from "react";
import Wrapper from "../../shared/Wrapper";
import Image from "next/image";
import Typography from "../../shared/Typography";
import { ButtonPrimary } from "../../shared/Buttons";

const Contact = () => {
  return (
    <section
      className=" xs:mt-[70px] md:mt-[110px] mb-[30px] xs:mb-[200px]"
      id="contact"
    >
      <Wrapper>
        <div className="flex  relative">
          <div className="hidden md:block md:basis-[10%] bg-white "></div>
          <div className="relative flex-1  w-full h-[650px] ">
            <Image
              src="/contact-img.png"
              alt="contact"
              className="w-full h-full object-cover absolute"
              sizes="(max-width:760px) 100vw, 900px"
              fill
              priority
            />
          </div>
          <div className=" hidden md:block  bg-teal w-[500px] max-w-[590px] md:h-[300px]  z-[10] absolute  md:-bottom-[130px] md:left-[20px] px-[30px] py-[35px]  ">
            <div className="flex gap-[15px] flex-col">
              <Typography.PSmall styles="text-off-white">
                Exclusive Insights | Hidden Strategies | Behind-the-scenes
                Stories
              </Typography.PSmall>
              <h2 className="text-[30px] sm:text-[40px] text-off-white font-medium">
                You Have Questions? We Have Answers
              </h2>
              <ButtonPrimary styles="bg-white text-teal w-[50%]">
                Call Us 0097431399058
              </ButtonPrimary>
            </div>
          </div>
        </div>
      </Wrapper>
      <div className="flex  md:hidden xs:relative px-4 md:max-w-[90%] mx-auto xs:mx-0">
        <div className="   bg-teal  max-w-[590px]   max-h-[max-content]  z-[10] xs:absolute xs:-translate-y-[100px] xs:left-[80px] px-[30px] py-[35px]  ">
          <div className="flex gap-[15px] flex-col">
            <Typography.PSmall styles="text-off-white">
              Exclusive Insights | Hidden Strategies | Behind-the-scenes Stories
            </Typography.PSmall>
            <h2 className="text-[30px] sm:text-[40px] text-off-white font-medium">
              You Have Questions? We Have Answers
            </h2>
            <ButtonPrimary styles="bg-white text-teal sm:w-[50%]">
              Call Us 0097431399058
            </ButtonPrimary>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Contact;
