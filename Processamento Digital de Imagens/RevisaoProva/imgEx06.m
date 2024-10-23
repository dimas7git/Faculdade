pkg load image;
clc;

img = imread('Informacao.bmp');
[M,N] = size(img);


for i = 1:M
    for j = 1:N
        mensagemExtraida(i,j) = bitget(img(i,j), 1);
    end
end


imshow(mensagemExtraida);





