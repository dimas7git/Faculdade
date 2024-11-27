pkg load image;
clc;

img = imread('Lena512.bmp');

imgSobel = edge(img,'sobel');
imgRoberts = edge(img,'roberts');
imgPrewitt = edge(img,'prewitt');


figure(1),subplot(1,4,1), imshow(imgSobel), title('borda sobel');
figure(1),subplot(1,4,2), imshow(imgRoberts), title('borda roberts');
figure(1),subplot(1,4,3), imshow(imgPrewitt), title('borda prewitt');
figure(1),subplot(1,4,4), imshow(img), title('imagem original');


