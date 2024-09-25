pkg load image;
clc;

imgRGB = imread('fotoif.png');
imgR = imgRGB(:,:,1);
imgG =imgRGB(:,:,2);
imgB = imgRGB(:,:,3);
imgRGB1 = cat(3, imgR, imgG, imgB);
imgRMaisClara= imgR + 100;
imgGMaisClara= imgG + 100;
imgBMaisClara= imgB + 100;
imgRGB2 = cat(3, imgRMaisClara, imgGMaisClara, imgBMaisClara);

imgRGB3 = cat(3, imgR, imgGMaisClara, imgB);
imgRGB4 = cat(3, imgR, imgG,imgBMaisClara );
imgRGB5 = cat(3, imgRMaisClara, imgG, imgB);

figure(1), subplot(4,4,1), imshow(imgRGB), title('Imagem Original')
figure(1), subplot(4,4,2), imshow(imgR), title('Imagem R')
figure(1), subplot(4,4,3), imshow(imgG), title('Imagem G')
figure(1), subplot(4,4,4), imshow(imgB), title('Imagem B')
figure(1), subplot(4,4,5), imshow(imgRMaisClara), title('Imagem R mais clara')
figure(1), subplot(4,4,6), imshow(imgGMaisClara), title('Imagem G mais clara')
figure(1), subplot(4,4,7), imshow(imgBMaisClara), title('Imagem B mais clara')
figure(1), subplot(4,4,8), imshow(imgRGB2), title('Imagem RGB nova')
figure(1), subplot(4,4,9), imshow(imgRGB3), title('Imagem R 2')
figure(1), subplot(4,4,10), imshow(imgRGB4), title('Imagem G 3')
figure(1), subplot(4,4,11), imshow(imgRGB5), title('Imagem B 4')



