pkg load image;
clc;

[filename, pathname] = uigetfile('Selecione a imagem');
[img] = imread(filename);

imgSobel = edge(img,'sobel');
imgCanny = edge(img,'canny',0.1);
imgRoberts = edge(img,'roberts',0.3);
imgPrewitt = edge(img,'prewitt');

imwrite(imgSobel,'ImagemSobe1.bmp');
imwrite(imgCanny,'ImagemCanny.bmp');
imwrite(imgRoberts,'ImagemRoberts.bmp');
imwrite(imgPrewitt,'Imagem prewiit.bmp');

figure(1),subplot(1,4,1), imshow(imgSobel);
figure(1),subplot(1,4,2), imshow(imgCanny);
figure(1),subplot(1,4,3), imshow(imgRoberts);
figure(1),subplot(1,4,4), imshow(imgPrewitt);
figure(1),subplot(1,4,4), imshow(img);

