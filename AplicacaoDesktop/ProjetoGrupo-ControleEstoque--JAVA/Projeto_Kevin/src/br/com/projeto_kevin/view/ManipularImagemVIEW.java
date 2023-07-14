/*
 * The MIT License
 *
 * Copyright 2022 Kevin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.projeto_kevin.view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Classe responsável por manipular as imagens inseridas.
 *
 * @author Kevin
 * @version 1.0
 */
public class ManipularImagemVIEW {
    /**
     * Método resposável por manipular e redimensionar a imagem.
     * 
     * @param filename, vindo da classe ProdutoVIEW.
     * @param imgLargura, vindo da classe ProdutoVIEW.
     * @param imgAltura, vindo da classe ProdutoVIEW.
     * @return novaImagem do tipo BufferedImage.
     */
    public static BufferedImage setImagemDimensao(String filename, Integer imgLargura, Integer imgAltura) {
        Double novaImgLargura = null;
        Double novaImgAltura = null;
        Double imgProporcao = null;
        Graphics2D g2d = null;
        BufferedImage imagem = null, novaImagem = null;
        
        try {
            imagem = ImageIO.read(new File(filename));
        }// Fecha try. 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ManipularImagemVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }// Fecha catch.
        
        novaImgLargura = Double.valueOf(imagem.getWidth());
        novaImgAltura = Double.valueOf(imagem.getHeight());
        
        if (novaImgLargura.doubleValue() >= imgLargura.intValue()) {
            imgProporcao = Double.valueOf(novaImgAltura.doubleValue() / novaImgLargura.doubleValue());
            novaImgLargura = Double.valueOf(imgLargura.intValue());
            novaImgAltura = Double.valueOf(novaImgLargura.doubleValue() * imgProporcao.doubleValue());
            
            while (novaImgAltura.doubleValue() > imgAltura.intValue()) {
                novaImgLargura = Double.valueOf((imgLargura = Integer.valueOf(imgLargura.intValue() - 1)).intValue());
                novaImgAltura = Double.valueOf(novaImgLargura.doubleValue() * imgProporcao.doubleValue());
            } 
        } else if (novaImgAltura.doubleValue() >= imgAltura.intValue()) {
            imgProporcao = Double.valueOf(novaImgLargura.doubleValue() / novaImgAltura.doubleValue());
            novaImgAltura = Double.valueOf(imgAltura.intValue());
            
            while (novaImgLargura.doubleValue() > imgLargura.intValue()) {
                novaImgAltura = Double.valueOf((imgAltura = Integer.valueOf(imgAltura.intValue() - 1)).intValue());
                novaImgLargura = Double.valueOf(novaImgAltura.doubleValue() * imgProporcao.doubleValue());
            } 
        } 
        novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), 1);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);
        return novaImagem;
    }// Fecha o método setImagemDimensao.
    
    /**
     * Método responsável por vetorizar a imagem.
     * 
     * @param image, vindo da classe ProdutoVIEW.
     * @return um vetor do tipo byte[].
     */
    public static byte[] getImgBytes(BufferedImage image) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
      ImageIO.write(image, "JPEG", baos);
    } catch (IOException iOException) {}
    InputStream is = new ByteArrayInputStream(baos.toByteArray());
    return baos.toByteArray();
  }// Fecha método getImgBytes.
  
  /**
   * Método responsável por mostrar a imagem.
   * 
   * @param minhaimagem
   * @param label 
   */  
  public static void exibeImagemLabel(byte[] minhaimagem, JLabel label) {
    if (minhaimagem != null) {
      InputStream input = new ByteArrayInputStream(minhaimagem);
      try {
        BufferedImage imagem = ImageIO.read(input);
        label.setIcon(new ImageIcon(imagem));
      } catch (IOException iOException) {}
    } else {
      label.setIcon(null);
    } 
  }//Fecha o método exibeImagemLabel.
}// Fecha classe ManipularImagemVIEW.
