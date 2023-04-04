import java.io.Serializable;
/**
 * Classe abstrata para criar os atributos comuns a todas as empresas e declara os metodos necessarios para os diferentes exercicios
 * @author Pedro Ramalho e André Pinto
 * @version final
 */
abstract class Empresa implements Serializable {
    /**
     * nome da empresa
     */
    private String nome;
    /**
     * distrito da empresa
     */
    private String distrito;
    /**
     * coordenadas gps
     */
    private String localizacao;
    /**
     * parametro estatico que guarda o indice da empresa com maior capacidade
     */
    static int indiceMaiorCapacidade1=-1;
    /**
     * parametro estatico que guarda o indice da 2ª empresa com maior capacidade
     */
    static int indiceMaiorCapacidade2=-1;

    /**
     * Construtor vazio da Classe Empresa
     */
    Empresa(){}

    /**
     * Construtor da Classe Empresa
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao coordenadas gps da empresa
     */
    Empresa(String nome,String distrito,String localizacao){
        this.nome=nome;
        this.distrito=distrito;
        this.localizacao=localizacao;
   }


    /**
     * Metodo para obter o nome da empresa
     * @return nome da empresa
     */
    public String getNome (){return nome;}
    /**
     * Metodo para definir o nome da empresa
     * @param nome nome da empresa
     */
    public void setNome (String nome) {this.nome = nome;}
    /**
     * Metodo para obter o distrito da empresa
     * @return distrito da empresa
     */
    public String getDistrito (){return distrito;}
    /**
     * Metodo para definir o distrito da empresa
     * @param distrito distrito da empresa
     */
    public void setDistrito (String distrito) {this.distrito = distrito;}
    /**
     * Metodo para obter a localização(coordenadas gps) da empresa
     * @return localização(coordenadas gps) da empresa
     */
    public String getLocalizacao (){return localizacao;}
    /**
     *  Metodo para definir a localização(coordenadas gps) da empresa
     * @param localizacao localização(coordenadas gps) da empresa
     */
    public void setLocalizacao (String localizacao) {this.localizacao = localizacao;}

    /**
     *Metodo abstrato que vai ser implementado em todas as subclasses de modo a devolver a despesa anual de cada empresa
     * @return despesa anual de cada empresa
     */
    abstract double despesaAnual();
    /**
     *Metodo abstrato que vai ser implementado em todas as subclasses de modo a devolver a receita anual de cada empresa
     * @return receita anual de cada empresa
     */
    abstract double receitaAnual();
    /**
     *Metodo abstrato que vai ser implementado em todas as subclasses de modo a atualizar o indice da maior receita anual de cada tipo de empresa
     * @param i indice da empresa com maior receita
     */
    abstract void alteraIndiceReceita(int i);
    /**
     *Metodo abstrato que vai ser implementado em todas as subclasses de modo a atualizar o indice da menor despesa anual de cada tipo de empresa
     * @param i indice da empresa com menor despesa
     */
    abstract void alteraIndiceDespesa(int i);

    /**
     * Metodo abstrato que vai ser implementado em todas as subclasses de modo a atualizar o indice do maior lucro anual de cada tipo de empresa
     * @param i indice da empresa com maior lucro
     */
    abstract void alteraIndiceLucro(int i);

    /**
     * Metodo abstrato que vai ser implementado em todas as subclasses de modo a devolver o indice da empresa com maior receita anual
     * @return indice da empresa com maior receita anual
     */
    abstract int devolveIndiceReceita();
    /**
     * Metodo abstrato que vai ser implementado em todas as subclasses de modo a devolver o indice da empresa com menor despesa anual
     * @return indice da empresa com menor despesa anual
     */
    abstract int devolveIndiceDespesa();
    /**
     * Metodo abstrato que vai ser implementado em todas as subclasses de modo a devolver o indice da empresa com maior lucro anual
     * @return indice da empresa com maior lucro anual
     */
    abstract int devolveIndiceLucro();

    /**
     * Metodo que devolve true se a receita anual for maior que a despesa anual da empresa
     * @return true or false
     */
    boolean lucro() {
        return this.receitaAnual() > this.despesaAnual();
    }

    /**
     * Metodo que devolve o lucro de uma empresa ou 0 se esta nao tiver lucro
     * @return lucro ou 0
     */
    double retLucro(){
        if (this.lucro()) return this.receitaAnual()-this.despesaAnual();
        return 0;
    }

    /**
     * Metodo que devolve uma "Sim" se a empresa tiver lucro ou "Nao" se nao tiver
     * @return "sim" ou "Nao"
     */
    String escreveLucro(){
        if(this.lucro()) return "Sim";
        return "Nao";
    }

    /**
     * Metodo que devolve a infomração necessária para imprimir a receita de uma empresa
     * @return nome e receita anual da empresa
     */
    String imprimeReceita(){
        return  this.getNome()+", "+ this.receitaAnual();
    }
    /**
     * Metodo que devolve a infomração necessária para imprimir a depesa de uma empresa
     * @return nome e despesa anual da empresa
     */
    String imprimeDespesa() {
        return this.getNome()+", "+ this.despesaAnual();
    }
    /**
     * Metodo que devolve a infomração necessária para imprimir o lucro de uma empresa
     * @return nome e lucro anual da empresa
     */
    String imprimeLucro() {
        return this.getNome()+", "+this.retLucro();
    }

    /**
     * Metodo que atualiza o indice da empresa com maior capacidade
     * @param i indice da empresa com maior capacidade
     */
    void alteraIndiceCapacidade1(int i) {
        indiceMaiorCapacidade1=i;
    }
    /**
     * Metodo que atualiza o indice da 2ª empresa com maior capacidade
     * @param i indice da 2ª empresa com maior capacidade
     */
    void alteraIndiceCapacidade2(int i) {
        indiceMaiorCapacidade2=i;
    }

    /**
     * Metodo que devolve o indice da empresa com maior capacidade
     * @return indice da empresa com maior capacidade
     */
    int devolveIndiceCapacidade1() {
        return indiceMaiorCapacidade1;
    }

    /**
     * Metodo que devolve o indice da 2ª empresa com maior capacidade
     * @return indice da 2ª empresa com maior capacidade
     */
    int devolveIndiceCapacidade2() {
        return indiceMaiorCapacidade2;
    }

    /**
     * Metodo abstrato que vai ser implementado em todas as subclasses de modo a calcular e devolver a capaciadade de clientes por dia ou 0 se essa classe nao possuir esses parametros
     * @return capacidade de clientes por dia ou 0
     */
    abstract double capacidadeClientesDia();
    /**
     * Imprime os atributos nome e distrito da Classe Empresa que são utilizados pelos toString das classes filhas
     * @return string com o nome e distrito
     */
    @Override
    public String toString(){

        return this.nome+", "+this.distrito;

    }

}




