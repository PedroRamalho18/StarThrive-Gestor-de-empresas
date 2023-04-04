import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
/**
 * Classe Janela reproduz a interface gráfica (JFrame) da empresa StarThrive
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
public class Janela {
    /**
     * verifica se a empresa já foi guardada ou ainda não
     */
    private int verificaGuardar;
    /**
     * lista adaptada a JList
     */
    JList list;
    /**
     * inicializa parametro de classe starThrive
     */
    StarThrive starThrive = new StarThrive();

    /**
     * verifica se uma string têm apenas números ou contêm números e caracteres
     * @param str string a verificar
     * @return retorna true se contiver apenas numeros, false caso contrario
     */
    private static boolean isNumeric(String str) {
        return str.matches("[0-9.]+");
    }

    /**
     * Cria o menu da StarThrive
     */
    public void input() {
        verificaGuardar = 0;

        starThrive.criaEmpresa();

        JFrame frame = new JFrame();
        frame.setTitle("Bem vindo à StarThrive");
        frame.setSize(400, 300);

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Criar Empresa");
        lista.add("Listar Empresas");
        lista.add("Editar Empresa");
        lista.add("Melhores Empresas");
        lista.add("Empresas Restauração com maior capacidade de clientes por dia");
        lista.add("Apagar Empresas");
        Vector palavras = new Vector(lista);
        list = new JList(palavras);
        list.setBounds(50, 35, 300, 150);

        JButton buttonSeleciona = new JButton("Selecionar");
        buttonSeleciona.addActionListener(new buttonSeleciona());
        buttonSeleciona.setBounds(50, 200, 120, 25);

        JButton buttonGuarda = new JButton("Guardar");
        buttonGuarda.addActionListener(new buttonGuarda());
        buttonGuarda.setBounds(200, 200, 120, 25);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(50, 35, 300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(buttonSeleciona);
        panel.add(listScroller);
        panel.add(buttonGuarda);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if(verificaGuardar==1) {
                    if (JOptionPane.showConfirmDialog(frame, "As empresas não foram guardadas, deja sair sem guardar?", "Não guardou!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) System.exit(0);
                    else frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Metodo que cria varias mini janelas de modo a criar ou editar uma empresa
     * @param str array de strings que contem as frazes para direcionar o utilizador a escrever na caixa texto o determinado parametro
     * @param obj obejeto que guarda todos os dados implementados pelo utilizado nas caixas texto
     */
    public void caixaTexto(String[] str, Object[] obj) {
        int i = 0;
        while (i < str.length) {
            String[] valores = {"Mini", "Super", "Hiper" };
            if (str[i].compareTo("o tipo de mercado") == 0)
                obj[i] = JOptionPane.showInputDialog(null, "Escolha o tipo de mercado", "Criar Empresa", JOptionPane.PLAIN_MESSAGE, null, valores, valores[0]);
            else {
                obj[i] = JOptionPane.showInputDialog(null, "Introduza " + str[i], "Criar Empresa", JOptionPane.PLAIN_MESSAGE);
                if ((obj[i] == null) || (obj[i].equals(""))) {
                    JOptionPane.showMessageDialog(null, "Insira algum tipo de caracter", "Cria Empresa", JOptionPane.ERROR_MESSAGE);
                    i--;
                } else {
                    if (i >= 3) {
                        if (!isNumeric((String) obj[i])) {
                            JOptionPane.showMessageDialog(null, "Insira apenas numeros!", "Cria Empresa", JOptionPane.ERROR_MESSAGE);
                            i--;
                        }
                    }
                }
            }
            i++;
        }
    }

    /**
     * Class que contem a leitura do butão sleciona
     */
    private class buttonSeleciona implements ActionListener {
        /**
         * Ações que o botão realiza ao ser pressionado
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object str = list.getSelectedValue();
            verificaGuardar = 1;
            String[][] palavras = {{"nome", "distrito", "loacalização GPS(x,y)", "numero de empregados", "salario médio anual","numero médio de clientes diários", "numero médio de cafés por dia", "valor médio de faturação anual por café vendido por dia" },
                    {"nome", "distrito", "loacalização GPS(x,y)", "numero de empregados", "salario médio anual","numero médio de clientes diários", "numero médio de bolos por dia", "valor médio de faturação anual por bolo vendido por dia" },
                    {"nome", "distrito", "loacalização GPS(x,y)", "numero de empregados", "salario médio anual", "numero médio de clientes diários", "numero de dias em funcionamento por ano", "numero de mesas no interior", "valor médio de faturação de mesa por dia", "número médio diário de clientes drive-thru", "valor médio de faturação de cliente drive-thru" },
                    {"nome", "distrito", "loacalização GPS(x,y)", "numero de empregados", "salario médio anual", "numero médio de clientes diários", "numero de dias em funcionamento por ano", "numero de mesas no interior", "valor médio de faturação de mesa por dia", "número de mesas por esplanada", "custo de licença anual por mesa de esplanada" },
                    {"nome", "distrito", "loacalização GPS(x,y)", "custo anual de limpeza", "número de produtos", "valor médio de faturação anual por produto" },
                    {"nome", "distrito", "loacalização GPS(x,y)", "custo anual de limpeza", "o tipo de mercado", "area dos corredores", "valor médio de faturação anual por metro quadrado" }
            };

            if (str == "Criar Empresa") {
                Object[] valores = {"Restauração", "Mercearia" };
                Object empresaValores = JOptionPane.showInputDialog(null, "Escolha uma opção", "Criar Empresa", JOptionPane.INFORMATION_MESSAGE, null, valores, valores[0]);
                if (empresaValores == "Restauração") {
                    Object[] valoresPossiveis = {"Café", "Pastelaria", "Restaurante" };
                    Object valoresSelecionados = JOptionPane.showInputDialog(null, "Escolha uma opção", "Empresa Restauração", JOptionPane.INFORMATION_MESSAGE, null, valoresPossiveis, valoresPossiveis[0]);
                    if (valoresSelecionados == "Café") {
                        String[] obj = new String[8];
                        caixaTexto(palavras[0], obj);
                        starThrive.empresas.add(new Cafe(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Double.parseDouble(obj[6]), Double.parseDouble(obj[7])));
                    }
                    if (valoresSelecionados == "Pastelaria") {
                        String[] obj = new String[8];
                        caixaTexto(palavras[1], obj);
                        starThrive.empresas.add(new Pastelaria(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]),Double.parseDouble(obj[5]), Integer.parseInt(obj[6]), Double.parseDouble(obj[7])));
                    }
                    if (valoresSelecionados == "Restaurante") {
                        Object[] restaurantePossiveis = {"Locais", "Fast-Food" };
                        Object restauranteValores = JOptionPane.showInputDialog(null, "Escolha uma opção", "Empresa Restauração", JOptionPane.INFORMATION_MESSAGE, null, restaurantePossiveis, restaurantePossiveis[0]);
                        if (restauranteValores == "Fast-Food") {
                            String[] obj = new String[11];
                            caixaTexto(palavras[2], obj);
                            starThrive.empresas.add(new FastFood(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Integer.parseInt(obj[6]), Integer.parseInt(obj[7]), Double.parseDouble(obj[8]), Double.parseDouble(obj[9]), Double.parseDouble(obj[10])));
                        }
                        if (restauranteValores == "Locais") {
                            String[] obj = new String[11];
                            caixaTexto(palavras[3], obj);
                            starThrive.empresas.add(new Locais(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Integer.parseInt(obj[6]), Integer.parseInt(obj[7]), Double.parseDouble(obj[8]), Integer.parseInt(obj[9]), Double.parseDouble(obj[10])));
                        }
                    }
                }
                if (empresaValores == "Mercearia") {
                    Object[] merceariaPossiveis = {"Frutaria", "Mercado" };
                    Object valoresMercearia = JOptionPane.showInputDialog(null, "Escolha uma opção", "Empresa Restauração", JOptionPane.INFORMATION_MESSAGE, null, merceariaPossiveis, merceariaPossiveis[0]);
                    if (valoresMercearia == "Frutaria") {
                        String[] obj = new String[7];
                        caixaTexto(palavras[4], obj);
                        starThrive.empresas.add(new Frutaria(obj[0], obj[1], obj[2], Double.parseDouble(obj[3]), Integer.parseInt(obj[4]), Double.parseDouble(obj[5])));
                    }
                    if (valoresMercearia == "Mercado") {
                        String[] obj = new String[7];
                        caixaTexto(palavras[5], obj);
                        starThrive.empresas.add(new Mercado(obj[0], obj[1], obj[2], Double.parseDouble(obj[3]), obj[4], Double.parseDouble(obj[5]), Double.parseDouble(obj[6])));
                    }
                }
            }

            if (str == "Listar Empresas") {
                starThrive.listaEmpresas();
            }

            if (str == "Editar Empresa") {
                int i = 0;
                if (starThrive.empresas.isEmpty())
                    JOptionPane.showMessageDialog(null, "A StarThrive nao tem empresas! ", "Editar Empresa", JOptionPane.PLAIN_MESSAGE);

                else {
                    String[] nomes = new String[starThrive.empresas.size()];
                    for (Empresa empresa : starThrive.empresas) {
                        nomes[i] = empresa.getNome();
                        i++;
                    }
                    String nome = (String) JOptionPane.showInputDialog(null, "Escolha o nome da empresa que deseja editar", "Editar Empresa", JOptionPane.INFORMATION_MESSAGE, null, nomes, nomes[0]);
                    if(nome!=null) {
                        for (Empresa empresa : starThrive.empresas) {
                            if (nome.compareTo(empresa.getNome()) == 0) {
                                String tipoEmpresa = empresa.toString().split(", ")[2];
                                starThrive.empresas.remove(empresa);
                                if (tipoEmpresa.compareTo("Cafe") == 0) {
                                    String[] obj = new String[8];
                                    caixaTexto(palavras[0], obj);
                                    starThrive.empresas.add(new Cafe(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Double.parseDouble(obj[6]), Double.parseDouble(obj[7])));
                                }
                                if (tipoEmpresa.compareTo("Pastelaria") == 0) {
                                    String[] obj = new String[8];
                                    caixaTexto(palavras[1], obj);
                                    starThrive.empresas.add(new Pastelaria(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Integer.parseInt(obj[6]), Double.parseDouble(obj[7])));
                                }
                                if (tipoEmpresa.compareTo("Restaurante Fast-food") == 0) {
                                    String[] obj = new String[11];
                                    caixaTexto(palavras[2], obj);
                                    starThrive.empresas.add(new FastFood(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Integer.parseInt(obj[6]), Integer.parseInt(obj[7]), Double.parseDouble(obj[8]), Double.parseDouble(obj[9]), Double.parseDouble(obj[10])));
                                }
                                if (tipoEmpresa.compareTo("Restaurante local") == 0) {
                                    String[] obj = new String[11];
                                    caixaTexto(palavras[2], obj);
                                    starThrive.empresas.add(new FastFood(obj[0], obj[1], obj[2], Integer.parseInt(obj[3]), Double.parseDouble(obj[4]), Double.parseDouble(obj[5]), Integer.parseInt(obj[6]), Integer.parseInt(obj[7]), Double.parseDouble(obj[8]), Double.parseDouble(obj[9]), Double.parseDouble(obj[10])));
                                }
                                if (tipoEmpresa.compareTo("Frutaria") == 0) {
                                    String[] obj = new String[7];
                                    caixaTexto(palavras[4], obj);
                                    starThrive.empresas.add(new Frutaria(obj[0], obj[1], obj[2], Double.parseDouble(obj[3]), Integer.parseInt(obj[4]), Double.parseDouble(obj[5])));
                                }
                                if (tipoEmpresa.compareTo("Mercado") == 0) {
                                    String[] obj = new String[7];
                                    caixaTexto(palavras[5], obj);
                                    starThrive.empresas.add(new Mercado(obj[0], obj[1], obj[2], Double.parseDouble(obj[3]), obj[4], Double.parseDouble(obj[5]), Double.parseDouble(obj[6])));
                                }
                            }
                        }
                    }
                }
            }

            if (str == "Apagar Empresas") {
                starThrive.empresas.clear();
                JOptionPane.showMessageDialog(null, "As empresas foram apagadas! :(", "Apagar Empresas", JOptionPane.PLAIN_MESSAGE);
            }

            if (str == "Melhores Empresas") {
                if (starThrive.empresas.isEmpty())
                    JOptionPane.showMessageDialog(null, "A StarThrive nao tem empresas! ", "Editar Empresa", JOptionPane.PLAIN_MESSAGE);
                else {
                    starThrive.jframeCondicoes();
                }
            }

            if (str == "Empresas Restauração com maior capacidade de clientes por dia") {
                if (starThrive.empresas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "A StarThrive nao tem empresas! ", "Lista de Empresas", JOptionPane.PLAIN_MESSAGE);
                } else {
                    int cont = 0;
                    for (Empresa empresa : starThrive.empresas) {
                        String tipoEmpresa = empresa.toString().split(", ")[2];
                        if ((tipoEmpresa.compareTo("Restaurante Fast-food") == 0) || (tipoEmpresa.compareTo("Restaurante local") == 0) || (tipoEmpresa.compareTo("Cafe") == 0) || (tipoEmpresa.compareTo("Pastelaria") == 0))
                            cont++;
                    }
                    if (cont >= 2) starThrive.jframeMaiorCapacidade();
                    else
                        JOptionPane.showMessageDialog(null, "A StarThrive nao tem duas ou mais empresas de Restauração! ", "Empresas do tipo Restauracao com maior capacidade de clientes", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

    }

    /**
     * Class que contem a leitura do butão guarda
     */
    private class buttonGuarda implements ActionListener {
        /**
         * Ações que o botão realiza ao ser pressionado
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            starThrive.guardaEmpresa();
            verificaGuardar=0;
            JOptionPane.showMessageDialog(null, "As empresas foram guardadas! :)", "Guardar Empresas", JOptionPane.PLAIN_MESSAGE);
        }
    }
}