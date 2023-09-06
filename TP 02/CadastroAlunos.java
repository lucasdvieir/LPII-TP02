import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CadastroAlunos extends JFrame implements ActionListener {
    private JTextField nomeField, idadeField, enderecoField;
    private List<Aluno> alunos;

    public CadastroAlunos() {
        alunos = new ArrayList<>();

        setTitle("Cadastro de Alunos");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        panel.add(idadeField);

        panel.add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        panel.add(enderecoField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));

        JButton okButton = new JButton("OK");
        okButton.addActionListener(this);
        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(this);
        JButton mostrarButton = new JButton("Mostrar");
        mostrarButton.addActionListener(this);
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(this);

        buttonPanel.add(okButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(mostrarButton);
        buttonPanel.add(sairButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("OK")) {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String endereco = enderecoField.getText();

            Aluno aluno = new Aluno(nome, idade, endereco);
            alunos.add(aluno);

            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        } else if (actionCommand.equals("Limpar")) {
            nomeField.setText("");
            idadeField.setText("");
            enderecoField.setText("");
        } else if (actionCommand.equals("Mostrar")) {
            StringBuilder mensagem = new StringBuilder("Lista de Alunos:\n");

            for (Aluno aluno : alunos) {
                mensagem.append(aluno.toString()).append("\n");
            }

            JOptionPane.showMessageDialog(this, mensagem.toString());
        } else if (actionCommand.equals("Sair")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAlunos cadastro = new CadastroAlunos();
            cadastro.setVisible(true);
        });
    }
}
