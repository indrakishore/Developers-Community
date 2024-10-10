import React, { ReactNode } from "react";

interface TypographyProps {
  children: ReactNode;
  styles?: string;
}

export const Heading1: React.FC<TypographyProps> = ({
  children,
  styles = "text-light-black",
}) => {
  return (
    <h1
      className={`font-normal text-[30px] sm:text-[46px] leading-[40px] sm:leading-[64.4px]  ${styles}`}
    >
      {children}
    </h1>
  );
};
export const Heading2: React.FC<TypographyProps> = ({
  children,
  styles = "text-light-black",
}) => {
  return (
    <h2
      className={`font-normal text-[25px] sm:text-[32px] leading-[30px] sm:leading-[44.8px]  ${styles}`}
    >
      {children}
    </h2>
  );
};
export const Heading3: React.FC<TypographyProps> = ({
  children,
  styles = "text-light-black font-semibold",
}) => {
  return (
    <h3
      className={` text-[20px] sm:text-[24px] leading-[25px] sm:leading-[33.6px]  ${styles}`}
    >
      {children}
    </h3>
  );
};
export const PLarge: React.FC<TypographyProps> = ({
  children,
  styles = "text-light-black font-medium",
}) => {
  return (
    <p className={` text-[14px] sm:text-[16px] leading-[22.4px]  ${styles}`}>
      {children}
    </p>
  );
};

export const PSmall: React.FC<TypographyProps> = ({
  children,
  styles = "text-light-black font-normal",
}) => {
  return (
    <p className={` text-[12px] sm:text-[14px] leading-[17px]  ${styles}`}>
      {children}
    </p>
  );
};

const Typography = {
  H1: Heading1,
  H2: Heading2,
  H3: Heading3,
  PLarge,
  PSmall,
};

export default Typography;
