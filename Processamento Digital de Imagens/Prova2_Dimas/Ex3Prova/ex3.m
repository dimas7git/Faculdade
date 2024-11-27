pkg load image;
clc;

img = imread('Lena512MSG.bmp');
[M,N] = size(img);


for i = 1:M
    for j = 1:N
        mensagemExtraida(i,j) = bitget(img(i,j), 1);
    end
end


figure(1), subplot(2,1,1),imshow(mensagemExtraida), title('mensagem');
figure(1), subplot(2,1,2),imshow(img), title('imagem original');






