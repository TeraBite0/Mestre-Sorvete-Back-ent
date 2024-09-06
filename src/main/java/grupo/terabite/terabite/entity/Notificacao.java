package grupo.terabite.terabite.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_NOTI")
    private Integer id;

    @Column(name = "EMAIL_NOTI")
    private String email;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PROD_NOTI", referencedColumnName = "ID_PROD")
    private Produto produto;

    public Notificacao(Integer id, String email, Produto produto) {
        this.id = id;
        this.email = email;
        this.produto = produto;
    }

    public Notificacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
