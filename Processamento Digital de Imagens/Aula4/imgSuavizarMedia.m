pkg load image;
clc;

img = imread('cameraman128.bmp');
img = imnoise(img, 'salt & pepper');
[M,N] = size(img);
c = double(img);

for i = 2:M-1
    for j = 2:N-1
        filtroc = [
            c(i-1,j-1), c(i-1,j), c(i-1,j+1),
            c(i,j-1),   c(i,j),   c(i,j+1),
            c(i+1,j-1), c(i+1,j), c(i+1,j+1)
        ];
        vetco = sort(filtroc);
        c(i,j) = vetco(5);
    endfor
endfor

c = uint8(c);
figure(1), subplot(1,2,1), imshow(img);
figure(1), subplot(1,2,2), imshow(c);

