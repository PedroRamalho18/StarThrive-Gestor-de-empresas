import java.io.*;
import java.util.ArrayList;
/**
 * Classe para ler o Ficheiro txt, construir, ler e atualizar o ficheiro objeto
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
public class Ficheiros implements Serializable{
    /**
     *  Metodo que gere a leitura de ficheiros de modo a ler do ficheiro de texto se nao existir o ficheiro objeto e lendo deste se se ele existir
     * @param fileNametxt nome do ficheiro de texto
     * @param fileNameObj nome do ficheiro objeto
     * @param starThrive objeto da Classe Starthive
     * @return ArrayList de empresas com os objetos lidos de um dos ficheiros
     */
    public ArrayList<Empresa> gereLeituraFicheiros(String fileNametxt, String fileNameObj, StarThrive starThrive){
        File f = new File(fileNameObj);
        if(f.exists()){
            starThrive.empresas= leFicheiroObj(fileNameObj);
        }
        else {
            leFicheirotxt(fileNametxt, starThrive);
        }
        return starThrive.empresas;
    }

    /**
     *Método que lê o ficheiro objeto para a ArrayList de Empresas
     * @param fileNameObj nome do ficheiro objeto
     * @return ArrayList de empresas com os objetos lidos do ficheiro objeto
     */
    public ArrayList<Empresa> leFicheiroObj(String fileNameObj){

        File arquivo = new File(fileNameObj);

        try {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Empresa> empresa = (ArrayList<Empresa>) objectIn.readObject();

            objectIn.close();
            fileIn.close();

            return empresa;
        }
        catch (FileNotFoundException ignored) {
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no tipo de objeto a ler!" + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Erro a ler objecto, a class nao ec" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro a ler do objecto!" + e.getMessage());
        }
        return null;
    }

    /**
     * Método que escreve o ficheiro objeto com os dados que se encontram na ArrayList de starThrive
     * @param fileNameObj nome do ficheiro objeto
     * @param starThrive objeto da Classe Starthive
     */
    public void escreveFicheiroObj(String fileNameObj, StarThrive starThrive){
        File f = new File(fileNameObj);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(starThrive.empresas);
            oos.close();
        }catch (FileNotFoundException ex){
            System.out.println("Erro a criar o ficheiro!");
        }catch (IOException ex){
            System.out.println("Erro a escrever para o ficheiro!");
        }

    }

    /**
     * Método que le os dados que se encontram no ficheiro de texto para a ArrayList de starThrive
     * @param fileNametxt nome do ficheiro de texto
     * @param starThrive objeto da Classe Starthive
     */
    public void leFicheirotxt(String fileNametxt, StarThrive starThrive) {
        File f= new File(fileNametxt);
        if(f.exists() && f.isFile()){ //carrega as starThrive do ficheiro starthrive.txt
            String line;
            String splitBy = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileNametxt));
                while ((line = br.readLine()) != null) {
                    String[] empresa = line.split(splitBy);
                    if (empresa[0].equalsIgnoreCase("Cafe")) {
                        starThrive.empresas.add(new Cafe(empresa[1], empresa[2], empresa[3], Integer.parseInt(empresa[4]), Double.parseDouble(empresa[5]), Double.parseDouble(empresa[6]), Double.parseDouble(empresa[7]), Double.parseDouble(empresa[8])));
                    }
                    if (empresa[0].equalsIgnoreCase("Pastelaria")) {
                        starThrive.empresas.add(new Pastelaria(empresa[1], empresa[2], empresa[3], Integer.parseInt(empresa[4]), Double.parseDouble(empresa[5]),Double.parseDouble(empresa[6]), Integer.parseInt(empresa[7]), Double.parseDouble(empresa[8])));
                    }
                    if (empresa[0].equalsIgnoreCase("Restaurante fast-food")) {
                        starThrive.empresas.add(new FastFood(empresa[1], empresa[2], empresa[3], Integer.parseInt(empresa[4]), Double.parseDouble(empresa[5]), Double.parseDouble(empresa[6]), Integer.parseInt(empresa[7]), Integer.parseInt(empresa[8]), Double.parseDouble(empresa[9]), Double.parseDouble(empresa[10]), Double.parseDouble(empresa[11])));
                    }
                    if (empresa[0].equalsIgnoreCase("Restaurante local")) {
                        starThrive.empresas.add(new Locais(empresa[1], empresa[2], empresa[3], Integer.parseInt(empresa[4]), Double.parseDouble(empresa[5]), Double.parseDouble(empresa[6]), Integer.parseInt(empresa[7]), Integer.parseInt(empresa[8]), Double.parseDouble(empresa[9]), Integer.parseInt(empresa[10]), Double.parseDouble(empresa[11])));
                    }
                    if (empresa[0].equalsIgnoreCase("Mercado")) {
                        starThrive.empresas.add(new Mercado(empresa[1], empresa[2], empresa[3], Double.parseDouble(empresa[4]), empresa[5], Double.parseDouble(empresa[6]), Double.parseDouble(empresa[7])));
                    }
                    if (empresa[0].equalsIgnoreCase("Frutaria")) {
                        starThrive.empresas.add(new Frutaria(empresa[1], empresa[2], empresa[3], Double.parseDouble(empresa[4]), Integer.parseInt(empresa[5]), Double.parseDouble(empresa[6])));
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Ficheiro não existe.");
        }
    }
}