import type { Metadata } from "next";

import "./globals.css";

export const metadata: Metadata = {
  title: "THCC  (Trade Home for Contracting and Cleaning Services)",
  description:
    "THCC a leading company based in Qatar, recognized for our expertise in civil works, building construction, and maintenance services.",
  openGraph: {
    title: "THCC  (Trade Home for Contracting and Cleaning Services)",
    description:
      "THCC a leading company based in Qatar, recognized for our expertise in civil works, building construction, and maintenance services.",
    images: [{ url: "/logo.jpg" }],
  },
  twitter: {
    card: "summary_large_image",
    title: "THCC  (Trade Home for Contracting and Cleaning Services)",
    description:
      "THCC a leading company based in Qatar, recognized for our expertise in civil works, building construction, and maintenance services.",
    images: [{ url: "/logo.jpg" }],
    creator: "@SyedMoazamALi19",
  },
  icons: "/favicon.ico",
  metadataBase: new URL("https://thcc.vercel.app"),
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
