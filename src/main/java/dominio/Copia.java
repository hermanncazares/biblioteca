
package dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jairi
 */
@Entity
@Table(name = "copia")
public class Copia {

    //Atributos de la clase
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "estadoCopia", nullable = false)
    @Enumerated(EnumType.STRING)
    private CopiaEstado copiaEstado;
    
    //Relaciones
    @OneToMany(mappedBy = "copia")
    private List<Prestamo> prestamo;
    
    @ManyToOne()
    @JoinColumn(name = "id_copia", nullable = false)
    private Libro libro;

    public Copia() {
    }

    public Copia(long id, CopiaEstado copiaEstado, List<Prestamo> prestamo, Libro libro) {
        this.id = id;
        this.copiaEstado = copiaEstado;
        this.prestamo = prestamo;
        this.libro = libro;
    }

    public Copia(CopiaEstado copiaEstado, List<Prestamo> prestamo, Libro libro) {
        this.copiaEstado = copiaEstado;
        this.prestamo = prestamo;
        this.libro = libro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CopiaEstado getCopiaEstado() {
        return copiaEstado;
    }

    public void setCopiaEstado(CopiaEstado copiaEstado) {
        this.copiaEstado = copiaEstado;
    }

    public List<Prestamo> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(List<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Copia other = (Copia) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Copia{" + "id=" + id + ", copiaEstado=" + copiaEstado + ", prestamo=" + prestamo + ", libro=" + libro + '}';
    }
    
    
}
