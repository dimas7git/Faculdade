pkg load image;
clc;

img = imread('Lena512.bmp');

for i = 1:512
    for j = 1:512
      if img(i,j) >= 125;
        imgBin(i,j) = 255;
      else
        imgBin(i,j) = 0;
      end
    end
end

figure(1), imshow(imgBin);
