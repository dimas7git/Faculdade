pkg load image;
clc;

imgMaior = imread('Lena512.bmp');
imgMenor = imread('if30.bmp');


[M, N] = size(imgMenor);

imgNova = imgMaior;


for i = 1:M
  for j = 1:N
    imgNova(end - M + i, end - N + j) = imgMenor(i, j);
  end
end


figure(1),imshow(imgNova);

imwrite(imgNova, 'lenaif.bmp');

