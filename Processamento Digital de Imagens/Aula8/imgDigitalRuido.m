pkg load image;
clc;

img = imread('imgDigitalRuido.png');
img = rgb2gray(img);
imgBW = im2bw(img);
SE = ones(3,3);
imgErode = imerode(img, SE);
imgAbertura = imdilate(imgErode, SE);

imgDilateFinal = imdilate(imgAbertura, SE);
imgFinal = imerode(imgDilateFinal, SE);

subplot(2,3,1), imshow(img), title ('Imagem Original');
subplot(2,3,2),imshow(imgErode), title ('Imagem Erosão');
subplot(2,3,3),imshow(imgDilateFinal), title ('Imagem Abertura');
subplot(2,3,4),imshow(imgFinal), title ('Imagem final');

