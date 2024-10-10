interface ButtonProps {
  children: React.ReactNode;
  styles?: string;
}
export const ButtonPrimary: React.FC<ButtonProps> = ({
  children,
  styles = "bg-teal hover:bg-[#005050] text-off-white",
}) => {
  return (
    <button
      className={`px-[10px] py-[8px]  md:px-[30px] md:py-[12px] rounded-[2px]   text-[12px] sm:text-[14px] ${styles}`}
    >
      {children}
    </button>
  );
};
