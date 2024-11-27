pkg load image;
clc;

img1 = imread('lenaRGB.jpg');

[M, N] = size(img1);

imgR = img1(:,:,1);
imgG = img1(:,:,2);
imgB = img1(:,:,3);


for i = 1:225
    for j = 1:225
        imgR(i,j) = bitset(imgR(i,j), 1);
        imgG(i,j) = bitset(imgG(i,j), 1);
        imgB(i,j) = bitset(imgB(i,j), 1);
    end
end

figure(1),subplot(1,4,1), imshow(imgR), title('imagem banda R');
figure(1),subplot(1,4,2), imshow(imgG), title('imagem banda G');
figure(1),subplot(1,4,3), imshow(imgB), title('imagem banda B');
figure(1),subplot(1,4,4), imshow(img1), title('imagem original');



