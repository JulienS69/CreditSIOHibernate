package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Client.
 * Modélise un client de la banque.
 * Mappée depuis la db creditsio.
 * @author : B. CHATAING.
 * created on  30/12/2020.
 * modified on 30/12/2020.
 */

@Entity
@Table(name = "client")
public class Client {
    /**
     * Attributs privés.
     * Attributs identiques aux champs de la table client de la DB.
     */

    @Id
    @Column(name="ClientNum", unique=true)
    private String numero;
    @Column(name = "ClientNom")
    private String nom;
    @Column(name = "ClientPrenom")
    private String prenom;
    @Column(name = "ClientRue")
    private String rue;
    @Column(name = "clientCP")
    private String cp;
    @Column(name = "ClientVille")
    private String ville;
    @Column(name = "ClientTelephone")
    private String mobile;
    @Column(name = "ClientMail")
    private String email;

    /**
     * Constructeur sans paramètre.
     * Ne fait rien
     */
    public Client() {

    }
    /**
     * Constructeur.
     * @param numero : type String.
     * @param nom : type String.
     * @param prenom : type String.
     * @param rue : type String.
     * @param cp : type String.
     * @param ville : type String.
     * @param mobile : type String.
     * @param email : type String.
     */
    public Client(String numero, String nom, String prenom, String rue, String cp, String ville, String mobile, String email) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.mobile = mobile;
        this.email = email;
    }


    /**
     * Accesseurs en lecture (get) et en écriture (set)
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Rend l'objet client sous forme textuelle;
     * @return String
     */
    public String toString() {
        String strClient;
        strClient = numero + "\n" + nom + "\n" + prenom + "\n" + rue + "\n" + cp + "\n" + ville + "\n" + mobile + "\n" + email;
        return strClient;
    }
}
