import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.String;
/**
 * Classe que constroi e gere as empresas da StarThrive
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
public class StarThrive implements Serializable {
    /**
     * ArrayList de empresas
     */
    public ArrayList<Empresa> empresas;
    /**
     * inicialização do objeto f da classe Ficheiros
     */
    Ficheiros f = new Ficheiros();

    /**
     * Construtor da Arraylist de Empresas
     */
    StarThrive() {
        this.empresas = new ArrayList<>();
    }

    /**
     * Método que carrega para a ArrayList a informação do ficheiro objeto ou do ficheiro txt se este nao existir
     */
    public void criaEmpresa(){
        this.empresas= f.gereLeituraFicheiros("starthrive.txt", "starthrive.dat", this);
    }

    /**
     * Método que escreve o ficheiro objeto
     */
    public void guardaEmpresa(){
        f.escreveFicheiroObj("starthrive.dat", this);

    }

    /**
     * Método que implementa uma tabela da lista de todas as empresas num JFrame
     */
    public void listaEmpresas(){
        String colun[]={"Nome","Distrito","Tipo de Empresa","Despesa anual","Receita anual","Lucro"};
        String data[][] = new String[empresas.size()][];
        int i=0;
        if(empresas.isEmpty()){
            JOptionPane.showMessageDialog(null, "A StarThrive nao tem empresas! ", "Lista de Empresas", JOptionPane.PLAIN_MESSAGE);
        }
        else {
            for (Empresa empresa : empresas) {
                data[i] = empresa.toString().split(", ");
                i++;
            }
            JFrame f = new JFrame();
            JTable jt = new JTable(data, colun);
            JScrollPane sp = new JScrollPane(jt);
            f.add(sp);
            f.setSize(500, 100);
            f.setVisible(true);
        }
    }

    /**
     * Método que atualiza o indice da empresa de cada tipo que apresentar a maior receita anual
     */
    void maiorReceitaAnual(){
        for (int i = 0; i < empresas.size() ; i++) {
            if (empresas.get(i).devolveIndiceReceita()==-1) {
                empresas.get(i).alteraIndiceReceita(i);
            }
            else{
                if(empresas.get(i).receitaAnual()>empresas.get(i-1).receitaAnual()) {
                    empresas.get(i).alteraIndiceReceita(i);
                }
            }

        }
    }
    /**
     * Método que atualiza o indice da empresa de cada tipo que apresentar o menor despesa anual
     */
    void menorDespesaAnual(){
        for (int i = 0; i < empresas.size() ; i++) {
            if (empresas.get(i).devolveIndiceDespesa()==-1) {
                empresas.get(i).alteraIndiceDespesa(i);
            }
            else{
                if(empresas.get(i).despesaAnual()<empresas.get(i-1).despesaAnual()) {
                    empresas.get(i).alteraIndiceDespesa(i);
                }
            }
        }
    }
    /**
     * Método que atualiza o indice da empresa de cada tipo que apresentar o maior lucro anual
     */
    void maiorLucroAnual(){
        for (int i = 0; i < empresas.size() ; i++) {
            if (empresas.get(i).devolveIndiceLucro()==-1) {
                empresas.get(i).alteraIndiceLucro(i);
            }
            else{
                if(empresas.get(i).retLucro()>empresas.get(i-1).retLucro()) {
                    empresas.get(i).alteraIndiceLucro(i);
                }
            }
        }
    }

    /**
     * metodo que cria e escreve numa interface gráfica as
     * Empresas com maior receita anual
     * Empresas com menor despesa anual
     * Empresas com maior lucro anual
     */
    void jframeCondicoes() {
        JFrame frame = new JFrame("Melhores Empresas");
        frame.setSize(400, 700);
        int y=50;

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelReceita = new JLabel("Empresas com maior receita anual:");
        labelReceita.setBounds(100, y, 300, 25);
        y+=25;
        panel.add(labelReceita);
        maiorReceitaAnual();
        for (int i = 0; i < empresas.size(); i++) {
            if (i == empresas.get(i).devolveIndiceReceita()) {
                JLabel label = new JLabel(empresas.get(i).imprimeReceita());
                label.setBounds(100, y, 300, 25);
                panel.add(label);
                y+=25;
            }
        }
        for (Empresa empresa : empresas) empresa.alteraIndiceReceita(-1);
        y+=25;
        JLabel labelDespesa = new JLabel("Empresas com menor despesa anual:");
        labelDespesa.setBounds(100, y, 300, 25);
        y+=25;
        panel.add(labelDespesa);
        menorDespesaAnual();
        for (int i = 0; i < empresas.size(); i++) {
            if (i == empresas.get(i).devolveIndiceDespesa()) {
                JLabel label = new JLabel(empresas.get(i).imprimeDespesa());
                label.setBounds(100, y, 300, 25);
                panel.add(label);
                y+=25;
            }
        }
        for (Empresa empresa : empresas) empresa.alteraIndiceDespesa(-1);
        y+=25;
        JLabel labelLucro = new JLabel("Empresas com maior lucro anual:");
        labelLucro.setBounds(100, y, 300, 25);
        y+=25;
        panel.add(labelLucro);
        maiorLucroAnual();
        for (int i = 0; i < empresas.size(); i++) {
            if (i == empresas.get(i).devolveIndiceLucro()) {
                JLabel label = new JLabel(empresas.get(i).imprimeLucro());
                label.setBounds(100, y, 300, 25);
                panel.add(label);
                y+=25;
            }
        }
        for (Empresa empresa : empresas) empresa.alteraIndiceLucro(-1);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Método que atualiza os indices das duas empresas com maior capacidade de Clientes por dia
     */
    void maiorCapacidadeClientes(){
        for (int i = 0; i < empresas.size() ; i++) {
            if(empresas.get(i).capacidadeClientesDia()!=0){
                if (empresas.get(i).devolveIndiceCapacidade1()==-1) {
                    empresas.get(i).alteraIndiceCapacidade1(i);
                }
                else{
                    if(empresas.get(i).devolveIndiceCapacidade2()==-1 & empresas.get(i).capacidadeClientesDia() >= empresas.get(i - 1).capacidadeClientesDia()){
                        empresas.get(i).alteraIndiceCapacidade2(i-1);
                    }
                    if(empresas.get(i).devolveIndiceCapacidade2()==-1 & empresas.get(i).capacidadeClientesDia() <= empresas.get(i - 1).capacidadeClientesDia()){
                        empresas.get(i).alteraIndiceCapacidade2(i);
                    }
                    if(empresas.get(i).capacidadeClientesDia()>empresas.get(empresas.get(i).devolveIndiceCapacidade1()).capacidadeClientesDia()) {
                        empresas.get(i).alteraIndiceCapacidade2(empresas.get(i).devolveIndiceCapacidade1());
                        empresas.get(i).alteraIndiceCapacidade1(i);

                    }
                    if(empresas.get(i).capacidadeClientesDia()<empresas.get(empresas.get(i).devolveIndiceCapacidade1()).capacidadeClientesDia() & empresas.get(i).capacidadeClientesDia()>empresas.get(empresas.get(i).devolveIndiceCapacidade2()).capacidadeClientesDia()){
                        empresas.get(i).alteraIndiceCapacidade2(i);
                    }
                }
            }
        }
    }

    /**
     * metodo que cria uma tabela numa nova interface gráfica com as duas empresas Restauração com maior capaciade de clientes
     */
    void jframeMaiorCapacidade() {
        maiorCapacidadeClientes();
        String string1 = new String();
        String string2 = new String();
        for (int j = 0; j < empresas.size(); j++) {

            if (j == empresas.get(j).devolveIndiceCapacidade1()) {
                string1 = empresas.get(j).toString();
            }

            if (j == empresas.get(j).devolveIndiceCapacidade2()) {
                string2 = empresas.get(j).toString();
            }
        }
        for (Empresa empresa : empresas) empresa.alteraIndiceCapacidade1(-1);
        for (Empresa empresa : empresas) empresa.alteraIndiceCapacidade2(-1);

        String colun[] = {"Nome", "Distrito", "Tipo de Empresa", "Despesa anual", "Receita anual", "Lucro"};
        String data[][] = new String[2][];
        data[0] = string1.split(", ");
        data[1] = string2.split(", ");

        JFrame f = new JFrame("Empresas do tipo Restauracao com maior capacidade de clientes por dia:");
        JTable jt = new JTable(data, colun);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(500, 100);
        f.setVisible(true);

    }

}
