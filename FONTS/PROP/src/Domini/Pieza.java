package Domini;

import java.util.ArrayList;

public abstract class Pieza {

    public boolean esNegra; //true si la pieza es de color negro. Sino false que representa el blanco
    public int id;
    public boolean firstMove;
    public char tipo;
    int posX, posY;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isEsNegra() {
        return esNegra;
    }

    public void setEsNegra(boolean esNegra) {
        this.esNegra = esNegra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public void setTipo(char t) {
        this.tipo = t;
    }

    public char getTipo() {
        return this.tipo;
    }

    abstract boolean esMovimientoOk(final Movimiento m, final char estadoTablero[][]);

    abstract ArrayList<Movimiento> movimientosPosibles(final Movimiento m, char estadoTablero[][]);
}
