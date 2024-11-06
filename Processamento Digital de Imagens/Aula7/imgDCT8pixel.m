clear all;
clc;
pkg load image;
pkg load signal;

img = rand(8,8);
img = img * 255;
img = uint8(img);

imgDct = dct2(img);
imgIdct = idct2(imgDct);
imgIdct = uint8(imgIdct);
imgDct1 = uint8(imgDct);



figure(1), subplot(2,2,1), imshow(img), title('Original');
figure(1), subplot(2,2,2), imshow(imgDct),title('DCT');
figure(1), subplot(2,2,3), imshow(imgDct1),title('DCT UINT8');
figure(1), subplot(2,2,4), imshow(imgIdct), title('Original de Volta');
