package grupo.terabite.terabite.enums;

public enum ProdutoEnum {

    PICOLE(1, "Picolé"),
    POTE(2, "Pote"),
    CONE(3, "Cone"),
    ACAI(4, "Açaí");

    private Integer valor;
    private String descricao;

    ProdutoEnum(Integer valor, String descricao) {
    }
}
