/**
 * Classe para construir as empresas do tipo Mercado
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
class Mercado extends Mercearia{
    /**
     * tipo de mercado (mini,super ou hiper)
     */
    private String tipoMercado;
    /**
     * area dos corredores
     */
    private double areaCorredores;
    /**
     * valor médio da faturação anual por metro quadrado
     */
    private double valMedFatMetroQ;
    /**
     * atributo estático para guardar o indice da empresa com maior receita anual
     */
    private static int indiceMRA=-1;
    /**
     * atributo estático para guardar o indice da empresa com menor custoEmpregadosMesa anual
     */
    private static int indicemDA=-1;
    /**
     * atributo estático para guardar o indice da empresa com maior lucro anual
     */
    private static int indiceMLA=-1;

    /**
     * Construtor vazio da Classe Mercado
     */
    Mercado(){}

    /**
     *Construtor da Classe Mercado
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localização da empresa
     * @param custoAnualLimpeza custo anual de limpeza da empresa
     * @param tipoMercado tipo de mercado (mini,super ou hiper)
     * @param areaCorredores area dos corredores
     * @param valMedFatMetroQ valor médio da faturação anual por metro quadrado
     */
    Mercado(String nome,String distrito,String localizacao, double custoAnualLimpeza, String tipoMercado, double areaCorredores, double valMedFatMetroQ){
        super(nome,distrito,localizacao,custoAnualLimpeza);
        this.tipoMercado = tipoMercado;
        this.areaCorredores=areaCorredores;
        this.valMedFatMetroQ=valMedFatMetroQ;
    }
    /**
     * Metodo para obter o tipo de mercado
     * @return tipo de mercado
     */
    public String getTipoMercado() {return tipoMercado;}

    /**
     * Metodo para definir o tipo de mercado
     * @param tipoMercado tipo de mercado (mini,super ou hiper)
     */
    public void setTipoMercado(String tipoMercado) {this.tipoMercado = tipoMercado;}
    /**
     * Metodo para obter a area dos corredores
     * @return  area dos corredores
     */
    public double getAreaCorredores() {return areaCorredores;}

    /**
     * Metodo para definir a area dos corredores
     * @param areaCorredores area dos corredores
     */
    public void setAreaCorredores(double areaCorredores) {this.areaCorredores = areaCorredores;}
    /**
     * Metodo para obter o valor médio da faturação anual por metro quadrado
     * @return  valor médio da faturação anual por metro quadrado
     */
    public double getValMedFatMetroQ() {return valMedFatMetroQ;}

    /**
     * Metodo para deinir o valor médio da faturação anual por metro quadrado
     * @param valMedFatMetroQ valor médio da faturação anual por metro quadrado
     */
    public void setValMedFatMetroQ(double valMedFatMetroQ) {this.valMedFatMetroQ = valMedFatMetroQ;}
    /**
     * Metodo para calcular a despesa anual da empresa
     * @return despesa anual
     */
    @Override
    double despesaAnual() {
        return this.custoAnualLimpeza;
    }
    /**
     * Metodo para calcular a receita anual da empresa
     * @return receita anual
     */
    @Override
    double receitaAnual(){
        return this.areaCorredores*this.valMedFatMetroQ;
    }
    /**
     * Metodo para alterar o indice da empresa com maior receita anual
     */
    @Override
    void alteraIndiceReceita(int i) {
        indiceMRA=i;
    }
    /**
     * Metodo para alterar o indice da empresa com menor despesa
     */
    @Override
    void alteraIndiceDespesa(int i) {
        indicemDA=i;
    }
    /**
     * Metodo para alterar o indice da empresa com maior lucro anual
     */
    @Override
    void alteraIndiceLucro(int i) {
        indiceMLA=i;
    }
    /**
     * Metodo para devolver o indice da empresa com maior receita anual
     * @return indice da empresa com maior receita anual
     */
    @Override
    int devolveIndiceReceita() {
        return indiceMRA;
    }
    /**
     * Metodo para devolver o indice da empresa com menor despesa anual
     * @return indice da empresa com menor despesa anual
     */
    @Override
    int devolveIndiceDespesa() {
        return indicemDA;
    }
    /**
     * Metodo para devolver o indice da empresa com maior lucro anual
     * @return indice da empresa com maior lucro anual
     */
    @Override
    int devolveIndiceLucro() {
        return indiceMLA;
    }
    /**
     * Metodo para devolver a capacidade de clientes por dia da empresa
     * @return capacidade de clientes por dia da empresa
     */
    @Override
    double capacidadeClientesDia() {
        return 0;
    }
    /**
     * Imprime os atributos especificos do Mercado e os atributos comuns a todas as empresas
     * @return string com a impressao de todos os atributos da Frutaria
     */
    @Override
    public String toString(){

        return super.toString()+", " +"Mercado"+", " + this.despesaAnual() + ", "+this.receitaAnual()+", "+escreveLucro();

    }
}
