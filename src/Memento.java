import java.io.Serializable;

interface Memento extends Serializable {
    void restore();
}
