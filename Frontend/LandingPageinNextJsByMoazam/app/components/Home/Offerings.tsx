import React from "react";
import Typography from "../../shared/Typography";
import Image from "next/image";
import Wrapper from "../../shared/Wrapper";

const offerings = [
  {
    text: "Interior Work",
    image: "/thcc/int1.png",
  },
  {
    text: "Interior Work",
    image: "/thcc/int2.png",
  },
  {
    text: "Villas Construction",
    image: "/thcc/villa.png",
  },
  {
    text: "Villas Construction ",
    image: "/thcc/villa2.png",
  },
  {
    text: "Warehouse Construction",
    image: "/thcc/warehouse1.png",
  },
  {
    text: "Warehouse Construction",
    image: "/thcc/warehouse2.png",
  },
  {
    text: "Roofing",
    image: "/thcc/roof1.png",
  },
  {
    text: "Roofing",
    image: "/thcc/roof2.png",
  },
];

const Offerings = () => {
  return (
    <section className="bg-teal" id="offerings">
      <Wrapper styles="md:px-16 py-[60px] md:py-[80px]">
        {/*  TOP  */}
        <div className="flex  justify-between flex-col sm:flex-row gap-[15px] sm:gap-0">
          <div className="flex flex-col gap-[10px] basis-1/2">
            <div className=" py-[10px] px-[20px] bg-[rgba(250,249,246,.15)] rounded-[5px] max-w-max">
              <Typography.PSmall styles="text-off-white font-medium">
                Value-Added Offerings
              </Typography.PSmall>
            </div>
            <Typography.H2 styles="text-off-white sm:w-[70%]">
              TRADE HOME, CONTRACTING AND HOSPITALITY
            </Typography.H2>
          </div>
          <div className="basis-1/2">
            <Typography.PSmall styles="text-off-white  leading-[28px]">
              In addition to our core construction services, we boast a team of
              IT professionals ready to meet all your technological needs. With
              a proven track record on both international and prominent local
              projects, TRADE HOME is continuously expanding our range of
              services beyond construction to include comprehensive supply
              solutions.
            </Typography.PSmall>
          </div>
        </div>
        {/*  BOTTOM PICS */}
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4  mt-[40px] gap-x-[20px] gap-y-[25px]">
          {offerings.map((offer, index) => (
            <div className="flex flex-col items-center gap-[10px] " key={index}>
              <div className=" flex justify-center items-center">
                <div className=" w-[300px] h-[250px] max-w-full relative">
                  <Image
                    src={offer.image}
                    alt="icon"
                    fill
                    className="w-full h-full object-fill absolute"
                  />
                </div>
              </div>
              <Typography.PLarge styles="text-off-white">
                {offer.text}
              </Typography.PLarge>
            </div>
          ))}
        </div>
      </Wrapper>
    </section>
  );
};

export default Offerings;
