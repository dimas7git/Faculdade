pkg load image;
clc;

imgRGB = imread('fotoif.png');

imgR = imgRGB(:,:,1);
imgG =imgRGB(:,:,2);
imgB = imgRGB(:,:,3);

imgRGB1 = cat(3, imgR, imgG, imgB);

figure(1), subplot(2,2,1), imshow(imgRGB)
figure(1), subplot(2,2,2), imshow(imgR)
figure(1), subplot(2,2,3), imshow(imgG)
figure(1), subplot(2,2,4), imshow(imgB)

figure(2), title('Imagem RGB NOVA'), imshow(imgRGB1);

