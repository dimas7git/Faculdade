pkg load image;
clc;

img = imread('Lena512.bmp');

imgQuad = img;

for i = 1:35
    for j = 1:55
        imgQuad(i,j)=0;
    end
end

figure(1), imshow(img);
figure(2), imshow(imgQuad);

