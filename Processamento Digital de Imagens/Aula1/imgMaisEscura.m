pkg load image;
clc;

img = imread('Lena512.bmp');

imgQuad = img;

for i = 1:512
    for j = 1:512
        #imgQuad(i,j)= imgQuad(i,j) + 100;
        imgQuad(i,j)= imgQuad(i,j) - 50;
    end
end

figure(1), imshow(img);
figure(2), imshow(imgQuad);

