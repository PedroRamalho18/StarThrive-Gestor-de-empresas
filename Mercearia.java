/**
 * Classe abstrata para construir a Mercearia
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
abstract class Mercearia extends Empresa{
    /**
     * Custo anual de limpeza
     */
    protected double custoAnualLimpeza;

    /**
     * Construtor vazio da Mercearia
     */
    Mercearia(){
    }

    /**
     * Construtor da Classe Mercearia
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param custoAnualLimpeza custo anual de limpeza
     */
    Mercearia(String nome,String distrito,String localizacao,double custoAnualLimpeza){
        super(nome,distrito,localizacao);
        this.custoAnualLimpeza=custoAnualLimpeza;
    }
    /**
     * Metodo para obter o custo anual de limpeza
     * @return custo anual de limpeza
     */
    public double getCustoAnualLimpeza() {return custoAnualLimpeza;}

    /**
     * Metodo para definir o custo anual de limpeza
     * @param custoAnualLimpeza custo anual de limpeza
     */
    public void setCustoAnualLimpeza(double custoAnualLimpeza) {this.custoAnualLimpeza = custoAnualLimpeza;}
    /**
     * Imprime os atributos provenientes da superclasse
     * @return string com a impressao de todos os atributos da superclasse
     */
    @Override
    public String toString(){

        return super.toString();

    }
}

