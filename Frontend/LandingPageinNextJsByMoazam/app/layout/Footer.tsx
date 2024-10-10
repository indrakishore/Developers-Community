import React from "react";
import Wrapper from "../shared/Wrapper";
import Image from "next/image";
import Typography from "../shared/Typography";
import Link from "next/link";

const links = [
  {
    title: "Home",
    path: "#home",
  },
  {
    title: "Services",
    path: "#services",
  },
  {
    title: "Offerings",
    path: "#offerings",
  },
  {
    title: "Contact",
    path: "#contact",
  },
];
const Footer = () => {
  return (
    <footer className="bg-teal">
      <Wrapper>
        {/* TOP */}
        <div className="flex flex-col xs:flex-row gap-y-[20px]  justify-between py-[50px]">
          {/* LEFT */}
          <div className="flex flex-col gap-[20px]">
            <Image src="/logo.jpg" alt="logo" width={100} height={50} />
            <p className="text-[13px] text-white font-normal leading:[15px] sm:leading-[19.5px] w-[55%]">
              We are a leading company based in Qatar, recognized for our
              expertise in civil works, building construction, and maintenance
              services.
            </p>
          </div>
          {/*  RIGHT */}
          <div className="flex gap-[30px] flex-col xs:flex-row gap-y-[30px]   xs:ml-auto my-[10px] xs:my-0">
            <div className="flex gap-[20px] flex-col">
              <Typography.H3 styles="text-off-white font-normal pb-[10px]">
                Quick Links
              </Typography.H3>
              <ul className="flex flex-col gap-[20px]">
                {links.map((link, index) => (
                  <Typography.PSmall
                    styles="text-off-white font-normal"
                    key={index}
                  >
                    <Link href={link.path}>{link.title}</Link>
                  </Typography.PSmall>
                ))}
              </ul>
            </div>
            <div className="flex gap-[20px] flex-col">
              <Typography.H3 styles="text-off-white font-normal pb-[10px]">
                Our Address
              </Typography.H3>
              <ul className="flex flex-col gap-[20px]">
                <Typography.PLarge styles="text-off-white font-normal md:w-[80%]">
                  Mob.: +974 31399058-30492554
                </Typography.PLarge>
                <Typography.PLarge styles="text-off-white font-normal md:w-[80%]">
                  Address: P.O Box No 14326.building no .35.st no.901. zone.38
                  al saad doha.qatar.
                </Typography.PLarge>
                <Typography.PLarge styles="text-off-white font-normal md:w-[80%]">
                  Email: companythcc@gmail.com
                </Typography.PLarge>
              </ul>
            </div>
          </div>
        </div>
        {/*  BOTTOM */}
      </Wrapper>
    </footer>
  );
};

export default Footer;
