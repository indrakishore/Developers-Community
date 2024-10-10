import React from "react";
import Wrapper from "../../shared/Wrapper";
import Image from "next/image";
import Typography from "../../shared/Typography";
import { ButtonPrimary } from "../../shared/Buttons";

const Hero = () => {
  return (
    <section className="mb-[30px]  xs:mb-[350px]  md:mb-[30px]" id="home">
      <Wrapper>
        <div className="flex relative">
          <div className="hidden md:block md:basis-[30%] bg-white "></div>
          <div className="relative flex-1 max-w-[950px] w-full h-[430px] md:h-[650px]">
            <Image
              src={"/hero.jpg"}
              alt="hero"
              className="w-full h-full object-fill absolute"
              fill
              priority
            />
          </div>
          {/*  TEAL COLOR BOX  */}
          <div className=" hidden md:block  bg-teal w-[570px] max-w-[590px] md:h-[530px] md:min-h-[400px] z-[10] absolute  md:top-[50px] md:left-0 px-[48px] py-[68px]  ">
            <div className="flex gap-[10px] flex-col">
              <div className="  py-[10px] px-[15px] bg-[rgba(250,249,246,.15)] rounded-[5px] max-w-max">
                <Typography.PSmall styles="text-off-white">
                  Leading Expertise in Construction and Technology Solutions
                </Typography.PSmall>
              </div>
              <Typography.H1 styles="text-off-white">
                Building Excellence, Delivering Results
              </Typography.H1>

              <Typography.PLarge styles="text-off-white">
                We are a leading company based in Qatar, recognized for our
                expertise in civil works, building construction, and maintenance
                services.
              </Typography.PLarge>
              <div className="flex gap-[20px] my-[10px]">
                <ButtonPrimary styles="bg-white text-teal">
                  Call Us 0097431399058
                </ButtonPrimary>
              </div>
            </div>
          </div>
        </div>
        {/*   TEAL BOX RESPONSIVE FOR MOBILE */}
      </Wrapper>
      <div className="flex  md:hidden xs:relative px-4  md:max-w-[90%] mx-auto xs:mx-0">
        <div className="   bg-teal  max-w-[590px]   max-h-[max-content]  z-[10] xs:absolute xs:-translate-y-[100px] xs:left-[80px] px-[30px] py-[35px]  ">
          <div className="flex gap-[10px] flex-col">
            <div className=" p-[10px] bg-[rgba(250,249,246,.15)] rounded-[5px] sm:w-[90%] ">
              <Typography.PSmall styles="text-off-white">
                Exceptional Management for Growth-Focused Investors 
              </Typography.PSmall>
            </div>
            <Typography.H1 styles="text-off-white">
              Transforming Properties, Maximizing Returns
            </Typography.H1>

            <Typography.PLarge styles="text-off-white">
              Learn more about our strategies to enhance Property Value and
              Market Appeal
            </Typography.PLarge>
            <div className="flex gap-[20px] my-[10px]">
              <ButtonPrimary styles="bg-white text-teal">
                Call Us 0097431399058
              </ButtonPrimary>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Hero;
