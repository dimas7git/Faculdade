pkg load image;
clc;

img1 = imread('lenaRGB.png');
imwrite(img1,'lenaRGB.jpg');

img2 = imread('lenaRGB.jpg');
semelhanca = corr2(img1,img2);

figure(1), subplot(1,2,1), imshow(img1);
figure(1), subplot(1,2,2), imshow(img2);
