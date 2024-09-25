pkg load image;
clc;

a = imread('lena128.bmp');
b = imread('cameraman128.bmp');
c = cat(1, a,b);


figure(1),imshow(c);
imwrite(c,'lenacameram.bmp');

