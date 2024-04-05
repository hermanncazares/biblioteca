package dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jairi
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    //Atributos de la clase
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "id_personal")
    private String id_personal;

    @Column(name = "usarioTipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioTipo usuarioTipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    //Relaciones
    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamo;

    public Usuario() {
    }

    public Usuario(long id, String id_personal, UsuarioTipo usuarioTipo, String nombre, List<Prestamo> prestamo) {
        this.id = id;
        this.id_personal = id_personal;
        this.usuarioTipo = usuarioTipo;
        this.nombre = nombre;
        this.prestamo = prestamo;
    }

    public Usuario(String id_personal, UsuarioTipo usuarioTipo, String nombre, List<Prestamo> prestamo) {
        this.id_personal = id_personal;
        this.usuarioTipo = usuarioTipo;
        this.nombre = nombre;
        this.prestamo = prestamo;
    }

    public Usuario(String id_personal, UsuarioTipo usuarioTipo, String nombre) {
        this.id_personal = id_personal;
        this.usuarioTipo = usuarioTipo;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_personal() {
        return id_personal;
    }

    public void setId_personal(String id_personal) {
        this.id_personal = id_personal;
    }

    public UsuarioTipo getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Prestamo> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(List<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", id_personal=" + id_personal + ", usuarioTipo=" + usuarioTipo + ", nombre=" + nombre + ", prestamo=" + prestamo + '}';
    }
    
    
}
