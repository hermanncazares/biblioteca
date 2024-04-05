
package dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "libro")
public class Libro {
    
    //Atributos de la clase
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "isbn", unique = true)
    private String isbn;
    
    @Column(name ="titulo")
    private String titulo;
    
    @Column(name = "nombre_autor")
    private String autor;
    
    //Relaciones
    @OneToMany(mappedBy = "copia")
    private List<Copia> copia;

    public Libro() {
    }
    
    public Libro(long id, String isbn, String titulo, String autor, List<Copia> copia) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.copia = copia;
    }

    public Libro(String isbn, String titulo, String autor, List<Copia> copia) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.copia = copia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Copia> getCopia() {
        return copia;
    }

    public void setCopia(List<Copia> copia) {
        this.copia = copia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Libro other = (Libro) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", copia=" + copia + '}';
    }
    
    
}
