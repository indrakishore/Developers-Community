import React from "react";
import Wrapper from "../../shared/Wrapper";
import Typography from "../../shared/Typography";
import { ButtonPrimary } from "../../shared/Buttons";
import Image from "next/image";
import Link from "next/link";

const Services = () => {
  return (
    <section className="my-[40px] xs:my-[100px] " id="services">
      <Wrapper styles="md:px-16">
        <div className=" grid grid-cols-1 lg:grid-cols-2 gap-[30px] custom-md:gap-[30px]     ">
          {/* LEFT SIDE */}
          <div className="w-full h-full flex flex-col gap-[20px] basis-1/2">
            <div className="rounded-[5px] coral-bg px-[20px] py-[10px] max-w-max ">
              <p className="text-coral font-medium text-[14px] sm:text-[16px]  ">
                Our Core Services
              </p>
            </div>
            <div className="flex flex-col gap-[15px] sm:gap-[22px]">
              <Typography.H2>
                Welcome to TRADE HOME Contracting and Hospitality
              </Typography.H2>
              <Typography.PLarge styles="text-great-black font-normal leading-[25px] sm:leading-[28px] md:leading-[32px] text-[#0E0E0E]">
                We are a leading company based in Qatar, recognized for our
                expertise in civil works, building construction, and maintenance
                services. Our specialties extend to prefabrication, steel
                cladding, sandblasting and painting, landscaping, and logistics
                support.
              </Typography.PLarge>

              <Link href="#offerings">
                <ButtonPrimary styles="bg-teal text-off-white hover:bg-teal-hover sm:w-[50%] mt-[10px]">
                  View Offerings
                </ButtonPrimary>
              </Link>
            </div>
          </div>
          {/*   RIGHT SIDE */}
          <div className="mx-auto w-full h-[250px] sm:h-[380px] lg:h-full basis-1/2 relative">
            {/* <iframe
              width="100%"
              height="100%"
              src="https://www.youtube.com/embed/Csn5JgsaAEg?si=59L2dGDFAjsyzkg8"
              title="YouTube video player"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
              allowFullScreen
            ></iframe> */}
            <Image
              src={"/pic1.jpg"}
              alt="hero"
              fill
              className="w-full h-full object-fill absolute"
            />
          </div>
        </div>
      </Wrapper>
    </section>
  );
};

export default Services;
