package Ex09;

import javax.swing.JOptionPane;

public class FuncionarioVIEW {

    public static void main(String args[]) {

        try {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
           funcionarioDTO.setTel(Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone do funcionario")));
            funcionarioDTO.setCod(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do funcionario ")));
            JOptionPane.showMessageDialog(null, funcionarioCTR.mostrarCodTel(funcionarioDTO));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no sistema: " + e.getMessage());
        }
    }
}
